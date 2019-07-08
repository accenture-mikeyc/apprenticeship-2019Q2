public class Movie
{
    public static final int CHILDRENS	= 2;
    public static final int REGULAR 	= 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private PriceCode priceCode;

    public Movie (String title, int priceCode) {
        this.title 		= title;

        switch (priceCode) {
            case REGULAR:
                this.priceCode = new RegularPriceCode();
                break;
            case NEW_RELEASE:
                this.priceCode = new NewReleasePriceCode();
                break;
            case CHILDRENS:
                this.priceCode = new ChildrensPriceCode();
                break;
        }

    }

    public PriceCode getPriceCode () {
        return priceCode;
    }

    public String getTitle () {
        return title;
    }

    double determineAmount(double thisAmount, int daysRented) {

        PriceCode priceCode = this.priceCode;

        thisAmount = priceCode.generatePrice(thisAmount, daysRented);
        return thisAmount;
    }

}