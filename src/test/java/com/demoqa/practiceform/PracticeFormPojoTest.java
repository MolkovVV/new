package com.demoqa.practiceform;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.practiceform.helpers.Attach;
import com.demoqa.practiceform.testdata.TestStudentInit;
import com.demoqa.practiceform.pages.StudentRegistrationForm;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PracticeFormPojoTest extends BasePracticeFormConfiguration {

    StudentRegistrationForm registrationForm = new StudentRegistrationForm();
    @Tag("Registration")
    @Test
    public void successAllElementsRegistration() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        TestStudentInit localTestStudentsData = new TestStudentInit();

            registrationForm.openForm()
                            .removeBanner()
                            .removeFooter()
                            .setFirstName(localTestStudentsData.getTestFirstName())
                            .setLastName(localTestStudentsData.getTestLastName())
                            .setEmail(localTestStudentsData.getTestEmail())
                            .setGender(localTestStudentsData.getGenderTest())
                            .setPhoneNumber(localTestStudentsData.getTestMobilePhone())
                            .setDate(localTestStudentsData.getTestDay(), localTestStudentsData.getTestMonth(), localTestStudentsData.getTestYear())
                            .setSubjectsValue(localTestStudentsData.getTestSubject())
                            .setHobbiesValue(localTestStudentsData.getTestHobby())
                            .uploadFileFromClassPath(localTestStudentsData.getTestFileClassPath())
                            .setCurrentAddress(localTestStudentsData.getTestCurrentAddress())
                            .setState(localTestStudentsData.getTestState())
                            .setCity(localTestStudentsData.getTestCity())
                            .submitForm();

            registrationForm.verifyModalAppears()
                    .verifyTableInModalWindow("Label", "Values")
                    .verifyTableInModalWindow("Student Name", localTestStudentsData.getTestFirstName() + " " + localTestStudentsData.getTestLastName())
                    .verifyTableInModalWindow("Student Email", localTestStudentsData.getTestEmail())
                    .verifyTableInModalWindow("Gender", localTestStudentsData.getGenderTest())
                    .verifyTableInModalWindow("Mobile", localTestStudentsData.getTestMobilePhone())
                    .verifyTableInModalWindow("Date of Birth", localTestStudentsData.getTestDay() + " " + localTestStudentsData.getTestMonth() + "," + localTestStudentsData.getTestYear())
                    .verifyTableInModalWindow("Subjects", localTestStudentsData.getTestSubject())
                    .verifyTableInModalWindow("Hobbies", localTestStudentsData.getTestHobby())
                    .verifyTableInModalWindow("Picture", localTestStudentsData.getTestFileName())
                    .verifyTableInModalWindow("Address", localTestStudentsData.getTestCurrentAddress())
                    .verifyTableInModalWindow("State and City", localTestStudentsData.getTestState() + " " + localTestStudentsData.getTestCity());
            Attach.pageSource();
            Attach.screenshotAs("screenshot");
            Attach.browserConsoleLogs();
            Attach.addVideo();
    }
}
