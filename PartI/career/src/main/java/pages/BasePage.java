package pages;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInitiator;

public class BasePage {
	private static WebDriver driver = null;
	public static String browserName = null;
	private DriverInitiator driverInitiator = new DriverInitiator();

	public static WebDriver getBaseDriver() {
		return driver;
	}

	public BasePage(String browserName) throws MalformedURLException {
		this.browserName = browserName;
		driver = driverInitiator.getDriver(browserName);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(xpath = "//*[@data-analytics-ga-attribute='careers' and @data-analytics-ga-subcategory='footer-links']")
	private WebElement footerCareerLink;

	@FindBy(xpath = "//*[contains(text(),'open positions')]")
	private WebElement openPostionsButton;

	public WebElement getFooterCareerLink() {
		return this.footerCareerLink;
	}

	public WebElement getOpenPostionsButton() {
		return this.openPostionsButton;
	}

	public WebElement searchElement(String xpath) {
		return this.driver.findElement(By.xpath(xpath));

	}
	
	public void click(WebElement el) {
		el.click();
	}

}
