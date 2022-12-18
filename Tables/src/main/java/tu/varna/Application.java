package tu.varna;

import java.util.Scanner;

public class Application implements IApplication {

    //console menu
    private Table<String, String, String> table;

    public void run() {
        printMenu();
    }

    @Override
    public void printMenu() {
        System.out.println(Constants.MENU_OPTIONS);
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> open();
            case 2 -> close();
            case 3 -> save();
            case 4 -> saveAs();
            case 5 -> help();
            case 6 -> System.exit(0);
            default -> System.out.println("Invalid option");
        }
    }

    private void help() {
        System.out.println(Constants.HELP_OPTIONS);
    }

    private void saveAs() {

    }

    private void save() {

    }

    private void close() {
        table = null;
    }

    private void open() {
        System.out.println(Constants.OPEN_FILE_OPTIONS);
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> openExistingTable();
            case 2 -> openNewTable();
            case 3 -> printMenu();
            default -> System.out.println("Invalid option");
        }
    }

    private void openExistingTable() {
        System.out.println("Enter file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        table = FileUtil.loadTable(fileName);
        System.out.println(table);
        System.out.println(Constants.DATA_OPTIONS);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> printTable();
            case 2 -> addValue();
            case 3 -> removeValue();
            case 4 -> performArithmeticOperation();
            case 5 -> printMenu();
            default -> System.out.println("Invalid option");
        }
    }

    private void performArithmeticOperation() {
        System.out.println("Enter command: ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        String[] data = command.split(" ");
        String[] firstCell = data[0].split("C");
        String[] secondCell = data[2].split("C");
        String firstRow = firstCell[0].substring(1);
        String firstColumn = firstCell[1];
        String secondRow = secondCell[0].substring(1);
        String secondColumn = secondCell[1];
        String firstValue = table.get(firstRow, firstColumn);
        String secondValue = table.get(secondRow, secondColumn);

        if (Preconditions.checkDouble(firstValue) && Preconditions.checkDouble(secondValue)) {
            double first = Double.parseDouble(firstValue);
            double second = Double.parseDouble(secondValue);
            double result = 0;
            switch (data[1]) {
                case "+" -> result = first + second;
                case "-" -> result = first - second;
                case "*" -> result = first * second;
                case "/" -> result = first / second;
            }
            System.out.println(result);
        } else {
            System.out.println("Invalid operation");
        }
    }

    private void removeValue() {
        //remove R1C1
        System.out.println("Enter cell: ");
        //check if command is valid and if cell exists
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[] data = command.split("C");
        String row = data[0].substring(1);
        String column = data[1];
        table.remove(row, column);
        System.out.println(table);
    }

    private void addValue() {

    }

    private void printTable() {
        System.out.println(table);
    }

    private void openNewTable() {
        table = new HashBasedImpl<>();
    }
}
