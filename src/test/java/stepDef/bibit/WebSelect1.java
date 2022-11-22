package stepDef.bibit;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebSelect1 {
    WebDriver driver;

    @Given("User Go to demoqa website")
    public void userGoToDemoqaWebsite() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver107.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(1000);
    }

    @When("user in select menu page")
    public void userInSelectMenuPage()  throws InterruptedException {
        String text = driver.findElement(By.className("main-header")).getAttribute("Select Menu");
        Thread.sleep(1000);
        System.out.println(text);
    }

    @And("User choose select value Another root option")
    public void userChooseSelectValueAnotherRootOption() throws Throwable{

        JavascriptExecutor js  = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\'react-select-2-option-3\']")).isDisplayed();
       Thread.sleep(3000);
        driver.findElement(By.id("react-select-2-option-3")).getAttribute("Another root option");
      driver.findElement(By.id("react-select-2-option-3")).click();

    }


    @And("User choose select one “Other”")
    public void userChooseSelectOneOther() throws Throwable{
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"selectOne\"]/div[1]")).click();

        driver.findElement(By.id("react-select-3-option-0-5")).click();
    }
    @And("User choose old style select menu “Aqua”")
    public void userChooseOldStyleSelectMenuAqua() {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
            Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
            se.selectByIndex(10);
// Select the option by index
//        se.selectByVisibleText("Aqua");
    }

    @And("User choose multi select drop down “all color”")
    public void userChooseMultiSelectDropDownAllColor() {
       driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div[1]")).click();
       driver.findElement(By.id("react-select-4-option-0")).click();
        driver.findElement(By.id("react-select-4-option-1")).click();
        driver.findElement(By.id("react-select-4-option-2")).click();
        driver.findElement(By.id("react-select-4-option-3")).click();
    }

    @Then("User success input all select menu")
    public void userSuccessInputAllSelectMenu() throws Throwable {
        System.out.println("success");
        driver.quit();
    }



}
