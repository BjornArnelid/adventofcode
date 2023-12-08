import unittest

from day6 import move_boat, find_error_margin, find_all_error_margins


class MyTestCase(unittest.TestCase):
    def test_hold_button_0(self):
        self.assertEqual(0, move_boat(0, 7))

    def test_move_boat_1(self):
        self.assertEqual(6, move_boat(1, 7))

    def test_find_margin_of_error_1(self):
        self.assertEquals(4, find_error_margin(7, 9))

    def test_find_margin_of_error_2(self):
        self.assertEquals(8, find_error_margin(15, 40))

    def test_find_margin_of_error_3(self):
        self.assertEquals(9, find_error_margin(30, 200))

    def test_find_combined_margin(self):
        self.assertEquals(288, find_all_error_margins([(7, 9), (15, 40), (30, 200)]))


if __name__ == '__main__':
    unittest.main()
