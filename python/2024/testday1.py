import unittest
from day1 import compare_numbers, compare_lists, evaluate_lists, evaluate_input, to_map, count_numbers, evaluate_number, \
    evaluate_list

TEST_DATA_1 = '''
3   4
4   3
2   5
1   3
3   9
3   3
'''


TEST_DATA_2 = '''
3   4
4   3
2   5
1   3
3   9
3   3
'''


class TestDey1(unittest.TestCase):
    def test_compare_numbers(self):
        self.assertEqual(2, compare_numbers(1, 3))

    def test_compare_lists(self):
        self.assertEqual([2, 1, 0, 1, 2, 5], compare_lists([3, 4, 2, 1, 3, 3], [4, 3, 5, 3, 9, 3]))

    def test_evaluate_lists(self):
        self.assertEqual(11, evaluate_lists([3, 4, 2, 1, 3, 3], [4, 3, 5, 3, 9, 3]))

    def test_evaluate_strings(self):
        self.assertEqual(11, evaluate_input(TEST_DATA_1))

    def test_count_3(self):
        right = to_map([4, 3, 5, 3, 9, 3])
        self.assertEqual(3, count_numbers(3, right))

    def test_count_2(self):
        right = to_map([4, 3, 5, 3, 9, 3])
        self.assertEqual(0, count_numbers(2, right))

    def test_evaluate_count_3(self):
        right = to_map([4, 3, 5, 3, 9, 3])
        self.assertEqual(9, evaluate_number(3, right))

    def test_evaluate_list(self):
        right = to_map([4, 3, 5, 3, 9, 3])
        self.assertEqual(31, evaluate_list([3, 4, 2, 1, 3, 3], right))

    def test_evaluate_input_2(self):
        self.assertEqual(31, evaluate_input2(TEST_DATA_2))


if __name__ == '__main__':
    unittest.main()
