import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.RegistrationPage;
import utils.ResourceUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertFalse;

public class RegistrationPageTest extends BaseTest {

  @Test
  @Description("Show error messages when setting incorrect user credentials")
  public void showErrorMessagesTest(){
    String expectedErrorMessage = ResourceUtils.getAgeAgreementErrorMessage();
    RegistrationPage registrationPage = new RegistrationPage().openPage();
    assertFalse(registrationPage.ageAgreementMessageVisible(), "agreement message must be not displayed");

    String ageAgreementMessage = registrationPage
        .clickRegisterButton()
        .getAgeAgreementMessage();
    assertThat(ageAgreementMessage, is(equalTo(expectedErrorMessage)));
  }


}
