package converter;

import model.TradingRules;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TradingRuleConverter {

  public static TradingRules convertFromStrings(List<WebElement> elements) {
    if (elements.size() % 2 == 1) {
      throw new RuntimeException("size of rule elements list must be even");
    }
    List<String> rules = new ArrayList<>();
    for (int i = 0; i < elements.size() / 2; i++) {
      rules.add(elements.get(i * 2).getText().trim() + " " + elements.get(i * 2 + 1).getText().trim());
    }
    return new TradingRules(rules);
  }

}
