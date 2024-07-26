package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.categorySalary;
import static ru.iteco.fmhandroid.ui.Data.Data.categoryTradeUnion;
import static ru.iteco.fmhandroid.ui.Data.Data.createdEditNewsId;
import static ru.iteco.fmhandroid.ui.Data.Data.createdEditNewsId2;
import static ru.iteco.fmhandroid.ui.Data.Data.deskriptionAddNew;
import static ru.iteco.fmhandroid.ui.Data.Data.deskriptionEditNew;
import static ru.iteco.fmhandroid.ui.Data.Data.editNewsButtonId2;
import static ru.iteco.fmhandroid.ui.Data.Data.localDateToStr;
import static ru.iteco.fmhandroid.ui.Data.Data.localDateToStrAfter;
import static ru.iteco.fmhandroid.ui.Data.Data.newCancelButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.newOkButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.titleAddNew;
import static ru.iteco.fmhandroid.ui.Data.Data.titleEditNew;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkToasts;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogIn;
import static ru.iteco.fmhandroid.ui.Object.AuthorizationPage.LogOut;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.addNew;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.checkTextNewsCreated;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.deleteNew;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.editNew;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.filterDateNews;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.filterNewsByDateButton;
import static ru.iteco.fmhandroid.ui.Object.NewsPage.goToTheNews;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование страницы: создания, реадктирования и фильтрации новостей")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
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
    public void in() {
        LogIn();
    }


    @Test
    @DisplayName("Создание, редактирование и удаление новости")
    public void addEditDeleteNews() {
        addNew(categorySalary, localDateToStr, "10:00", deskriptionAddNew, titleAddNew);
        checkTextNewsCreated(createdEditNewsId, titleAddNew);
        editNew(titleAddNew, categorySalary, categoryTradeUnion,
                deskriptionEditNew, titleEditNew, localDateToStrAfter, "18:00");
        checkTextNewsCreated(createdEditNewsId2, titleEditNew);
        deleteNew(titleEditNew);
        waitingForElement(R.id.news_list_recycler_view);
    }


    @Test
    @DisplayName("Поля при создании новости не заполнены")
    public void FieldsAreNotFilled() {
        addNew("", "", "", "", "");
        checkToasts("Fill empty fields");
        clickButton(newCancelButtonId);
        clickButton(newOkButtonId);
    }

    @Test
    @DisplayName("Фильтруем новости по дате создания")
    public void filterByDateButton() {
        goToTheNews();
        filterNewsByDateButton();
    }

    @Test
    @DisplayName("Фильтруем новости по определенной дате")
    public void filterByDate() {
        goToTheNews();
        filterDateNews(localDateToStr, localDateToStrAfter);
    }

    @Test
    @DisplayName("Фильтруем новости на контрольной панели по дате создания")
    public void filterByDateButtonControlPanel() {
        goToTheNews();
        waitingForElement(R.id.edit_news_material_button);
        clickButton(editNewsButtonId2);
        filterNewsByDateButton();

    }
}
