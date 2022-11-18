package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Classroom {

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



}
