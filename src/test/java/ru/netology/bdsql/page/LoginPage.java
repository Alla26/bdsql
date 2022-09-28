package ru.netology.bdsql.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=\"login\"] .input__control");
    private SelenideElement passwordField = $("[data-test-id=\"password\"] .input__control");
    private SelenideElement buttonResume = $("[data-test-id=\"action-login\"] .button__text");


    public void input(String login, String password){
        loginField.val(login);
        passwordField.val(password);
        buttonResume.click();
    }

}
