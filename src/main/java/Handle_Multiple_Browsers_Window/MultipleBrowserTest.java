package Handle_Multiple_Browsers_Window;
import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleBrowserTest {
	WebDriver driver;
	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button1")));
		element.click();

		// Get and store both window handles in array
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nWindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		driver.get("http://www.google.com");
		System.out.println("\nWindow2 Title = " + driver.getTitle());
		


		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
		driver.get("http://www.prothom-alo.com");
		System.out.println("\nWindow1 Title = " + driver.getTitle());


		// Once Again switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		driver.get("http://www.prothom-alo.com");
		System.out.println("\nWindow2 Title =" + driver.getTitle());
		driver.close();

		// Once Again switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
		driver.get("http://www.fb.com");
		System.out.println("\nWindow1 Title = " + driver.getTitle());
		driver.close();

	}
}
