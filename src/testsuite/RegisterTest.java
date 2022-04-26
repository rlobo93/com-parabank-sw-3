package testsuite;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;


public class RegisterTest extends Utility {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";


    @Before
    public void setUp(){
        openBrowser(BaseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() throws InterruptedException{

        //locate ‘Register’ link and click on it
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //Verify the text ‘Signing up is easy!’
        verifyExpectedAndActual(By.xpath("//h1[@class='title']"),"Signing up is easy!");
    }


    public void userSholdRegisterAccountSuccessfully()throws InterruptedException{

        //locate ‘Register’ link and click on it
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(1000);

        //Enter First name
        sendTextToElement(By.id("customer.firstName"),"Ron");
        Thread.sleep(1000);

        //Enter Last name
        sendTextToElement(By.id("customer.lastName"),"Jira");
        Thread.sleep(1000);

        //Enter Address
        sendTextToElement(By.id("customer.address.street"),"150 london street");
        Thread.sleep(1000);

        //Enter City
        sendTextToElement(By.id("customer.address.city"),"london");
        Thread.sleep(1000);

        //Enter State
        sendTextToElement(By.id("customer.address.state"),"london");
        Thread.sleep(1000);

        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"ub10 10ub");
        Thread.sleep(1000);

        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"),"07123456789");
        Thread.sleep(1000);

        //Enter SSN
        sendTextToElement(By.id("customer.ssn"),"1234");
        Thread.sleep(1000);

        //Enter Username
        sendTextToElement(By.id("customer.username"),"ronjira");
        Thread.sleep(1000);

        //Enter Password
        sendTextToElement(By.id("customer.password"),"ron12345");
        Thread.sleep(1000);

        //Enter Confirm
        sendTextToElement(By.id("repeatedPassword"),"ron12345");
        Thread.sleep(1000);

        //Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        Thread.sleep(1000);

        //Verify the text 'Your account was created successfully. You are now logged in.’
        verifyExpectedAndActual(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"),"Your account was created successfully. You are now logged in.");
    }




    @After
    public void tearDown(){
        closeBrowser();
    }




}
