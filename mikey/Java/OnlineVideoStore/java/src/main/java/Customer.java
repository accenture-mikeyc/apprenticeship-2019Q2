import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    private String result = "";

    public String statement() {

        buildStatementHeader();

        for (Rental rental : rentals) {
            buildStatementBody(rental);
        }

        buildStatementFooter();
        return result;
    }

    private void buildStatementFooter() {
        result += "You owed " + calculateTotalRentalAmount() + "\n";
        result += "You earned " + calculateFrequentRenterPoints() + " frequent renter points\n";
    }

    private void buildStatementBody(Rental rental) {
        result += "\t" + rental.getMovie().getTitle() + "\t"
                + rental.getCostOfRental() + "\n";
    }

    private void buildStatementHeader() {
        result = "Rental Record for " + getName() + "\n";
    }

    private double calculateTotalRentalAmount() {
        double totalAmount = 0;

        for (Rental rental : rentals) {

            totalAmount += rental.getCostOfRental();
        }

        return totalAmount;
    }

    private int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }
}
