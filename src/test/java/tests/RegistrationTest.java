package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationPositiveTest() {
        User user = new User().withName("Lion").withLastName("King2")
                .withEmail("pass2@gmail.com").withPassword("Pa$$2gmailc0m");
        app.userHelper().clickOnSignUp();
        app.userHelper().fillRegistrationForm(user);
        app.userHelper().clickOnCheckbox();

        app.userHelper().clickOnYalla();

        app.userHelper().waitTheRegistrationInSuccess();
        String registrationInSuccess = app.userHelper().takeTheText();
        app.userHelper().clickOkButton();
        Assert.assertEquals(registrationInSuccess,"Registration in success");

    }
}
