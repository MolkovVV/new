package com.demoqa.practiceform.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.practiceform.Components.DatePicker;
import com.demoqa.practiceform.Components.SuccessModalWindow;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    private final SelenideElement FIRST_NAME_INPUT = $("#firstName");
    private final SelenideElement LAST_NAME_INPUT = $("#lastName");
    private final SelenideElement EMAIL_INPUT = $("#userEmail");
    private final SelenideElement GENDER_BUTTONS_ROW = $("#genterWrapper");
    private final SelenideElement MOBILE_NUMBER_INPUT =  $("#userNumber");
    private final SelenideElement DATE_OF_BIRTH_INPUT = $("#dateOfBirthInput");
    DatePicker datePickerOnStudentRegistrationForm = new DatePicker();
    SuccessModalWindow modalWindow = new SuccessModalWindow();
    private final SelenideElement SUBJECTS_INPUT = $("#subjectsInput");
    private final SelenideElement HOBBIES_ROW = $("#hobbiesWrapper");
    private final SelenideElement UPLOAD_IMG_INPUT = $("#uploadPicture");
    private final SelenideElement ADDRESS_TEXT_AREA = $("#currentAddress");
    private final SelenideElement STATE_DROPDOWN = $("#state");
    private final SelenideElement CITY_DROPDOWN = $("#city");
    private final SelenideElement CITY_STATE_ELEMENT_WRAPPER = $("#stateCity-wrapper");
    private final SelenideElement SUBMIT_BUTTON =  $("#submit");

    public StudentRegistrationForm openStudentRegistrationFormPage(){
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationForm removeBannerOnRegistrationFormPage(){
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public StudentRegistrationForm removeFooterOnRegistrationFormPage(){
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public StudentRegistrationForm setFirstName(String firstName){
        FIRST_NAME_INPUT.setValue(firstName);
        return this;
    }

    public StudentRegistrationForm setLastName(String lastName){
        LAST_NAME_INPUT.setValue(lastName);
        return this;
    }

    public StudentRegistrationForm setEmail(String email){
        EMAIL_INPUT.setValue(email);
        return this;
    }

    public StudentRegistrationForm setGender(String gender){
        GENDER_BUTTONS_ROW.$(byText(gender)).click();
        return this;
    }

    public StudentRegistrationForm setPhoneNumber(String phoneNumber){
        MOBILE_NUMBER_INPUT.setValue(phoneNumber);
        return this;
    }

    public StudentRegistrationForm setDate(String day, String monthName, String year){
        DATE_OF_BIRTH_INPUT.click();
        datePickerOnStudentRegistrationForm.checkVisibilityDatePicker();
        datePickerOnStudentRegistrationForm.selectYear(year);
        datePickerOnStudentRegistrationForm.selectMonth(monthName);
        datePickerOnStudentRegistrationForm.selectDay(day);

        return this;
    }

    public StudentRegistrationForm setSubjectsValue(String subjects){
        SUBJECTS_INPUT.setValue(subjects).pressEnter();
        return this;
    }

    public StudentRegistrationForm setHobbiesValue(String hobby){
        HOBBIES_ROW.$(byText(hobby)).click();
        return this;
    }

    public StudentRegistrationForm uploadFileFromClassPath(String filename){
        UPLOAD_IMG_INPUT.uploadFromClasspath(filename);
        return this;
    }

    public StudentRegistrationForm setCurrentAddress(String currentAddress){
        ADDRESS_TEXT_AREA.setValue(currentAddress);
        return this;
    }

    public StudentRegistrationForm setCity(String city){
        CITY_DROPDOWN.click();
        CITY_STATE_ELEMENT_WRAPPER.$(byText(city)).click();
        return this;
    }

    public StudentRegistrationForm setState(String state){
        STATE_DROPDOWN.click();
        CITY_STATE_ELEMENT_WRAPPER.$(byText(state)).click();
        return this;
    }

    public void submitForm(){
        SUBMIT_BUTTON.click();
    }

    public StudentRegistrationForm verifyModalAppears(){
        modalWindow.registrationModalVerify();
        return this;
    }

    public StudentRegistrationForm verifyTableInModalWindow(String key, String value){
        modalWindow.verifyResultInTable(key,value);
        return this;
    }
}