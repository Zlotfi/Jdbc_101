package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final UserRepository userRepository = new UserRepository();
    Scanner scanner = new Scanner(System.in);

    public UserService() throws SQLException {
    }

    public void register() throws SQLException {
        User user = new User(null,"zahra","lotfi","zlotfi","1234");
        int result = userRepository.save(user);
        if(result != 0)
            System.out.println(user.getFirstName() + " successfully added to database");
        else
            System.out.println("OOps! :(");
    }

    public void login() throws SQLException {
        System.out.println("please enter your userName");
        String userName = scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.nextLine();

        User user = userRepository.login(userName);
        if((user != null) && user.getPassword().equals(password))
            System.out.println("login successfully");
        else
            System.out.println("Bad credentials");
    }

    public void changeFirstName() throws SQLException {
        System.out.println("please enter your new firstName: ");
        String firstName = scanner.nextLine();
        int result = userRepository.updateFirstName(firstName);
        if(result != 0)
            System.out.println("successfully edited to database");
        else
            System.out.println("OOps! :(");
    }

    public void delete() throws SQLException {
        int result = userRepository.delete(2);
        if(result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("OOps! :(");
    }


}
