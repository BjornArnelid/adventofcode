def find_and_multiply_two(input_array):
    for position, first in enumerate(input_array):
        for second in input_array[position+1:]:
            if first + second == 2020:
                return first * second
    raise Exception('No match found')


def find_and_multiply_three(input_array):
    sorted_array = sorted(input_array)
    for first_position, first in enumerate(sorted_array):
        if first > 2020:
            break
        for second_position, second in enumerate(sorted_array[first_position+1:], start=first_position+1):
            if first + second > 2020:
                break
            for third in sorted_array[second_position+1:]:
                if first + second + third > 2020:
                    break
                if first + second + third == 2020:
                    return first * second * third
    raise Exception('No match found')


def get_from_file():
    numbers = []
    with open('day1.data') as data:
        for line in data:
            numbers.append(int(line))
    return numbers


if __name__ == '__main__':
    input_numbers = get_from_file()
    print(find_and_multiply_three(input_numbers))
