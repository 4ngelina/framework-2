import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

  @BeforeMethod()
  public void setUp()
  {
    DriverSingleton.getDriver();
  }

  @AfterMethod(alwaysRun = true)
  public void stopBrowser()
  {
    DriverSingleton.closeDriver();
  }

}
