package com.demoqa.practiceform;

import com.demoqa.practiceform.pages.StudentRegistrationForm;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PracticeFormPojoTest extends SetBasePracticeFormConfiguration {
    Faker faker = new Faker();
    String testFirstName = faker.name().firstName();
    String testLastName = faker.name().lastName();
    String testEmail = faker.internet().emailAddress();
    String testMobilePhone = faker.phoneNumber().subscriberNumber(10);
    String genderTest = "Other";
    String testSubject = "Math";
    String testHobby = "Sports";
    String testDay = "12";
    String testMonth = "February";
    String testYear = "1991";
    File testFile = new File("testFiles/test.png");
    String testFileClassPath = testFile.toPath().toString();
    String testFileName = testFile.getName();
    String testCurrentAdress = faker.address().fullAddress();
    String testCity ="Karnal";
    String testState ="Haryana";

    StudentRegistrationForm registrationForm = new StudentRegistrationForm();

    @Test
    public void successAllElementsRegistration(){
        registrationForm.openStudentRegistrationFormPage()
                        .removeBannerOnRegistrationFormPage()
                        .removeFooterOnRegistrationFormPage()
                        .setFirstName(testFirstName)
                        .setLastName(testLastName)
                        .setEmail(testEmail)
                        .setGender(genderTest)
                        .setPhoneNumber(testMobilePhone)
                        .setDate(testDay, testMonth, testYear)
                        .setSubjectsValue(testSubject)
                        .setHobbiesValue(testHobby)
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
                        .verifyTableInModalWindow("Subjects", testSubject)
                        .verifyTableInModalWindow("Hobbies", testHobby)
                        .verifyTableInModalWindow("Picture", testFileName)
                        .verifyTableInModalWindow("Address", testCurrentAdress)
                        .verifyTableInModalWindow("State and City", testState + " " + testCity);
    }
}
