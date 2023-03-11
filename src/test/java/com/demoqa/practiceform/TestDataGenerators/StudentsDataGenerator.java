package com.demoqa.practiceform.TestDataGenerators;
import com.github.javafaker.Faker;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;


public class StudentsDataGenerator {
    Faker faker = new Faker();
    private LocalDate birthday = LocalDate.from(faker.date().birthday().toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime());
    private String testFirstName = faker.name().firstName();
    private String testLastName = faker.name().lastName();
    private String testEmail = faker.internet().emailAddress();
    private String testMobilePhone = faker.phoneNumber().subscriberNumber(10);
    private String genderTest = getRandomElementFromGender(Gender.values());
    private String testSubject = getRandomElementFromSubjects(Subjects.values());
    private String testHobby = getRandomElementFromHobbies(Hobbies.values());
    private String testDay = getDayFromBirthday(birthday);
    private String testMonth = updateFirstCharToUpperCase(birthday.getMonth().toString());
    private String testYear = Integer.toString(birthday.getYear());
    private File testFile = new File("testFiles/test.png");
    private String testFileClassPath = testFile.toPath().toString();
    private String testFileName = testFile.getName();
    private String testCurrentAddress = faker.address().fullAddress();
    private String testCity = "Karnal";
    private String testState = "Haryana";

    public String getTestFirstName() {
        return testFirstName;
    }

    public String getTestLastName() {
        return testLastName;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public String getTestMobilePhone() {
        return testMobilePhone;
    }

    public String getGenderTest() {
        return genderTest;
    }

    public String getTestSubject() {
        return testSubject;
    }

    public String getTestHobby() {
        return testHobby;
    }

    public String getTestDay() {
        return testDay;
    }

    public String getTestMonth() {
        return testMonth;
    }

    public String getTestYear() {
        return testYear;
    }

    public String getTestFileClassPath() {
        return testFileClassPath;
    }

    public String getTestFileName() {
        return testFileName;
    }

    public String getTestCurrentAddress() {
        return testCurrentAddress;
    }

    public String getTestCity() {
        return testCity;
    }

    public String getTestState() {
        return testState;
    }

    public int getRandomIndexArray(Object[] array) {
        return ThreadLocalRandom.current().nextInt(0, array.length - 1);
    }

    public String getRandomElementFromSubjects(Subjects[] subjects) {
        int index = getRandomIndexArray(subjects);
        return subjects[index].toString();
    }

    public String getRandomElementFromGender(Gender[] genders) {
        int index = getRandomIndexArray(genders);
        return genders[index].toString();
    }

    public String getRandomElementFromHobbies(Hobbies[] hobbies) {
        int index = getRandomIndexArray(hobbies);
        return hobbies[index].toString();
    }

    public String updateFirstCharToUpperCase(String value) {
        String inLowerCaseString = value.toLowerCase();
        char firstCharToUpperCase = Character.toUpperCase(inLowerCaseString.charAt(0));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inLowerCaseString).setCharAt(0, firstCharToUpperCase);
        return stringBuilder.toString();
    }

    public String getDayFromBirthday(LocalDate birthday) {
        int dayFromBirthday = birthday.getDayOfMonth();
        return dayFromBirthday < 10 ? "0" + dayFromBirthday : Integer.toString(dayFromBirthday);
    }
}

