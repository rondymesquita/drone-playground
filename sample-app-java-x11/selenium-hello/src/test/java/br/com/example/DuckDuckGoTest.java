import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.OutputType;

public class DuckDuckGoTest {
 
	private WebDriver driver;
	private static final String URL = "file://" + new File("./res/public/index.html").getAbsolutePath();
	public final By searchFieldSelectorBy = By.id("search_field");
    public final By searchButtonSelectorBy = By.id("search_button");


	@Test
	public void shouldDoASearchWithSuccess() throws Exception{

		String path = new File("./res/geckodriver").getAbsolutePath();
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		 
		driver.get(URL);

		WebElement searchField = driver.findElement(searchFieldSelectorBy);
        searchField.clear();
        searchField.sendKeys("Darth Vader");

        WebDriver augmentedDriver = new Augmenter().augment(driver);
		File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		 
		WebElement searchButton = driver.findElement(searchButtonSelectorBy);
		searchButton.click();
		 
		driver.getPageSource().contains("Darth Vader");
		 
		driver.quit();
	}
}