from enum import Enum


class Ship(object):
    def __init__(self):
        self.east = 0
        self.north = 0
        self.beacon_east = 10
        self.beacon_north = 1
        self.direction = Direction.EAST

    def move(self, direction):
        heading = direction[0]
        amount = int(direction[1:])

        if heading == 'F':
            self.move_forward(self.direction, amount)

        elif heading == 'E':
            self.move_forward(Direction.EAST, amount)
        elif heading == 'W':
            self.move_forward(Direction.WEST, amount)
        elif heading == 'N':
            self.move_forward(Direction.NORTH, amount)
        elif heading == 'S':
            self.move_forward(Direction.SOUTH, amount)

        elif heading == 'R':
            self.change_direction(amount / 90)
        elif heading == 'L':
            self.change_direction((amount / 90) * 3)

    def change_direction(self, change):
        new_direction = (self.direction.value + change) % 4
        self.direction = Direction(new_direction)

    def move_forward(self, direction, amount):
        if direction == Direction.EAST:
            self.east += amount
        elif direction == Direction.WEST:
            self.east -= amount
        elif direction == Direction.NORTH:
            self.north += amount
        elif direction == Direction.SOUTH:
            self.north -= amount

    def move_with_beacon(self, direction):
        heading = direction[0]
        amount = int(direction[1:])

        if heading == 'F':
            self.move_to_beacon(amount)

        elif heading == 'E':
            self.beacon_east += amount
        elif heading == 'W':
            self.beacon_east -= amount
        elif heading == 'N':
            self.beacon_north += amount
        elif heading == 'S':
            self.beacon_north -= amount

        elif heading == 'R':
            self.turn_ship(amount / 90)
        elif heading == 'L':
            self.turn_ship((amount / 90) * 3)

    def move_to_beacon(self, moves):
        self.move_forward(Direction.EAST, self.beacon_east * moves)
        self.move_forward(Direction.NORTH, self.beacon_north * moves)

    def turn_ship(self, steps):
        for step in range(int(steps)):
            old_north = self.beacon_north
            self.beacon_north = - self.beacon_east
            self.beacon_east = old_north


class Direction(Enum):
    EAST = 0
    SOUTH = 1
    WEST = 2
    NORTH = 3


if __name__ == '__main__':
    ship = Ship()
    with open('data/day12.data') as data:
        all_steps = data.readlines()
    for line in all_steps:
        ship.move(line.strip())
    print('Ship east: {} Ship north: {} Distance: {}'.format(ship.east, ship.north, abs(ship.east) + abs(ship.north)))
    ship.east = 0
    ship.north = 0
    for line in all_steps:
        ship.move_with_beacon(line.strip())
    print('Ship east: {} Ship north: {} Distance: {}'.format(ship.east, ship.north, abs(ship.east) + abs(ship.north)))
