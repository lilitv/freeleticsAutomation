package pages;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerPage extends BasePage {
	WebDriverWait wait = null;
	private WebDriver driver = BasePage.getBaseDriver();

	public CareerPage(String browserName) throws MalformedURLException {
		super(browserName);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'QA Engineer')]")
	private WebElement jobName;

	@FindBy(xpath = "//*[@itemprop='title']")
	private WebElement jobTitle;

	@FindBy(xpath = "//*[@itemprop='jobLocation']")
	private WebElement jobLocation;

	@FindBy(xpath = "//*[@itemprop='description']")
	private WebElement jobDescription;

	@FindBy(xpath = "//*[contains(text(),'Your responsibilities')]")
	private WebElement jobResponsibilities;

	@FindBy(xpath = "//*[contains(text(),'Your profile')]")
	private WebElement jobProfile;

	@FindBy(xpath = "//*[contains(text(),'Apply')]")
	private WebElement applyButton;

	@FindBy(xpath = "//*[contains(text(),'Submit your application')]")
	private WebElement submitFormText;
	
	@FindBy(xpath="(//*[@data-ng-bind-html='listitem.content'])[1]/li")
	private List<WebElement> listResponsibilities;
	
	@FindBy(xpath = "(//*[@data-ng-bind-html='listitem.content'])[2]/li")
	private List<WebElement> listProfile;

	public WebElement getJobName() {
		return this.jobName;
	}

	public WebElement getJobTitle() {
		return this.jobTitle;
	}

	public WebElement getJobLocation() {
		return this.jobLocation;
	}

	public WebElement getJobDescription() {
		return this.jobDescription;
	}

	public WebElement getJobProfile() {
		return this.jobProfile;
	}

	public WebElement getJobResponsibilities() {
		return this.jobResponsibilities;
	}

	public WebElement getApplyButton() {
		return this.applyButton;
	}

	public WebElement getSubmitFormText() {
		return this.submitFormText;
	}
	
	public List<WebElement> getListResponsibilities() {
		return this.listResponsibilities;
	}
	
	public List<WebElement> getListProfile() {
		return this.listProfile;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
