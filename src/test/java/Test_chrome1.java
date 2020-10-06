import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test_chrome1 {

    public static void main (String[] args) {

        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Amazon");
        element.submit();
        WebElement GoogleSheet = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

        assertThat((driver.findElement(By.xpath(" (//div[@class='g']//cite)[1]")).getText()), containsString("www.amazon.com"));
        assertThat((driver.findElement(By.xpath("(//div[@class='g']//h3)[1]")).getText()), containsString("Amazon.com: Online Shopping for Electronics, Apparel ..."));
        driver.close();
    }
}
