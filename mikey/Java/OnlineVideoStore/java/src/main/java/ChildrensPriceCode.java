public class ChildrensPriceCode extends PriceCode {
    @Override
    double generatePrice(double thisAmount, int daysRented) {

        thisAmount += 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
