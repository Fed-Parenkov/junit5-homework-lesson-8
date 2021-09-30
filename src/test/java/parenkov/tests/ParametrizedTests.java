package parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import parenkov.header.HeaderMenuItem;
import parenkov.objects.FormPageObjects;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTests {

    // ValueSource annotation
    @ValueSource(strings = {"Development", "Design", "PopSci"})
    @ParameterizedTest(name = "Switching to the header menu item: {0}")
    void habrHeaderMenuVSTest(String menuItem) {
        Configuration.startMaximized = true;
        open("https://habr.com/en/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem)).click();
        $("h1").shouldHave(text(menuItem));
    }

    // CsvSource annotation
    @CsvSource(value = {
            "01; Tesla; Elon Musk; elon; 123456789",
            "02; Apple; Tim Cook; cook; 123456789",
            "03; Microsoft; Bill Gates; gates; 123456789"
    }, delimiter = ';')
    @ParameterizedTest(name = "Fill form with name: {2}")
    void fillFormCSVTest(int testId,
                         String company,
                         String name,
                         String email,
                         String pass) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "none";
        FormPageObjects form = new FormPageObjects();
        open("https://www.simpleinout.com/en/signup/new");
        form.typeCompany(company);
        form.typeFullName(name);
        form.typeEmail(email);
        form.typePassword(pass);
        form.submit();
        $("h2").shouldHave(text("Welcome to your Simple In/Out free trial"));
    }

    // EnumSource annotation
    @EnumSource(value = HeaderMenuItem.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = {"DESIGN", "MANAGEMENT"}
    )
    @ParameterizedTest(name = "Switching to the header menu item: {0}")
    void habrHeaderMenuESTest(HeaderMenuItem menuItem) {
        Configuration.startMaximized = true;
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem.getDesc())).click();
        $("h1").shouldHave(text(menuItem.getDesc()));
    }

    // MethodSource annotation
    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, "Tesla", "Elon Musk", "elon", "123456789"),
                Arguments.of(2, "Apple", "Tim Cook", "timcook", "123456789"),
                Arguments.of(3, "Microsoft", "Bill Gates", "gates", "123456789")
        );
    }
    @MethodSource("testData")
    @ParameterizedTest(name = "Fill form with name: {2}")
    void fillFormMSTest(int testId,
                        String company,
                        String name,
                        String email,
                        String pass) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "none";
        FormPageObjects form = new FormPageObjects();
        open("https://www.simpleinout.com/en/signup/new");
        form.typeCompany(company);
        form.typeFullName(name);
        form.typeEmail(email);
        form.typePassword(pass);
        form.submit();
        $("h2").shouldHave(text("Welcome to your Simple In/Out free trial"));
    }
}