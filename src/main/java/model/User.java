package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    static final Logger LOG = LoggerFactory.getLogger(User.class);

    private final String first;
    private final String last;
    private final String email;

    public User(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }
}
