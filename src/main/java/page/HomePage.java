package page;

import model.TradingRules;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import converter.TradingRuleConverter;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    private static final String BINANCE_FUTURE_URL = "https://testnet.binancefuture.com/en/futures/BTCUSDT";

    @FindBy(id = "fiatlngdialog_ba-languageRegion-ua")
    private WebElement changeLanguageButton;

    @FindBy(css = "div[class='css-1ef19zs']")
    private WebElement languageText;

    @FindBy(css = "svg[class='css-15bf2k5']")
    private WebElement settings;

    @FindBy(css = "svg[class='css-16vuvx8']")
    private WebElement lightThemeButton;

    @FindBy(xpath = "/html/body/div[13]/div/div[1]/div[2]/div[1]")
    private WebElement attribute;

    @FindBy(css = "div[class='css-1ef19zs']")
    private WebElement languageButton;

    @FindBy(id = "header_login")
    private WebElement loginButton;

    @FindBy(className = "css-1wp7bnt")
    private WebElement tradingGridSettingsButton;

    @FindBy(className = "opr")
    private WebElement tradingRulesButton;

    @FindBy(xpath = "//div[@class='rules css-4cffwv']")
    List<WebElement> ruleElements;

    public HomePage openPage() {
        logger.info("opening home page");
        driver.get(BINANCE_FUTURE_URL);
        return this;
    }

    public HomePage clickLanguageButton(){
        logger.info("click select language button");
        languageButton.click();
        return this;
    }

    public HomePage clickChangeLanguageToUkrainianButton() {
        logger.info("click ukrainian language button");
        changeLanguageButton.click();
        return this;
    }

    public String getLanguageButtonText(){
        logger.info("getting text from language button");
        return languageText.getText();
    }

    public HomePage moveOnThemeSettings(){
        logger.info("move mouse to setting icon");
        Actions actions = new Actions(driver);
        actions.moveToElement(settings).build().perform();
        return this;
    }

    public HomePage changeThemeOnLight(){
        logger.info("click light theme button");
        lightThemeButton.click();
        return this;
    }

    public HomePage clickTradingGridSettingsButton() {
        logger.info("click trading grid settings button");
        tradingGridSettingsButton.click();
        return this;
    }

    public HomePage clickTradingRulesButton() {
        logger.info("click treading rules button");
        tradingRulesButton.click();
        return this;
    }

    public String getThemeAttribute(){
        logger.info("getting theme attribute \"class\"");
        return attribute.getAttribute("class");
    }

    public TradingRules getTradingRules() {
        return new TradingRules(ruleElements.stream().map(element -> element.getText().trim()).collect(Collectors.toList()));
    }

}
