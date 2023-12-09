import unittest

from day9 import predict_next_value, predict_previous_value


class MyTestCase(unittest.TestCase):
    def test_predict_next_value_1(self):
        self.assertEqual(18, predict_next_value([0, 3, 6, 9, 12, 15]))

    def test_predict_next_value_2(self):
        self.assertEqual(28, predict_next_value([1, 3, 6, 10, 15, 21]))

    def test_predict_next_value_3(self):
        self.assertEqual(68, predict_next_value([10, 13, 16, 21, 30, 45]))

    def predict_previous_value_1(self):
        self.assertEqual(5, predict_previous_value([10, 13, 16, 21, 30, 45]))

    def predict_previous_value_2(self):
        self.assertEqual(-3, predict_previous_value([0, 3, 6, 9, 12, 15]))

    def test_predict_previous_value_3(self):
        self.assertEqual(0, predict_previous_value([1, 3, 6, 10, 15, 21]))


if __name__ == '__main__':
    unittest.main()
