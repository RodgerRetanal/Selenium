import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {

    private static void login(WebDriver driver) {

        driver.findElement(By.id("i0116")).sendKeys("ralp.retanal@vrd-drv.crc.ca");
//        driver.findElement(By.id("idSIButton9")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        signIn.click();

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        password.sendKeys("?x*5+PK@");
        password.submit();

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        submit.click();
    }

    private static void timeSeriesS(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        WebElement timeSeriesS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Time Series (Single)'")));
        timeSeriesS.click();

        // Selecting Sensor Name
        selectingDataID(driver, "SelectedSensor-selectized", "CRC_SENSOR_052" );

        // Selecting Frequency Band
        selectingDataID(driver, "SelectedFreqRange-selectized", "BETWEEN 406.1 AND 430");


        // Selecting Channel Frequency
//        selectingDataID(driver, "SelectedCentreFreq-selectized", "406.1125");

        // Selecting Time Range
        selectingDate(driver, "2018-12-01", "2018-12-02");
        selectingDate(driver, "2018-12-15", "2019-01-01");

        // Submit input
//        driver.findElement(By.id("submit")).click();
    }

    private static void selectingDataID(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
        selector.click();
        selector.sendKeys(Keys.BACK_SPACE);
        selector.sendKeys(data);
        selector.sendKeys(Keys.ENTER);
    }

    private static void selectingDate(WebDriver driver, String id, String date){
        WebElement selector = driver.findElement(By.cssSelector("input[data-initial-date ='" + id + "']"));
        selector.click();
        selector.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        selector.sendKeys(Keys.BACK_SPACE);
        selector.sendKeys(date);
        selector.sendKeys(Keys.ENTER);
    }

    private static void timeSeriesM(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        WebElement timeSeriesM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Time Series (Multi)'")));
        timeSeriesM.click();

        // Selecting the type of graph
        driver.findElement(By.cssSelector("input[value='Bar']")).click();
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

        // Selecting Sensors
        selectingDataID(driver, "MFSelectedSensor-selectized", "CRC_SE_002" );
        selectingDataAdd(driver, "MFSelectedSensor-selectized", "CRC_SENSOR_052");
        selectingDataAdd(driver, "MFSelectedSensor-selectized", "DGSO_ISOC_004");
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

        // Selecting Frequency Band
        selectingDataID(driver, "MFSelectedFreqRange-selectized", "BETWEEN 406.1 AND 430");


        // Selecting Channel Frequency
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.10625");
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.125");
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.1875");
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

        // Selecting Time Range
        selectingDate(driver, "2018-12-01", "2018-12-02");
        selectingDate(driver, "2018-12-15", "2019-01-01");

        // Submitting Inputs
//        driver.findElement(By.id("MFsubmit")).click();
    }

    private static void selectingDataAdd(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
//        selector.click();
        selector.sendKeys(data);
        selector.sendKeys(Keys.ENTER);
    }

    private static void selectingChannels(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
        selector.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement channel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-value='"+ data +"']")));
        channel.click();

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
        timeSeriesM(driver);

    }
}
