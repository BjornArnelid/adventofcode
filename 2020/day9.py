def evaluate_two_matches(verify_list, expected_result):
    for first_candidate in verify_list:
        for second_candidate in verify_list[1:]:
            if first_candidate + second_candidate == expected_result and first_candidate != second_candidate:
                return True
    return False


def find_first_deviant(numbers_list, cypher_length):
    verify_position = cypher_length
    while verify_position < len(numbers_list):
        if not evaluate_two_matches(numbers_list[verify_position - cypher_length:verify_position],
                                    numbers_list[verify_position]):
            return numbers_list[verify_position]
        else:
            verify_position += 1


def find_list_of_matches(search_list, expected_result):
    accumulated_result = 0
    numbers_used = []
    for num in search_list:
        numbers_used.append(num)
        accumulated_result += num
        if accumulated_result == expected_result:
            return numbers_used
        elif accumulated_result > expected_result:
            return None


def find_matching_sequence(number_list, expected_result):
    start_position = 0
    while start_position < len(number_list):
        matches = find_list_of_matches(number_list[start_position:], expected_result)
        if matches is not None:
            return matches
        start_position += 1


if __name__ == '__main__':
    numbers = []
    with open('data/day9.data') as data:
        for line in data:
            numbers.append(int(line))
        no_match = find_first_deviant(numbers, 25)
        print('First number not matching: ' + str(no_match))
        matching_list = find_matching_sequence(numbers, no_match)
        matching_list = sorted(matching_list)
        print('Matching result is {}'.format(matching_list[0] + matching_list[-1])) # Not # 115800385
