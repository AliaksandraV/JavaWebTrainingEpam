package by.training.photographer.action;

import by.training.photographer.entity.Role;

import java.util.Objects;

public class User {

    private int id;
    private String email;
    private String name;
    private String phoneNumber;
    private Role role;

    public User(int id, String email, String name, String phoneNumber, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        User user = (User) other;
        return id == user.id &&
            Objects.equals(email, user.email) &&
            Objects.equals(name, user.name) &&
            Objects.equals(phoneNumber, user.phoneNumber) &&
            role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, phoneNumber, role);
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", role=" + role +
            '}';
    }
}
