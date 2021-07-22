package tests;

import models.Car;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        //login
    }

    @Test
    public void createNewCar() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("12-" + i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very good car")
                .build();

        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car);
        app.carHelper().attachPhoto();
        //assert
        Assert.assertTrue(app.carHelper().isCarAdded());

    }

}
