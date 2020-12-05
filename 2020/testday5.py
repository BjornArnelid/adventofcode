import unittest

from day5 import get_ticket_row, get_ticket_column, get_ticket_id

base_ticket = 'FBFBBFFRLR'
class Day5Test(unittest.TestCase):
    def test_row_from_ticket(self):
        self.assertEqual(44, get_ticket_row(base_ticket))

    def test_column_from_ticket(self):
        self.assertEqual(5, get_ticket_column(base_ticket))

    def test_get_ticket_id(self):
        self.assertEqual(357, get_ticket_id(base_ticket))
        self.assertEqual(567, get_ticket_id('BFFFBBFRRR'))
        self.assertEqual(119, get_ticket_id('FFFBBBFRRR'))
        self.assertEqual(820, get_ticket_id('BBFFBBFRLL'))


if __name__ == '__main__':
    unittest.main()
