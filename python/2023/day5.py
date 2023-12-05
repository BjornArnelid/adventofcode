class ConverterMapping:
    def __init__(self, mapping_string):
        self.destination, self.source, self.size = [int(string) for string in mapping_string.split(' ')]

    def applies_to(self, number):
        return self.source <= number <= self.source + self.size

    def convert(self, number):
        diff = number - self.source
        return self.destination + diff


class SeedConverter:
    def __init__(self, input_strings):
        current_index = 1
        to_be_read = input_strings[current_index].strip()
        while to_be_read != 'seed-to-soil map:':
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.seed_to_soil_mappings = []
        while to_be_read != 'soil-to-fertilizer map:':
            if to_be_read != '':
                self.seed_to_soil_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.soil_to_fertilizer_mappings = []
        while to_be_read != 'fertilizer-to-water map:':
            if to_be_read != '':
                self.soil_to_fertilizer_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.fertilizer_to_water_mappings = []
        while to_be_read != 'water-to-light map:':
            if to_be_read != '':
                self.fertilizer_to_water_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.water_to_light_mappings = []
        while to_be_read != 'light-to-temperature map:':
            if to_be_read != '':
                self.water_to_light_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.light_to_temperature_mappings = []
        while to_be_read != 'temperature-to-humidity map:':
            if to_be_read != '':
                self.light_to_temperature_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.temperature_to_humidity_mappings = []
        while to_be_read != 'humidity-to-location map:':
            if to_be_read != '':
                self.temperature_to_humidity_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            to_be_read = input_strings[current_index].strip()
        current_index += 1
        to_be_read = input_strings[current_index].strip()

        self.humidity_to_location_mappings = []
        while current_index < len(input_strings):
            if to_be_read != '':
                self.humidity_to_location_mappings.append(ConverterMapping(to_be_read))
            current_index += 1
            if current_index < len(input_strings):
                to_be_read = input_strings[current_index].strip()

    def convert_seed_to_soil(self, seed):
        for mapping in self.seed_to_soil_mappings:
            if mapping.applies_to(seed):
                return mapping.convert(seed)
        return seed

    def convert_soil_to_fertilizer(self, soil):
        for mapping in self.soil_to_fertilizer_mappings:
            if mapping.applies_to(soil):
                return mapping.convert(soil)
        return soil

    def convert_fertilizer_to_water(self, fertilizer):
        for mapping in self.fertilizer_to_water_mappings:
            if mapping.applies_to(fertilizer):
                return mapping.convert(fertilizer)
        return fertilizer

    def convert_water_to_light(self, water):
        for mapping in self.water_to_light_mappings:
            if mapping.applies_to(water):
                return mapping.convert(water)
        return water

    def convert_light_to_temperature(self, light):
        for mapping in self.light_to_temperature_mappings:
            if mapping.applies_to(light):
                return mapping.convert(light)
        return light

    def convert_temperature_to_humidity(self, temperature):
        for mapping in self.temperature_to_humidity_mappings:
            if mapping.applies_to(temperature):
                return mapping.convert(temperature)
        return temperature

    def convert_humidity_to_location(self, humidity):
        for mapping in self.humidity_to_location_mappings:
            if mapping.applies_to(humidity):
                return mapping.convert(humidity)
        return humidity

    def convert_seed_to_location(self, seed):
        soil = self.convert_seed_to_soil(seed)
        fertilizer = self.convert_soil_to_fertilizer(soil)
        water = self.convert_fertilizer_to_water(fertilizer)
        light = self.convert_water_to_light(water)
        temperature = self.convert_light_to_temperature(light)
        humidity = self.convert_temperature_to_humidity(temperature)
        return self.convert_humidity_to_location(humidity)


def parse_seeds(seed_string):
    seeds = []
    values = seed_string[7:]
    range_start = None
    for value in values.split(' '):
        if not range_start:
            range_start = int(value)
        else:
            seeds += range(range_start, range_start + int(value))
            range_start = None
    return seeds


if __name__ == '__main__':
    print("Starting day 5")
    with open('data/day5.data') as data:
        data_list = list(data)
    locations = []
    converter = SeedConverter(data_list)
    for seed_string in data_list[0].replace('seeds: ', '').split(' '):
        locations.append(converter.convert_seed_to_location(int(seed_string)))

    locations.sort()
    print("Answer part 1: " + str(locations[0]))

