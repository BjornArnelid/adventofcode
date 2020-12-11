import unittest

from day11 import occupy_seats, empty_seats, simulate_seat_change

base = '''L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL'''

phase1 = '''#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##'''

phase2 = '''#.LL.L#.##
#LLLLLL.L#
L.L.L..L..
#LLL.LL.L#
#.LL.LL.LL
#.LLLL#.##
..L.L.....
#LLLLLLLL#
#.LLLLLL.L
#.#LLLL.##'''

eight_occupied_with_gap = '''.......#.
...#.....
.#.......
.........
..#L....#
....#....
.........
#........
...#.....'''

result_with_gap = '''#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##L#.#L.L#
L.L#.LL.L#
#.LLLL#.LL
..#.L.....
LLL###LLL#
#.LLLLL#.L
#.L#LL#.L#'''


class Day11Test(unittest.TestCase):
    def test_occupy_seats(self):
        new_map, _ = occupy_seats(base, True)
        self.assertEqual(phase1, new_map)

    def test_empty_seats(self):
        new_map, _ = empty_seats(phase1, True)
        self.assertEqual(phase2, new_map)

    def test_total_changes_seats(self):
        final_map = simulate_seat_change(base, True)
        self.assertEqual(37, final_map.count('#'))

    def test_gap_rules_occupied(self):
        final_map = simulate_seat_change(base, False)
        self.assertEqual(result_with_gap, final_map)
        self.assertEqual(26, final_map.count('#'))


if __name__ == '__main__':
    unittest.main()
