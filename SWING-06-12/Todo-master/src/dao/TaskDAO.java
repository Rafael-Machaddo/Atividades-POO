package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class TaskDAO {
	private Connection con;
	public Task add(Task task) {
		if (task != null) {
			System.out.printf("Incluindo tarefa %s", task.getLabel());
			System.out.println();

			if (con != null) { PreparedStatement pstmt = null;
				try {
					pstmt = con.prepareStatement("INSERT INTO tasks VALUES (null, ?, false);");
					pstmt.setString(1, task.getLabel());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.printf("ERROR! Falha ao incluir tarefa com o label %s", task.getLabel());
					System.out.println();
					e.printStackTrace();
					return null;
				} finally { closeCon(pstmt); }
			}
		}
		return this.getLastInsertedTask();
	}

	public List<Task> getAllTasks(boolean done) {
		List<Task> allTasks = new ArrayList<Task>();
		Task task;

		if (con != null) { PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement("SELECT * FROM tasks where isDone = ?");
				pstmt.setBoolean(1, done);
				ResultSet rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("Apresentando tarefas encontradas");
				System.out.println("################################");

				while (rs.next()) {
					System.out.println(rs.getString("label"));
					task = resultSetToTask(rs);
					System.out.printf("Id: %s, Label: %s, Done: %s", task.getId(), task.getLabel(), task.getIsDone());
					System.out.println();
					allTasks.add(task);
				}

				System.out.println("################################");
				System.out.println();
			} catch (SQLException e) {
				System.out.printf("ERROR! Falha ao apresentar todas as tarefas, %s", e);
				System.out.println();
			} finally { closeCon(pstmt); }
		}

		return allTasks;
	}

	public Task getTaskById(int id) {
		Task task = null;

		if (con != null) { PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement("SELECT * FROM tasks WHERE id = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) { task = resultSetToTask(rs);
				} else { System.out.printf("WARNING! Nenhuma tarefa com o id %s, encontrada", id);
					System.out.println();
				}
			} catch (SQLException e) {
				System.out.printf("ERROR! Falha ao buscar a tarefa id %s, ", e);
				System.out.println();
			} finally { closeCon(pstmt); }
		}

		System.out.printf("! Tarefa encontrada ! Label: %s, Done: %s", task.getLabel(), task.getIsDone());
		System.out.println();
		return task;
	}

	public boolean delete(int id) {
		boolean success = true;
		System.out.printf("Deletando tarefa com id %s", id);
		System.out.println();

		if (con != null) { PreparedStatement pstmt = null;

			try {
				pstmt = con.prepareStatement("DELETE FROM tasks WHERE id = ?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.printf("ERROR! Falha ao deletar tarefa");
				System.out.println();
				e.printStackTrace();
				success = false;
			} finally { closeCon(pstmt); }
		}

		return success;
	}

	public Task toggleTask(Task task) {
		if (con != null) { PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement("UPDATE tasks SET isDone = ? where id = ?");
				pstmt.setBoolean(1, !task.getIsDone());
				pstmt.setInt(2, task.getId());
				pstmt.execute();
				System.out.println("Tarefa finalizada com êxito");
			} catch (SQLException e) {
				System.out.printf("ERROR! Falha ao finalizar a tarefa com id %d, %s", task.getId(), e);
				System.out.println();
				return null;
			} finally { closeCon(pstmt); }
		}
		return this.getTaskById(task.getId());
	}

	public void setCon(Connection conexao) { this.con = conexao; }
	private Task getLastInsertedTask() { Task task = null;

		if (con != null) { PreparedStatement pstmt = null;

			try {
				pstmt = con.prepareStatement("SELECT * FROM tasks WHERE id = (SELECT MAX(id) FROM tasks)");
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) { task = resultSetToTask(rs);
				} else {
					System.out.printf("Nenhuma tarefa inserida no banco");
					System.out.println();
					return null;
				}
			} catch (SQLException e) {
				System.out.printf("ERROR! Falha ao procurar a tarefa");
				System.out.println();
				return null;
			} finally { closeCon(pstmt);
			}
		}
		System.out.printf("Tarefa encontrada, Label: %s, Done: %s", task.getLabel(), task.getIsDone());
		System.out.println();
		return task;
	}

	private Task resultSetToTask(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String label = rs.getString("label");
		boolean done = rs.getBoolean("isDone");
		return new Task(id, label, done);
	}

	private void closeCon(Statement pstmt) {
		if (pstmt != null) {
			try { pstmt.close();
			} catch (SQLException e) {
				System.out.printf("ERROR! Conexão com banco de dados não concluída, %s", e);
				System.out.println();
			}
		}
	}
}
