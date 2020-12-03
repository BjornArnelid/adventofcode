import unittest

from day3 import Topography

topography_list = [
    '..##.......\n',
    '#...#...#..\n',
    '.#....#..#.\n',
    '..#.#...#.#\n',
    '.#...##..#.\n',
    '..#.##.....\n',
    '.#.#.#....#\n',
    '.#........#\n',
    '#.##...#...\n',
    '#...##....#\n',
    '.#..#...#.#\n']


class Day3Test(unittest.TestCase):
    def test_find_collision(self):
        topography = Topography(topography_list)
        self.assertEqual(True, topography.find_collision(3, 0))

    def test_new_x_pos(self):
        topography = Topography(topography_list)
        topography.step(3, 0)
        self.assertEqual(3, topography.x_pos)
        topography.step(9, 0)
        self.assertEqual(1, topography.x_pos)
        self.assertEqual(0, topography.y_pos)

    def test_count_trees(self):
        topography = Topography(topography_list)
        self.assertEqual(7, topography.count_trees(3, 1))


if __name__ == '__main__':
    unittest.main()
