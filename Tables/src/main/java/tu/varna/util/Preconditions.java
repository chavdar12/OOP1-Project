package tu.varna.util;

import tu.varna.table.impl.Table;

public class Preconditions {
    public static void checkNotNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                throw new NullPointerException();
            }
        }
    }

    public static void checkContainsInTable(Table table, String... args) {
        //check if table contains all args
        for (String arg : args) {
            if (!table.containsValue(arg)) {
                throw new IllegalArgumentException();
            }
        }
    }

    //check if value is integer or double and return true if it is integer
    public static boolean checkIfInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void checkIfOperatorIsValid(Character operator) {
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new IllegalArgumentException();
        }
    }
}
