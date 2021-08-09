package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CarHelper extends HelperBase {

    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));

    }

    public void fillCarForm(Car car) {
        if(isCarFormPresent()) {
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());

            type((By.id("fuelConsumption")), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());

            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"),car.getAbout());

         //   pause(7000);

        }
    }

    private void typeLocation(String address) {
        WebElement el = wd.findElement(By.id("pickUpPlace"));
        el.click();
        el.clear();
        el.sendKeys(address);
        pause(2000);
        wd.findElement(By.xpath("//div[@class='pac-item']")).click();
        pause(2000);
    }

    public void goToTheHomePage() {
        wd.navigate().to("https://ilcarro.xyz/search");
    }

    private boolean isCarFormPresent() {
        return wd.findElements(By.xpath("//h1[contains(.,' Let the car work ')]")).size() > 0;
    }

    public void attachPhoto() {
            wd.findElement(By.id("photos")).sendKeys("/home/ksu/Documents/GitHub_QA28/QA28_XeniaK_ILCarro_v1.0/src/ferrari.jpg");
    }

    public void attachPhoto2(String carName) {

        if(carName.equals("Ferrari")) {
            wd.findElement(By.id("photos")).sendKeys("/home/ksu/Documents/GitHub_QA28/QA28_XeniaK_ILCarro_v1.0/src/ferrari.jpg");
        }else if(carName.equals("BMW")) {
            wd.findElement(By.id("photos")).sendKeys("/home/ksu/Documents/GitHub_QA28/QA28_XeniaK_ILCarro_v1.0/src/BMW.jpg");
        }else if(carName.equals("Nissan")) {
            wd.findElement(By.id("photos")).sendKeys("/home/ksu/Documents/GitHub_QA28/QA28_XeniaK_ILCarro_v1.0/src/nissan.jpg");
        }else{
            wd.findElement(By.id("photos")).sendKeys("/home/ksu/Documents/GitHub_QA28/QA28_XeniaK_ILCarro_v1.0/src/ford.jpg");
        }
    }

    public void waitForActiveSubmit() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Submit']")));
    }

    public void clickOnSubmitButton() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void waitForCarAdded() {
        waitForElement(By.xpath("//*[contains(@id, 'mat-dialog')]"), 10);
    }

    public boolean isCarAdded() {
        return wd.findElements(By.xpath("//h2[contains(., 'successful')]")).size() > 0;

    }

    public void submitCar() {
        click(By.xpath("//button[text()='Search cars']"));
    }
}
