package ru.netology.bdsql.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.bdsql.data.DataBase;
import ru.netology.bdsql.data.DataHelper;
import ru.netology.bdsql.data.UserData;
import ru.netology.bdsql.page.DashboardPage;
import ru.netology.bdsql.page.LoginPage;
import ru.netology.bdsql.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    UserData userData;
    LoginPage login;


    @BeforeEach
    public void setup() {
        open("http://localhost:9999/");
        userData = DataHelper.validUser();
        login = new LoginPage();
    }

    @AfterEach
    public void after() {
        DataBase.resetStatus(userData.getName());
        DataBase.resetVerifyCode();
    }

    @AfterAll
    public static void afterAll() {
        DataBase.resetBase();
    }

    @Test
    public void validData() {
        login.input(userData.getName(), userData.getPassword());
        VerificationPage verification = new VerificationPage();
        verification.input(DataHelper.validVerifyCode(userData.getName()));
        DashboardPage dashboard = new DashboardPage();
        dashboard.visiblePage();


    }

    @Test
    public void blockedInvalidPass() {
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        DataHelper.assertStatus(userData.getName());
    }
}
