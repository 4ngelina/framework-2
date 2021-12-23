import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserService;
import utils.ResourceUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

  @Test(groups = "testnet", priority = 1)
  @Description("Show error messages when setting incorrect user credentials")
  public void showErrorMessagesTest(){
    String expectedErrorMessage = ResourceUtils.getEmailErrorMessage();
    String emailErrorMessage = new LoginPage()
        .openPage()
        .setUserData(UserService.withEmptyEmail())
        .clickLoginButton()
        .getEmailErrorMessage();
    assertThat(emailErrorMessage, is(equalTo(expectedErrorMessage)));
  }

  @Test(groups = "testnet", priority = 2)
  @Description("Show captcha where setting correct user credentials")
  public void setData(){
    LoginPage loginPage = new LoginPage()
        .openPage()
        .setUserData(UserService.withRandomCredentials())
        .clickLoginButton();
    assertTrue(loginPage.isCaptchaShow(), "popup with captcha was not show");
  }

}
