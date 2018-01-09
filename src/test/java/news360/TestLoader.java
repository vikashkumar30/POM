package news360;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestLoader {
	
	private WebDriver driver = null;
	private Properties OR = null;
	private Properties config = null;
	
	public void loadConfig() throws IOException {
		
		final String USER_DIR = System.getProperty("user.dir");
		final String DRIVER_CHROME_PATH = USER_DIR + "\\src\\test\\resources\\executables\\chromedriver.exe";
		final String DRIVER_IE_PATH = USER_DIR + "\\src\\test\\resources\\executables\\IEDriverServer.exe";
		
		if (driver == null) {
			
			OR = new Properties();
			config = new Properties();
			FileInputStream fis = new FileInputStream(USER_DIR + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
					
			fis = new FileInputStream(USER_DIR + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			
			final String BROWSER = config.getProperty("browser");
			
			if ("firefox".equals( BROWSER )) {
				
				driver = new FirefoxDriver();
				
			}else if("chrome".equals( BROWSER )) {
				
				System.setProperty("webdriver.chrome.driver", DRIVER_CHROME_PATH);
				driver = new ChromeDriver();
				
				
			}else if(config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver", DRIVER_IE_PATH);
				driver = new InternetExplorerDriver();
			
			}
		}
	}

	public Properties getConfig() {
		return config;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getOR() {
		return OR;
	}

}
