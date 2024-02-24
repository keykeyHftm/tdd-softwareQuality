package org.note.manager;

public class Exam {
    private String name;
    private double note;

    public Exam(String name, double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public double getNote() {
        return note;
    }
}
