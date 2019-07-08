class Movie:
    CHILDRENS = 2
    REGULAR = 0
    NEW_RELEASE = 1

    def __init__(self, title, priceCode):
        self.title = title
        self.priceCode = priceCode

    def get_price_code(self):
        return self.priceCode

    def get_title(self):
        return self.title
