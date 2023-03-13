package com.demoqa.practiceform;

import com.demoqa.practiceform.testdata.TestStudentInit;
import com.demoqa.practiceform.pages.StudentRegistrationForm;
import org.junit.jupiter.api.Test;


public class PracticeFormPojoTest extends BasePracticeFormConfiguration {

    StudentRegistrationForm registrationForm = new StudentRegistrationForm();

    @Test
    public void successAllElementsRegistration(){
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
                        .verifyTableInModalWindow("Label","Values")
                        .verifyTableInModalWindow("Student Name", localTestStudentsData.getTestFirstName() + " " + localTestStudentsData.getTestLastName())
                        .verifyTableInModalWindow("Student Email",localTestStudentsData.getTestEmail())
                        .verifyTableInModalWindow("Gender", localTestStudentsData.getGenderTest())
                        .verifyTableInModalWindow("Mobile", localTestStudentsData.getTestMobilePhone())
                        .verifyTableInModalWindow("Date of Birth", localTestStudentsData.getTestDay() + " " + localTestStudentsData.getTestMonth() + "," + localTestStudentsData.getTestYear())
                        .verifyTableInModalWindow("Subjects", localTestStudentsData.getTestSubject())
                        .verifyTableInModalWindow("Hobbies", localTestStudentsData.getTestHobby())
                        .verifyTableInModalWindow("Picture", localTestStudentsData.getTestFileName())
                        .verifyTableInModalWindow("Address", localTestStudentsData.getTestCurrentAddress())
                        .verifyTableInModalWindow("State and City", localTestStudentsData.getTestState() + " " + localTestStudentsData.getTestCity());
    }
}
