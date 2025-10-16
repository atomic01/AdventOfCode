def check_total_distance(i, j, coordinates):
    distances_to_coordinates = []
    markers = [i for i in range(0, len(coordinates))]
    manhattan_distance = 0
    for pair in coordinates:
        manhattan_distance += abs(pair[0] - i) + abs(pair[1] - j)
    if manhattan_distance >= 10000:
        return -1
    else:
        return 1


def get_max_finite_area(grid, coordinates):
    sizes = []
    markers = [i for i in range(0, len(coordinates))]
    counter = 0
    for marker in markers:
        for i in range(len(grid)):
            for j in range(len(grid)):
                if grid[i][j] == 1:
                    counter += 1
        sizes.append(counter)
        counter = 0
    return max(sizes)


file = open("Input_12.txt", "r")
lines = [line.strip() for line in file.readlines()]
grid = [[-1 for i in range(400)] for j in range(400)]
number = 0
letters = [i for i in range(0, len(lines))]
coordinates = []

for line in lines:
    y = int(line[0:line.find(",")].strip())
    x = int(line[line.find(" "):].strip())
    grid[x][y] = letters[number]
    number += 1
    coordinates.append([x, y])

for i in range(0, len(grid)):
    for j in range(0, len(grid)):
        result = check_total_distance(i, j, coordinates)
        grid[i][j] = result

sizes = get_max_finite_area(grid, coordinates)
print(sizes)
file.close()