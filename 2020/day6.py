def count_group_any_answers(answers):
    question_set = set()
    for person in answers.split('\n'):
        for question in person:
            question_set.add(question)
    return len(question_set)


def count_group_every_answers(answers):
    question_set = set([x for x in answers.split('\n')[0]])
    for person in answers.split('\n'):
        if person == '':
            continue
        to_remove = []
        for question in question_set:
            if question not in person:
                to_remove.append(question)
        for q in to_remove:
            question_set.remove(q)
    #print(str(question_set) + ' = ' + str(len(question_set)))
    return len(question_set)


def count_any_answers(answers):
    return sum([count_group_any_answers(group) for group in answers.split('\n\n')])


def count_every_answers(answers):
    return sum([count_group_every_answers(group) for group in answers.split('\n\n')])


if __name__ == '__main__':
    with open('day6.data') as data:
        read_answers = data.read()
        print(count_any_answers(read_answers))
        print(count_every_answers(read_answers))
