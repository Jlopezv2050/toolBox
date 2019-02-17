package database;

import java.sql.*;

public class DataSource {

    private static final String DB_NAME = "postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "testing";
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/" + DB_NAME;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERS_ID = "id";
    public static final String COLUMN_USERS_USERNAME = "username";
    public static final String COLUMN_USERS_PASSWORD = "password";

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_DESC = 3;


    protected Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASSWORD);
            statement = conn.createStatement();

            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if(statement != null) {
                statement.close();
                resultSet.close();
            }

        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String sb) {
        try{
            return resultSet = statement.executeQuery(sb);

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public int executeUpdateQuery(String sb) {
        try{
            preparedStatement = conn.prepareStatement(sb);
            return preparedStatement.executeUpdate();

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return 0;
        }
    }

}