package driver;

import java.net.MalformedURLException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitiator {

	private static WebDriver driver = null;
	public static HashMap<String, WebDriver> drivers = new HashMap();

	public static WebDriver getDriver(String browserName) throws MalformedURLException {

		switch (browserName) {

		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/driverbinaries/chromedriver.exe");
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;

		}
		return driver;
	}

}