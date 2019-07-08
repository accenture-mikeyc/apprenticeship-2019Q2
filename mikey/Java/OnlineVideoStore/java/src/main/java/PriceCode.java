abstract public class PriceCode {
    abstract int getPriceCode();

    abstract double generatePrice(double thisAmount, int daysRented);
}
