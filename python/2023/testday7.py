import unittest

from day7 import Hand


class MyTestCase(unittest.TestCase):
    def test_find_highest_7(self):
        self.assertEqual(7, Hand(['A', 'K', 'T', '9', '7']).get_value())

    def test_find_highest_k(self):
        self.assertEqual(10, Hand(['T', 'A', 'K']).get_value())

    def test_find_pair(self):
        self.assertEqual(103, Hand(['3', 'T', 'A', 'K', 'T']).get_value())

#    def test_find_two_pairs(self):
#        self.assertEquals(205, Hand(['A', 'T', 'A', '5', 'T']).get_value())


if __name__ == '__main__':
    unittest.main()
