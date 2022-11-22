package stepDef;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login1 {
    WebDriver driver;
    @Given("open the browser demoqa")
    public void openTheBrowserDemoqa() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver107.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        Thread.sleep(1000);
    }
}
