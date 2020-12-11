from math import ceil


def get_ticket_row(ticket):
    max_row = 127
    min_row = 0
    for row_descriptor in ticket[:7]:
        if row_descriptor == 'F':
            max_row -= ceil((max_row - min_row) / 2)
        elif row_descriptor == 'B':
            min_row += ceil((max_row - min_row) / 2)
        else:
            raise ValueError
    return min_row


def get_ticket_column(ticket):
    max_col = 7
    min_col = 0
    for col_descriptor in ticket[7:]:
        if col_descriptor == 'L':
            number = ceil((max_col - min_col) / 2)
            max_col -= ceil((max_col - min_col) / 2)
        elif col_descriptor == 'R':
            min_col += ceil((max_col - min_col) / 2)
        else:
            raise ValueError
    return max_col


def get_ticket_id(ticket):
    return get_ticket_row(ticket) * 8 + get_ticket_column(ticket)


if __name__ == '__main__':
    with open('data/day5.data') as data:
        all_ids = []
        for line in data:
            all_ids.append(get_ticket_id(line.strip()))
        all_ids = sorted(all_ids)
    print("Highest seat: " + str(all_ids[-1]))
    last_seat = all_ids[0] -1
    for seat_id in all_ids:
        if seat_id - 1 != last_seat:
            print('Seat found: ' + str(seat_id - 1))
        last_seat = seat_id
