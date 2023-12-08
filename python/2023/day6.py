def move_boat(charge_duration, total_time):
    if charge_duration > total_time:
        return 0
    return charge_duration * (total_time - charge_duration)


def find_error_margin(duration, record):
    charge_duration = round(duration / 3)
    lowest_charge = find_charge_limit(1, record, duration, +1)

    charge_duration = lowest_charge * 2
    highest_charge = find_charge_limit(duration, record, duration, -1)
    return highest_charge - lowest_charge + 1


def find_charge_limit(charge_duration, record, total_time, step):
    previous_distance = move_boat(charge_duration, total_time)
    previous_duration = charge_duration
    charge_duration += 1
    charge_limit = None
    while not charge_limit:
        distance = move_boat(charge_duration, total_time)
        if previous_distance <= record < distance:
            charge_limit = charge_duration
        elif previous_distance >= record > distance:
            charge_limit = previous_duration
        previous_duration = charge_duration
        charge_duration += step
    return charge_limit


def find_all_error_margins(races):
    margin = None
    for race in races:
        score = find_error_margin(race[0], race[1])
        if margin:
            margin *= score
        else:
            margin = score
    return margin


if __name__ == '__main__':
    print("Starting day 5")
    race_input = [(56, 546), (97, 1927), (78, 1131), (75, 1139)]
    print("Answer part 1: " + str(find_all_error_margins(race_input)))
    race_input = [(56977875, 546192711311139)]
    print("Answer part 1: " + str(find_all_error_margins(race_input)))
