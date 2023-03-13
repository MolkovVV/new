package com.demoqa.practiceform.testdata;

public enum City {
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    NOIDA("Noida"),
    AGRA("Agra"),
    LUCKNOW("Lucknow"),
    MERRUT("Merrut"),
    KARNAL("Karnal"),
    PANIPAT("Panipat"),
    JAIPUR("Jaipur"),
    JAISELMER("Jaiselmer");

    private String nameCity;

    City(String nameCity){
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return nameCity;
    }
}
