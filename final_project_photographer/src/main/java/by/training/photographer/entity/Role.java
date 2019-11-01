package by.training.photographer.entity;

import java.util.stream.Stream;

public enum Role {
    ADMIN(1), USER(2);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Role getById(int id) {
        return Stream.of(values())
            .filter(role -> role.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
