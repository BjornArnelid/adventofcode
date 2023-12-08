def interpret_card(card_string):
    if card_string == 'T':
        return 10
    elif card_string == 'J':
        return 11
    elif card_string == 'Q':
        return 12
    elif card_string == 'K':
        return 13
    elif card_string == 'A':
        return 14
    else:
        return int(card_string)


class Hand:
    def __init__(self, hand_input):
        self.hand = [interpret_card(val) for val in hand_input]
        self.hand.sort()
        # TODO different values
        type = self.get_type()
        highest_card = type + self.hand[0]
        self.value = highest_card

    def get_type(self):
        previous = None
        pairs = 0
        for val in self.hand:
            if previous and previous == val:
                pairs = 1
                return 100
            else:
                previous = val
        return 0

    def get_value(self):
        return self.value
