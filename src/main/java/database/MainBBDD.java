package database;

import database.model.Users;

import java.util.List;

public class MainBBDD {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        UserDTO userDTO = new UserDTO(dataSource);

        try {
            if (dataSource.open()){
                List<Users> usersList = userDTO.queryUsers(1);

                for (Users user : usersList){
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            dataSource.close();
        }
    }

}