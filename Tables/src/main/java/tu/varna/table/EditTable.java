package tu.varna.table;

import tu.varna.table.impl.HashBasedImpl;
import tu.varna.table.impl.Table;
import tu.varna.util.Preconditions;

import static tu.varna.util.Preconditions.*;

public class EditTable {
    private Table<String, String, String> table;

    public EditTable() {
        table = new HashBasedImpl<>();
    }

    public void cellAddition(String firstRow, String firstColumn, String secondRow, String secondColumn, Character operator) {
        checkNotNull(firstRow, firstColumn, secondRow, secondColumn);
        checkContainsInTable(table, firstRow, firstColumn, secondRow, secondColumn);
        checkIfOperatorIsValid(operator);

        boolean firstValue = checkIfInteger(table.get(firstRow, firstColumn));
        boolean secondValue = checkIfInteger(table.get(secondRow, secondColumn));

        //if one of the values is not integer, parse to double
        if (!firstValue || !secondValue) {
            double first = Double.parseDouble(table.get(firstRow, firstColumn));
            double second = Double.parseDouble(table.get(secondRow, secondColumn));
            double result = switch (operator) {
                case '+' -> first + second;
                case '-' -> first - second;
                case '*' -> first * second;
                case '/' -> first / second;
                default -> 0;
            };
            table.put(firstRow, firstColumn, String.valueOf(result));
        } else {
            int first = Integer.parseInt(table.get(firstRow, firstColumn));
            int second = Integer.parseInt(table.get(secondRow, secondColumn));
            int result = switch (operator) {
                case '+' -> first + second;
                case '-' -> first - second;
                case '*' -> first * second;
                case '/' -> first / second;
                default -> 0;
            };
            table.put(firstRow, firstColumn, String.valueOf(result));
        }
    }
}
