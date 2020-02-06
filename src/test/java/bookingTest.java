import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class bookingTest {
    WebDriver driver;
    pageObjectModel pom;

    // WebDriver setup
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pom = new pageObjectModel(driver);
    }
    // Post test execution process
    @AfterClass
    public void setupRemove(){
        driver.quit();
    }
    // Function to use Data Driven approach
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod1() {
        return new Object[][] { {"5523261151","Test","4111111111111111","11","2025","111","test@test.com"}};
    }
    // Test Function
    @Test(dataProvider = "data-provider")
    public void endToEndFunctionalTest(String phoneNumber, String name, String card, String month, String date, String cvv, String email){
        try {
            driver.get("http://prueba.undostres.com.mx/");
            pom.fillEndUserNumberToRecharge(phoneNumber);
            pom.performPayment(name,card,month,date,cvv,email);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            pom.login("marze.zr@gmail.com","123456");
            Assert.assertTrue(driver.findElement(By.xpath(pom.paymentSuccess)).isDisplayed());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
