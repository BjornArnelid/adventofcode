def count_neighbours(seat_map, seat, end_of_row, only_once):
    neighbours = 0

    # top left
    if is_seat_taken(seat_map, seat, end_of_row, -(end_of_row+1), only_once):
        neighbours += 1
    # top
    if is_seat_taken(seat_map, seat, end_of_row, -end_of_row, only_once):
        neighbours += 1
    # top right
    if is_seat_taken(seat_map, seat, end_of_row, -(end_of_row-1), only_once):
        neighbours += 1
    # left
    if is_seat_taken(seat_map, seat, end_of_row, -1, only_once):
        neighbours += 1
    # right
    if is_seat_taken(seat_map, seat, end_of_row, +1, only_once):
        neighbours += 1
    # bottom left
    if is_seat_taken(seat_map, seat, end_of_row, end_of_row - 1, only_once):
        neighbours += 1
    # bottom
    if is_seat_taken(seat_map, seat, end_of_row, end_of_row, only_once):
        neighbours += 1
    # bottom right
    if is_seat_taken(seat_map, seat, end_of_row, end_of_row + 1, only_once):
        neighbours += 1
    return neighbours


def is_seat_taken(seat_map, start_pos, end_row, step, only_once):
    current_pos = start_pos + step
    while 0 <= current_pos < len(seat_map) and seat_map[current_pos] != '\n':
        if seat_map[current_pos] == '#':
            return True
        if seat_map[current_pos] == 'L' or only_once:
            return False
        current_pos += step
    return False


def occupy_seats(seat_map, only_once):
    new_map = ''
    map_changed = False
    end_of_row = seat_map.find('\n') + 1
    for seat in range(len(seat_map)):
        if seat_map[seat] == 'L' and count_neighbours(seat_map, seat, end_of_row, only_once) == 0:
            map_changed = True
            new_map += '#'
        else:
            new_map += seat_map[seat]
    return new_map, map_changed


def empty_seats(seat_map, only_once):
    new_map = ''
    map_changed = False
    end_of_row = seat_map.find('\n') + 1
    if only_once:
        threshold = 4
    else:
        threshold = 5
    for seat in range(len(seat_map)):
        if seat_map[seat] == '#' and count_neighbours(seat_map, seat, end_of_row, only_once) >= threshold:
            map_changed = True
            new_map += 'L'
        else:
            new_map += seat_map[seat]
    return new_map, map_changed


def simulate_seat_change(seat_map, only_once):
    map_changed = True
    while map_changed:
        seat_map, occupy_changed = occupy_seats(seat_map, only_once)
        seat_map, empty_changed = empty_seats(seat_map, only_once)
        map_changed = occupy_changed and empty_changed
    return seat_map


if __name__ == '__main__':
    with open('data/day11.data') as data:
        seat_map = str(data.read())
        print('Occupied seats: ' + str(simulate_seat_change(seat_map, True).count('#')))
        print('Occupied with gaps: ' + str(simulate_seat_change(seat_map, False).count('#')))
