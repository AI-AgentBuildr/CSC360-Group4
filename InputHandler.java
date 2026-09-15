import java.util.*;

public class InputHandler {
    public static List<String[]> readRelationships(Scanner sc) {
        List<String[]> pairs = new ArrayList<>();
        System.out.print("Enter number of relationships: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Enter relationships as \"Parent Child\":");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            pairs.add(parts);
        }
        return pairs;
    }
}