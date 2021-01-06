def number_game(starting_numbers, iterations):
    number_map = {}
    for position, number in enumerate(starting_numbers[:-1]):
        number_map[number] = position
    last_number = starting_numbers[-1]
    for i in range(iterations):
        last_position = (i + len(starting_numbers) - 1)
        remembered_position = number_map.get(last_number)
        number_map[last_number] = last_position
        if remembered_position is not None:
            last_number = last_position - remembered_position
        else:
            last_number = 0
    return last_number


if __name__ == '__main__':
    input_numbers = [0, 20, 7, 16, 1, 18, 15]
    print('2020th number is: ' + str(number_game(input_numbers, 2020 - len(input_numbers))))
    print('30000000th number is: ' + str(number_game([0, 20, 7, 16, 1, 18, 15], 30000000- len(input_numbers))))
