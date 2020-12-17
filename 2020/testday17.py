import unittest

from day17 import CubeGrid

starting_map = '.#.\n..#\n###'


class Day17Test(unittest.TestCase):
    def test_1_cycle(self):
        grid = CubeGrid(starting_map, False)
        self.assertEqual(11, grid.run_simulation(1))

    def test_2_cycles(self):
        grid = CubeGrid(starting_map, False)
        self.assertEqual(21, grid.run_simulation(2))

    def test_1_cycle_w(self):
        grid = CubeGrid(starting_map, True)
        self.assertEqual(29, grid.run_simulation(1))


if __name__ == '__main__':
    unittest.main()
