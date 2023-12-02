import unittest

from day2 import verify, count, CubeBag


class MyTestCase(unittest.TestCase):
    def test_verify_1(self):
        self.assertEqual(1, verify("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))

    def test_verify_2(self):
        self.assertEqual(2, verify("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"))

    def test_verify_3(self):
        self.assertEqual(0, verify("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))

    def test_verify_4(self):
        self.assertEqual(0, verify("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"))

    def test_verify_5(self):
        self.assertEqual(5, verify("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"))

    def test_verify_8(self):
        self.assertEqual(0, verify("Game 99: 1 green, 11 red, 12 blue; 7 red, 20 blue, 1 green; 5 blue, 5 red; 6 "
                                   "blue, 4 red; 1 blue, 1 green; 6 red, 8 blue"))

    def test_parse_hand_1(self):
        test_hand = CubeBag()
        test_hand.parse_hand("3 blue, 4 red")
        self.assertEqual(3, test_hand.blue)
        self.assertEqual(4, test_hand.red)
        self.assertEqual(0, test_hand.green)

    def test_count_1(self):
        self.assertEqual(48, count("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))

    def test_count_2(self):
        self.assertEqual(12, count("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"))

    def test_count_3(self):
        self.assertEqual(1560, count("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))

    def test_count_4(self):
        self.assertEqual(630, count("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"))

    def test_count_5(self):
        self.assertEqual(36, count("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"))

if __name__ == '__main__':
    unittest.main()
