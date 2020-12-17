import re


class Decoder(object):
    def __init__(self):
        self.mask = None
        self.memory = {}

    def set_mask(self, mask):
        self.mask = mask

    def apply_mask(self, to_bit_string):
        masked_value = ''
        for i in range(36):
            if self.mask[i] != 'X':
                masked_value += self.mask[i]
            else:
                masked_value += to_bit_string[i]
        return masked_value

    def apply_floating_mask(self, to_bit_address):
        masked_address = ''
        for i in range(36):
            if self.mask[i] == '0':
                masked_address += to_bit_address[i]
            else:
                masked_address += self.mask[i]
        return masked_address

    def set_value(self, memory_slot, value):
        bits = to_bit_string(value)
        masked_bits = self.apply_mask(bits)
        self.memory[memory_slot] = masked_bits

    def set_value_translated_memory(self, memory_slot, value):
        slot_string = to_bit_string(memory_slot)
        slot_string = self.apply_floating_mask(slot_string)
        address_strings = expand_address(slot_string)
        for the_string in address_strings:
            self.memory[to_integer(the_string)] = value


def to_bit_string(number):
    return '{:b}'.format(number).zfill(36)


def to_integer(value):
    return int(value, 2)


def expand_address(input_bits):
    expanded = ['']
    for i in range(36):
        to_add = []
        for address in expanded:
            if input_bits[i] != 'X':
                address += input_bits[i]
            else:
                new_address = address + '1'
                address += '0'

                to_add.append(new_address)
            to_add.append(address)
            expanded = to_add
    return expanded


def parse_line(line):
    command_type, value = line.split(' = ')
    if command_type == 'mask':
        return True, value
    else:
        print(command_type[3:1])
        return False, (int(re.search(r'\d+', command_type).group()), int(value))


if __name__ == '__main__':
    with open('data/day14.data') as data:
        lines = data.readlines()
    decoder = Decoder()
    for line in lines:
        if line == '\n':
            continue
        is_mask, value = parse_line(line)
        if is_mask:
            decoder.set_mask(value)
        else:
            decoder.set_value(value[0], value[1])

    mem_sum = 0
    for value in decoder.memory.values():
        mem_sum += to_integer(value)
    print('Memory sum: {}'.format(mem_sum))

    decoder = Decoder()
    for line in lines:
        if line == '\n':
            continue
        is_mask, value = parse_line(line)
        if is_mask:
            decoder.set_mask(value)
        else:
            decoder.set_value_translated_memory(value[0], value[1])
    mem_sum = 0
    for value in decoder.memory.values():
        mem_sum += value
    print('New memory sum: {}'.format(mem_sum))
