package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestOrderForm {
    @Test
    public void shouldAccepted() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }
}
