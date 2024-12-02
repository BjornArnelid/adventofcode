def check_list(levels):
    direction = 0
    if not levels:
        return False
    for i in range(1, len(levels)):
        diff = levels[i] - levels[i - 1]
        if abs(diff) > 3:
            return False
        if diff > 0:
            if direction == -1:
                return False
            direction = 1
        elif diff < 0:
            if direction == 1:
                return False
            direction = -1
        else:
            return False
    return True


def check_strings(level_strings):
    total = 0
    for ls in level_strings:
        levels = [int(x) for x in ls.split()]
        if check_list(levels):
            total += 1
    return total


if __name__ == '__main__':
    print("Starting day 2")
    with open('data/day2.data') as data:
        print("Answer part 1: " + str(check_strings(data.read().split('\n'))))
    # print("Starting part 2")
    # with open('data/day2.data') as data:
    #     print("Answer part 2: " + str(evaluate_input2(data.read())))