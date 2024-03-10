package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test
	public void testLogin() {
		
		logger.info("***** Starting TC_002_LoginTest*****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickSubmitBtn();
		
		MyAccountPage macp = new MyAccountPage(driver);
		boolean targePage =macp.isMyAccountPageExist();
		
		Assert.assertEquals(targePage, true);
		
						
		}catch(Exception e){
			Assert.fail();
			
		}
		
		logger.info("***** Finished TC_002_LoginTest*****");
		
	}
	

}
