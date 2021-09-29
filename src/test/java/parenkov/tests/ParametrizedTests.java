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
import java.util.Random;


import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTests {

    @ParameterizedTest(name = "Check switching between header menu items: {0}")
    @ValueSource(strings = {"Разработка", "Дизайн", "Научпоп"})
    void habrHeaderMenuTest(String menuItem) {
        Configuration.startMaximized = true;
        open("https://habr.com/ru/all/");
        $(".tm-main-menu__section-content").$(byText(menuItem)).click();
        $("h1").shouldHave(text(menuItem));
        System.out.println();
    }

//    @ParameterizedTest(name = "Check : {0}")
//    @CsvSource(value = {"Ananas 10", "Bananas 20", "Apple 30"})
//    void csvSourceTest(String fruitName, int fruitPrice) {
//        Configuration.startMaximized = true;
//        open("https://www.jotform.com/build/212703357443351");
//        $("#input_4").setValue("Ivan");
//        $("#input_5").setValue("ivan@mail.com");
//        $("#input_8_area").setValue("+7");
//        $("#input_8_phone").setValue("1234567890");
//        $("#input_2").click();
//    }


    @CsvSource(value = {
            "01; Tesla; Elon Musk; elon; 123456789",
            "02; Apple; Tim Cook; cook; 123456789",
            "03; Microsoft; Bill Gates; gates; 123456789"
    }, delimiter = ';')
    @ParameterizedTest(name = "Fill form with name: {2}")
    void fillFormTest(int testId,
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


//    @Test
//        void googleTest(){
//        Configuration.startMaximized = true;
//        open("https://www.jotform.com/build/212703357443351");
//        $("#input_4").setValue("Ivan");
//        $("#input_5").setValue("ivan@mail.com");
//        $("#input_8_area").setValue("+7");
//        $("#input_8_phone").setValue("1234567890");
//        $("#input_2").click();

//        open("https://www.tutorialrepublic.com/" +
//                "snippets/preview.php?topic=bootstrap&file=elegant-contact-form");
//        $("#inputName").setValue("Ivan");
//        $("#inputEmail").setValue("ivan@mail.com");
//        $("#inputPhone").setValue("1234567890");
//        $("#inputPhone").setValue("Test");
//        $("#inputMessage").setValue("Test Test Test");
//        $("button").click();


//        open("https://www.w3docs.com/tools/editor/5872");
//        $("[placeholder='Full name']").setValue("Ivan Petrov");
//        $("[placeholder='Email']").setValue("ivan@mail.com");
//        $("[placeholder='Phone number']").setValue("1234567890");
//        $("[placeholder='Website']").setValue("Test");
//        $("#inputMessage").setValue("Test Test Test");
//        $("form button").click();


}