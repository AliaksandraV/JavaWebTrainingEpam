package by.training.photographer.entity;

public class UserEntity {

    private int id;
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private int role;

    public UserEntity(final int id, final String email, final String password, final String name, final String phone_number, final int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.role = role;
    }

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
