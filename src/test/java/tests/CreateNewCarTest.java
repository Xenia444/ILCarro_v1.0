package tests;

import models.Car;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(app.userHelper().isLogged()) {
            LoginTest login = new LoginTest();
            login.loginTestPositive();
        }
        app.carHelper().goToTheHomePage();
    }

    @Test
    public void createNewCar() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("Ferrari")
                .model("Portofino M")
                .year("2021")
                .engine("2.6")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("3")
                .seats("2")
                .clasS("Ы")
                .fuelConsumption("15.0")
                .carRegNumber("12-" + i)
                .price("250")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very good car")
                .build();

        System.out.println("Car number:" +car.getCarRegNumber());
        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car);
        app.carHelper().attachPhoto();
        app.carHelper().waitForActiveSubmit();
        app.carHelper().clickOnSubmitButton();

        app.carHelper().waitForCarAdded();
        Assert.assertTrue(app.carHelper().isCarAdded());

    }
    @AfterMethod
    public void postCondition() {
        app.carHelper().submitCar();
    }

}
