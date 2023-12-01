import unittest
from day1 import parse_string


class MyTestCase(unittest.TestCase):
    def test_string_1(self):
        self.assertEqual(12, parse_string("1abc2"))

    def test_string_2(self):
        self.assertEqual(38, parse_string("pqr3stu8vwx"))

    def test_string_3(self):
        self.assertEqual(15, parse_string("a1b2c3d4e5f"))

    def test_string_4(self):
        self.assertEqual(77, parse_string("treb7uchet"))

    def test_string_5(self):
        self.assertEqual(29, parse_string("two1nine"))

    def test_string_6(self):
        self.assertEqual(83, parse_string("eightwothree"))

    def test_string_7(self):
        self.assertEqual(13, parse_string("abcone2threexyz"))

    def test_string_8(self):
        self.assertEqual(24, parse_string("xtwone3four"))

    def test_string_9(self):
        self.assertEqual(42, parse_string("4nineeightseven2"))

    def test_string_10(self):
        self.assertEqual(14, parse_string("zoneight234"))

    def test_string_11(self):
        self.assertEqual(76, parse_string("7pqrstsixteen"))


if __name__ == '__main__':
    unittest.main()
