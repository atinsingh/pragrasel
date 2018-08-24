package co.pragra.selframework.testcases;

import co.pragra.selframework.config.DriverConfig;
import co.pragra.selframework.drivermanger.DriverManager;
import co.pragra.selframework.drivermanger.WDriverManager;
import co.pragra.selframework.listeners.ScreenShotListener;
import co.pragra.selframework.pageobjects.ContactPage;
import co.pragra.selframework.pageobjects.ContactPageV2;
import co.pragra.selframework.testdata.ExcelReader;
import co.pragra.selframework.testdata.FlatFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Iterator;
//@Listeners(ScreenShotListener.class)
public class ContactTest {

    private  static Logger logger  = LogManager.getLogger(ContactTest.class);

    ExcelReader reader;
    FlatFileReader flatFileReader;
    ContactPageV2 contactPage;
    //WebDriver driver = WDriverManager.getInstance();
    @BeforeSuite
    public void setUp(){
      // reader = new ExcelReader("/Users/atinsingh/OneDrive/pragra/selframework/src/test/resources/testdata/Testdata.xlsx");
        //driver.get(DriverConfig.getProperty("browser.url"));
        flatFileReader = new FlatFileReader();
    }

//    @BeforeTest
//   // public void preparePage(){
//    //    contactPage = new ContactPageV2(this.driver);
//   // }

    @Test(dataProvider = "flatFileDP")
    public void test2(String name, String address, String age, String des, String intrest){
        System.out.println("Name "+ name);
        System.out.println("Address "+ address);
        System.out.println("Age "+ age);

    }

//    @Test(dataProvider = "contactData")
//    public void  tc1(String name, String email, String subject, String message){
//
//        logger.info("Passing follwing data name = {}, email = {}, subject = {} and message ={}",name,email,subject, message);
//
//        contactPage.typeName(name).typeEmail(email).typeSubject(subject);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Assert.fail();
//    }

//    @AfterMethod
//    public void clearForm(){
//        contactPage.getYourName().clear();
//        contactPage.getEmail().clear();
//        contactPage.getSubject().clear();
//        contactPage.getMessage().clear();
//    }

    // DataProvider
    //Parameeters

    @DataProvider(name = "contactData")
    public Iterator<Object[]> contactPageDataProvider(){
        return reader.getTestData().iterator();
    }


    @DataProvider(name = "flatFileDP")
    public Iterator<Object[]> flatFileDataProvider(){
        //System.out.println(flatFileReader.getFlatFileData());
       return flatFileReader.getFlatFileData().iterator();
    }


}
