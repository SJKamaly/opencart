package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegisterationTest extends BaseClass {
	
	@Test
	public void testAccountRegesteration() {
		logger.info("****** starting TC_001_AccountRegisterationTest******");
		//logger.debug("started debug log");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegisterationPage arp = new AccountRegisterationPage(driver);
		logger.info("providing customer details");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastname(randomString().toUpperCase());
		arp.setTelephon(randomNumber());
		arp.setEmail(randomString()+"@gmail.com");
		String pass=randomAlphaNumber();
		arp.setPassword(pass);
		arp.setConfPassword(pass);
		arp.checkPolicyBox();
		arp.btnClickContinue();
		logger.info("Clicked on continue button");
		
		String confMsg=arp.getConfirmationMsg();
		if(confMsg.equals("Your Account Has Been Created!")) {
            logger.info("test passed");
			Assert.assertTrue(true);
		}else {
			logger.error("test failed");
			Assert.assertTrue(false);
		}
			
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***** finished TC_001_AccountRegisterationTest****** ");
	}
}
