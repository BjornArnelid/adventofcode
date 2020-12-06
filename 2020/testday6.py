import unittest

from day6 import count_group_any_answers, count_any_answers, count_group_every_answers, count_every_answers

group_answers = 'abcx\nabcy\nabcz'
answers = '''abc

a
b
c

ab
ac

a
a
a
a

b'''


class Day6Test(unittest.TestCase):
    def test_count_group_answers(self):
        self.assertEqual(6, count_group_any_answers(group_answers))

    def test_count_answers(self):
        self.assertEqual(11, count_any_answers(answers))

    def test_group_every_answer(self):
        self.assertEqual(3, count_group_every_answers(group_answers))

    def test_count_every_answer(self):
        self.assertEqual(6, count_every_answers(answers))


if __name__ == '__main__':
    unittest.main()
