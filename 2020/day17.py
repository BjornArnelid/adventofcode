class CubeGrid:
    def __init__(self, initial_map, use_w):
        self.active_cubes = {}
        self.add_cubes = {}
        self.remove_cubes = {}
        self.use_w = use_w
        self.x_range = [0, 0]
        self.y_range = [0, 0]
        self.z_range = [0, 0]
        self.w_range = [0, 0]
        self.extract_active_cubes(initial_map)

    def extract_active_cubes(self, starting_map):
        cube_list = []
        line_number = 0
        for line in starting_map.split('\n'):
            column = 0
            for char in line:
                if char == '#':
                    self.active_cubes[(column, line_number, 0, 0)] = ActiveCube()
                    self.get_edge_dimensions(column, line_number, 0, 0)
                column += 1
            line_number += 1
        return cube_list

    def run_simulation(self, cycles):
        for lap in range(cycles):
            print('running simulation no. {}'.format(lap))
            for w in range(self.w_range[0] - 1, self.w_range[1] + 2):
                for z in range(self.z_range[0] - 1, self.z_range[1] + 2):
                    for y in range(self.y_range[0] - 1, self.y_range[1] + 2):
                        for x in range(self.x_range[0] - 1, self.x_range[1] + 2):
                            neighbours = self.find_neighbours(x, y, z, w)
                            if neighbours < 2 or neighbours > 3:
                                self.remove_cube(x, y, z, w)
                            elif neighbours == 3:
                                self.add_cube(x, y, z, w)
            self.do_cycle()
        return len(self.active_cubes)

    def get_edge_dimensions(self, x, y, z, w):
        if x < self.x_range[0]:
            self.x_range[0] = x
        elif x > self.x_range[1]:
            self.x_range[1] = x
        if y < self.y_range[0]:
            self.y_range[0] = y
        elif y > self.y_range[1]:
            self.y_range[1] = y
        if z < self.z_range[0]:
            self.z_range[0] = z
        elif z > self.z_range[1]:
            self.z_range[1] = z
        if self.use_w:
            if w < self.w_range[0]:
                self.w_range[0] = w
            elif w > self.w_range[1]:
                self.w_range[1] = w

    def remove_cube(self, x, y, z, w):
        cube = self.active_cubes.get((x, y, z, w))
        if cube is not None:
            self.remove_cubes[(x, y, z, w)] = cube

    def add_cube(self, x, y, z, w):
        if not self.use_w and w != 0:
            return
        if self.active_cubes.get((x, y, z, w)) is not None:
            return
        self.add_cubes[(x, y, z, w)] = ActiveCube()
        self.get_edge_dimensions(x, y, z, w)

    def find_neighbours(self, x, y, z, w):
        neighbours = 0

        for wi in range(w-1, w+2):
            for zi in range(z - 1, z + 2):
                for yi in range(y - 1, y + 2):
                    for xi in range(x - 1, x + 2):
                        if wi == w and zi == z and yi == y and xi == x:
                            continue
                        if self.active_cubes.get((xi, yi, zi, wi)) is not None:
                            neighbours += 1
        return neighbours

    def do_cycle(self):
        for key, cube in self.remove_cubes.items():
            del self.active_cubes[key]
        for key, cube in self.add_cubes.items():
            self.active_cubes[key] = cube
        self.add_cubes = {}
        self.remove_cubes = {}


class ActiveCube:
    def __init__(self):
        pass


if __name__ == '__main__':
    with open('data/day17.data') as data:
        starting_point = data.read()
    grid = CubeGrid(starting_point, True)
    number_of_cubes = grid.run_simulation(6)
    print('Number of cubes: {}'.format(number_of_cubes))
