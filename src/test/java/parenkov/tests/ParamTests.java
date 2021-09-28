package parenkov.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ParamTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
        void googleTest(){
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText("Разработка")).click();
        $("h1").shouldHave(text("Разработка"));
        $(".tm-main-menu__section-content").$(byText("Дизайн")).click();
        $("h1").shouldHave(text("Дизайн"));
        $(".tm-main-menu__section-content").$(byText("Научпоп")).click();
        $("h1").shouldHave(text("Научпоп"));



        System.out.println();
    }
}
