import unittest

from day9 import evaluate_two_matches, find_first_deviant, find_matching_sequence

number_list = [35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576]


class Day9Test(unittest.TestCase):
    def test_26_is_valid(self):
        self.assertEqual(True, evaluate_two_matches(range(1, 25), 26))

    def test_49_is_valid(self):
        self.assertEqual(True, evaluate_two_matches(range(2, 26), 49))

    def test_100_is_not_valid(self):
        numbers = list(range(3, 26))
        numbers.append(49)
        self.assertEqual(False, evaluate_two_matches(numbers, 100))

    def test_100_is_not_valid(self):
        numbers = list(range(3, 26))
        numbers.append(49)
        self.assertEqual(False, evaluate_two_matches(numbers, 50))

    def test_list_of_numbers(self):
        self.assertEqual(127, find_first_deviant(number_list, 5))

    def test_find_matching_sequence(self):
        self.assertEqual([15, 25, 47, 40], find_matching_sequence(number_list, 127))


if __name__ == '__main__':
    unittest.main()
