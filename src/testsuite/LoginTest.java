package testsuite;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        //Enter valid username
        sendTextToElement(By.name("username"), "ronjira");
        Thread.sleep(100);

        //Enter valid password
        sendTextToElement(By.name("password"), "ron12345");
        Thread.sleep(100);


        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        Thread.sleep(100);

        //Verify the ‘Accounts Overview’ text is display
        verifyExpectedAndActual(By.xpath("//a[contains(text(),'Accounts Overview')]"), "Accounts Overview");
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {

        //Enter invalid username
        sendTextToElement(By.name("username"), "rlobo123");
        Thread.sleep(1000);

        //Enter invalid password
        sendTextToElement(By.name("password"), "rlobo123");
        Thread.sleep(100);

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        Thread.sleep(100);


        //Verify the error message ‘The username and password could not be verified.’
        verifyExpectedAndActual(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"),"The username and password could not be verified.");

        }


    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {

        //Enter valid username
        sendTextToElement(By.name("username"),"ronjira");
        Thread.sleep(100);

        //Enter valid password
        sendTextToElement(By.name("password"),"ron12345");
        Thread.sleep(100);

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        Thread.sleep(100);

        //Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        Thread.sleep(100);

        //Verify the text ‘Customer Login’
        verifyExpectedAndActual(By.xpath("h2[contains(text(),'Customer Login')]"),"Customer Login");
    }


//    @After
//    public void tearDown(){
//        closeBrowser();
//    }


}
