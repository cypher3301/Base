package study.db;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JDBC jdbc = new JDBC();
        jdbc.connection();
//        String username = "starscream";
//        String password = "Starscream1999";
//        String connectionUrl = "jdbc:mysql://localhost:3306/simplenn_test";
//        Class.forName("com.mysql.jdbc.Driver");
//        String sql = "INSERT testphones(name, phone) VALUES (?,?)";
//
//        Menu menu = new Menu();
//        menu.showMenu();
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            System.out.println("Connected\n");
//            String name = menu.getName();
//            String phone = menu.getPhone();
//            statement.setString(1, name);
//            statement.setString(2, phone);
//
////            statement.setString(1, new Scanner(System.in).nextLine());
////            statement.setString(2, new Scanner(System.in).nextLine());
//            statement.executeUpdate();



//            statement.executeUpdate("INSERT testphones(name, phone) VALUES ("+s[0]+","+Integer.parseInt(s[1])+")");
//            ResultSet resultSet = statement.
//            statement.executeUpdate("drop table test");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS test (id MEDIUMINT NOT NULL AUTO_INCREMENT, name char(30) not null, PRIMARY KEY(id));");
//            statement.executeUpdate("insert into test (name) value('Inferno')");
//            statement.executeUpdate("insert into test set name = 'Solomon key'");
//            ResultSet resultSet = statement.executeQuery("select * from test");
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println("----------------------------");
//            }
//
//            ResultSet resultSet1 = statement.executeQuery("select  name from test where id = 1");
//            while (resultSet1.next()){
//                System.out.println(resultSet1.getString(1));
//            }

//            statement.executeUpdate("drop table Users");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id MEDIUMINT NOT NULL AUTO_INCREMENT, name char(30) not null, password char(30) not null, PRIMARY KEY(id));");
//            statement.executeUpdate("INSERT INTO Users (name, password) VALUES ('max','123')");
//            statement.executeUpdate("INSERT INTO Users SET name = 'otherGuy', password='321'");

//            String userID="1 or 1 = 1";
//            ResultSet resultSet = statement.executeQuery("select * from test where id='" + userID + "'");
//            while (resultSet.next()){
//                System.out.println("UserName: " + resultSet.getString("name"));
////                System.out.println("UserPassword: " + resultSet.getString("password"));
//            }
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from test where id=? and name=?");
//            preparedStatement.setString(1, userID);
//            ResultSet resultSet1 =preparedStatement.executeQuery();
        }

//    }

//    private void putArgsToDB(PreparedStatement statement, ArrayList<String> objectsName, ArrayList<String> objectsPhone) throws SQLException {
//        int lenght = Math.min(objectsName.size(), objectsPhone.size());
//        for (int i = 0; i < lenght; i++) {
//            statement.setString(1,objectsName.get(i));
//            statement.setString(2,objectsPhone.get(i));
//        }
//    }

    private static String[] getWords(String string) {
        return string.split(" ");
    }
}
