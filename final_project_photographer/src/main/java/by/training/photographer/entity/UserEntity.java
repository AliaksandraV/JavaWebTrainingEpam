package by.training.photographer.entity;

import java.util.Objects;

public class UserEntity extends Entity {

    private String email;
    private String password;
    private String name;
    private String phone_number;
    private int role;

    /**
     * default constructor
     */
    public UserEntity(){

    }

    public UserEntity(final int id, final String email, final String password, final String name, final String phone_number, final int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(final String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRole() {
        return role;
    }

    public void setRole(final int role) {
        this.role = role;
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        UserEntity that = (UserEntity) obj;
        return role == that.role &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone_number, that.phone_number);
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, name, phone_number, role);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", role=" + role +
                '}';
    }
}
