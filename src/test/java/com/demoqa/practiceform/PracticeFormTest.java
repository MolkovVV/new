package com.demoqa.practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @Test
    @Tag("Smoke")
    public void formIsVisible(){
        Configuration.baseUrl = "https://demoqa.com/";
        //open form
        open("automation-practice-form");
        //assert that form is visible (question: Can I use isDisplayed() method in this step?)
        $("form[novalidate]#userForm").shouldBe(visible);
    }

    @Test
    @Tag("Functional")
    public void successRegistryNewStudent() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        //open form
        open("automation-practice-form");
        //add Name in input
        $("#firstName").setValue("Jonny");
        //add LastName in input
        $("#lastName").setValue("Walker");
        //add email in input
        $("#userEmail").setValue("test@gmail.com");
        //radio-button check
        $("#genterWrapper").$$(".custom-control-inline").first().click();
        //set phone number
        $("#userNumber").setValue("9102222222");

        //date setup (question: How insert random date with sendKeys??? it doesn`t replace default value)
        //$("#dateOfBirthInput").sendKeys("02/20/2002");
        $("#dateOfBirthInput").click();
        $$(".react-datepicker__week").first().ancestor(".").click();
        //add text in subjectInput
        $("#subjectsInput").setValue("text");
        //set hobbie checkbox
        $("#hobbies-checkbox-3").sendKeys(" ");
        //set currentAddress
        $("#currentAddress").setValue("example text");
        //set State
        $("#state").scrollTo().click();
        $$(".css-yt9ioa-option").first().click();
        //set City
        $("#city").click();
        $$(".css-1n7v3ny-option").first().click();
        //submit on button with bug
        /*$("#city").click();
        $("#submit").click();
        sleep(4000);
        */
        //submit on Enter
        $("#city").click();
        $("#submit").pressEnter();

        //Asserts
        $(".modal-dialog").isDisplayed();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody").find("tr",0).find("td",1).shouldHave(text("Jonny"));
        $("tbody").find("tr",1).find("td",1).shouldHave(text("test@gmail.com"));
        $("tbody").find("tr",2).find("td",1).shouldNotBe(empty);
        $("tbody").find("tr",3).find("td",1).shouldHave(text("9102222222"));
    }
}
