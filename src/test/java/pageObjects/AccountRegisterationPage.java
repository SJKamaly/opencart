package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage{

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLastName;
	@FindBy(id="input-email")WebElement txtEmail;
	@FindBy(id="input-telephone")WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement txtConfirmPassword;
	@FindBy(name="agree")WebElement chkdPolicy;
	@FindBy(xpath="//input[@type='submit']")WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;
	//@FindBy(linkText ="Your Account Has Been Created!")WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephon(String tel) {
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfPassword(String pwdConf) {
		txtConfirmPassword.sendKeys(pwdConf);
	}
	public void checkPolicyBox() {
		chkdPolicy.click();
	}
	public void btnClickContinue() {
		btnContinue.click();
		
	}
	public String getConfirmationMsg() {
		try {
		return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}

}
