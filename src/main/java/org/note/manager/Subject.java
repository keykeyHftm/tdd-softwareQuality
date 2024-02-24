package org.note.manager;

import java.util.ArrayList;

public class Subject {
    private String name;
    private double note;

    private ArrayList<Exam> exams;

    public Subject(String name) {
        this.name = name;
        this.exams = new ArrayList<Exam>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public double calculateNote() throws Exception {
        if (this.exams.size() == 0) {
            throw new Exception("No Exams added!");
        }
        double result = 0.0;
        for(Exam exam: exams) {
            result += exam.getNote();
        }

        return result / this.exams.size();
    }

    public String toString() {
        return this.name;
    }
}
