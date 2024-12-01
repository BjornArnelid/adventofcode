def compare_numbers(a, b):
    return abs(a - b)


def compare_lists(left, right):
    sorted_a = sorted(left)
    sorted_b = sorted(right)
    return [compare_numbers(sorted_a[i], sorted_b[i]) for i in range(len(sorted_a))]


def evaluate_lists(left, right):
    return sum(compare_lists(left, right))


def evaluate_input(data):
    left = list()
    right = list()
    for line in data.strip().split('\n'):
        a, b = [int(x) for x in line.split()]
        left.append(a)
        right.append(b)
    return evaluate_lists(left, right)


def to_map(numbers):
    result = dict()
    for number in numbers:
        result[number] = result.get(number, 0) + 1
    return result


def count_numbers(number, numbers):
    return numbers.get(number, 0)


def evaluate_number(number, numbers):
    return number * numbers.get(number, 0)


def evaluate_list(left, right):
    return sum([evaluate_number(number, right) for number in left])


def evaluate_input2(data):
    left = list()
    right = list()
    for line in data.strip().split('\n'):
        a, b = [int(x) for x in line.split()]
        left.append(a)
        right.append(b)
    return evaluate_list(left, to_map(right))


if __name__ == '__main__':
    print("Starting day 1")
    with open('data/day1.data') as data:
        print("Answer part 1: " + str(evaluate_input(data.read())))
    print("Starting part 2")
    with open('data/day1.data') as data:
        print("Answer part 2: " + str(evaluate_input2(data.read())))
