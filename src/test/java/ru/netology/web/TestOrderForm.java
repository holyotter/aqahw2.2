package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestOrderForm {

    public int days;
    public String dateMeeting = DateMeeting.dateInput(3);

    @Test
    public void shouldAccepted() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Краснодар");
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(DateMeeting.dateInput(days));
        $("[data-test-id=name] [name='name']").setValue("Валерий Копин-Боков");
        $("[data-test-id=phone] [name='phone']").setValue("+79296969292");
        $("[class=checkbox__box]").click();
        $(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
        $(withText(dateMeeting)).shouldBe(visible, Duration.ofSeconds(15));
    }
}
