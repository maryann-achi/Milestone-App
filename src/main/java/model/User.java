package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    static final Logger LOG = LoggerFactory.getLogger(User.class);

    private int id;
    private final String name;
    private final String email;
    private final String password;
    private final byte[] salt;

    public User(String name, String email, String password, byte[] salt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public User(int id, String name, String email, String password, byte[] salt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }
}
