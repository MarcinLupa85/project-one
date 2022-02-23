package testdata;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.PasswordUtils;

import java.util.ArrayList;
import java.util.List;

import static config.Constants.USERS_PASSWORD;
import static testdata.EvUsers.*;

public class Users {
    private static final Logger LOGGER = LogManager.getLogger(Users.class);
    private List<User> usersList;
    private String password = getDecryptedPassword(USERS_PASSWORD);

    public Users() {
        usersList = new ArrayList<>();
        usersList.add(new User(NEW_EASEE_WITH_EXTRA, password, "575437397"));
        usersList.add(new User(NEW_EASEE_NO_EXTRA, password, "575437666"));
        usersList.add(new User(NEW_CABLE_NO_EXTRA, password, "575437306"));
        usersList.add(new User(NEW_EASEE_WITH_INSTALLATION, password, "575437307"));
        usersList.add(new User(NEW_EASEE_NO_EXTRA2, password, "94564565"));
        usersList.add(new User(NEW_EASEE_NO_EXTRA3, password, "94564566"));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    private String getDecryptedPassword(String password) {
        PasswordUtils passwordUtils = null;
        try {
            passwordUtils = new PasswordUtils();
        } catch (Exception e) {
            LOGGER.error("Cannot decrypt password ", e.getMessage());
        }
        return passwordUtils.decrypt(USERS_PASSWORD);
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                ", password='" + password + '\'' +
                '}';
    }

}
