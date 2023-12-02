class CubeBag:
    def __init__(self):
        self.red = 0
        self.blue = 0
        self.green = 0

    def parse_hand(self, hand):
        for cube_set in hand.split(","):
            [amount_string, color] = cube_set.strip().split(" ")
            amount = int(amount_string)
            if color == "red":
                self.red = max(self.red, amount)
            elif color == "green":
                self.green = max(self.green, amount)
            elif color == "blue":
                self.blue = max(self.blue, amount)


def count_bag(content):
    bag = CubeBag()
    for pull in content.split(";"):
        bag.parse_hand(pull)
    return bag


def is_invalid(bag):
    return bag.red > 12 or bag.green > 13 or bag.blue > 14


def verify(string):
    [game_id, content] = string.split(":")
    bag = count_bag(content)
    if is_invalid(bag):
        return 0
    return int(game_id.split(" ")[1])


def count(string):
    [_, content] = string.split(":")
    bag = count_bag(content)
    return bag.green * bag.red * bag.blue


if __name__ == '__main__':
    print("Starting day 2")
    with open('data/day2.data') as data:
        data_list = list(data)
    total = 0
    for line in data_list:
        total += verify(line)
    print("Answer part 1: " + str(total))

    total = 0
    for line in data_list:
        total += count(line)
    print("Answer part 2: " + str(total))
