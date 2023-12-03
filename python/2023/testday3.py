import unittest

from day3 import read_parts, combine_values, MachineParts, is_near_symbol, read_gears, count_gear_ratio


class MyTestCase(unittest.TestCase):
    def test_parse_just_number(self):
        parts = read_parts(['114'])
        self.assertEqual(0, combine_values(parts))

    def test_parse_number_and_symbol(self):
        parts = read_parts(['467..114..', '...*......'])
        self.assertEqual(467, combine_values(parts))

    def test_parse_all_sides(self):
        parts = read_parts(['467..114..',
                            '...*......',
                            '..35..633.',
                            '......#...',
                            '617*......',
                            '.....+.58.',
                            '..592.....',
                            '......755.',
                            '...$.*....',
                            '.664.598..'])
        self.assertEqual(4361, combine_values(parts))

    def test_check_right(self):
        part = MachineParts(617, 3)
        is_near_symbol(0, 1, part,
                       ['......#...',
                                '617*......',
                                '.....+.58.'])
        self.assertTrue(part.is_real)

    def test_negative_number(self):
        parts = read_parts(['-44'])
        self.assertEqual(44, combine_values(parts))

    def test_decimal(self):
        parts = read_parts(['............',
                            '..73.133.40.',
                            '.....*...*..'])
        self.assertEqual(173, combine_values(parts))

    def test_check_last(self):
        part = MachineParts(510, 3)
        self.assertFalse(is_near_symbol(1, 1, part, ['....\n',
                                                                            '.510\n',
                                                                            '....\n']))

    def test_no_gears(self):
        parts = read_parts(['467..114..'])
        gears = read_gears(parts)
        self.assertEqual(0, count_gear_ratio(gears))

    def test_one_gear(self):
        parts = read_parts(['467..114..',
                            '...*......',
                            '..35..633.'])
        gears = read_gears(parts)
        self.assertEqual(16345, count_gear_ratio(gears))

    def test_gears(self):
        parts = read_parts(['467..114..',
                            '...*......',
                            '..35..633.',
                            '......#...',
                            '617*......',
                            '.....+.58.',
                            '..592.....',
                            '......755.',
                            '...$.*....',
                            '.664.598..'])
        gears = read_gears(parts)
        self.assertEqual(467835, count_gear_ratio(gears))


if __name__ == '__main__':
    unittest.main()
