package ru.iteco.fmhandroid.ui.Object;

import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.Data.Data.enterButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.logOutButtonId1;
import static ru.iteco.fmhandroid.ui.Data.Data.logOutButtonId2;
import static ru.iteco.fmhandroid.ui.Data.Data.loginId;
import static ru.iteco.fmhandroid.ui.Data.Data.passwordId;
import static ru.iteco.fmhandroid.ui.Data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.Data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.inputText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

import ru.iteco.fmhandroid.R;

public class AuthorizationPage {
    public static final void LogIn() {
        step("Вход в аккаунт");
        waitingForElement(R.id.login_text_input_layout);
        inputText(loginId, validLogin);
        inputText(passwordId, validPassword);
        clickButton(enterButtonId);

    }

    public static final void LogOut() {
        step("Выход из аккаунта]");
        clickButton(logOutButtonId1);
        clickButton(logOutButtonId2);
    }
}
