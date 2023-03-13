package com.demoqa.practiceform.testdata;
import com.github.javafaker.Faker;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


public class TestStudentInit {
    Faker faker = new Faker();

    SimpleDateFormat formatter = new SimpleDateFormat("MMMM/dd/yyyy", Locale.ENGLISH);
    String[] birthday = formatter.format(faker.date().birthday()).split("/");
    private String testFirstName = faker.name().firstName();
    private String testLastName = faker.name().lastName();
    private String testEmail = faker.internet().emailAddress();
    private String testMobilePhone = faker.phoneNumber().subscriberNumber(10);
    private String genderTest = faker.options().option(Gender.values()).toString();
    private String testSubject = faker.options().option(Subject.values()).toString();
    private String testHobby = faker.options().option(Hobby.values()).toString();
    private String testDay = birthday[1];
    private String testMonth = birthday[0];
    private String testYear = birthday[2];
    private File testFile = new File("testFiles/test.png");
    private String testFileClassPath = testFile.toPath().toString();
    private String testFileName = testFile.getName();
    private String testCurrentAddress = faker.address().fullAddress();

    private HashMap<String,List<City>> stateCitiesMap = new HashMap<>(){{
        put(State.NCR.toString(),new ArrayList<>(Arrays.asList(City.DELHI,City.GURGAON,City.NOIDA)));
        put(State.UTTAR_PRADESH.toString(), new ArrayList<>(Arrays.asList(City.AGRA,City.LUCKNOW,City.MERRUT)));
        put(State.HARYANA.toString(), new ArrayList<>(Arrays.asList(City.KARNAL,City.PANIPAT)));
        put(State.RAJASTHAN.toString(), new ArrayList<>(Arrays.asList(City.JAIPUR,City.JAISELMER)));
    }};

    private String testState = faker.options().option(State.values()).toString();
    private String testCity = faker.options().nextElement(getCityForState(testState)).toString();

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

    public String getTestCity() {return testCity;}

    public String getTestState() {
        return testState;
    }

    public List<City> getCityForState (String stateName){
        return stateCitiesMap.get(stateName);
    }
}