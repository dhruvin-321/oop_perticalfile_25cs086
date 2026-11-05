import java.util.*;

class Drivers {
    public static void main(String[] args) {

        String paragraph = "java is easy java is powerful java is popular";

        // Split paragraph into words
        String[] words = paragraph.toLowerCase().split("\\s+");

        // Create HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Count word frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Convert map entries into list
        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(map.entrySet());

        // Sort by frequency (highest first)
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        // Print word frequencies
        System.out.println("Word Frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}