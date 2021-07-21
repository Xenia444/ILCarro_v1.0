package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.userHelper().isLogged()) {
            app.userHelper().logOut();
        }
    }

    @Test
    public void loginTestPositive() {

        app.userHelper().openLoginFrom();
        app.userHelper().fillLoginForm("pass@gmail.com", "Pa$$gmailc0m");
        app.userHelper().submitLogin();
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(loginS,"Logged in success");
    }

    @Test
    public void loginTestPositiveDto() {
        User user = new User().withEmail("pass@gmail.com").withPassword("Pa$$gmailc0m");

        app.userHelper().openLoginFrom();
        app.userHelper().fillLoginForm(user);

        app.userHelper().submitLogin();
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(loginS,"Logged in success");
    }
}
