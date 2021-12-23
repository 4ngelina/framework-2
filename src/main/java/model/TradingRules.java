package model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TradingRules {

  private List<String> ruleList;

  public TradingRules(List<String> rules) {
    this.ruleList = rules;
  }

  public void addRule(String rule) {
    ruleList.add(rule);
  }

  public List<String> getRuleList() {
    return ruleList;
  }

  public void setRuleList(List<String> ruleList) {
    if (ruleList != null) {
      this.ruleList = ruleList;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TradingRules that = (TradingRules) o;
    return Set.copyOf(ruleList).equals(Set.copyOf(that.ruleList));
  }

  @Override
  public int hashCode() {
    return Objects.hash(ruleList);
  }
}
