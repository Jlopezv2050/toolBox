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
}