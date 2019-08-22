import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReadAndCount {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        File file = new File("zadanie.txt");
        Scanner scan = null;
        try {
            file.createNewFile();
            scan = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadAndSort(list, scan);
        Collections.sort(list);
        int[] results = new int[list.size()];
        counting(list, results);
        showResults(list, results);
    }

    private static void counting(List<Integer> list, int[] results) {
        int number = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                number++;
            } else {
                results[i-1] = number;
                number = 1;
            }
            results[list.size()-1] = number;
        }
    }

    private static void loadAndSort(List<Integer> list, Scanner scan) {
        int lines = 0;
        while (scan.hasNextLine()) {
            list.add(scan.nextInt());
            list.get(lines);
            lines++;
        }
    }

    private static void showResults(List<Integer> list, int[] results) {
        for (int i = 0; i < list.size(); i++) {
            if (results[i] > 0) {
                System.out.println(list.get(i) + " - liczba wystąpień: " + results[i]);
            }
        }
    }
}
