package com.demoqa.practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    public static void setBaseUrl() {
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    @Tag("Smoke")
    public void formIsVisible() {
        open("automation-practice-form");
        $("form[novalidate]#userForm").shouldBe(visible);
    }


    @BeforeEach
    public void addBrowserSize() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    @Tag("Functional")
    public void successfulNewStudentRegistration() {
        open("automation-practice-form");
        $("#firstName").setValue("Jonny");
        $("#lastName").setValue("Walker");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$$(".custom-control-inline").first().click();
        $("#userNumber").setValue("9102222222");
        $("#dateOfBirthInput").click();
        $$(".react-datepicker__week").first().ancestor(".").click();
        $("#subjectsInput").setValue("text");
        $("#hobbies-checkbox-3").sendKeys(" ");
        $("#currentAddress").setValue("example text");
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#city").click();
        $("#submit").pressEnter();

        //Asserts
        $(".modal-dialog").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody").find("tr", 0).find("td", 1).shouldHave(text("Jonny"));
        $("tbody").find("tr", 1).find("td", 1).shouldHave(text("test@gmail.com"));
        $("tbody").find("tr", 2).find("td", 1).shouldHave(text("Male"));
        $("tbody").find("tr", 3).find("td", 1).shouldHave(text("9102222222"));
        $("tbody").find("tr", 4).find("td", 1).shouldBe(matchText("([0-9]{2}\\s\\w{3,8}.[0-9]{4})"));
    }
}
