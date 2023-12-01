def parse_string(string):
    return int(find_first(string) + find_last(string))


def find_number(string):
    if string[0].isnumeric():
        return string[0]
    elif string.startswith('one'):
        return '1'
    elif string.startswith('two'):
        return '2'
    elif string.startswith('three'):
        return '3'
    elif string.startswith('four'):
        return '4'
    elif string.startswith('five'):
        return '5'
    elif string.startswith('six'):
        return '6'
    elif string.startswith('seven'):
        return '7'
    elif string.startswith('eight'):
        return '8'
    elif string.startswith('nine'):
        return '9'


def find_first(string):
    for index in range(len(string)):
        first = find_number(string[index:])
        if first:
            return first


def find_last(string):
    for index in reversed(range(len(string))):
        last = find_number(string[index:])
        if last:
            return last


if __name__ == '__main__':
    print("Starting day 1")
    total = 0
    with open('data/day1.data') as data:
        result = 0
        for line in data:
            total += parse_string(line)
    print("Answer part 2: " + str(total))
