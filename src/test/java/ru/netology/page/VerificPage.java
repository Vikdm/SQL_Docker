package ru.netology.page;
import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class VerificPage {

    private static final Faker faker = new Faker(new Locale("en"));

    public VerificPage() {
        $("[data-test-id=login] input").setValue(faker.name().firstName());
        $("[data-test-id=password] input").setValue(faker.internet().password(4,6));
        $("[data-test-id=action-login]").click();
    }
}