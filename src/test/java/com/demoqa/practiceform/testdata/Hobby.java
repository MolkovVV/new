package com.demoqa.practiceform.testdata;

public enum Hobby {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private String hobby;

    Hobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return hobby;
    }
}
