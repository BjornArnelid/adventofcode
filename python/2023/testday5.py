import unittest

from day5 import SeedConverter, parse_seeds


class MyTestCase(unittest.TestCase):
    converter = SeedConverter(
        ['seeds: 79 14 55 13',
         '',
         'seed-to-soil map:',
         '50 98 2',
         '52 50 48',
         '',
         'soil-to-fertilizer map:',
         '0 15 37',
         '37 52 2',
         '39 0 15',
         '',
         'fertilizer-to-water map:',
         '49 53 8',
         '0 11 42',
         '42 0 7',
         '57 7 4',
         '',
         'water-to-light map:',
         '88 18 7',
         '18 25 70',
         '',
         'light-to-temperature map:',
         '45 77 23',
         '81 45 19',
         '68 64 13',
         '',
         'temperature-to-humidity map:',
         '0 69 1',
         '1 0 69',
         '',
         'humidity-to-location map:',
         '60 56 37',
         '56 93 4'])

    def test_seed_to_soil_1(self):
        self.assertEqual(81, self.converter.convert_seed_to_soil(79))

    def test_seed_to_soil_2(self):
        self.assertEqual(14, self.converter.convert_seed_to_soil(14))

    def test_seed_to_soil_3(self):
        self.assertEqual(57, self.converter.convert_seed_to_soil(55))

    def test_seed_to_soil_4(self):
        self.assertEqual(13, self.converter.convert_seed_to_soil(13))

    def test_water_to_light(self):
        self.assertEqual(74, self.converter.convert_water_to_light(81))

    def test_seed_to_location_1(self):
        self.assertEqual(82, self.converter.convert_seed_to_location(79))

    def test_water_to_fertilizer(self):
        self.assertEqual(49, self.converter.convert_fertilizer_to_water(53))

    def test_seed_to_location_2(self):
        self.assertEqual(43, self.converter.convert_seed_to_location(14))

    def test_seed_to_location_3(self):
        self.assertEqual(86, self.converter.convert_seed_to_location(55))

    def test_seed_to_location_4(self):
        self.assertEqual(35, self.converter.convert_seed_to_location(13))


if __name__ == '__main__':
    unittest.main()
