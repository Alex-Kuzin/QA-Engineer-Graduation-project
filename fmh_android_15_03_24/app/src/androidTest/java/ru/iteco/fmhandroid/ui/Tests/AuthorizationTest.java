package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.enterButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.Data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.Data.Data.loginId;
import static ru.iteco.fmhandroid.ui.Data.Data.passwordId;
import static ru.iteco.fmhandroid.ui.Data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.Data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkToasts;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.inputText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogIn;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogOut;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;


@Epic("Тестирование страницы Авторизации")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Before
    public void waitElements() {
        waitingForElement(R.id.login_text_input_layout);
    }

    @Test
    public void validData() {
        LogIn();
        waitingForElement(R.id.container_list_news_include_on_fragment_main);
        LogOut();

    }

    @Test
    @DisplayName("Ввод не валидных данных")
    public void invalidData() {
        inputText(loginId, invalidLogin);
        inputText(passwordId, invalidPassword);
        clickButton(enterButtonId);
        checkToasts("Something went wrong. Try again later.");

    }

    @Test
    @DisplayName("Поля не заполнены")
    public void emptyFields() {
        clickButton(enterButtonId);
        checkToasts("Login and password cannot be empty");

    }

    @Test
    @DisplayName("Поля заполнены пробелом")
    public void spaceData() {
        inputText(loginId, " ");
        inputText(passwordId, " ");
        clickButton(enterButtonId);
        checkToasts("Login and password cannot be empty");

    }

    @Test
    @DisplayName("Поле пароль не заполнено")
    public void emptyPassword() {
        inputText(loginId, validLogin);
        clickButton(enterButtonId);
        checkToasts("Login and password cannot be empty");

    }

    @Test
    @DisplayName("Поле логин не заполнено")
    public void emptyLogin() {
        inputText(passwordId, validPassword);
        clickButton(enterButtonId);
        checkToasts("Login and password cannot be empty");

    }
}
