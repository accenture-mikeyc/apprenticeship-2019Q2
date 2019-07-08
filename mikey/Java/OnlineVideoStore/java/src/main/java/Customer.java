import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) rentals.nextElement();

            // determines the amount for rental line
            int daysRented = rental.getDaysRented();

            Movie movie = rental.getMovie();

            thisAmount = movie.determineAmount(thisAmount, daysRented);

            frequentRenterPoints++;

            if (movie.getPriceCode().getPriceCode() == Movie.NEW_RELEASE
                    && daysRented > 1)
                frequentRenterPoints++;

            result += "\t" + movie.getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";


        return result;
    }


    private String name;
    private Vector rentals = new Vector();
}
