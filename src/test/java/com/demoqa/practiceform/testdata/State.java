package com.demoqa.practiceform.testdata;


public enum State {
    NCR("NCR"),
    UTTAR_PRADESH("Uttar Pradesh"),
    HARYANA("Haryana"),
    RAJASTHAN("Rajasthan");

    private String stateName;

    State(String stateName){
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return stateName;
    }
}
