package parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTests {

    @ParameterizedTest(name = "Check switching between header menu items: {0}")
    @ValueSource(strings = {"Разработка", "Дизайн", "Научпоп"})
    void habrHeaderMenuVSTest(String menuItem) {
            Configuration.startMaximized = true;
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem)).click();
        $("h1").shouldHave(text(menuItem));
        System.out.println();
    }

    @ParameterizedTest(name = "Check : {0}")
    @CsvSource(value = {"Ananas 10", "Bananas 20", "Apple 30"})
    void csvSourceTest(String fruitName, int fruitPrice) {
        Configuration.startMaximized = true;
        open("https://www.jotform.com/build/212703357443351");
        $("#input_4").setValue("Ivan");
        $("#input_5").setValue("ivan@mail.com");
        $("#input_8_area").setValue("+7");
        $("#input_8_phone").setValue("1234567890");
        $("#input_2").click();
    }



    @Test
        void googleTest(){
        Configuration.startMaximized = true;
        open("https://www.jotform.com/build/212703357443351");
        $("#input_4").setValue("Ivan");
        $("#input_5").setValue("ivan@mail.com");
        $("#input_8_area").setValue("+7");
        $("#input_8_phone").setValue("1234567890");
        $("#input_2").click();



        System.out.println();
    }



}
