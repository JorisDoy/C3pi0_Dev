package com.indra.iopen;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that represents an User of the IOpen system.
 * @author mbaez
 *
 */
public class User {
    @NotNull
    @Size(
            min = 2,
            max = 30,
            message = "{firstname.size}")
    private String firstName;

    @NotNull
    @Size(
            min = 2,
            max = 30,
            message = "{lastname.size}")
    private String lastName;

    @NotNull
    @Size(
            min = 5,
            max = 16,
            message = "{username.size}")
    private String username;

    @NotNull
    @Size(
            min = 5,
            max = 25,
            message = "{password.size}")
    private String password;

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    public User(final String firstName, final String lastName, final String username, final String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

}
