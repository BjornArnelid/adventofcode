class Topography(object):
    def __init__(self, topology):
        self.topology = topology
        self.topology_width = len(topology[0]) -1
        self.x_pos = 0
        self.y_pos = 0

    def find_collision(self, x_pos, y_pos):
        return self.topology[y_pos][x_pos] == '#'

    def step(self, x, y):
        self.y_pos += y
        self.x_pos = (self.x_pos + x) % self.topology_width

    def count_trees(self, x_step, y_step):
        hit_trees = 0
        while self.y_pos < len(self.topology):
            if self.find_collision(self.x_pos, self.y_pos):
                hit_trees += 1
            self.step(x_step, y_step)
        return hit_trees

    def reset(self):
        self.x_pos = 0
        self.y_pos = 0


if __name__ == '__main__':
    with open('data/day3.data') as data:
        topography = Topography(list(data))
        first = topography.count_trees(1, 1)
        topography.reset()
        second = topography.count_trees(3, 1)
        topography.reset()
        third = topography.count_trees(5, 1)
        topography.reset()
        fourth = topography.count_trees(7, 1)
        topography.reset()
        fifth = topography.count_trees(1, 2)
        print('First answer: ' + str(second))
        print('second answer: ' + str(first * second * third * fourth * fifth))
