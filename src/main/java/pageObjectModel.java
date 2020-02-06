import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageObjectModel {
    WebDriver driver;
    String operator = "//body/div[@class='postload dn']/div[@id='mainBlueContainer']/div[@class='col-sm-12 mainBoxWhite']/div[@class='container-main-top']/div[@id='col-sm-12']/form/div[@class='perform']/div[contains(@class,'box menuitem')]/div[@class='user-interact']/div[2]/ul[1]/li[1]/div[1]/div[1]/input[1]";
    String telcel = "//b[contains(text(),'Telcel')]";
    String phoneTextBox = "//body/div[@class='postload dn']/div[@id='mainBlueContainer']/div[@class='col-sm-12 mainBoxWhite']/div[@class='container-main-top']/div[@id='col-sm-12']/form/div[@class='perform']/div[contains(@class,'box menuitem')]/div[@class='user-interact']/div[2]/ul[1]/li[2]/div[1]/div[1]/input[1]";
    String rechargeValueSelection = "//body/div[@class='postload dn']/div[@id='mainBlueContainer']/div[@class='col-sm-12 mainBoxWhite']/div[@class='container-main-top']/div[@id='col-sm-12']/form/div[@class='perform']/div[contains(@class,'box menuitem')]/div[@class='user-interact']/div[2]/ul[1]/li[3]/div[1]/div[1]/input[1]";
    String recargaSaldo = "//div[contains(text(),'Recarga Saldo')]";
    String recharge10Dollar = "//ul[contains(@class,'cat1')]//li[1]";
    String submitButton = "//div[contains(@class,'box menuitem')]//div[3]//div[1]//button[1]";
    String cardFrameElement = "//div[@id='card']";
    String name = "//div[@class='field form-group']//input[@name='cardname']";
    String cardNumber = "//div[@class='field input-group']//input[@name='cardno']";
    String month = "//div[@class='field col-xs-5 col-md-5 paddleft0']//input[@name='expmonth']";
    String date = "//div[@class='field col-xs-7 col-md-7 paddleft0']//input[@name='expyear']";
    String cvv = "//div[@class='field form-group']//input[@name='cvvno']";
    String email = "//form[@id='payment-form']//input[@name='txtEmail']";
    String paymentSubmit = "//div[@id='card']//div[6]//div[1]";
    String loginId = "//input[@id='usrname']";
    String loginpwd = "//input[@id='psw']";
    String accessLink = "//a[contains(text(),'Acceso')]";
    String loginSubmit = "//button[@id='loginBtn']";
    String paymentSuccess = "//span[@class='recharge-status success-msg']";

    public pageObjectModel(WebDriver driver) {
        this.driver = driver;
    }
    // Function to put recharge details
    public void fillEndUserNumberToRecharge(String phoneNumber){
        driver.findElement(By.xpath(operator)).click();
        driver.findElement(By.xpath(telcel)).click();
        driver.findElement(By.xpath(phoneTextBox)).sendKeys(phoneNumber);
        driver.findElement(By.xpath(rechargeValueSelection)).click();
        driver.findElement(By.xpath(recargaSaldo)).click();
        driver.findElement(By.xpath(recharge10Dollar)).click();
        driver.findElement(By.xpath(submitButton)).click();
    }
    // Function to provide end user's payment details
    public void performPayment(String pname, String pcardNumber,String pmonth, String pdate, String pcvv, String pemail){
        driver.findElement(By.xpath(name)).sendKeys(pname);
        driver.findElement(By.xpath(cardNumber)).sendKeys(pcardNumber);
        driver.findElement(By.xpath(month)).sendKeys(pmonth);
        driver.findElement(By.xpath(date)).sendKeys(pdate);
        driver.findElement(By.xpath(cvv)).sendKeys(pcvv);
        driver.findElement(By.xpath(email)).sendKeys(pemail);
        driver.findElement(By.xpath(paymentSubmit)).click();
    }
    // Function to perform login post payment function
    public void login(String id, String pwd){
        driver.findElement(By.xpath(loginId)).sendKeys(id);
        driver.findElement(By.xpath(loginpwd)).sendKeys(pwd);
        driver.switchTo().frame("a-yzj7ly4qmqsa");
        driver.findElement(By.xpath("//div[@class='rc-anchor-center-item rc-anchor-checkbox-holder']")).click();
        driver.findElement(By.xpath(loginSubmit)).click();
    }
}
