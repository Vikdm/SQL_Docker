package ru.netology.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.VerificPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class test {

    @BeforeEach
    void openPage() {
        open("http://localhost:7777");
        refresh();
    }


    @Test
    void test1() {
        var verificPage = new VerificPage();
        $("[data-test-id=error-notification]").shouldHave(text("Ошибка! Неверно указан логин или пароль"));
    }

    @Test
    void test2() {
        $("[data-test-id=login] input").setValue("vasya");
        $("[data-test-id=password] input").setValue("qwerty123");
        $("[data-test-id=action-login]").click();
        $("[data-test-id=code] input").setValue("12345");
        $("[data-test-id=action-verify]").click();
        $("[data-test-id=error-notification]").shouldHave(text("Ошибка! Неверно указан код! Попробуйте ещё раз."));
    }
}
