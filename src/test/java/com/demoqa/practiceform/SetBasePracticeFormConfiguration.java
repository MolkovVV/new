package com.demoqa.practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class SetBasePracticeFormConfiguration {
    @BeforeEach
    public void addBrowserSize() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }
}
