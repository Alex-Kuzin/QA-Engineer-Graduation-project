package ru.iteco.fmhandroid.ui.Data;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import ru.iteco.fmhandroid.R;

public class Data {
    // Данные для Authorization
    public static final String validLogin = "login2";
    public static final String validPassword = "password2";
    public static final String invalidLogin = "loginlogin";
    public static final String invalidPassword = "passwordpassword";
    public static final ViewInteraction loginId = onView(allOf(childAtPosition(childAtPosition(withId(R.id.login_text_input_layout), 0), 1)));
    public static final ViewInteraction passwordId = onView(allOf(childAtPosition(childAtPosition(withId(R.id.password_text_input_layout), 0), 1)));
    public static final ViewInteraction enterButtonId = onView(withId(R.id.enter_button));
    public static final ViewInteraction logOutButtonId1 = onView(withId(R.id.authorization_image_button));
    public static final ViewInteraction logOutButtonId2 = onView(withId(android.R.id.title));

    //Данные для About
    public static final ViewInteraction menuButtonId = onView(withId(R.id.main_menu_image_button));
    public static final ViewInteraction goAboutButtonId = onView(allOf(withId(android.R.id.title), withText("About"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed()));
    public static final ViewInteraction outAboutButtonId = onView(withId(R.id.about_back_image_button));
    public static final ViewInteraction devMark = onView(withId(R.id.about_company_info_label_text_view));
    public static final ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static final ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));

    //Данные для ThematicQuotes
    public static final ViewInteraction quotesButtonId = onView(withId(R.id.our_mission_image_button));
    public static final ViewInteraction selectQuoteByPositionId = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));

    //Данные для News
    public static final LocalDate date = LocalDate.now();
    public static final int year = date.getYear();
    public static final int month = date.getMonthValue();
    public static final int dayOfMonth = date.getDayOfMonth();
    public static final String parseDay = Integer.toString(dayOfMonth);
    public static final String parseMonth = Integer.toString(month);
    public static final String parseYear = Integer.toString(year);
    public static final String localDateToStr = parseDay + "." + "0" + parseMonth + "." + parseYear;
    static int randomNumber = ThreadLocalRandom.current().nextInt(8);
    static LocalDate randomDate = date.plusWeeks(randomNumber);
    public static final int yearAfter = randomDate.getYear();
    public static final int monthAfter = randomDate.getMonthValue();
    public static final int dayOfMonthAfter = randomDate.getDayOfMonth();
    public static final String parseDayAfter = Integer.toString(dayOfMonthAfter);
    public static final String parseMonthAfter = Integer.toString(monthAfter);
    public static final String parseYearAfter = Integer.toString(yearAfter);
    public static final String localDateToStrAfter = parseDayAfter + "." + "0" + parseMonthAfter + "." + parseYearAfter;
    public static final String titleAddNew = "Test new";
    public static final String titleEditNew = "EditTest new";
    public static final String deskriptionAddNew = "Demo Description";
    public static final String deskriptionEditNew = "Edit Desc";
    public static final String categorySalary = "Зарплата";
    public static final String categoryTradeUnion = "Профсоюз";
    public static final ViewInteraction newsButtonId = onView(allOf(withId(android.R.id.title), withText("News"),
            childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed()));
    public static final ViewInteraction editNewsButtonId = onView(allOf(withId(R.id.edit_news_material_button),
            childAtPosition(childAtPosition(withId(R.id.container_list_news_include), 0), 3), isDisplayed()));
    public static final ViewInteraction addNewsButtonId = onView(allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"),
            childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")), 1), 3), isDisplayed()));
    public static final ViewInteraction categoryAutoTextFieldId = onView(allOf(withId(R.id.news_item_category_text_auto_complete_text_view),
            childAtPosition(childAtPosition(withId(R.id.news_item_category_text_input_layout), 0), 0), isDisplayed()));
    public static final ViewInteraction textInputFieldId = onView(allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
            childAtPosition(childAtPosition(withClassName(is("android.widget.LinearLayout")), 1), 0), isDisplayed()));
    public static final ViewInteraction descriptionFieldId = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static final ViewInteraction titleFieldId = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static final ViewInteraction newsSaveButtonId = onView(allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
            childAtPosition(childAtPosition(withClassName(is("com.google.android.material.card.MaterialCardView")), 0), 6)));
    public static final ViewInteraction createdEditNewsId = onView(allOf(withId(R.id.news_item_title_text_view), withText(titleAddNew), withParent(withParent(withId(R.id.news_item_material_card_view))), isDisplayed()));
    public static final ViewInteraction createdEditNewsId2 = onView(allOf(withId(R.id.news_item_title_text_view), withText(titleEditNew), withParent(withParent(withId(R.id.news_item_material_card_view))), isDisplayed()));
    public static final ViewInteraction editNewsButtonId2 = onView(allOf(withId(R.id.edit_news_material_button), childAtPosition(
            childAtPosition(withId(R.id.container_list_news_include), 0), 3), isDisplayed()));
    public static final ViewInteraction newCancelButtonId = onView(allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"),
            childAtPosition(childAtPosition(withClassName(is("com.google.android.material.card.MaterialCardView")), 0), 7)));
    public static final ViewInteraction newOkButtonId = onView(allOf(withId(android.R.id.button1), withText("OK"),
            childAtPosition(childAtPosition(withId(com.google.android.material.R.id.buttonPanel), 0), 3)));
    public static final ViewInteraction deleteOkButtonId = onView(allOf(withId(android.R.id.button1)));

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}
