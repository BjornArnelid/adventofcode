class Link:
    def __init__(self):
        self.x = None
        self.y = None
        self.symbol = None

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y and self.symbol == other.symbol


class MachineParts:
    def __init__(self, value, size):
        self.value = value
        self.size = size
        self.is_real = False
        self.link = None


class Gear:
    def __init__(self, part):
        self.parts = [part]

    def add_part(self, part):
        self.parts.append(part)

    def count_ratio(self):
        return self.parts[0].value * self.parts[1].value


def create_part(x_coord, y_coord, blueprint):
    x = x_coord
    value = ""
    next_char = blueprint[y_coord][x]
    while next_char.isnumeric() and x < len(blueprint[y_coord]):
        value += next_char
        x += 1
        if x < len(blueprint[y_coord]):
            next_char = blueprint[y_coord][x]
    return MachineParts(int(value), len(value))


def check_horizontally(x_coord, part, blueprint_line):
    x = x_coord - 1

    while x < x_coord + part.size + 1 and x < len(blueprint_line):
        point = blueprint_line[x]
        if is_symbol(point):
            part.is_real = True
            if point == '*':
                part.link = Link()
                part.link.x = x
            return point
        x += 1
    return None


def is_near_symbol(x_coord, y_coord, part, blueprint):
    # check top
    if y_coord > 0:
        point = check_horizontally(x_coord, part, blueprint[y_coord - 1])
        if point:
            if point == '*':
                part.link.y = y_coord - 1

    # check left
    if x_coord > 0:
        point = blueprint[y_coord][x_coord-1]
        if is_symbol(point):
            part.is_real = True
            if point == '*':
                part.link = Link()
                part.link.x = x_coord-1
                part.link.y = y_coord

    # check bottom
    if y_coord + 1 < len(blueprint):
        point = check_horizontally(x_coord, part, blueprint[y_coord + 1])
        if point:
            if point == '*':
                part.link.y = y_coord + 1

    # check right
    if x_coord + part.size < len(blueprint[y_coord]):
        point = blueprint[y_coord][x_coord + part.size]
        if is_symbol(point):
            part.is_real = True
            if point == '*':
                part.link = Link()
                part.link.x = x_coord + part.size
                part.link.y = y_coord


def is_symbol(point):
    return (not point.isnumeric()) and point != '.' and point != '\n'


def read_parts(blueprint):
    parts = []
    x_coord = 0
    y_coord = 0
    while y_coord < len(blueprint):
        while x_coord < len(blueprint[y_coord]):
            if blueprint[y_coord][x_coord].isnumeric():
                part = create_part(x_coord, y_coord, blueprint)
                is_near_symbol(x_coord, y_coord, part, blueprint)
                parts.append(part)
                x_coord += part.size
            else:
                x_coord += 1
        x_coord = 0
        y_coord += 1
    return parts


def read_gears(parts):
    gears = {}
    for part in parts:
        if part.link:
            key = (part.link.x, part.link.y)
            if key in gears:
                gears[key].add_part(part)
            else:
                gears[key] = Gear(part)
    return gears


def combine_values(parts):
    combined = 0
    for part in parts:
        if part.is_real:
            combined += part.value
    return combined


def count_gear_ratio(gears):
    combined = 0
    for _, gear in gears.items():
        if len(gear.parts) == 2:
            combined += gear.count_ratio()
    return combined


if __name__ == '__main__':
    print("Starting day 3")
    with open('data/day3.data') as data:
        data_list = list(data)
    parts = read_parts(data_list)
    print("Answer part 1: " + str(combine_values(parts)))
    gears = read_gears(parts)
    print("Answer part 2: " + str(count_gear_ratio(gears)))
