package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginFrom() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"),user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickOkButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged() {
        
        return wd.findElements(By.xpath("//a[.=' Log in ']")).size() > 0;
    }

    public void logOut() {
        click(By.xpath("//a[.=' Logout ']"));
    }

    public void clickOnSignUp() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickOnCheckbox() {
        click(By.xpath("//div[@class='checkbox-container']"));
    }

    public void clickOnSubmit() {
        click(By.xpath("//*[@type='submit']"));
    }

    public String takeTheText() {

        return getText(By.xpath("//div[@class='dialog-container']//h2"));
    }


    public void waitTheRegistrationInSuccess() {

        waitForElement(By.xpath("//div[@class='dialog-container']//h2"), 30);
    }

}
