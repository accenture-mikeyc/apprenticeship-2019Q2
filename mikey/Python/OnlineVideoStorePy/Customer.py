from Movie import Movie


class Customer:
    def __init__(self, name):
        self.name = name
        self.rentals = []

    def add_rental(self, rental):
        self.rentals.append(rental)

    def get_name(self):
        return self.name

    def statement(self):
        totalAmount = 0.0
        frequentRenterPoints = 0
        rentals = self.rentals
        result = "Rental Record for " + self.get_name() + "\n"

        for each in rentals:
            thisAmount = 0.0
            if each.get_movie().get_price_code() == Movie.REGULAR:
                thisAmount += 2
                if each.get_days_rented() > 2:
                    thisAmount += (each.get_days_rented() - 2) * 1.5
            elif each.get_movie().get_price_code() == Movie.NEW_RELEASE:
                thisAmount += each.get_days_rented() * 3
            elif each.get_movie().get_price_code() == Movie.CHILDRENS:
                thisAmount += 1.5
                if each.get_days_rented() > 3:
                    thisAmount += (each.get_days_rented() - 3) * 1.5

            frequentRenterPoints += 1

            if each.get_movie().get_price_code() == Movie.NEW_RELEASE and each.get_days_rented() > 1:
                frequentRenterPoints += 1

            result += "\t" + each.get_movie().get_title() + "\t" + str(thisAmount) + "\n";
            totalAmount += thisAmount

        result += "You owed " + str(totalAmount) + "\n"
        result += "You earned " + str(frequentRenterPoints) + " frequent renter points\n"

        return result
