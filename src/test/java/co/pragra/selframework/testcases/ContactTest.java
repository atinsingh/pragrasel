package co.pragra.selframework.testcases;

import co.pragra.selframework.config.DriverConfig;
import co.pragra.selframework.drivermanger.DriverManager;
import co.pragra.selframework.pageobjects.ContactPage;
import co.pragra.selframework.testdata.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Iterator;

public class ContactTest {

    ExcelReader reader;
    ContactPage contactPage;
    WebDriver driver = DriverManager.getDriver();
    @BeforeSuite
    public void setUp(){
        reader = new ExcelReader("/Users/atinsingh/OneDrive/pragra/selframework/src/test/resources/testdata/Testdata.xlsx");
        driver.get(DriverConfig.getProperty("broswer.url"));
    }

    @BeforeTest
    public void preparePage(){
        contactPage = new ContactPage(this.driver);
    }

    @Test(dataProvider = "contactData")
    public void  tc1(String name, String email, String subject, String message){
        contactPage.enterName(name).enterEmail(email).enterMessage(message).enterSubject(subject);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void clearForm(){
        contactPage.getNameInput().clear();
        contactPage.getEmailInput().clear();
        contactPage.getSubject().clear();
        contactPage.getMessage().clear();
    }

    // DataProvider
    //Parameeters

    @DataProvider(name = "contactData")
    public Iterator<Object[]> contactPageDataProvider(){
        return reader.getTestData().iterator();
    }



}
