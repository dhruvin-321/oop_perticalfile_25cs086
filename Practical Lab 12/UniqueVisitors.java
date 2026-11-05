import java.util.*;

class Drivers {
    public static void main(String[] args) {

        // List of login names with repeats
        String[] names = {
            "Rahul", "Priya", "Amit", "Rahul",
            "Neha", "Priya", "Karan", "Amit"
        };

        // HashSet to count unique users
        HashSet<String> uniqueUsers = new HashSet<>();

        // LinkedHashSet to maintain first-seen order
        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        // Add names to both sets
        for (String name : names) {
            uniqueUsers.add(name);
            orderedUsers.add(name);
        }

        // Print unique count
        System.out.println("Unique Visitors: " + uniqueUsers.size());

        // Print first three distinct names
        System.out.println("First three unique visitors:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3)
                break;

            System.out.println(name);
            count++;
        }
    }
}