package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement txtUserName;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@type='submit']")WebElement btnSubmitt;
	
	public void setEmail(String email) {
		txtUserName.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmitBtn() {
		btnSubmitt.click();
	}
	
	

}
