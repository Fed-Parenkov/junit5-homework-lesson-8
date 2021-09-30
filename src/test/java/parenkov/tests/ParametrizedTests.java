package parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import parenkov.header.HeaderMenuItem;

import java.util.Random;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTests {

    @ParameterizedTest(name = "Switching to the header menu item: {0}")
    @ValueSource(strings = {"Разработка", "Дизайн", "Научпоп"})
    void habrHeaderMenuVSTest(String menuItem) {
        Configuration.startMaximized = true;
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem)).click();
        $("h1").shouldHave(text(menuItem));
    }

    @ParameterizedTest(name = "Fill form with name: {2}")
    @CsvSource(value = {
            "01; Tesla; Elon Musk; elon; 123456789",
            "02; Apple; Tim Cook; cook; 123456789",
            "03; Microsoft; Bill Gates; gates; 123456789"
    }, delimiter = ';')
    void fillFormCSVTest(int testId,
                         String company,
                         String name,
                         String email,
                         String pass) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "none";
        Random rand = new Random();
        int upperbound = 10000;
        int int_rand = rand.nextInt(upperbound);
        String randNumber = String.valueOf(int_rand);
        open("https://www.simpleinout.com/en/signup/new");
        $("#signup_company_name").setValue(company + randNumber);
        $("#signup_user_name").setValue(name + randNumber);
        $("#signup_user_email").setValue(email + randNumber + "@mail.com");
        $("#signup_user_password").setValue(pass);
        $("#signup_user_password_confirmation").setValue(pass);
        $("#signup_mailing_list").click();
        $("[type=submit]").click();
        $("h2").shouldHave(text("Welcome to your Simple In/Out free trial"));
    }

    @ParameterizedTest(name = "Switching to the header menu item: {0}")
    @EnumSource(value = HeaderMenuItem.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = {"DESIGN", "MANAGEMENT"}
    )
    void habrHeaderMenuESTest(HeaderMenuItem menuItem) {
        Configuration.startMaximized = true;
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem.getDesc())).click();
        $("h1").shouldHave(text(menuItem.getDesc()));
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        1, "Tesla", "Elon Musk", "elon", "123456789"
                ),
                Arguments.of(
                        2, "Apple", "Tim Cook", "timcook", "123456789"
                ),
                Arguments.of(
                        3, "Microsoft", "Bill Gates", "gates", "123456789"
                )
        );
    }

    @ParameterizedTest(name = "Fill form with name: {2}")
    @MethodSource("testData")
    void fillFormMSTest(int testId,
                        String company,
                        String name,
                        String email,
                        String pass) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "none";
        Random rand = new Random();
        int upperbound = 10000;
        int int_rand = rand.nextInt(upperbound);
        String randNumber = String.valueOf(int_rand);
        open("https://www.simpleinout.com/en/signup/new");
        $("#signup_company_name").setValue(company + randNumber);
        $("#signup_user_name").setValue(name + randNumber);
        $("#signup_user_email").setValue(email + randNumber + "@mail.com");
        $("#signup_user_password").setValue(pass);
        $("#signup_user_password_confirmation").setValue(pass);
        $("#signup_mailing_list").click();
        $("[type=submit]").click();
        $("h2").shouldHave(text("Welcome to your Simple In/Out free trial"));
    }

}