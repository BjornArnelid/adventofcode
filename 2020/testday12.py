import unittest

from day12 import Ship, Direction

test_steps = '''F10
N3
F7
R90
F11'''


class Day12Test(unittest.TestCase):
    def test_move_forward(self):
        ship = Ship()
        ship.move('F10')
        self.assertEqual(10, ship.east)

    def test_move_north(self):
        ship = Ship()
        ship.move('N3')
        self.assertEqual(3, ship.north)

    def test_turn_90(self):
        ship = Ship()
        ship.move('R90')
        self.assertEqual(Direction.SOUTH, ship.direction)

    def test_turn_and_move(self):
        ship = Ship()
        ship.move('R90')
        ship.move('F11')
        self.assertEqual(-11, ship.north)

    def test_move_teststeps(self):
        ship = Ship()
        for step in test_steps.split('\n'):
            ship.move(step)
        self.assertEqual(17, ship.east)
        self.assertEqual(-8, ship.north)

    def test_move_to_beacon(self):
        ship = Ship()
        ship.move_with_beacon('F10')
        self.assertEqual(100, ship.east)
        self.assertEqual(10, ship.north)

    def test_move_beacon(self):
        ship = Ship()
        ship.move_with_beacon('N3')
        self.assertEqual(4, ship.beacon_north)

    def test_turn_ship(self):
        ship = Ship()
        ship.move_with_beacon('R90')
        self.assertEqual(-10, ship.beacon_north)
        self.assertEqual(1, ship.beacon_east)

    def test_beacon_with_teststeps(self):
        ship = Ship()
        for step in test_steps.split('\n'):
            ship.move_with_beacon(step)
        self.assertEqual(214, ship.east)
        self.assertEqual(-72, ship.north)


if __name__ == '__main__':
    unittest.main()
