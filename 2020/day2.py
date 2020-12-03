def password_is_legal(min_occurrence, max_occurrence, letter, password):
    return min_occurrence <= password.count(letter) <= max_occurrence


def password_position_legal(first_occurrence, second_occurrence, letter, password):
    return letter_is_at_position(first_occurrence, letter, password) != \
           letter_is_at_position(second_occurrence, letter, password)


def letter_is_at_position(position, letter, word):
    try:
        return word[position-1] == letter
    except IndexError:
        return False


if __name__ == '__main__':
    with open('day2.data') as data:
        counter = 0
        for line in data:
            rule, password = line.split(': ')
            occurrence, letter = rule.split(' ')
            minimum, maximum = occurrence.split('-')
            if password_position_legal(int(minimum), int(maximum), letter, password):
                counter += 1
        print(counter)
