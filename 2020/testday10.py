import unittest

from day10 import count_steps, count_variations

first_example = [16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4]

second_example = [28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4,
                  2, 34, 10, 3]


class Day10Test(unittest.TestCase):
    def test_count_steps(self):
        one_step, three_steps = count_steps(first_example)
        self.assertEqual(7, one_step)
        self.assertEqual(5, three_steps)

    def test_count_steps2(self):
        one_step, three_steps = count_steps(second_example)
        self.assertEqual(22, one_step)
        self.assertEqual(10, three_steps)

    def test_count_variation_first_example(self):
        self.assertEqual(8, count_variations(first_example))

    def test_count_variation_second_example(self):
        self.assertEqual(19208,count_variations(second_example))


if __name__ == '__main__':
    unittest.main()
