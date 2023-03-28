package com.demoqa.practiceform.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.practiceform.components.DatePicker;
import com.demoqa.practiceform.components.SuccessModalWindow;
import io.qameta.allure.Step;

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

    @Step("Открываем форму регистрации")
    public StudentRegistrationForm openForm(){
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Убираем banner")
    public StudentRegistrationForm removeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Убираем footer")
    public StudentRegistrationForm removeFooter(){
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("В input FirstName вводим значение {firstName}")
    public StudentRegistrationForm setFirstName(String firstName){
        FIRST_NAME_INPUT.setValue(firstName);
        return this;
    }

    @Step("В input LastName вводим значение {lastName}")
    public StudentRegistrationForm setLastName(String lastName){
        LAST_NAME_INPUT.setValue(lastName);
        return this;
    }

    @Step("В input Email вводим значение {email}")
    public StudentRegistrationForm setEmail(String email){
        EMAIL_INPUT.setValue(email);
        return this;
    }

    @Step("Устанавливаем значение {gender} для поля Gender")
    public StudentRegistrationForm setGender(String gender){
        GENDER_BUTTONS_ROW.$(byText(gender)).click();
        return this;
    }

    @Step("В поле PhoneNumber вводим значение {phoneNumber}")
    public StudentRegistrationForm setPhoneNumber(String phoneNumber){
        MOBILE_NUMBER_INPUT.setValue(phoneNumber);
        return this;
    }

    @Step("В поле BirthdayDate устанавливаем значение {day}/{monthName}/{year}")
    public StudentRegistrationForm setDate(String day, String monthName, String year){
        DATE_OF_BIRTH_INPUT.click();
        datePickerOnStudentRegistrationForm.checkVisibilityDatePicker();
        datePickerOnStudentRegistrationForm.selectYear(year);
        datePickerOnStudentRegistrationForm.selectMonth(monthName);
        datePickerOnStudentRegistrationForm.selectDay(day);

        return this;
    }

    @Step("В поле Subject устанавливаем значение {subjects}")
    public StudentRegistrationForm setSubjectsValue(String subjects){
        SUBJECTS_INPUT.setValue(subjects).pressEnter();
        return this;
    }

    @Step("В поле Hobby устанавливаем значение {hobby}")
    public StudentRegistrationForm setHobbiesValue(String hobby){
        HOBBIES_ROW.$(byText(hobby)).click();
        return this;
    }

    @Step("В поле UploadFile загружаем файл {filename}")
    public StudentRegistrationForm uploadFileFromClassPath(String filename){
        UPLOAD_IMG_INPUT.uploadFromClasspath(filename);
        return this;
    }

    @Step("В поле currentAddress устанавливаем значение {currentAddress}")
    public StudentRegistrationForm setCurrentAddress(String currentAddress){
        ADDRESS_TEXT_AREA.setValue(currentAddress);
        return this;
    }

    @Step("В поле City устанавливаем значение {city}")
    public StudentRegistrationForm setCity(String city){
        CITY_DROPDOWN.click();
        CITY_STATE_ELEMENT_WRAPPER.$(byText(city)).click();
        return this;
    }

    @Step("В поле State устанавливаем значение {state}")
    public StudentRegistrationForm setState(String state){
        STATE_DROPDOWN.click();
        CITY_STATE_ELEMENT_WRAPPER.$(byText(state)).click();
        return this;
    }

    @Step("Отправили форму")
    public void submitForm(){
        SUBMIT_BUTTON.click();
    }

    @Step("Проверить отображение pop-up окна при успешной регистрации")
    public StudentRegistrationForm verifyModalAppears(){
        modalWindow.registrationModalVerify();
        return this;
    }

    @Step("В pop-up окне значение для {key} соответствует {value}")
    public StudentRegistrationForm verifyTableInModalWindow(String key, String value){
        modalWindow.verifyResultInTable(key,value);
        return this;
    }
}