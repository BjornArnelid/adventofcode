def find_differences(input_history):
    list_of_diffs = []
    for i in range(len(input_history)-1):
        list_of_diffs.append(input_history[i + 1] - input_history[i])
    return list_of_diffs


def predict_next_value(input_history):
    diffs = []
    diff_history = find_differences(input_history)
    while any(diff_history):
        diffs.append(diff_history)
        diff_history = find_differences(diff_history)
    calculated_diff = sum([v[-1] for v in diffs])
    return input_history[-1] + calculated_diff


def predict_previous_value(input_history):
    diffs = []
    diff_history = find_differences(input_history)
    while any(diff_history):
        diffs.append(diff_history)
        diff_history = find_differences(diff_history)
    calculated_diff = 0
    for diff in diffs[::-1]:
        calculated_diff = diff[0] - calculated_diff

    return input_history[0] - calculated_diff


if __name__ == '__main__':
    print("Starting day 9")
    with open('data/day9.data') as data:
        data_list = list(data)
    total = 0
    for line in data_list:
        total += predict_next_value([int(v) for v in line.split(' ')])
    print("Answer part 1: " + str(total))

    total = 0
    for line in data_list:
        total += predict_previous_value([int(v) for v in line.split(' ')])
    print("Answer part 2: " + str(total))
