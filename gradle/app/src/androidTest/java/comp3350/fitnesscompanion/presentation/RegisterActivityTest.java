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
public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void registerActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.registerBttn), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.regFirstName),
                        childAtPosition(
                                allOf(withId(R.id.regIndex0),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                0)),
                                1),
                        isDisplayed()));
        editText.perform(replaceText("John"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.regLastName),
                        childAtPosition(
                                allOf(withId(R.id.regIndex1),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                1)),
                                1),
                        isDisplayed()));
        editText2.perform(replaceText("snow"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.regEmail),
                        childAtPosition(
                                allOf(withId(R.id.regIndex2),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                2)),
                                1),
                        isDisplayed()));
        editText3.perform(replaceText("jon.snow@myumn.ca"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.regPassword),
                        childAtPosition(
                                allOf(withId(R.id.regIndex3),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                3)),
                                1),
                        isDisplayed()));
        editText4.perform(replaceText("#1Winter"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.nextBttn), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regDetails),
                                        8),
                                4),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.regAge),
                        childAtPosition(
                                allOf(withId(R.id.regIndex5),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                5)),
                                1),
                        isDisplayed()));
        editText5.perform(replaceText("30"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.regHeight),
                        childAtPosition(
                                allOf(withId(R.id.regIndex6),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                6)),
                                1),
                        isDisplayed()));
        editText6.perform(replaceText("170"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.regWeight),
                        childAtPosition(
                                allOf(withId(R.id.regIndex7),
                                        childAtPosition(
                                                withId(R.id.regDetails),
                                                7)),
                                1),
                        isDisplayed()));
        editText7.perform(replaceText("69"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.signUpBttn), withText("Sign Up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regDetails),
                                        8),
                                3),
                        isDisplayed()));
        button2.perform(click());
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
