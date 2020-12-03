import unittest
import day1


class Day1Test(unittest.TestCase):
    def test_find_2020_and_multiply(self):
        input_array = [1721, 979, 366, 299, 675, 1456]
        self.assertEqual(514579, day1.find_and_multiply_two(input_array))

    def test_find_3_numbers(self):
        input_array = [1721, 979, 366, 299, 675, 1456]
        self.assertEqual(241861950, day1.find_and_multiply_three(input_array))


if __name__ == '__main__':
    unittest.main()
