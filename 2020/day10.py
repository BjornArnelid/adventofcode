def count_steps(numbers):
    sorted_numbers = sorted(numbers)
    one_steps = 0
    three_steps = 0
    last = 0

    for number in sorted_numbers:
        if number - last == 1:
            one_steps += 1
        elif number - last == 3:
            three_steps += 1
        last = number
    return one_steps, three_steps + 1


def count_variations(numbers):
    sorted_numbers = sorted(numbers)
    return recursive_count_variations(0, 0, sorted_numbers)


def recursive_count_variations(current_value, counter, numbers):
    possible_branches = 0
    if counter < len(numbers) and numbers[counter] - current_value <= 3:
        possible_branches += recursive_count_variations(numbers[counter], counter+1, numbers)

        if counter + 1 < len(numbers) and numbers[counter+1] - current_value <= 3:
            possible_branches += recursive_count_variations(numbers[counter+1], counter+2, numbers)
            if counter + 2 < len(numbers) and numbers[counter+2] - current_value == 3:
                possible_branches += recursive_count_variations( numbers[counter+2], counter+3, numbers)
        return possible_branches
    else:
        return 1


if __name__ == '__main__':
    numbers = []
    with open('day10.data') as data:
        for line in data:
            numbers.append(int(line))
    one_steps, three_steps = count_steps(numbers)
    print('multiplied steps: ' + str(one_steps * three_steps))
    print('possible variations: ' + str(count_variations(numbers)))
