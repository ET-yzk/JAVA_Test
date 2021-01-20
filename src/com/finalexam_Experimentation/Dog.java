package com.finalexam_Experimentation;

import java.util.Arrays;

public class Dog {
    private String type;
    private String gender;
    public float[] score;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float[] getScore() {
        return score;
    }

    public void setScore(float[] score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + Arrays.toString(score) +
                '}';
    }

}
