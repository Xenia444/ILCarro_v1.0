package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }

    public void type(By locator, String text){
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public String getText(By locator){
        return wd.findElement(locator).getText();
    }

    public void pause(int millise){
        try {
            Thread.sleep(millise);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions
                .presenceOfElementLocated(locator));
    }
}
