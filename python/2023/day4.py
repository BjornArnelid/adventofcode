def create_number_list(number_string):
    return list(filter(lambda k: k.isnumeric(), number_string.strip().split(' ')))


def count_correct_answers(correct_numbers, given_numbers):
    correct = []
    for number in given_numbers:
        if number in correct_numbers:
            correct.append(number)
    print(str(correct_numbers) + ' | ' + str(given_numbers))
    print("matches " + str(correct))
    return len(correct)


def count_score(correct_numbers):
    score = 0
    for i in range(correct_numbers):
        if score == 0:
            score = 1
        else:
            score = score * 2
    return score


def analyse_cards(list_of_cards):
    total = 0
    for card in list_of_cards:
        _, content = card.split(':')
        correct_numbers, given_numbers = content.split('|')
        correct_answers = count_correct_answers(create_number_list(correct_numbers), create_number_list(given_numbers))
        points = count_score(correct_answers)
        total += points
        print("correct " + str(correct_answers) + ", points " + str(points) + ", new total " + str(total))
    return total


if __name__ == '__main__':
    print("Starting day 4")
    with open('data/day4.data') as data:
        data_list = list(data)
    print("Answer part 1: " + str(analyse_cards(data_list)))
