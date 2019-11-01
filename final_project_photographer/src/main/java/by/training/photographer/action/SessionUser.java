package by.training.photographer.action;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;

import java.util.Objects;

public class SessionUser {

    private int id;
    private String email;
    private String name;
    private String phoneNumber;
    private Role role;

    public SessionUser(int id, String email, String name, String phoneNumber, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public SessionUser(UserEntity userEntity) {
        this(userEntity.getId(),
            userEntity.getEmail(),
            userEntity.getName(),
            userEntity.getPhoneNumber(),
            userEntity.getRole());
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        SessionUser user = (SessionUser) other;
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
        return "SessionUser{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", role=" + role +
            '}';
    }
}
