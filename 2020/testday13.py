import unittest

from day13 import get_next_departure, parse_departures, find_ordered_departures

depart_times = ['7', '13', 'x', 'x', '59', 'x', '31', '19']


class Day13Test(unittest.TestCase):
    def test_parse_departures(self):
        self.assertEqual([7, 13, 0, 0, 59, 0, 31, 19], parse_departures(depart_times))

    def test_get_next_departure(self):
        depart_time, line = get_next_departure('939', depart_times)
        self.assertEqual((5, 59), (depart_time - 939, line))

    def test_find_2_first_in_order(self):
        self.assertEqual(77, find_ordered_departures(['7', '13']))

    def test_find_departures_order(self):
        self.assertEqual(1068781, find_ordered_departures(depart_times))


if __name__ == '__main__':
    unittest.main()
