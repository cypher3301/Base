package study.db.book;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        String username = "usr";
        String password = "pass";
        String connectUrl = "jdbc:mysql://localhost:3306/simplenn_test";
        try (Connection connection = DriverManager.getConnection(connectUrl, username, password);
             Statement statement = connection.createStatement();
        ) {
//            statement.execute("drop table if exists employs");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employs(id INT NOT NULL AUTO_INCREMENT UNIQUE , name varchar(30), phone varchar(13), img BLOB, dt DATE, primary key(id) )");
            final String sql = "call getname(?,?)";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, 978);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();
            String name = callableStatement.getString(2);
            System.out.println(name);

            //image
//            putImageToDB(connection);
//            getImageFromDB(connection);

            //date
//            putDateToDB(connection);
//            getDateFromDB(connection);

            //procedures
//            procedures(connection);
//            moreResultsWithProcedure(connection);

            //result set and update

        }


    }



    private static void putDateToDB(Connection connection) throws SQLException {
        long time = System.currentTimeMillis();
        String sql = "INSERT INTO employs (name, dt) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "vladislav");
        preparedStatement.setDate(2, new Date(time));
        preparedStatement.execute();
        System.out.println("putDateToDB:");
        System.out.println(preparedStatement);
        System.out.println("----------------");
    }

    private static void getDateFromDB(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.getResultSet();
        ResultSet set = connection.createStatement().executeQuery("select * from employs");
        Date date;
        while (set.next()) {
            if ((date = set.getDate("dt")) != null)
                System.out.println(date.toString());
            else
                System.out.println("null");

        }
    }

    private static void putImageToDB(Connection connection) throws IOException, SQLException {
        BufferedImage image = ImageIO.read(new File("img/photo_2020-09-13_17-00-54.jpg"));
        Blob blob = connection.createBlob();
        try (OutputStream outputStream = blob.setBinaryStream(1)) {
            ImageIO.write(image, "jpg", outputStream);
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employs (name, img) VALUES (?,?)");
        preparedStatement.setString(1, "Vladislav");
        preparedStatement.setBlob(2, blob);
        preparedStatement.execute();
        System.out.println("putImageToDB:");
        System.out.println(preparedStatement);
        System.out.println("----------------");
    }

    private static void getImageFromDB(Connection connection) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select  * from employs");
        while (resultSet.next()) {
            Blob blob1 = resultSet.getBlob("img");
            BufferedImage image1 = ImageIO.read(blob1.getBinaryStream());
            File file = new File("img/Vladislav.png");
            ImageIO.write(image1, "png", file);
        }

    }

    private static void procedures(Connection connection) throws SQLException {
        CallableStatement callableStatement1 = connection.prepareCall("{call employscount(?)}");
        callableStatement1.registerOutParameter(1, Types.INTEGER);
        callableStatement1.execute();
        System.out.println(callableStatement1.getInt(1));

        CallableStatement callableStatement = connection.prepareCall("{call getemployes(?)}");
        callableStatement.setInt(1,1);
        if(callableStatement.execute()){
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
    }

    private static void moreResultsWithProcedure(Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call getcount(?)}");
        boolean hasResults= callableStatement.execute();
        while (hasResults){
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
            hasResults= callableStatement.getMoreResults();
        }
    }

    private static void scrollableRowSet(Connection connection){

    }

    private static void resultSetAndUpdate(Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select * from testphones");
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }
    }
}
