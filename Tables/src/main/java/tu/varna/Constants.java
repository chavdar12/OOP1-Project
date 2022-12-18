package tu.varna;

public interface Constants {

    String DOUBLE_REGEX_PATTERN = "[0-9]+(\\.[0-9]+)?";

    String INTEGER_REGEX_PATTERN = "[0-9]+";
    String MENU_OPTIONS = """
            1. Open
            2. Close
            3. Save
            4. Save as
            5. Help
            6. Exit
            """;
    String HELP_OPTIONS = """
            1. Open - open a table from a file
            2. Close - close the current table
            3. Save - save the current table to a file
            4. Save as - save the current table to a file with a new name
            5. Help - show the menu
            6. Exit - exit the program
            """;

    String OPEN_FILE_OPTIONS = """
            1. Open existing table
            2. Open new table
            3. Back
            """;

    String DATA_OPTIONS = """
            1. Print table
            2. Add value
            3. Remove value
            3. Perform operation
            4. Back
            """;
}
