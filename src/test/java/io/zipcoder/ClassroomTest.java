package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {

    @Test
    public void testAddStudent() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student("Leon", "Hunter", examScoresList);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment); //moved up so that classroom object doesnt get changed again

        classroom.addStudent(student);

        Student[] postEnrollment = classroom.getStudents();
        // Then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
        //manually checked output, null for pre enrollment, post populated with info
    }

    @Test
    public void testGetAverageExamScore() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));

        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
        Assert.assertEquals(expected, output, 0);
    }

    @Test
    public void testRemoveStudent(){
        Double[] s1Scores = { 225.0, 25.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 225.0, 25.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        Double[] s3Scores = { 225.0, 25.0 };
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        Double[] s4Scores = { 225.0, 25.0 };
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));
        Double[] s5Scores = { 225.0, 25.0 };
        ArrayList<Double> s5ScoresList = new ArrayList<>(List.of(s5Scores));

        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);
        Student s3 = new Student("student", "three", s3ScoresList);
        Student s4 = new Student("student", "four", s4ScoresList);
        Student s5 = new Student("student", "five", s5ScoresList);

        Student[] students = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent("student", "two");

        Student[] actual = classroom.getStudents();
        String removed = Arrays.toString(actual);
        Student[] expected = {s1,s3,s4,s5,null};

        // Then
        System.out.println(removed);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void testGetStudentByScore() {

        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 200.0, 200.0 };
        Double[] s3Scores = { 150.0, 150.0 };
        Double[] s4Scores = { 150.0, 150.0 };

        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));

        Student s1 = new Student("Bob", "one", s1ScoresList);
        Student s2 = new Student("Tyler", "two", s2ScoresList);
        Student s3 = new Student("Fred", "three", s3ScoresList);
        Student s4 = new Student("Anthony", "four", s4ScoresList);

        Student[] students = {s1,s2,s3,s4};
        Classroom classroom = new Classroom(students);

        String expected = Arrays.toString(classroom.getStudents());

        System.out.println(Arrays.toString(classroom.getStudentsByScore()));

        Assert.assertNotEquals(expected, Arrays.toString(classroom.getStudentsByScore()));
    }

    @Test
    public void getGradeBookTest_B() {

        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 50.0, 50.0 };
        Double[] s3Scores = { 75.0, 75.0 };
        Double[] s4Scores = { 80.0, 80.0 };
        Double[] s5Scores = { 90.0, 90.0 };

        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));
        ArrayList<Double> s5ScoresList = new ArrayList<>(List.of(s5Scores));

        Student s1 = new Student("Bob", "one", s1ScoresList);
        Student s2 = new Student("Tyler", "two", s2ScoresList);
        Student s3 = new Student("Fred", "three", s3ScoresList);
        Student s4 = new Student("Anthony", "four", s4ScoresList);
        Student s5 = new Student("Jack", "five", s5ScoresList);

        Student[] students = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(students);

        HashMap<Student, String> gb = classroom.getGradeBook();
        System.out.println(Collections.singletonList(gb));

        String expected = "B";
        String actual = gb.get(s1);



        Assert.assertEquals(actual, expected);


    }
}
