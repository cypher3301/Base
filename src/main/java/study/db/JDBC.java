package study.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBC {
    private Menu menu;
    private int countColumn;

    public JDBC() {
        menu = new Menu();
    }

    public void connection() throws ClassNotFoundException, SQLException {
        String username = "usr";
        String password = "pass";
        String connectionUrl = "jdbc:mysql://localhost:3306/simplenn_test";
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "INSERT testphones(name, phone) VALUES (?,?)";
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Connected\n");
            controlDB(statement);


        }
    }

    private void controlDB(PreparedStatement statement) throws SQLException {
        //----------------------
        ResultSet resultSet = statement.executeQuery("SELECT * FROM testphones");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        setColumnCountFromDB(resultSetMetaData);
        //----------------------
        menu.showMenu();
        while (!menu.getResult().equals("5")) {
            switch (menu.getResult()) {
                case "0":
                    break;
                case "1":
                    addToDB(statement, new ArrayList<>(Arrays.asList(menu.getName(), menu.getPhone())));
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Exit");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Not correct value!");
            }
            menu.showMenu();
        }
    }

    private void addToDB(PreparedStatement statement, List<String> items) throws SQLException {
        for (int i = 0; i < countColumn-1; i++) {
            statement.setString(i + 1, items.get(i));
        }
        statement.executeUpdate();
    }

    private void setColumnCountFromDB(ResultSetMetaData resultSetMetaData) throws SQLException {
        this.countColumn = resultSetMetaData.getColumnCount();
    }
}
