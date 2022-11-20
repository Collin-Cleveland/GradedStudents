package io.zipcoder;

import java.util.*;

public class Classroom {

    private HashMap<Student, String> gb = new HashMap<>();

    public Student[] students;
    int maxNumberOfStudents;


    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(){
        students = new Student[30];
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore(){
        double sum = 0;
        int count = 0;

        for (int i = 0; i < students.length; i++){
            while (students != null){
                count++;
                sum += students[i].getAverageExamScore();
                break;
            }
        }

        return sum / count;
    }

    public void removeStudent(String firstName, String lastName){

        for (int i = 0; i < students.length; i++){
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)){
                students[i] = null;
            }
        }
        Boolean sorted = false;
        Student swap;
        while (!sorted){
            sorted = true;
            for (int j = 0; j < students.length -1; j++){
                if (students[j] == null){
                    swap = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = swap;
                    sorted = false;
                }
            }
        }
//        for (int j = temp + 1; j < students.length; j++){
//            if (students[j] == null){
//                students[count] = students[j - 1];
//                students[j - 1] = null;
//            }
//        }
    }

    public Student[] getStudentsByScore(){
        sortStudentsByScore();

        return students;
    }

    public void sortStudentsByName() {
        Arrays.sort(students, Student.nameComparator);
    }

    public void sortStudentsByScore() {
        sortStudentsByName();
        Arrays.sort(students, Student.scoreComparator);
    }

    public HashMap<Student, String> getGradeBook() {

        this.students = getStudentsByScore();

        for (int i = 0; i < students.length; i++) {
            double percentile = 0;
            double rank = students.length - (i + 1);
            percentile = (rank / students.length) * 100.0;
            if (percentile >= 90) {
                //A
                gb.put(students[i], "A");
            } else if (percentile <= 89 && percentile >= 71) {
                //B
                gb.put(students[i], "B");
            } else if (percentile <= 70 && percentile >= 50) {
                //c
                gb.put(students[i], "C");
            } else if (percentile <= 49 && percentile >= 11) {
                //D
                gb.put(students[i], "D");
            } else {
                //F
                gb.put(students[i], "F");
            }
        }
        return gb;
    }



}
