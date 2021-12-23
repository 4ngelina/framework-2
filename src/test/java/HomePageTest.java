import jdk.jfr.Description;
import model.TradingRules;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.TradingRulesService;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HomePageTest extends BaseTest {

    private final TradingRulesService tradingRulesService = new TradingRulesService();

    @Test(groups = "testnet", priority = 1)
    @Description("Change language from english to ukrainian")
    public void ChangeLanguageToUkrainian(){
        HomePage homePage = new HomePage()
                .openPage()
                .clickLanguageButton()
                .clickChangeLanguageToUkrainianButton();
        Assert.assertEquals(homePage.getLanguageButtonText(), "Українська");
    }

    @Test(groups = "testnet", priority = 2)
    public void ChangeThemeToLight() {
        HomePage homePage = new HomePage()
                .openPage()
                .moveOnThemeSettings()
                .changeThemeOnLight();
        Assert.assertTrue(homePage.getThemeAttribute().contains("active"));
    }

    @Test(groups = "testnet", priority = 2)
    public void showTradingRulesTest() {
        TradingRules expectedTradingRules = tradingRulesService.getTradingRules();
        Set<String> expectedRulesSet = Set.copyOf(expectedTradingRules.getRuleList());
        TradingRules tradingRules = new HomePage()
            .openPage()
            .clickTradingGridSettingsButton()
            .clickTradingRulesButton()
            .getTradingRules();

        Set<String> actualRulesSet = Set.copyOf(tradingRules.getRuleList());

        Collections.sort(tradingRules.getRuleList());
        System.out.println(tradingRules.getRuleList());

        Collections.sort(expectedTradingRules.getRuleList());
        System.out.println(expectedTradingRules.getRuleList());

        assertThat(tradingRules.getRuleList().toString(), is(equalTo(expectedTradingRules.getRuleList().toString())));
    }


}
