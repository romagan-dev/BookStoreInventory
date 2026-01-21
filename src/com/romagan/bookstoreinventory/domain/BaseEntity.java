package com.romagan.bookstoreinventory.domain;

import java.util.UUID;

public abstract class BaseEntity implements Entity {

    private final UUID id;

    protected Map<String, List<String>> errors;

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
