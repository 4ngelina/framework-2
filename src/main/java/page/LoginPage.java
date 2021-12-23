package page;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

  private static final String LOGIN_URL = "https://testnet.binancefuture.com/en/login";

  @FindBy(id = "login_input_email")
  private WebElement inputEmail;

  @FindBy(id = "login_input_password")
  private WebElement inputPassword;

  @FindBy(id = "login_input_login")
  private WebElement loginButton;

  @FindBy(xpath = "//div[@class='sutggo-2 gZYsUQ'][2]//div[@class='bnc-form-item-help']")
  private WebElement passwordErrorMessage;

  @FindBy(xpath = "//div[@class='sutggo-2 gZYsUQ'][1]//div[@class='bnc-form-item-help']")
  private WebElement emailErrorMessage;

  @FindBy(className = "geetest_panel")
  private WebElement captcha;

  public LoginPage() {
  }

  public LoginPage openPage() {
    logger.info("opening login page");
    driver.get(LOGIN_URL);
    return this;
  }

  public LoginPage setUserData(User user) {
    if (user != null) {
      setEmail(user);
      setPassword(user);
    }
    return this;
  }

  public LoginPage clickLoginButton() {
    waitUntilElementIsDisabled(loginButton);
    loginButton.click();
    return this;
  }

  public String getEmailErrorMessage() {
    return emailErrorMessage.getText();
  }

  public boolean isPasswordErrorMessageVisible() {
    return !passwordErrorMessage.getText().isBlank();
  }

  public boolean isCaptchaShow() {
    return captcha.isDisplayed();
  }

  private void setEmail(User user) {
    if (!user.getEmail().isBlank()) {
      logger.info(String.format("writing %s to email input", user.getEmail()));
      inputEmail.sendKeys(user.getEmail());
    }
  }

  private void setPassword(User user) {
    if (!user.getPassword().isBlank()) {
      logger.info(String.format("writing %s to password input", user.getPassword()));
      inputPassword.sendKeys(user.getPassword());
    }
  }

}
