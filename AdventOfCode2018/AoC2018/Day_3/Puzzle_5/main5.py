file = open("Input_5.txt", "r")

lines = [lines.strip() for lines in file.readlines()]
fabric = [['.'] * 1000 for _ in range(1000)]

for line in lines:
    rectangle_id = int(line[1:line.index('@')])
    rectangle_x = int(line[line.index('@') + 2: line.index(',')])
    rectangle_y = int(line[line.index(',') + 1: line.index(':')])
    rectangle_width = int(line[line.index(':') + 2: line.index('x')])
    rectangle_height = int(line[line.index('x') + 1:])

    for x in range(rectangle_x, rectangle_x + rectangle_width):
        for y in range(rectangle_y, rectangle_y + rectangle_height):
            if fabric[y][x] == '.':
                fabric[y][x] = str(rectangle_id)
            else:
                fabric[y][x] = 'X'


print(sum([i.count('X') for i in fabric]))
file.close()
