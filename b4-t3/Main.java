package br.caelum.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "insert into pessoa(nome, idade, id) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        adiciona("idade", "24''", statement);
        adiciona("nome", "João", statement);
        statement.close();
        connection.close();
    }
    private static void adiciona(String nome, float idade, number id.
            PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, idade);        
        boolean resultado = statement.execute();
        System.out.println(resultado);
        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            System.out.println(id + "gerado");
        }
        resultSet.close();

    connection conn = new connectionfactory().geteconnection();
    string sql = "Delete from pessoa where id = (?)";
    PreparedStatement  PreparedStatement = conn. PreparedStatement(sql);

    scanner sc = new acanner(system.in);

    system.out.println("digite o id)";
    PreparedStatement.setInt(parameterindex 1,id);
    PreparedStatement.execute();
    PreparedStatement.close();
    conn.close();

    } catch (sqlException e ){
        throw new runtimeException(e);
    }
}
    PreparedStatement ps = conn.prepareStatement(
      "UPDATE pessoa SET nome = ?, idade = ? WHERE nome = ? AND idade = ?");

    // set the preparedstatement parameters
    ps.setString(1,description);
    ps.setString(2,author);
    ps.setInt(3,id);
    ps.setInt(4,seqNum);

    // call executeUpdate to execute our sql update statement
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException se)
  {
    // log the exception
    throw se;
  }
}
public list<pessoa> listar() throws sqlexception{
    list<pessoas> pessoas -= new arreylist <>();
    try
    connection conn = new connectionfactory().getconnection();
    preparedStatement stm = conn.preparedStatement(sql " select * from pessoa");
    resultset rs = stm.executeQuery();
    while(rs.next())
        pessoa p = new pessoa(0;
        p.setId(rs.getInt("columnLabel: id"));
        p.nome(rs.getInt("columnLabel: nome"));
        p.idade(rs.getInt("columnLabel: idade"));
        
        pessoas.add(p);
    }
    rs.close();
    stm.close();
    conn.close();
} catch (sqlException e){
    throw new runtimerxception(e);

}
return pessoas;