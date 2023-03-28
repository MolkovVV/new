package com.demoqa.practiceform.testdata;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String value;
    Gender(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}