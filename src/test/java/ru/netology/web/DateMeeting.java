package ru.netology.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMeeting {
    static String dataInput(int days) {
        String inputDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return inputDate;
    }
}