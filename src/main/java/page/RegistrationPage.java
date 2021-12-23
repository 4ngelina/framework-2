package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

  private static final String REGISTRATION_URL = "https://testnet.binancefuture.com/en/register";

  @FindBy(className = "sc-1s5ecn4-3")
  WebElement ageAgreementMessage;

  @FindBy(className = "sc-1s5ecn4-2 bPoTrt")
  WebElement ageAgreementLabel;

  @FindBy(className = "bnc-btn")
  WebElement registerButton;

  public RegistrationPage openPage() {
    logger.info("open register page");
    driver.get(REGISTRATION_URL);
    waitUntilElementIsDisabled(registerButton);
    return this;
  }

  public boolean ageAgreementMessageVisible() {
    logger.info("check age agreement message visible");
    return !ageAgreementMessage.getText().isBlank();
  }

  public String getAgeAgreementMessage() {
    logger.info("getting agreement message");
    return ageAgreementMessage.getText();
  }

  public RegistrationPage clickRegisterButton() {
    logger.info("click register button");
    registerButton.click();
    return this;
  }


}
