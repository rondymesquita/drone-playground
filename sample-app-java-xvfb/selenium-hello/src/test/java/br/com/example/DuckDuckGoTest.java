import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class DuckDuckGoTest {
 
	private WebDriver driver;
	private static final String URL = "file://" + new File("./res/public/index.html").getAbsolutePath();
	public final By searchFieldSelectorBy = By.id("search_field");
    public final By searchButtonSelectorBy = By.id("search_button");


	@Test
	public void shouldDoASearchWithSuccess() throws Exception{
		System.setProperty("webdriver.gecko.driver", "./res/geckodriver");
		driver = new FirefoxDriver();
		 
		driver.get(URL);

		WebElement searchField = driver.findElement(searchFieldSelectorBy);
        searchField.clear();
        searchField.sendKeys("Darth Vader");
		 
		WebElement searchButton = driver.findElement(searchButtonSelectorBy);
		searchButton.click();
		 
		driver.getPageSource().contains("Darth Vader");
		 
		driver.quit();
	}
}