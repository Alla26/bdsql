package ru.netology.bdsql.data;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataHelper {

    private static Faker faker = new Faker();

    public static UserData validUser() {
        return new UserData("vasya", "qwerty123");
    }

    public static String validVerifyCode(String login) {
        String verifyCode = DataBase.getValidVerifyCode(login);
        return verifyCode;
    }

    public static String invalidVerifyCode() {
        int verifyCode = faker.number().numberBetween(100000, 999999);
        return String.valueOf(verifyCode);
    }

}
