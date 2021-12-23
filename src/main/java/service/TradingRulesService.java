package service;

import model.TradingRules;
import utils.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TradingRulesService {

  public TradingRules getTradingRules() {
    Map<String, String> ruleMap = ResourceUtils.getTradingRulesMap();
    List<String> rules = new ArrayList<>();
    for (Map.Entry<String, String> map : ruleMap.entrySet()) {
      rules.add(map.getKey());
      rules.add(map.getValue());
    }
    return new TradingRules(rules);
  }





}
