package com.juaracoding.utlis;

public enum ScenarioTests {

    //loginfeature
    T1("Suceccesfull login with valid credentials"),
    T2("Failed login with invalid credentials"),
    T3("Failed login with invalid credentials"),
    T4("Failed login with invalid credentials"),
    //checkoutfeature
    T5("Successful checkout process"),
    T6("Failed checkout process with empty information");


    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName  = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
