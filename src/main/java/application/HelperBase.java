package application;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


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
                .visibilityOf(wd.findElement(locator)));
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor)wd;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void  takeScreenshot(String pathFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
