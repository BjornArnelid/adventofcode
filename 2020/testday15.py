import unittest

from day15 import number_game


class Day15Test(unittest.TestCase):
    def test_iterate_once(self):
        self.assertEqual(0, number_game([0, 3, 6], 1)[-1])

    def test_iter_twice(self):
        self.assertEqual(3, number_game([0, 3, 6], 2)[-1])

    def test_iter_thrice(self):
        self.assertEqual(3, number_game([0, 3, 6], 3)[-1])

    def test_iter_fourth(self):
        self.assertEqual(1, number_game([0, 3, 6], 4)[-1])

    def test_2020_iterations(self):
        self.assertEqual(1, number_game([1, 3, 2], 2020)[2019])

    def test_2020_iterations(self):
        self.assertEqual(10, number_game([2, 1, 3], 2020)[2019])


if __name__ == '__main__':
    unittest.main()
