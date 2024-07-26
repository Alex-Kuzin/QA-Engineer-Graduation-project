package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.devMark;
import static ru.iteco.fmhandroid.ui.Data.Data.privacyPolicyLink;
import static ru.iteco.fmhandroid.ui.Data.Data.termsOfUseLink;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkIsDisplayed;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.Object.AboutPage.OpenAboutPage;
import static ru.iteco.fmhandroid.ui.Object.AboutPage.clickOutButton;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogIn;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogOut;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование страницы `О приложении`")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));

    @Before
    public void In() {
        LogIn();
        OpenAboutPage();
    }

    @After
    public void Out() {
        clickOutButton();
        LogOut();
    }

    @Test
    @DisplayName("Отображение сведений о версии приложения")
    public void checkTexts() {
        checkIsDisplayed(devMark);
        checkText("Version:");
        checkText("1.0.0");
        checkText("Privacy Policy:");
        checkText("Terms of use:");
    }

    @Test
    @DisplayName("Отображение ссылок")
    public void checkLinks() {
        checkIsDisplayed(privacyPolicyLink);
        checkText("https://vhospice.org/#/privacy-policy/");
        checkIsDisplayed(termsOfUseLink);
        checkText("https://vhospice.org/#/terms-of-use");
    }
}
