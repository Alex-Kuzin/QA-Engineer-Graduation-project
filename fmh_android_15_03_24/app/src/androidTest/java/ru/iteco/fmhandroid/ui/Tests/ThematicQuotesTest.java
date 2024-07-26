package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogIn;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogOut;
import static ru.iteco.fmhandroid.ui.Object.QuotesPage.checkQuotesText;
import static ru.iteco.fmhandroid.ui.Object.QuotesPage.goToQuotes;
import static ru.iteco.fmhandroid.ui.Object.QuotesPage.selectQuoteByPosition;

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

@Epic("Тестирование страницы `Тематические цитаты`")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ThematicQuotesTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @After
    public void Out() {
        LogOut();
    }

    @Before
    public void In() {
        LogIn();
        goToQuotes();

    }

    @Test
    @DisplayName("Проверяем заголовок страницы")
    public void QuotesTitle() {
        checkText("Love is all");
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation1() {
        selectQuoteByPosition(0);
        checkQuotesText(
                "«Хоспис для меня - это то, каким должен быть мир.\"",
                "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер"
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation2() {
        selectQuoteByPosition(1);
        checkQuotesText(
                "Хоспис в своем истинном понимании - это творчество",
                "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий."
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation3() {
        selectQuoteByPosition(2);
        checkQuotesText(
                "“В хосписе не работают плохие люди” В.В. Миллионщикова\"",
                "Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи."
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation4() {
        selectQuoteByPosition(3);
        checkQuotesText(
                "«Хоспис – это философия, из которой следует сложнейшая наука медицинской помощи умирающим и искусство ухода, в котором сочетается компетентность и любовь» С. Сандерс",
                "“Творчески и осознанно подойти к проектированию опыта умирания. Создать пространство физическое и психологическое, чтобы позволить жизни отыграть себя до конца. И тогда человек не просто уходит с дороги. Тогда старение и умирание могут стать процессом восхождения до самого конца” \n" +
                        "Би Джей Миллер, врач, руководитель проекта \"Дзен-хоспис\""
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation5() {
        selectQuoteByPosition(4);
        checkQuotesText(
                "Служение человеку с теплом, любовью и заботой",
                "\"Если пациента нельзя вылечить, это не значит, что для него ничего нельзя сделать. То, что кажется мелочью, пустяком в жизни здорового человека - для пациента имеет огромный смысл.\""
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation6() {
        selectQuoteByPosition(5);
        checkQuotesText(
                "\"Хоспис продлевает жизнь, дает надежду, утешение и поддержку.\"",
                "\" Хоспис - это мои новые друзья. Полная перезагрузка жизненных ценностей. В хосписе нет страха и одиночества.\"\n" +
                        "Евгения Белоусова, дочь пациентки Ольги Васильевны"
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation7() {
        selectQuoteByPosition(6);
        checkQuotesText(
                "\"Двигатель хосписа - милосердие плюс профессионализм\"\n" +
                        "А.В. Гнездилов, д.м.н., один из пионеров хосписного движения.",
                "\"Делай добро... А добро заразительно. По-моему, все люди милосердны. Нужно просто говорить с ними об этом, суметь разбудить в них чувство сострадания, заложенное от рождения\" - В.В. Миллионщикова"
        );
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation8() {
        selectQuoteByPosition(7);
        checkQuotesText(
                "Важен каждый!",
                "\"Каждый, кто оказывается в стенах хосписа, имеет огромное значение в жизни хосписа и его подопечных\""
        );
    }
}
