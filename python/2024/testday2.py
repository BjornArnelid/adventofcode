import unittest

from day2 import check_list, check_strings


TEST_DATA = '''7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9'''
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

if __name__ == '__main__':
    unittest.main()
