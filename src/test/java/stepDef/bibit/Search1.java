package stepDef.bibit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search1 {
    WebDriver driver;
    @Given("Open the browser")
    public void openTheBrowser() throws Throwable{
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver107.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        Thread.sleep(1000);
    }

    @When("User in Book Page")
    public void userInBookPage() throws Throwable{
        String text = driver.findElement(By.className("main-header")).getAttribute("Book Store");
        Thread.sleep(1000);
        System.out.println(text);
    }

    @And("User search Book a enginerr")
    public void userSearchBookAEnginerr() {
        driver.findElement(By.xpath("//*[@id=\"searchBox\"]")).sendKeys("qa engineer");
    }

    @Then("User see No rows found")
    public void userSeeNoRowsFound() {
    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[3]")).isDisplayed();
        driver.quit();
    }
}
