package database;

import database.model.Users;

import java.sql.SQLException;
import java.util.List;

public class MainBBDD {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        UserDTO userDTO = new UserDTO(dataSource);

        try {
            //RETRIEVE QUERY
            if (dataSource.open()){
                List<Users> usersList = userDTO.queryUsers(1);

                for (Users user : usersList){
                    System.out.println(user);
                }
            }

            //INSERT QUERY
            userDTO.insertUser();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            dataSource.close();
        }
    }

}