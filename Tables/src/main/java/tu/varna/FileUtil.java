package tu.varna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    //save table to file
    public static void saveTable(Table<String, String, String> table, String fileName) {
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(table.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    //load table from file
    public static Table<String, String, String> loadTable(String fileName) {
        //reat table C:\Users\chavd\Documents\Projects\IdeaProjects\Tables\src\main\resources\table.txt

        Table<String, String, String> table = new HashBasedImpl<>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                table.put(values[0], values[1], values[2]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return table;
    }
}
