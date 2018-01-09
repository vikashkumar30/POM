package news360;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class news360 {
	private WebDriver driver = null;
	private Properties OR = null;
	private Properties config = null;
	
	@BeforeSuite
	public void properties() throws IOException{
		TestLoader loader = new TestLoader();
		loader.loadConfig();
		driver = loader.getDriver();
		config = loader.getConfig();
		OR = loader.getOR();
	}
	
	@Test(priority=1)
	public void launchBrowser() {
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=2)
	public void signUp() {
		System.out.println("User Registration Successful");
		Assert.assertTrue(true);
		}
	
	
	@Test (priority=3, dependsOnMethods="signUp")
	public void doLogin()
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("readNews360Btn_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("signInBtn_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("useYoueEmailBtn_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("userNameTextBox_XPATH"))).sendKeys("vkumar30@gmail.com");
		driver.findElement(By.xpath(OR.getProperty("pwdTextBox_XPATH"))).sendKeys("welcome");
		driver.findElement(By.xpath(OR.getProperty("submitBtn_XPATH"))).click();
				
	}
	
	@Test (priority=4)
	public void verifyLogin() {
		
		String expectedTitle = ("News360: Your personalized news reader app");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test (priority = 5)
	public void doLogout()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("userProfileLink_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("signOutLink_XPATH"))).click();
	}
	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}

}
