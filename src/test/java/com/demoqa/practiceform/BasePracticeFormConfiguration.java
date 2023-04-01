package com.demoqa.practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePracticeFormConfiguration {
    @BeforeEach
    public void addBrowserSize() {
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com/");
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoidAddress","selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
