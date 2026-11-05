// Generic Box class
class Box<T> {

    private T value;

    // Set value
    public void set(T value) {
        this.value = value;
    }

    // Get value
    public T get() {
        return value;
    }
}

// Generic Pair class
class Pair<A, B> {

    private A first;
    private B second;

    // Constructor
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

// Generic method to return first array element
class Drivers {

    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        // Box with Integer
        Box<Integer> b1 = new Box<>();
        b1.set(100);

        // Box with String
        Box<String> b2 = new Box<>();
        b2.set("Hello Java");

        System.out.println("Integer Box: " + b1.get());
        System.out.println("String Box: " + b2.get());

        // Pair with String and Integer
        Pair<String, Integer> p1 =
            new Pair<>("Rahul", 21);

        System.out.println("Pair First: " + p1.getFirst());
        System.out.println("Pair Second: " + p1.getSecond());

        // Pair with Integer and Double
        Pair<Integer, Double> p2 =
            new Pair<>(10, 25.5);

        System.out.println("Pair First: " + p2.getFirst());
        System.out.println("Pair Second: " + p2.getSecond());

        // Generic method with Integer array
        Integer[] numbers = {10, 20, 30};

        System.out.println("First Number: " +
            getFirst(numbers));

        // Generic method with String array
        String[] names = {"Amit", "Rahul", "Priya"};

        System.out.println("First Name: " +
            getFirst(names));
    }
}