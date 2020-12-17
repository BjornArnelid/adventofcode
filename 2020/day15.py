def number_game(starting_numbers, iterations):
    number_series = starting_numbers.copy()
    for i in range(iterations):
        last_number = number_series[-1]
        try:
            numbers_to_remember = number_series[:-1]
            index = numbers_to_remember[::-1].index(last_number)
            age = index + 1
            number_series.append(age)
        except ValueError:
            number_series.append(0)
    return number_series


if __name__ == '__main__':
    print('2020th number is: ' + str(number_game([0, 20, 7, 16, 1, 18, 15], 2020)[2019]))
    print('30000000th number is: ' + str(number_game([0, 20, 7, 16, 1, 18, 15], 30000000)[29999999]))
