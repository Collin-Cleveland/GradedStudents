package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    @Test
    public void testGetExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };

        ArrayList examScoresList = new ArrayList(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Exam Scores:\n\tExam 1 -> 100.0\n\tExam 2 -> 95.0\n\tExam 3 -> 123.0\n\tExam 4 -> 96.0";

        // When
        String output = student.getExamScores();

        // Then
        System.out.println(output);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testAddExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {};
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Exam Scores:\n\tExam 1 -> 100.0";

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testSetExamScore(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Exam Scores:\n\tExam 1 -> 150.0";

        // When
        student.setExamScore(0, 150.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void getAverageExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoreList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoreList);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then
        System.out.println(output);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoreList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoreList);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }

}