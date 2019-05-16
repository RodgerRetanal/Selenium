
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    private static void login(WebDriver driver) {
        driver.findElement(By.id("i0116")).sendKeys("ralp.retanal@vrd-drv.crc.ca");
        driver.findElement(By.id("idSIButton9")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        password.sendKeys("?x*5+PK@");
        password.submit();

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        submit.click();
    }

    private static void timeSeriesS(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 180);
        WebElement timeSeriesS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tabs\"]/li[2]/a")));
        timeSeriesS.click();
    }

    private static void timeSeriesM(WebDriver driver) {

    }

    private static void heatMap(WebDriver driver) {

    }

    private static void boxplot(WebDriver driver) {

    }

    public static void main(String[] args) {

        // Initializing
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crcuser.DESKTOP-P436DG7\\OneDrive - ISED-ISDE\\Selenium\\Selenium Servers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://lmrdashboard.apps.vrd-drv.crc.ca/shiny-server-pro-version/");

        login(driver);
        timeSeriesS(driver);

    }
}
