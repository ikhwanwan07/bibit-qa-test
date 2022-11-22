package stepDef;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class LoginStep {
  WebDriver driver;
    @Given("i open the browser")
    public void iOpenTheBrowser() throws InterruptedException {

        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver107.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        Thread.sleep(1000);
    }

    @And("i fill email {string} and correct password {string}")
    public void iFillEmailAndCorrectPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @And("i click login")
    public void iClickLogin() {

        driver.findElement(By.id("login-button")).click();
    }

    @Then("i should be login")
    public void iShouldBeLogin() {
        driver.findElement(By.xpath("//div[@class=\'app_logo\']")).isDisplayed();
        driver.close();
    }


}
