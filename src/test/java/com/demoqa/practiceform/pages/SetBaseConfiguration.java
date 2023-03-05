package com.demoqa.practiceform.pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class SetBaseConfiguration {
    @BeforeEach
    public void addBrowserSize() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }
}
