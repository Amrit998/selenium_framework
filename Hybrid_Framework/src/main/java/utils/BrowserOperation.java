package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import config.Config;



public class BrowserOperation {

	public  static WebDriver driver;
	
	public static WebDriver  openBrowser() throws FrameworkException{
		switch (Config.TEST_BROWSER.trim().toUpperCase()){
		case "FIREFOX":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "..//Hybrid_Framework//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "..//Hybrid_Framework//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;	
		default:
			throw new FrameworkException("Incorrect browser set in config file.");
		}
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;

	}


	public static void openApplication(){
		driver.get(Config.APPLICATION_URL);
	}

	public static void closeBrowser(){
		driver.close();
		driver.quit();
	}
	public static void takeScreenshot(WebDriver driver) throws Exception{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("..//Hybrid_Framework//target//" + scrFile.getName() +".jpg"));	
		} catch (Exception e){

			throw new Exception();
		}
	}

}
