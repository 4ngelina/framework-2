package utils;

import model.User;

import java.util.Random;

public class UserCredentialsUtils {

  private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final Random random = new Random();

  public static User getRandomUser() {
    return new User(
        getRandomEmail(),
        getRandomPassword()
    );
  }

  public static String getRandomEmail() {
    return "%s@%s.%s".formatted(getRandomString(), getRandomString(), getRandomString());
  }

  public static String getRandomPassword() {
    return getRandomString(15);
  }


  private static String getRandomString() {
    return getRandomString((int)(Math.random() * 10) + 3);
  }

  private static String getRandomString(int stringLength) {
    StringBuilder stringBuilder = new StringBuilder(stringLength);
    for (int i = 0; i < stringLength; i++)
    {
      stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
    }
    return stringBuilder.toString();
  }

}
