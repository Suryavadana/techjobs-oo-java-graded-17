package org.launchcode.techjobs.oo;

import java.util.Objects;
public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false; // Corrected instanceof check
        JobField other = (JobField) o; // Cast to JobField
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    // No setter for id since it's managed internally

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
