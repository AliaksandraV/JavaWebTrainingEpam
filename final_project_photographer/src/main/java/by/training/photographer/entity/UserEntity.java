package by.training.photographer.entity;

import java.util.Objects;

public class UserEntity extends Entity {

    private String email;
    private String passwordHash;
    private String salt;
    private String name;
    private String phoneNumber;
    private Role role;

    /**
     * default constructor.
     */
    public UserEntity() {

    }

    public UserEntity(final int id) {
        super(id);
    }

    public UserEntity(final Integer id,
                      final String email,
                      final String passwordHash,
                      final String salt,
                      final String name,
                      final String phoneNumber,
                      final Role role) {
        super(id);
        this.email = email;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
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
                Objects.equals(passwordHash, that.passwordHash) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, passwordHash, salt, name, phoneNumber, role);
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
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
