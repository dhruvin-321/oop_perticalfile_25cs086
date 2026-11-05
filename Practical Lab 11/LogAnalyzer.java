import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

class Drivers {
    public static void main(String[] args) {

        try {
            // Create text files
            Files.write(Paths.get("log1.txt"), Arrays.asList(
                "Application started",
                "Error: File not found",
                "User logged in"
            ));

            Files.write(Paths.get("log2.txt"), Arrays.asList(
                "Database connected",
                "Warning: Low memory",
                "Error: Connection failed"
            ));

            Files.write(Paths.get("log3.txt"), Arrays.asList(
                "Server started",
                "User logged out",
                "Error: Timeout"
            ));

            // Array of file paths
            Path[] files = {
                Paths.get("log1.txt"),
                Paths.get("log2.txt"),
                Paths.get("log3.txt")
            };

            String keyword = "Error";

            int totalLines = 0;
            int matchingLines = 0;

            System.out.println("Log File Analysis:");
            System.out.println("------------------------");

            // Process each file
            for (Path path : files) {

                int fileLines = 0;

                // Read file attributes
                BasicFileAttributes attr =
                    Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println("File: " + path.getFileName());
                System.out.println("Size: " + attr.size() + " bytes");

                // Read file line by line
                BufferedReader reader =
                    Files.newBufferedReader(path);

                String line;

                while ((line = reader.readLine()) != null) {

                    fileLines++;
                    totalLines++;

                    if (line.contains(keyword)) {
                        matchingLines++;
                    }
                }

                reader.close();

                System.out.println("Lines: " + fileLines);
                System.out.println("------------------------");
            }

            // Display final results
            System.out.println("Total Lines: " + totalLines);
            System.out.println("Lines containing '" +
                               keyword + "': " + matchingLines);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}