public class RegularPriceCode extends PriceCode {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double generatePrice(double thisAmount, int daysRented) {
        thisAmount += 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
