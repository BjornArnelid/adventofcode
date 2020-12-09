class Program(object):
    def __init__(self, operations):
        self.operations = operations.split('\n')
        self.accumulator = 0

    def execute_instructions(self):
        completed_operations = []
        i = 0
        while i < len(self.operations):
            if i in completed_operations:
                return False, self.accumulator
            else:
                completed_operations.append(i)
            if ' ' not in self.operations[i]:
                print(self.operations[i])
            instruction, value = self.operations[i].split(' ')
            if instruction == 'acc':
                self.accumulator += int(value)
            elif instruction == 'jmp':
                i += int(value)
                continue
            i += 1
        return True, self.accumulator

    def correct_and_execute_instructions(self):
        backup_instruction = 0
        for i in range(len(self.operations)):
            instruction, value = self.operations[i].split(' ')
            if instruction =='jmp':
                backup_instruction = self.operations[i]
                self.operations[i] = 'nop ' + value
                success, result = self.execute_instructions()
                if success:
                    return result
                else:
                    self.operations[i] = backup_instruction
                    self.accumulator = 0
            if instruction == 'nop':
                backup_instruction = self.operations[i]
                self.operations[i] = 'jmp ' + value
                success, result = self.execute_instructions()
                if success:
                    return result
                else:
                    self.operations[i] = backup_instruction
                    self.accumulator = 0
        raise Exception('No solution found!')


if __name__ == '__main__':
    with open('day8.data') as data:
        program = Program(data.read().strip())
        print('Number at recursion ' + str(program.execute_instructions()[1]))
        program.accumulator = 0
        print('Corrected answer ' + str(program.correct_and_execute_instructions()))
