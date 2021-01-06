import unittest

from day15 import number_game


class Day15Test(unittest.TestCase):
    def test_iterate_once(self):
        self.assertEqual(0, number_game([0, 3, 6], 1))

    def test_iter_twice(self):
        self.assertEqual(3, number_game([0, 3, 6], 2))

    def test_iter_thrice(self):
        self.assertEqual(3, number_game([0, 3, 6], 3))

    def test_iter_fourth(self):
        self.assertEqual(1, number_game([0, 3, 6], 4))

    def test_iter_fifth(self):
        self.assertEqual(0, number_game([0, 3, 6], 5))

    def test_iter_sixth(self):
        self.assertEqual(4, number_game([0, 3, 6], 6))

    def test_iter_seventh(self):
        self.assertEqual(0, number_game([0, 3, 6], 7))

    def test_2020_iterations(self):
        self.assertEqual(436, number_game([0, 3, 6], 2017))

    def test_2020_iterations2(self):
        self.assertEqual(1, number_game([1, 3, 2], 2017))

    def test_2020_iterations3(self):
        self.assertEqual(10, number_game([2, 1, 3], 2017))


if __name__ == '__main__':
    unittest.main()
