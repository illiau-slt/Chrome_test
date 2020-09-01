import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_chrome1 {

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "W:\\SeleniumTest\\chromedriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Amazon");
        element.submit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> findLinks = driver.findElements(By.xpath("//div[@class='r']/a")); //make a list of results and get the first one
        String result_link = findLinks.get(0).getAttribute("href");
        String expected_link = "http://www.amazon.com/";
        Assert.assertEquals(result_link,expected_link);
        List<WebElement> findTitle = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        String result_title = findTitle.get(0).getText();
        String expected_title = "Amazon.com: Online Shopping for Electronics, Apparel ...";
        Assert.assertEquals(result_title,expected_title);
        driver.close();
    }
}
