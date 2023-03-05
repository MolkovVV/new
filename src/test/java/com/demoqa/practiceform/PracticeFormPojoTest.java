package com.demoqa.practiceform;

import com.demoqa.practiceform.pages.SetBaseConfiguration;
import com.demoqa.practiceform.pages.StudentRegistrationForm;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class PracticeFormPojoTest extends SetBaseConfiguration {
    Faker faker = new Faker();
    String testFirstName = faker.name().firstName();
    String testLastName = faker.name().lastName();
    String testEmail = faker.internet().emailAddress();
    String testMobilePhone = faker.phoneNumber().subscriberNumber(10);
    String genderTest = "Other";
    String testSubjVal = faker.educator().course();
    String testHobbie = "Sports";
    int testDay = 12;
    String testMonth = "February";
    int testYear = 1991;
    String testFileClassPath = "testFiles/test.png";
    String testCurrentAdress = faker.address().fullAddress();
    String testCity ="Karnal";
    String testState ="Haryana";

    StudentRegistrationForm registrationForm = new StudentRegistrationForm();

    @Test
    public void successAllElementsRegistration(){
        registrationForm.openPracticeFormPage()
                        .setFirstName(testFirstName)
                        .setLastName(testLastName)
                        .setEmail(testEmail)
                        .setGender(genderTest)
                        .setPhoneNumber(testMobilePhone)
                        .setDate(testDay, testMonth, testYear)
                        .setSubjectsValue(testSubjVal)
                        .setHobbiesValue(testHobbie)
                        .uploadFileFromClassPath(testFileClassPath)
                        .setCurrentAddress(testCurrentAdress)
                        .setState(testState)
                        .setCity(testCity)
                        .submitForm();

        registrationForm.verifyModalAppears()
                        .verifyTableInModalWindow("Label","Values")
                        .verifyTableInModalWindow("Student Name", testFirstName + " " + testLastName)
                        .verifyTableInModalWindow("Student Email",testEmail)
                        .verifyTableInModalWindow("Gender", genderTest)
                        .verifyTableInModalWindow("Mobile", testMobilePhone)
                        .verifyTableInModalWindow("Date of Birth", testDay + " " + testMonth + "," + testYear)
                        //.verifyTableInModalWindow("Subjects", testSubjVal)
                        .verifyTableInModalWindow("Hobbies", testHobbie)
                        .verifyTableInModalWindow("Picture", testFileClassPath.substring(testFileClassPath.indexOf("/")+1))
                        .verifyTableInModalWindow("Address", testCurrentAdress)
                        .verifyTableInModalWindow("State and City", testState + " " + testCity);
    }
}
