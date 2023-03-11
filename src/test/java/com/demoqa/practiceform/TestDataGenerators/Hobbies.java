package com.demoqa.practiceform.TestDataGenerators;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private String hobby;

    Hobbies(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return hobby;
    }
}
