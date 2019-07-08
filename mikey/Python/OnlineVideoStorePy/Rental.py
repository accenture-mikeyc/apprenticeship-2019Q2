class Rental:

    def __init__(self, movie, daysRented):
        self.movie = movie
        self.daysRented = daysRented

    def get_days_rented(self):
        return self.daysRented

    def get_movie(self):
        return self.movie
