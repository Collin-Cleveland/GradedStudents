package io.zipcoder;

import java.util.ArrayList;

public class Student {

    public  String firstName;
    public String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder list = new StringBuilder("Exam Scores:");

        for(int i = 0; i < this.examScores.size(); i++) {
            list.append("\n\tExam ").append(i + 1).append(" -> ").append(this.examScores.get(i));
        }

        return list.toString();
    }

    public void addExamScore(double examScore){
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newExamScore){
        this.examScores.set(examNumber, newExamScore);
    }

    public double getAverageExamScore(){
        int sum = 0;
        for (int i = 0; i < examScores.size(); i++){
            sum += examScores.get(i);
        }
        return sum / examScores.size();
    }

    @Override
    public String toString(){
        return String.format("Student Name: %s %s\n> Average Scores: %s\n> %s", this.firstName, this.lastName, (int) getAverageExamScore(), getExamScores());
    }

}
