public class NewReleasePriceCode extends PriceCode {
    @Override
    double generatePrice(double thisAmount, int daysRented) {
        return thisAmount += daysRented * 3;
    }

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
