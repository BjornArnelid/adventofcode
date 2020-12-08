import unittest

from day8 import Program

instructions = '''nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6'''


class Day8Test(unittest.TestCase):
    def test_do_nop(self):
        program = Program('nop +0')
        self.assertEqual(0, program.execute_instructions()[1])

    def test_do_acc(self):
        program = Program('acc +1')
        self.assertEqual(1, program.execute_instructions()[1])

    def test_do_jmp(self):
        program = Program('jmp +4\nacc +3\njmp -3\nacc -99\nacc +1')
        self.assertEqual(1, program.execute_instructions()[1])

    def test_stop_at_recursion(self):
        program = Program(instructions)
        self.assertEqual(5, program.execute_instructions()[1])

    def test_exits_correctly(self):
        program = Program(instructions)
        self.assertEqual(False, program.execute_instructions()[0])

    def test_find_correct_answer(self):
        program = Program(instructions)
        self.assertEqual(8, program.correct_and_execute_instructions())


if __name__ == '__main__':
    unittest.main()
