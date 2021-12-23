package utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceUtils {

  private static final String EMAIL_ERROR_MESSAGE_KEY = "email.error.message";
  private static final String PASSWORD_ERROR_MESSAGE_KEY = "password.error.message";
  private static final String AGREEMENT_ERROR_MESSAGE_KEY = "age.agreement.error.message";

  private static final ResourceBundle RULES_RESOURCE = ResourceBundle.getBundle(System.getProperty("environment", "trading_rules"));
  private static final ResourceBundle LOGIN_PAGE_RESOURCE = ResourceBundle.getBundle(System.getProperty("environment", "error_messages"));

  public static Map<String, String> getTradingRulesMap() {
    Map<String, String> map = new HashMap<>();
    Enumeration<String> keys = RULES_RESOURCE.getKeys();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      map.put(key, RULES_RESOURCE.getString(key));
    }
    return map;
  }

  public static String getEmailErrorMessage() {
    return LOGIN_PAGE_RESOURCE.getString(EMAIL_ERROR_MESSAGE_KEY);
  }

  public static String getPasswordErrorMessage() {
    return LOGIN_PAGE_RESOURCE.getString(PASSWORD_ERROR_MESSAGE_KEY);
  }

  public static String getAgeAgreementErrorMessage() {return LOGIN_PAGE_RESOURCE.getString(AGREEMENT_ERROR_MESSAGE_KEY);}

}
