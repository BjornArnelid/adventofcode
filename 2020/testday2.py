import unittest

from day2 import password_is_legal, password_position_legal


class Day2Test(unittest.TestCase):
    def test_first_password(self):
        self.assertEqual(True, password_is_legal(1, 3, 'a', 'abcde'))

    def test_second_password(self):
        self.assertEqual(False, password_is_legal(1, 3, 'b', 'cdefg'))

    def test_third_password(self):
        self.assertEqual(True, password_is_legal(2, 9, 'c', 'ccccccccc'))

    def test_first_occurrence(self):
        self.assertEqual(True, password_position_legal(1, 3, 'a', 'abcde'))

    def test_second_occurrence(self):
        self.assertEqual(False, password_position_legal(1, 3, 'b', 'cdefg'))

    def test_third_occurrence(self):
        self.assertEqual(False, password_position_legal(2, 9, 'c', 'ccccccccc'))


if __name__ == '__main__':
    unittest.main()
