def is_invalid(content):
    for cube_set in content.split(","):
        [amount, color] = cube_set.strip().split(" ")
        if color == "red" and int(amount) > 12:
            return True
        elif color == "green" and int(amount) > 13:
            return True
        elif color == "blue" and int(amount) > 14:
            return True
    return False


def verify(string):
    [game_id, content] = string.split(":")
    for pull in content.split(";"):
        if is_invalid(pull):
            return 0
    return int(game_id.split(" ")[1])


if __name__ == '__main__':
    print("Starting day 2")
    total = 0
    with open('data/day2.data') as data:
        for line in data:
            total += verify(line)
        print("Answer part 1: " + str(total))
