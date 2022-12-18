package tu.varna;

public class Main {
    public static void main(String[] args) {
        Table<String, String, String> table = new HashBasedImpl<>();
        Table<String, String, String> table2 = new HashBasedImpl<>();
        table.put("1", "1", "1");
        table.put("2", "2", "2");
        table.put("3", "3", "3");

        System.out.println(table.toString());

        FileUtil.saveTable(table, "C:\\Users\\chavd\\Documents\\Projects\\IdeaProjects\\Tables\\src\\main\\resources\\table.txt");

        table2 = FileUtil.loadTable("C:\\Users\\chavd\\Documents\\Projects\\IdeaProjects\\Tables\\src\\main\\resources\\table.txt");

        System.out.println(table2.toString());
    }
}