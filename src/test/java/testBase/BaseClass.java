package testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;// properties file 
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		 rb = ResourceBundle.getBundle("config");
	
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equalsIgnoreCase("chrome")) {
			logger.info("Launching Chrome Browser...");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
		driver = new ChromeDriver(options);
		}else if(br.equalsIgnoreCase("edge")) {
			logger.info("Launching Edge Browser ....");
			driver = new EdgeDriver();	
		}else{
			logger.info("Launching Firefox Browser ....");
			driver = new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));//local url 
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}
	public String randomNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedNumber+generatedString);
	}
	
	public String captureScreen (String tname)throws IOException {
		
//		Date dt = new Date();
//		SimpleDateFormat sp = new SimpleDateFormat("yyyymmddhhmmss");
//		String timestamp = sp.format(dt);  //combined the three steps in one step below"
		
		String timeStamp = new SimpleDateFormat ("yyyy_mm_dd_hh_mm_ss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+ timeStamp+ ".png";
		
		try {
			FileUtils.copyFile(source,new File( destination));
			
		}catch (Exception e) {
			e.getMessage();
		}
		return destination;
		
	}


}
