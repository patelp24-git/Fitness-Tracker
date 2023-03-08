package comp3350.fitnesscompanion.presentation;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.fitnesscompanion.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PersonalInformationUpdateActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void personalInformationUpdateActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edtTxtEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("jon.boisvert@myumn.ca"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edtTxtPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("#1Manitoba"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.signIn), withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.userInformation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.regFirstName), withText("Jon"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex0),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.regFirstName), withText("Jon"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex0),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Jonathan"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.regFirstName), withText("Jonathan"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex0),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.regAge), withText("31"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex4),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                4)),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("32"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.regAge), withText("32"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex4),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                4)),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.regHeight), withText("170"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex5),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("172"));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.regHeight), withText("172"),
                        childAtPosition(
                                allOf(withId(R.id.regIndex5),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.updateBttn), withText("Update"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regDetails),
                                        7),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());
    }

    private static Matcher<View> childAtPosition(
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
