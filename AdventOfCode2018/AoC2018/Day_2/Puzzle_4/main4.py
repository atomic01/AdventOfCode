file = open("Input_4.txt", "r")


def compare_box_to_all_boxes(box_string, boxes):
    difference = 0
    for box in boxes:
        u = zip(box_string, box)
        for i, j in u:
            if i != j:
                difference += 1
        if difference == 1:
            u = zip(box_string, box)
            for i, j in u:
                if i == j:
                    print(i, end="")
            return True
        else:
            difference = 0


box_IDs = [line.strip() for line in file.readlines()]
is_done = False

for box_id in box_IDs:
    is_done = compare_box_to_all_boxes(box_id, box_IDs)
    if is_done:
        break

file.close()
