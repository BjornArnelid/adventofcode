import unittest

from day4 import analyse_cards, count_correct_answers, count_won_cards, Card


class MyTestCase(unittest.TestCase):
    def test_card_1(self):
        self.assertEqual(8, analyse_cards(["Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"]))

    def test_count_numbers(self):
        self.assertEqual(4, count_correct_answers(Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")))

    def test_all_cards(self):
        self.assertEqual(13, analyse_cards([
            'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53',
            'Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19',
            'Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1',
            'Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83',
            'Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36',
            'Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11']))

    def test_count_all_tickets(self):
        self.assertEqual(30, count_won_cards([
            'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53',
            'Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19',
            'Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1',
            'Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83',
            'Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36',
            'Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11']))


if __name__ == '__main__':
    unittest.main()
