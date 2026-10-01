import java.util.*;

public class InputHandler {
    public static List<String[]> readRelationships(Scanner sc) {
        List<String[]> pairs = new ArrayList<>();
        System.out.print("Enter number of relationships: ");
        if (!sc.hasNextLine()) {
            System.out.println("Not enough input lines provided. Stopping early.");
            return pairs;
        }

        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, please enter a whole number. Exiting.");
            return pairs;
        }

        if (n < 0) {
            System.out.println("Invalid number, the relationship count cannot be negative. Exiting.");
            return pairs;
        }

        System.out.println("Enter relationships as \"Parent Child\":");
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) {
                System.out.println("Not enough input lines provided. Stopping early.");
                break;
            }
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            // Day 3 Validation Check
            if (parts.length != 2) {
                System.out.println("Invalid line, skipping: " + line);
                continue;
            }

            if (parts[0].equals(parts[1])) {
                System.out.println("Invalid line (a node cannot be its own parent), skipping: " + line);
                continue;
            }

            pairs.add(parts);
        }
        return pairs;
    }
}
