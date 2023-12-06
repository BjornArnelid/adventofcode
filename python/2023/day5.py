class ConverterMapping:
    def __init__(self, mapping_string):
        self.destination, self.source, self.size = [int(string) for string in mapping_string.split(' ')]

    def convert(self, number):
        mapped = ()
        unmapped = []
        diff = abs(number[0] - self.source)
        if number[0] < self.source:
            if diff >= number[1]:
                return (), [number]
            else:
                unmapped.append((number[0], diff))
                if number[1] > self.size + diff:
                    unmapped.append((number[0] + diff + self.size, number[1] - diff - self.size))
                    return (self.destination, self.size), unmapped
                else:
                    return (self.destination,number[1] - diff), unmapped
        else:
            if diff > self.size:
                return (), [number]
            else:
                if number[1] + diff <= self.size:
                    return (self.destination + diff, number[1]), []
                else:
                    return ((self.destination + diff, self.size - diff),
                            [(number[0] + self.size - diff, number[1] - self.size - diff)])


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

    def apply_mapping(self, ranges, mappings):
        to_be_mapped = ranges
        mapped_ranges = []
        for mapping in mappings:
            mapped_next_cycle = []
            for range in to_be_mapped:
                mapped, unmapped = mapping.convert(range)
                if mapped:
                    mapped_ranges.append(mapped)
                if unmapped:
                    mapped_next_cycle += unmapped
            to_be_mapped = mapped_next_cycle
        mapped_ranges += to_be_mapped
        return mapped_ranges

    def convert_seed_to_soil(self, seeds):
        return self.apply_mapping(seeds, self.seed_to_soil_mappings)

    def convert_soil_to_fertilizer(self, soils):
        return self.apply_mapping(soils, self.soil_to_fertilizer_mappings)

    def convert_fertilizer_to_water(self, fertilizers):
        return self.apply_mapping(fertilizers, self.fertilizer_to_water_mappings)

    def convert_water_to_light(self, waters):
        return self.apply_mapping(waters, self.water_to_light_mappings)

    def convert_light_to_temperature(self, lights):
        return self.apply_mapping(lights, self.light_to_temperature_mappings)

    def convert_temperature_to_humidity(self, temperatures):
        return self.apply_mapping(temperatures, self.temperature_to_humidity_mappings)

    def convert_humidity_to_location(self, humidities):
        return self.apply_mapping(humidities, self.humidity_to_location_mappings)

    def convert_seed_to_location(self, seed):
        soil = self.convert_seed_to_soil(seed)
        fertilizer = self.convert_soil_to_fertilizer(soil)
        water = self.convert_fertilizer_to_water(fertilizer)
        light = self.convert_water_to_light(water)
        temperature = self.convert_light_to_temperature(light)
        humidity = self.convert_temperature_to_humidity(temperature)
        return self.convert_humidity_to_location(humidity)


def find_min(location_ranges):
    min_value = location_ranges[0][0]
    for location_range in location_ranges:
        min_value = min(min_value, location_range[0])
    return min_value


def parse_seeds(seed_string):
    seed_list = []
    values = seed_string[7:].split(' ')
    start_value = None
    for val in values:
        if not start_value:
            start_value = int(val)
        else:
            seed_list.append((start_value, int(val)))
    return seed_list


if __name__ == '__main__':
    print("Starting day 5")
    with open('data/day5.data') as data:
        data_list = list(data)
    locations = []
    converter = SeedConverter(data_list)
    for seed_string in data_list[0].replace('seeds: ', '').split(' '):
        locations.append(converter.convert_seed_to_location([(int(seed_string), 1)]))

    locations.sort()
    print("Answer part 1: " + str(locations[0]))

    seed_list = parse_seeds(data_list[0])
    locations = converter.convert_seed_to_location(seed_list)

    locations.sort()
    print("Answer part 2: " + str(find_min(locations)))
