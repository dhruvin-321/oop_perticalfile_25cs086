abstract class Media {
    protected String title;
    protected int lateDays;

    // Constructor
    public Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    // Abstract method
    abstract double calculateLateFee();
}

// Book class
class Book extends Media {

    public Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 2.0;
    }
}

// DVD class
class DVD extends Media {

    public DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 5.0;
    }
}

// Magazine class
class Magazine extends Media {

    public Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 1.5;
    }
}

// Drivers class
class Drivers {
    public static void main(String[] args) {

        Media[] items = {
            new Book("Java Programming", 3),
            new DVD("Avengers", 2),
            new Magazine("Science Today", 4)
        };

        double totalFee = 0;

        System.out.println("Late Fees:");

        for (Media m : items) {
            double fee = m.calculateLateFee();

            System.out.println(m.title + " = Rs. " + fee);

            totalFee += fee;
        }

        System.out.println("--------------------");
        System.out.println("Total Late Fee: Rs. " + totalFee);
    }
}