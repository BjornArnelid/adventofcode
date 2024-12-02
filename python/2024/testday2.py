import unittest

from day2 import check_list, check_strings


TEST_DATA = '''7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9'''


TEST_DATA_EDGE = '''48 46 47 49 51 54 56
1 1 2 3 4 5
1 2 3 4 5 5
5 1 2 3 4 5
1 4 3 2 1
1 6 7 8 9
1 2 3 4 3
9 8 7 6 7
7 10 8 10 11
29 28 27 25 26 25 22 20'''


class TestDey2(unittest.TestCase):
    def test_is_safe(self):
        self.assertEqual(True, check_list([7, 6, 4, 2, 1]))

    def test_is_increase(self):
        self.assertEqual(False, check_list([1, 2, 7, 8, 9]))

    def test_is_decrease(self):
        self.assertEqual(False, check_list([9, 7, 6, 2, 1]))

    def test_change_direction(self):
        self.assertEqual(False, check_list([1, 3, 2, 4, 5]))

    def test_parse_string(self):
        self.assertEqual(1, check_strings(["7 6 4 2 1"]))

    def test_parse_strings(self):
        self.assertEqual(2, check_strings(TEST_DATA.split('\n')))

    def test_parse_string_2(self):
        self.assertEqual(4, check_strings(TEST_DATA.split('\n'), 1))

    def test_increase_level_1(self):
        self.assertEqual(False, check_list([1, 2, 7, 8, 9], 1))

    def test_parse_strings_edge(self):
        self.assertEqual(10, check_strings(TEST_DATA_EDGE.split('\n'), 1))

    def test_edge_case_1(self):
        self.assertEqual(True, check_list([48, 46, 47, 49, 51, 54, 56], 1))

if __name__ == '__main__':
    unittest.main()