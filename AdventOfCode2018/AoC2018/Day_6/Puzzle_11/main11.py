def find_closest_point(i, j, coordinates):
    distances_to_coordinates = []
    markers = [i for i in range(0, len(coordinates))]
    for pair in coordinates:
        manhattan_distance = abs(pair[0] - i) + abs(pair[1] - j)
        distances_to_coordinates.append(manhattan_distance)
    manhattan_distance = min(distances_to_coordinates)
    counter_of_repeating_distances = 0
    for distance in distances_to_coordinates:
        if distance == manhattan_distance:
            counter_of_repeating_distances += 1
    if counter_of_repeating_distances > 1:
        return -1
    else:
        return markers[distances_to_coordinates.index(min(distances_to_coordinates))]


def get_max_finite_area(grid, coordinates):
    sizes = []
    markers = [i for i in range(0, len(coordinates))]
    counter = 0
    for marker in markers:
        for i in range(len(grid)):
            for j in range(len(grid)):
                if grid[i][j] == marker:
                    counter += 1
        sizes.append(counter)
        counter = 0
    for i in range(len(grid)):
        if grid[0][i] in markers:
            sizes[letters.index(grid[0][i])] = 0
        if grid[len(grid) - 1][i] in markers:
            sizes[letters.index(grid[len(grid) - 1][i])] = 0
        if grid[i][0] in markers:
            sizes[letters.index(grid[i][0])] = 0
        if grid[i][len(grid) - 1] in markers:
            sizes[letters.index(grid[i][len(grid) - 1])] = 0
    return max(sizes)


file = open("Input_11.txt", "r")
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
        if grid[i][j] == -1:
            closest_point = find_closest_point(i, j, coordinates)
            grid[i][j] = closest_point

sizes = get_max_finite_area(grid, coordinates)

print(sizes)
file.close()