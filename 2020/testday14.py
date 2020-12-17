import unittest

from day14 import Decoder, to_bit_string, parse_line, expand_address


class Day14Test(unittest.TestCase):
    def test_parse_mask(self):
        is_mask, mask_value = parse_line('mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X')
        self.assertEqual(True, is_mask)
        self.assertEqual('XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X', mask_value)

    def test_parse_mem(self):
        is_mask, value = parse_line('mem[8] = 11')
        self.assertEqual(False, is_mask)
        self.assertEqual((8, 11), value)

    def test_number_to_bit_string(self):
        self.assertEqual('000000000000000000000000000000001011', to_bit_string(11))

    def test_apply_mask(self):
        decoder = Decoder()
        decoder.set_mask('XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X')
        self.assertEqual('000000000000000000000000000001001001',
                         decoder.apply_mask('000000000000000000000000000000001011'))

    def test_put_value_in_memory(self):
        decoder = Decoder()
        decoder.set_mask('XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X')
        decoder.set_value(8, 11)
        self.assertEqual('000000000000000000000000000001001001', decoder.memory[8])

    def test_apply_mask_2(self):
        decoder = Decoder()
        decoder.set_mask('000000000000000000000000000000X1001X')
        self.assertEqual('000000000000000000000000000000X1101X',
                         decoder.apply_floating_mask('000000000000000000000000000000101010'))

    def test_expand_address(self):
        self.assertCountEqual(['000000000000000000000000000000011010', '000000000000000000000000000000011011',
                               '000000000000000000000000000000111010', '000000000000000000000000000000111011'],
                              expand_address('000000000000000000000000000000X1101X'))

    def test_put_to_translated_memory(self):
        decoder = Decoder()
        decoder.set_mask('000000000000000000000000000000X1001X')
        decoder.set_value_translated_memory(42, 100)
        decoder.set_mask('00000000000000000000000000000000X0XX')
        decoder.set_value_translated_memory(26, 1)
        mem_sum = 0
        for value in decoder.memory.values():
            mem_sum += value
        self.assertEqual(208, mem_sum)


if __name__ == '__main__':
    unittest.main()
