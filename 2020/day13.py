import multiprocessing


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


def find_ordered_departures(first_number, depart_input):
    depart_times = parse_departures(depart_input)
    largest_departure = max(depart_times)
    largest_index = depart_times.index(largest_departure)
    diff = first_number % largest_departure
    departure = first_number - (diff + largest_index)
    in_order = False
    while not in_order:
        departure += largest_departure
        in_order = verify_order(depart_times, departure)
    if departure > first_number*2:
        return 0
    return departure


def verify_order(depart_times, departure):
    for i in range(len(depart_times)):
        if depart_times[i] != 0 and (departure + i) % depart_times[i] != 0:
            return False
    return True


if __name__ == '__main__':
    with open('data/day13.data') as data:
        lines = data.readlines()
    departing_time = lines[0]
    buss_lines = lines[1].strip().split(',')
    best_time, best_line = get_next_departure(departing_time, buss_lines)
    wait_time = best_time-int(departing_time)
    print('Buss {} leaves in {} which results in {}'.format(best_line, wait_time, best_line*wait_time))

    tasks = []
    pool = multiprocessing.Pool()
    for i in range(1, 11):
        tasks.append((100000000000000*i, buss_lines))
    results = [pool.apply_async(find_ordered_departures, t) for t in tasks]

    for answer in results:
        if answer.get() != 0:
            print('earliest matching timestamp: ' + str(answer))
        else:
            print('No result found')
