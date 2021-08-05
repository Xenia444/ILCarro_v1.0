package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test(groups = {"web"})
    public void positiveTestSendKey(){
        //with concatenate string
        logger.info("Haifa\",\"08/10/2021\",\"08/30/2021\"");

        app.searchHelper().typeSearchCurrentMonth("Haifa","08/10/2021","08/30/2021");
        logger.info("message");
        app.userHelper().clickOnSubmit();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());
    }
    @Test(groups = {"a","web"})
    public void negativeTestSendKey(){
        //with concatenate string
        app.searchHelper().typeSearchCurrentMonth("Haifa","06/29/2021","06/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isDataInPath());
        Assert.assertTrue(app.searchHelper().buttonYallaInactive());
    }

    @Test()
    public void selectPeriodCurrentMouth(){
        app.searchHelper().fillSearchFormCurrentMonth("Haifa","08/10/2021","08/30/2021");
        app.userHelper().clickOnSubmit();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());
    }

    @Test
    public void selectPeriodInFuture(){
        app.searchHelper().fillSearchFormInFuture("Haifa","08/12/2021","08/30/2021");
        app.userHelper().clickOnSubmit();
        app.carHelper().pause(3000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());
    }
    @AfterMethod(alwaysRun = true)
    public void postConditions(){
        app.searchHelper().backToHome();
    }
}
