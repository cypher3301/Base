package study.db.book;

import java.io.IOException;
import java.sql.*;

public class Transaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        String username = "usr";
        String password = "pass";
        String connectUrl = "jdbc:mysql://localhost:3306/simplenn_test";
        Connection connection= null;
        try {
            connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement();

            connection.setAutoCommit(false);
            statement.execute("drop table if exists employs");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employ(id INT NOT NULL AUTO_INCREMENT UNIQUE , name varchar(30), primary key(id) )");

            statement.executeUpdate("insert into employ (name) values ('vova'), ('vlad'), ('sanya'), ('artur')");
            statement.executeUpdate("insert into employ (name) values ('haha'), ('lala'), ('fafa'), ('tata')");
            connection.commit();


        } catch (SQLException e){
            assert connection != null;
            connection.rollback();
        }


    }
}
