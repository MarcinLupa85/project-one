package models;

public class User {

    private String email, password, phoneNumber;

    public User(String email, String password, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
