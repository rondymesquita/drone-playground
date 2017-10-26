import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.OutputType;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class DuckDuckGoTest {
 
    private WebDriver driver;
    private static final String URL = "file://" + new File("./res/public/index.html").getAbsolutePath();
    public final By searchFieldSelectorBy = By.id("search_field");
    public final By searchButtonSelectorBy = By.id("search_button");
    public final By readMoreButtonSelectorBy = By.cssSelector("#result_item_1 .btn");
    private int count = 0;

    private void takeScreenshot() throws Exception{
        new File("./target/screenshots/").mkdirs();
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File in = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        File out = new File("./target/screenshots/screenshot_"+(count++)+".png");

        FileInputStream is = new FileInputStream(in);
        FileOutputStream os = new FileOutputStream(out);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    }

    @Before
    public void before(){
        String path = new File("./res/geckodriver").getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
    }

    @After
    public void after(){
        driver.quit();
    }


    @Test
    public void shouldDoASearchWithSuccess() throws Exception{
        driver.get(URL);

        WebElement searchField = driver.findElement(searchFieldSelectorBy);
        searchField.clear();
        searchField.sendKeys("Darth Vader");
        takeScreenshot();

        // Should throws an error
        // WebElement readMoreButton = driver.findElement(readMoreButtonSelectorBy);
        // readMoreButton.click();
        
        WebElement searchButton = driver.findElement(searchButtonSelectorBy);
        searchButton.click();

        // Should NOT throws an error
        WebElement readMoreButton = driver.findElement(readMoreButtonSelectorBy);
        readMoreButton.click();
         
        driver.getPageSource().contains("Darth Vader");
        takeScreenshot();
        
    }

    @Test
    public void shouldDoASearchWithSuccessAgain() throws Exception{
        driver.get(URL);

        WebElement searchField = driver.findElement(searchFieldSelectorBy);
        searchField.clear();
        searchField.sendKeys("Darth Vader");
        takeScreenshot();

        // Should throws an error
        // WebElement readMoreButton = driver.findElement(readMoreButtonSelectorBy);
        // readMoreButton.click();
        
        WebElement searchButton = driver.findElement(searchButtonSelectorBy);
        searchButton.click();

        // Should NOT throws an error
        WebElement readMoreButton = driver.findElement(readMoreButtonSelectorBy);
        readMoreButton.click();
         
        driver.getPageSource().contains("Darth Vader");
        takeScreenshot();
        
    }
}