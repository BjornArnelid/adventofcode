class SpaceMap:
    def __init__(self, rows):
        self.map = rows

    def expand(self):
        new_map = []
        filled_columns = set()
        original_column_size = len(self.map[0])
        # Add rows
        for row in self.map:
            all_empty = True
            for position in range(original_column_size):
                if row[position] == '#':
                    all_empty = False
                    filled_columns.add(position)
            new_map.append(row)
            if all_empty:
                new_map.append(row)
        self.map = expand_column(new_map, [i for i in range(original_column_size) if i not in filled_columns])

    def calculate_diffs(self):
        stars = []
        # find stars
        for row_index in range(len(self.map)):
            for column_index in range(len(self.map[row_index])):
                if self.map[row_index][column_index] == '#':
                    stars.append((row_index, column_index))

        # count distance
        distance = 0
        for from_index in range(len(stars) - 1):
            for to_index in range(from_index + 1, len(stars)):
                distance += calculate_distance(stars[from_index], stars[to_index])
        return distance


def expand_column(map, expand_columns):
    new_map = []
    for row in map:
        shift = 0
        new_row = row
        for expand in expand_columns:
            new_row = '.'.join([new_row[:expand+shift], new_row[expand+shift:]])
            shift += 1
        new_map.append(new_row)
    return new_map


def calculate_distance(first, second):
    x_diff = second[0] - first[0]
    y_diff = second[1] - first[1]
    return abs(x_diff) + abs(y_diff)


if __name__ == '__main__':
    print("Starting day 11")
    with open('data/day11.data') as data:
        data_list = list(data)
    space_map = SpaceMap(data_list)
    space_map.expand()
    print("Answer part 1: " + str(space_map.calculate_diffs()))

