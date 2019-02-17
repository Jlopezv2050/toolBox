package database;

import database.model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDTO  {
    private DataSource dataSource;

    UserDTO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Users> queryUsers(int sortOrder) throws SQLException {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(DataSource.TABLE_USERS);
        if (sortOrder != DataSource.ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(DataSource.COLUMN_USERS_USERNAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == DataSource.ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        ResultSet results = dataSource.executeQuery(sb.toString());
        List<Users> usersList = new ArrayList<>();
        while(results.next()) {
            Users users  = new Users();
            users.setId(results.getLong("id"));
            users.setUsername(results.getString("username"));
            users.setPassword(results.getString("password"));
            usersList.add(users);
        }
        return usersList;
    }

    void insertUser() {

        try {
            //TODO move into dataSource
            dataSource.conn.setAutoCommit(false);

            String sb = "INSERT INTO " + DataSource.TABLE_USERS +
                    " (" +
                    DataSource.COLUMN_USERS_ID.concat(", ") +
                    DataSource.COLUMN_USERS_USERNAME.concat(", ") +
                    DataSource.COLUMN_USERS_PASSWORD.concat(")") +
                    " VALUES (10, \'Ines\', \'pwd\')";


            int affectedRows = dataSource.executeUpdateQuery(sb);

            if(affectedRows == 1) {
                dataSource.conn.commit();
            } else {
                throw new SQLException("The song insert failed");
            }

        } catch(SQLException e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                dataSource.conn.rollback();
            } catch(SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                dataSource.conn.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }

        }
    }


}