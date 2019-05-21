import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {

    ///////////////////////////////////     Variables            //////////////////////////////////////////////////////

    ///////////////////////////////////      Helper Methods      /////////////////////////////////////////////////////

    private static void selectingDataID(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
        selector.click();
        selector.sendKeys(Keys.BACK_SPACE);
        selector.sendKeys(data);
        selector.sendKeys(Keys.ENTER);
    }

    private static void selectingDataAdd(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
//        selector.click();
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

    private static void selectingDateM(WebDriver driver, String id, String date){
        WebElement selector = driver.findElement(By.xpath(id));
        selector.click();
        selector.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        selector.sendKeys(Keys.BACK_SPACE);
        selector.sendKeys(date);
        selector.sendKeys(Keys.ENTER);
    }

    private static void selectingChannels(WebDriver driver, String id, String data) {
        WebElement selector = driver.findElement(By.id(id));
        selector.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement channel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-value='"+data+"']")));
        channel.click();
    }

    private static void selectingDateClicksA(WebDriver driver, String id){
        WebElement selector = driver.findElement(By.xpath(id));
        selector.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top'")));

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[2]/td[1]")).click();
    }

    private static void selectingDateClicksB(WebDriver driver, String id){
        WebElement selector = driver.findElement(By.xpath(id));
        selector.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top'")));

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[1]")).click();
    }

    //////////////////////////////        Code for each tab    ////////////////////////////////////////////////////////

    private static void login(WebDriver driver) {
        driver.findElement(By.id("i0116")).sendKeys("ralp.retanal@vrd-drv.crc.ca");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        signIn.click();

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        password.sendKeys("?x*5+PK@");
        password.submit();

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        submit.click();
    }

    private static void timeSeriesS(WebDriver driver, WebDriverWait wait) {
        WebElement timeSeriesS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Time Series (Single)'")));
        timeSeriesS.click();

        // Selecting Frequency Band
        selectingDataID(driver, "SelectedFreqRange-selectized", "BETWEEN 406.1 AND 430");

        // Selecting Sensor Name
        selectingDataID(driver, "SelectedSensor-selectized", "CRC_SENSOR_052" );



        // Selecting Channel Frequency
//        selectingDataID(driver, "SelectedCentreFreq-selectized", "406.1065");
//        selectingChannels(driver, "SelectedCentreFreq-selectized", "406.1065");
//        WebElement channelFrequency = driver.findElement(By.xpath("//*[@id=\"sidebarItemExpanded\"]/div[2]/div/div/div[3]/div/div/div[2]"));
//        channelFrequency.click();
//        channelFrequency.sendKeys(Keys.BACK_SPACE);
//        channelFrequency.sendKeys("406.1065");
//        channelFrequency.sendKeys(Keys.ENTER);

        // Selecting Time Range
        selectingDate(driver, "2018-12-01", "2018-12-02");
        selectingDate(driver, "2018-12-15", "2019-01-01");
//        selectingDateClicksA(driver, "//*[@id=\"MFdefineDateRange\"]/div/input[1]");
//        selectingDateClicksB(driver, "//*[@id=\"MFdefineDateRange\"]/div/input[2]");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Submit input
        driver.findElement(By.id("submit")).click();
//
        WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='svg-container']")));
    }


    private static void timeSeriesMF(WebDriver driver, WebDriverWait wait) {
        WebElement timeSeriesM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Time Series (Multi)'")));
        timeSeriesM.click();

        // Selecting Frequency Band
        selectingDataID(driver, "MFSelectedFreqRange-selectized", "BETWEEN 406.1 AND 430");

        // Selecting the type of graph
        driver.findElement(By.cssSelector("input[value='Bar']")).click();
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

        // Selecting Sensorsl
        selectingDataID(driver, "MFSelectedSensor-selectized", "CRC_SE_002" );
        selectingDataAdd(driver, "MFSelectedSensor-selectized", "CRC_SENSOR_052");
        selectingDataAdd(driver, "MFSelectedSensor-selectized", "DGSO_ISOC_004");
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Selecting Channel Frequency
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.10625");
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.11875");
        selectingChannels(driver, "MFSelectedCentreFreq-selectized", "406.1125");
        driver.findElement(By.cssSelector("input[value='power_mean_dbm']")).click();

        // Selecting Time Range
        selectingDateM(driver, "//*[@id=\"MFdefineDateRange\"]/div/input[1]", "2018-12-02");
        selectingDateM(driver, "//*[@id=\"MFdefineDateRange\"]/div/input[2]", "2019-01-01");

        // Submitting Inputs
        driver.findElement(By.id("MFsubmit")).click();
        WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='svg-container']")));
    }


    private static void heatMap(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Heatmap'"))).click();

        // Selecting Frequency Band
        selectingDataID(driver, "SelectedHeatMapFreqRange-selectized", "BETWEEN 406.1 AND 430");

        // Selecting Sensor Name
        selectingDataID(driver, "HeatMapSelectedSensor-selectized", "CRC_SENSOR_052" );

        // Selecting Time Range
        selectingDateM(driver, "//*[@id=\"defineHeatMapDateRange\"]/div/input[1]", "2018-12-02");
        selectingDateM(driver, "//*[@id=\"defineHeatMapDateRange\"]/div/input[2]", "2019-01-01");

        // Selecting Parameter to Display
        driver.findElement(By.cssSelector("input[value='Occupancy'")).click();

        // Channel Frequency Range
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sidebarItemExpanded\"]/div[5]/div/div/div[3]/span/span[6]"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 140, 425).release().build().perform();
        slider.click();

        // Subset of Occupancy Value to Display
        WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"sidebarItemExpanded\"]/div[5]/div/div/div[5]/span/span[6]"));
        move.dragAndDropBy(slider2,  50, 425).release().build().perform();
        slider2.click();

        // Submit
        driver.findElement(By.id("HeatMapSubmit")).click();
        WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[style='-webkit-user-drag: none;']")));
    }

    private static void boxplot(WebDriver driver,  WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-value='Boxplot'"))).click();

        // Selecting Frequency Band
        selectingDataID(driver, "SelectedBoxplotFreqRange-selectized", "BETWEEN 406.1 AND 430");

        // Selecting Sensor Name
        selectingDataID(driver, "BoxplotSelectedSensor-selectized", "CRC_SENSOR_052" );

        // Selecting Time Range
        selectingDateM(driver, "//*[@id=\"defineBoxplotDateRange\"]/div/input[1]", "2018-12-02");
        selectingDateM(driver, "//*[@id=\"defineBoxplotDateRange\"]/div/input[2]", "2018-12-16");

        // Parameter to Display
        selectingDataID(driver, "defineBoxplotParameterRadio-selectized", "Power (mean)");

        // Channel Frequency Range
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sidebarItemExpanded\"]/div[3]/div/div/div[3]/span/span[6]"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 140, 425).release().build().perform();
        slider.click();

        // Submit
        driver.findElement(By.id("BoxplotSubmit")).click();
        WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='svg-container']")));


    }

    public static void main(String[] args) {

        // Initializing
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crcuser.DESKTOP-P436DG7\\OneDrive - ISED-ISDE\\Selenium\\Selenium Servers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://lmrdashboard.apps.vrd-drv.crc.ca/shiny-server-pro-version/");
        WebDriverWait wait = new WebDriverWait(driver, 180);

        login(driver);
        timeSeriesMF(driver, wait);
        timeSeriesS(driver, wait);
        heatMap(driver, wait);
        boxplot(driver, wait);

        driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
        driver.quit();

    }
}
