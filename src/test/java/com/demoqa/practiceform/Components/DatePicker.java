package com.demoqa.practiceform.Components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DatePicker {
    private final SelenideElement DATE_PICKER_WINDOW = $(".react-datepicker");
    private final SelenideElement MONTH_SELECT = $(".react-datepicker__month-select");
    private final SelenideElement YEAR_SELECT = $(".react-datepicker__year-select");

    public DatePicker checkVisibilityDatePicker(){
        DATE_PICKER_WINDOW.shouldBe(visible);
        return this;
    }

    public DatePicker selectMonthByValue(String monthNumber){
        MONTH_SELECT.selectOptionByValue(monthNumber);
        return this;
    }

    public DatePicker selectMonth(String monthName){
        MONTH_SELECT.selectOption(monthName);
        return this;
    }

    public DatePicker selectYear(String year){
        YEAR_SELECT.selectOption(year);
        return this;
    }

    public DatePicker selectDay(int day){
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
