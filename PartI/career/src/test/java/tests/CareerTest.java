package tests;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import constants.Constants;
import pages.BasePage;
import pages.CareerPage;

public class CareerTest {

	WebDriver driver = null;
	CareerPage careerPage = null;
	BasePage basePage = null;
	String title = null;
	List<WebElement> elems = null;
	int count = 0;
	DesiredCapabilities cap = null;

	@BeforeClass
	public void setUP() throws MalformedURLException {
		basePage = new BasePage(Constants.BROWSER_NAME);
		careerPage = new CareerPage(Constants.BROWSER_NAME);
		driver = careerPage.getDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void checkJobTopSection() {
		basePage.getFooterCareerLink().click();
		basePage.getOpenPostionsButton().click();
		careerPage.getJobName().click();
		Assert.assertTrue(careerPage.getJobTitle().getText().contains(Constants.EXPECTED_JOB_TITLE));
	}

	@Test(priority = 2)
	public void checkJobDesciption() {
		Assert.assertTrue(careerPage.getJobDescription().isDisplayed());
	}

	@Test(priority = 3)
	public void checkJobResponisilities() {
		Assert.assertTrue(careerPage.getJobResponsibilities().isDisplayed());
		elems = careerPage.getListResponsibilities();
		count = elems.size();
		System.out.println(count);
		Assert.assertTrue(count == Constants.EXPECTED_RESPONSIBILITES_COUNT);
	}

	@Test(priority = 4)
	public void checkJobProfile() {
		Assert.assertTrue(careerPage.getJobProfile().isDisplayed());
		elems = careerPage.getListProfile();
		count = elems.size();
		System.out.println(count);
		Assert.assertTrue(count == Constants.EXPECTED_PROFILE_COUNT);
	}

	@Test(priority = 5)
	public void checkApplyNowButton() {
		careerPage.getApplyButton().click();
		Assert.assertTrue(careerPage.getSubmitFormText().isDisplayed());
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}

}
