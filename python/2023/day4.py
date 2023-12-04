class Card:
    def __init__(self, card_string):
        card_id, content = card_string.split(':')
        self.name = card_id.strip()
        content_parts = content.split('|')
        self.correct_numbers = create_number_list(content_parts[0])
        self.input_numbers = create_number_list(content_parts[1])
        self.number_of_cards = 1


def create_number_list(number_string):
    return list(filter(lambda k: k.isnumeric(), number_string.strip().split(' ')))


def count_correct_answers(card):
    correct = []
    for number in card.input_numbers:
        if number in card.correct_numbers:
            correct.append(number)
    return len(correct)


def count_score(correct_numbers):
    score = 0
    for i in range(correct_numbers):
        if score == 0:
            score = 1
        else:
            score = score * 2
    return score


def analyse_cards(list_of_cards):
    total = 0
    for card_string in list_of_cards:
        total += count_score(count_correct_answers(Card(card_string)))
    return total


def find_won_cards(index, cards):
    current_card = cards[index]
    correct_answers = count_correct_answers(current_card)
    for add_index in range(index + 1, index + 1 + correct_answers):
        cards[add_index].number_of_cards += current_card.number_of_cards


def count_won_cards(list_of_cards):
    cards = []
    # Add cards to dict
    for card_string in list_of_cards:
        cards.append(Card(card_string))

    # Add card winnings
    for i in range(len(cards)):
        find_won_cards(i, cards)

    total = 0
    # Count number of cards
    for card in cards:
        total += card.number_of_cards
    return total


if __name__ == '__main__':
    print("Starting day 4")
    with open('data/day4.data') as data:
        data_list = list(data)
    print("Answer part 1: " + str(analyse_cards(data_list)))

    print("Answer part 2: " + str(count_won_cards(data_list)))
