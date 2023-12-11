import unittest

from day11 import SpaceMap, calculate_distance


class MyTestCase(unittest.TestCase):

    def __init__(self, string):
        super().__init__(string)
        self.space_map = SpaceMap(['...#......',
                                   '.......#..',
                                   '#.........',
                                   '..........',
                                   '......#...',
                                   '.#........',
                                   '.........#',
                                   '..........',
                                   '.......#..',
                                   '#...#.....'])
        self.space_map.expand()

    def test_expand_rows(self):
        self.assertEqual(12, len(self.space_map.map))

    def test_expand_columns(self):
        for row in self.space_map.map:
            self.assertEqual(13, len(row))

    def test_calculate_distance(self):
        self.assertEqual(15, calculate_distance((0, 4), (10, 9)))

    def test_calculate_all_distances(self):
        self.assertEqual(374, self.space_map.calculate_diffs())


if __name__ == '__main__':
    unittest.main()
