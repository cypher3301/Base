package study.db.book;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {
    String username = "usr";
    String password = "pass";
    String connectUrl = "jdbc:mysql://localhost:3306/simplenn_test";


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException {

        Class.forName("com.mysql.jdbc.Driver");
        String username = "usr";
        String password = "pass";
        String connectUrl = "jdbc:mysql://localhost:3306/simplenn_test";
        try (Connection connection = DriverManager.getConnection(connectUrl, username, password);
             Statement statement = connection.createStatement();
        ) {
//            statement.execute("drop table if exists employs");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employs(id INT NOT NULL AUTO_INCREMENT UNIQUE , name varchar(30), phone varchar(13), img BLOB, dt DATE, primary key(id) )");
//            final String sql = "call getname(?,?)";
//            CallableStatement callableStatement = connection.prepareCall(sql);
//            callableStatement.setInt(1, 978);
//            callableStatement.registerOutParameter(2, Types.VARCHAR);
//            callableStatement.execute();
//            String name = callableStatement.getString(2);
//            System.out.println(name);

            //image
//            putImageToDB(connection);
//            getImageFromDB(connection);

            //date
//            putDateToDB(connection);
//            getDateFromDB(connection);

            //procedures
//            procedures(connection);
//            moreResultsWithProcedure(connection);

            //ResultSet and update
//            resultSetAndUpdate(connection);

            //CashedRowSet
//            cachedRowSet(connection);

            //Metadata
//            metadata(connection);

            //sql Batch
//            batch(connection);

            //transaction
//            transaction(connection);
            new Main().transactionLevelIsolation(connection);
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
        callableStatement.setInt(1, 1);
        if (callableStatement.execute()) {
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
    }

    private static void moreResultsWithProcedure(Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call getcount(?)}");
        boolean hasResults = callableStatement.execute();
        while (hasResults) {
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            hasResults = callableStatement.getMoreResults();
        }
    }

    private static void scrollableRowSet(Connection connection) {

    }

    private static void resultSetAndUpdate(Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select * from test");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("name"));
        }
        System.out.println();
        resultSet.last();
        resultSet.updateString("name", "new Value");
        resultSet.updateRow();

        resultSet.moveToInsertRow();
        resultSet.updateString("name", "inserted row");
        resultSet.insertRow();

        resultSet.absolute(2);
        resultSet.deleteRow();

        resultSet.beforeFirst();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("name"));
        }
    }

    private static ResultSet getData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO test (name) values ('avraam'),('abraham'),('adolf')";
        statement.executeUpdate(sql);

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedRowSet = factory.createCachedRowSet();

        Statement statement1 = connection.createStatement();
        ResultSet resultSet = statement1.executeQuery("select * from test");
        cachedRowSet.populate(resultSet);

        return cachedRowSet;
    }

    private static void cachedRowSet(Connection connection) throws SQLException {
        ResultSet resultSet = getData(connection);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("name"));
        }

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setCommand("select * from test where id = ?");
        cachedRowSet.setInt(1, 1);
        cachedRowSet.setPageSize(20);
        cachedRowSet.execute();

        while (cachedRowSet.nextPage()) {
            while (cachedRowSet.next()) {
                System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("name"));
            }
        }
    }

    private static void metadata(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, null, null, new String[]{"tables"});
        while (tables.next()){
            System.out.println(tables.getString(3));
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from testphones");
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println("-----------------");
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            System.out.println(metaData.getColumnLabel(i));
            System.out.println(metaData.getColumnType(i));
        }
        System.out.println("-----------------");
    }

    private static void batch(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        connection.setAutoCommit(false);
        statement.addBatch("insert into test (name) values ('vova'), ('vlad'), ('sanya'), ('artur')");
        statement.addBatch("insert into test (name) values ('haha'), ('lala'), ('fafa'), ('tata')");
        statement.executeBatch();
        connection.commit();
    }

    private static void transaction(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        connection.setAutoCommit(false);
        statement.executeUpdate("insert into test (name) values ('vova'), ('vlad'), ('sanya'), ('artur')");
        Savepoint savepoint = connection.setSavepoint();
        statement.executeUpdate("insert into test (name) values ('haha'), ('lala'), ('fafa'), ('tata')");
        connection.rollback(savepoint);
        connection.commit();
        connection.releaseSavepoint(savepoint);
    }

    private void transactionLevelIsolation(Connection connection) throws SQLException, InterruptedException {
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        statement.execute("update test set name = 'Inferno' where id = 1");
        new OtherTransaction().start();
        Thread.sleep(2000);
        connection.rollback();
    }

    class OtherTransaction extends Thread{
        @Override
        public void run() {
            try (Connection connection = DriverManager.getConnection(connectUrl, username, password);
                 Statement statement = connection.createStatement();
            ) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                ResultSet resultSet = statement.executeQuery("select * from test");
                showData(resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString("id")+"\t| "+resultSet.getString("name"));
        }
    }
}