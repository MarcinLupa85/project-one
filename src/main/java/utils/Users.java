package utils;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class Users{
    private List<User> usersList;
    private String password = "Emobility1";
    public Users() {
        usersList = new ArrayList<>();
        usersList.add(new User("newuser.easeewithextra@mailinator.com", password, "575437397"));
        usersList.add(new User("newuser.easeenoextra@mailinator.com", password, "575437666"));
        usersList.add(new User("newuser.cablenoextra@mailinator.com", password, "575437306"));
        usersList.add(new User("newuser.mennekeswithextra@mailinator.com", password, "575437305"));
        usersList.add(new User("newuser.mennekesnoextra@mailinator.com", password, "575437304"));
        usersList.add(new User("newuser.easeeinstallation@mailinator.com", password, "575437307"));
        usersList.add(new User("newuser.mennekesinstallation@mailinator.com", password, "575437308"));
        usersList.add(new User("newuser.easeewithextra@mailinator.com", password, "575437398"));
        usersList.add(new User("newuser.mennekesnoextra@mailinator.com", password, "575437304"));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                ", password='" + password + '\'' +
                '}';
    }
}
