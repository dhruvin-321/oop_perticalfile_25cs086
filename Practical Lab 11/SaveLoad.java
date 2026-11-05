import java.io.*;

// Serializable class
class Student implements Serializable {

    int id;
    String name;

    // Transient field
    transient String password;

    // Constructor
    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Display method
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println("------------------");
    }
}

// Drivers class
class Drivers {

    public static void main(String[] args) {

        try {
            // Create array of Student objects
            Student[] students = {
                new Student(1, "Rahul", "abc123"),
                new Student(2, "Priya", "xyz456"),
                new Student(3, "Amit", "pass789")
            };

            // Serialization: Save objects to file
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("students.dat"));

            out.writeObject(students);
            out.close();

            System.out.println("Objects saved successfully!");

            // Deserialization: Read objects from file
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("students.dat"));

            Student[] loadedStudents =
                (Student[]) in.readObject();

            in.close();

            System.out.println("\nLoaded Student Details:");

            // Display loaded objects
            for (Student s : loadedStudents) {
                s.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}