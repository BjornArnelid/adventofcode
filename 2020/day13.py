def get_next_departure(depart_string, departures):
    valid_departures = parse_departures(departures)
    depart_time = int(depart_string)
    best_option = None
    best_line = None
    for departure in valid_departures:
        if departure == 0:
            continue
        next_departure = departure
        while next_departure < depart_time:
            next_departure += departure
        if best_option is None or next_departure < best_option:
            best_option = next_departure
            best_line = departure
    return best_option, best_line


def parse_departures(departures):
    parsed_departures = []
    for departure in departures:
        try:
            parsed_departures.append(int(departure))
        except ValueError:
            # Do not parse x
            parsed_departures.append(0)
    return parsed_departures


def chinese_remainder_find_order(time_table):
    depart_map = departures_to_map(parse_departures(time_table))
    combined_modulus = get_combined_modulus(depart_map)
    accumulated_depart_time = 0
    for position, modulus in depart_map.items():
        accumulated_depart_time += calculate_depart_time(position, modulus, combined_modulus)
    return accumulated_depart_time % combined_modulus


def calculate_depart_time(position, modulus, combined_modulus):
    working_modulus = combined_modulus / modulus
    remainder = -position % modulus
    inverse_mod = 1
    while (working_modulus * inverse_mod) % modulus != remainder:
        inverse_mod += 1
    return working_modulus * inverse_mod


def get_combined_modulus(depart_map):
    combined_modulus = 1
    for departure_time in depart_map.values():
        combined_modulus *= departure_time
    return combined_modulus


def find_ordered_departures(depart_input):
    return chinese_remainder_find_order(depart_input)


def departures_to_map(departures):
    departure_map = {}
    for i in range(len(departures)):
        if departures[i] != 0:
            departure_map[i] = departures[i]
    return departure_map


if __name__ == '__main__':
    with open('data/day13.data') as data:
        lines = data.readlines()
    departing_time = lines[0]
    buss_lines = lines[1].strip().split(',')
    best_time, best_line = get_next_departure(departing_time, buss_lines)
    wait_time = best_time-int(departing_time)
    print('Buss {} leaves in {} which results in {}'.format(best_line, wait_time, best_line*wait_time))

    results = chinese_remainder_find_order(buss_lines)
    print('Earliest matching timestamp: ' + str(results))
