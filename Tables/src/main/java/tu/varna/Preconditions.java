package tu.varna;

import static tu.varna.Constants.DOUBLE_REGEX_PATTERN;
import static tu.varna.Constants.INTEGER_REGEX_PATTERN;

public class Preconditions {
    public static void checkNotNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                throw new NullPointerException();
            }
        }
    }

    //check if string is integer
    public static boolean checkInteger(String number) {
        return number.matches(INTEGER_REGEX_PATTERN);
    }

    //check if string is double
    public static boolean checkDouble(String number) {
        return number.matches(DOUBLE_REGEX_PATTERN);
    }
}
