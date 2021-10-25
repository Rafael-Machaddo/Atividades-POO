package com.company;
import java.sql.*;

public class Main {

    public static <SQLiteDatabase> void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:meu_banco.db")) {

            System.out.println("Conexão realizada");
            Statement statement = connection.createStatement();
            // criando tabela
            statement.execute("CREATE TABLE IF NOT EXISTS NOME( ID INTEGER primary key autoincrement , NOME VARCHAR )");

            // inserindo registros

            statement.execute("INSERT  INTO NOME (NOME) VALUES ('João')");
            statement.execute("update NOME set Rafael = machado + where id = 3");

            //lendo os registros

            PreparedStatement stmt = ((Connection) connection).prepareStatement("select * from NOME");
            ResultSet resultSet = stmt.executeQuery();

            statement.execute("DELETE FROM NOME\n" + "WHERE ID = 1;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");

                System.out.println( id + " - " + nome);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}