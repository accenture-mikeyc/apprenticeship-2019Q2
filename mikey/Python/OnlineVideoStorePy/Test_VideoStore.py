from Movie import Movie
from Rental import Rental
from Customer import Customer


class TestVideoStore:

    def test_single_new_release_statement(self):
        fred = Customer("Fred")
        fred.add_rental(Rental(Movie("The Cell", Movie.NEW_RELEASE), 3))
        assert fred.statement() == "Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n"

    def test_dual_new_release_statement(self):
        fred = Customer("Fred")
        fred.add_rental(Rental(Movie("The Cell", Movie.NEW_RELEASE), 3))
        fred.add_rental(Rental(Movie("The Tigger Movie", Movie.NEW_RELEASE), 3))
        assert fred.statement() == "Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n"

    def test_single_childrens_statement(self):
        fred = Customer("Fred")
        fred.add_rental(Rental(Movie("The Tigger Movie", Movie.CHILDRENS), 3))
        assert fred.statement() == "Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n"

    def test_dual_childrens_statement(self):
        fred = Customer("Fred")
        fred.add_rental(Rental(Movie("The Tigger Movie", Movie.CHILDRENS), 3))
        fred.add_rental(Rental(Movie("Zootopia", Movie.CHILDRENS), 4))
        assert fred.statement() == "Rental Record for Fred\n\tThe Tigger Movie\t1.5\n\tZootopia\t3.0\nYou owed 4.5\nYou earned 2 frequent renter points\n"

    def test_multiple_regular_statement(self):
        fred = Customer("Fred")
        fred.add_rental(Rental(Movie("Plan 9 from Outer Space", Movie.REGULAR), 1))
        fred.add_rental(Rental(Movie("8 1/2", Movie.REGULAR), 2))
        fred.add_rental(Rental(Movie("Eraserhead", Movie.REGULAR), 3))
        assert fred.statement() == "Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n"
