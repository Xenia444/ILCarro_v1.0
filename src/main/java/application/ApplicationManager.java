package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    SearchHelper searchHelper;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
            logger.info("Star browser CHROME");
        }else if(browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
            logger.info("Star browser FIREFOX");
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
        logger.info("Navigate to: " + wd.getCurrentUrl());
        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        searchHelper = new SearchHelper(wd);
    }

    public UserHelper userHelper() {
        return userHelper;
    }

    public CarHelper carHelper() {
        return carHelper;
    }

    public SearchHelper searchHelper() {
        return searchHelper;
    }

    public void stop() {
        wd.quit();
    }


}
