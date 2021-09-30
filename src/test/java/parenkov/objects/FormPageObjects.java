package parenkov.objects;

import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class FormPageObjects {

    //рандомайзер целых чисел
    Random rand = new Random();
    int upperbound = 10000;
    int int_rand = rand.nextInt(upperbound);
    String randNumber = String.valueOf(int_rand);

    private SelenideElement companyField = $("#signup_company_name"),
            nameField = $("#signup_user_name"),
            emailField = $("#signup_user_email"),
            passwordField = $("#signup_user_password"),
            passwordConfField = $("#signup_user_password_confirmation"),
            checkBox = $("#signup_mailing_list"),
            submitButton = $("[type=submit]");

    public FormPageObjects typeCompany(String value) {
        companyField.setValue(value + randNumber);
        return this;
    }

    public FormPageObjects typeFullName(String value) {
        nameField.setValue(value + randNumber);
        return this;
    }

    public FormPageObjects typeEmail(String value) {
        emailField.setValue(value + randNumber + "@mail.com");
        return this;
    }

    public FormPageObjects typePassword(String value) {
        passwordField.setValue(value);
        passwordConfField.setValue(value);
        return this;
    }

    public FormPageObjects submit() {
        checkBox.click();
        submitButton.click();
        return this;
    }
}
