package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestOrderForm {

    public int days;

    @BeforeEach
    public void openPage() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    public void shouldAccepted() {
        $("[data-test-id=city] input").setValue("Краснодар");
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(DateMeeting.dataInput(days));
        $("[data-test-id=name] [name='name']").setValue("Валерий Копин-Боков");
        $("[data-test-id=phone] [name='phone']").setValue("+79296969292");
        $("[class=checkbox__box]").click();
        $(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
