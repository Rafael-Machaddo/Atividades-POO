package model;

import javax.swing.*;
import dao.DBConnection;
import dao.TaskDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
	public final List<Task> notDone = new ArrayList<Task>();
	public final List<Task> done = new ArrayList<Task>();
	public final DefaultListModel<String> notDoneModel = new DefaultListModel<String>();;
	public final DefaultListModel<String> doneModel = new DefaultListModel<String>();
	public final JList<String> notDoneList;
	public final JList<String> doneList;

	private final TaskDAO DAO = new TaskDAO();

	public TodoList() {
		notDoneList = new JList<String>(notDoneModel);
		doneList = new JList<String>(doneModel);
		notDoneList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setCon();
		fillTasks();
	}

	public void addTask(String label) {
		Task task = DAO.add(new Task(label));
		System.out.println("Ótimo - Adicionado");
		if (task != null) {
			notDone.add(task);
			notDoneModel.addElement(task.getLabel());
		}
	}

	public void removeTask(int index, DefaultListModel<String> model, List<Task> array, Task task) {
		if (index >= 0 && index < array.size()) {
			boolean success = DAO.delete(task.getId());
			if (success) { array.remove(index);  model.remove(index); }
		}
	}

	public void toggleDone(Task task) { Task taskToggled = DAO.toggleTask(task);

		if (taskToggled != null) {
			if (taskToggled.getIsDone()) {
				done.add(taskToggled);
				doneModel.addElement(taskToggled.getLabel());
				notDone.remove(taskToggled);
				notDoneModel.remove(notDoneList.getSelectedIndex());
			} else {
				notDone.add(taskToggled);
				notDoneModel.addElement(taskToggled.getLabel());
				done.remove(taskToggled);
				doneModel.remove(doneList.getSelectedIndex());
			}
		}
	}

	private void fillTasks() {
		List<Task> notDoneTasks = DAO.getAllTasks(false);
		List<Task> doneTasks = DAO.getAllTasks(true);

		for (Task task : notDoneTasks) {
			notDone.add(task);
			notDoneModel.addElement(task.getLabel());
		}
		for (Task task : doneTasks) { done.add(task); doneModel.addElement(task.getLabel());}
	
	}

	private void setCon() {
		try {
			DAO.setCon(new DBConnection().getConnection());
		} catch (SQLException e) {
			System.out.println("Conexão com banco de dados NÃO foi concluída.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
