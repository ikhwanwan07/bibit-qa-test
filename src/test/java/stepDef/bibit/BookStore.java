package stepDef.bibit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Book.Book;

public class BookStore {
    WebDriver driver;
    Book book = new Book();

    @Given("User go to “https:\\/\\/demoqa.com\\/books”")
    public void userGoToHttpsDemoqaComBooks() throws Throwable {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver107.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        Thread.sleep(1000);
    }

    @When("User in “Book Store” page")
    public void userInBookStorePage() throws Throwable {
        String text = driver.findElement(By.className("main-header")).getAttribute("Book Store");
        Thread.sleep(1000);
        System.out.println(text);
    }

    @And("User search book “Git Pocket Guide”")
    public void userSearchBookGitPocketGuide() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"searchBox\"]")).sendKeys("Git Pocket Guide");

        book.setTitle(driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]")).getText());
        book.setAuthor(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]")).getText());
        book.setPubliser(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[4]")).getText());
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPubliser());
    }

    @And("User click book “Git Pocket Guide”")
    public void userClickBookGitPocketGuide() {
        driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")).click();
    }

    @Then("User see “Git Pocket Guide”")
    public void userSeeGitPocketGuide() {
    driver.findElement(By.xpath("//*[@id=\"userName-value\"]")).getAttribute(book.getTitle());
        driver.findElement(By.xpath("//*[@id=\"userName-value\"]")).getAttribute(book.getAuthor());
        driver.findElement(By.xpath("//*[@id=\"userName-value\"]")).getAttribute(book.getPubliser());
        driver.quit();
    }
}
