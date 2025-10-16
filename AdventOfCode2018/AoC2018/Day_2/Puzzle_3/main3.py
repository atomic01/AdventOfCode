file = open("Input_3.txt", "r")


def check_two_letters(box_string):
    letter_counter = 0
    for letter in box_string:
        letter_counter = box_string.count(letter)
        if letter_counter == 2:
            return 1

    if letter_counter != 2:
        return 0


def check_three_letters(box_string):
    letter_counter = 0
    for letter in box_string:
        letter_counter = box_string.count(letter)
        if letter_counter == 3:
            return 1

    if letter_counter != 3:
        return 0


box_IDs = [line.strip() for line in file.readlines()]
two_letter_counter = 0
three_letter_counter = 0

for box_id in box_IDs:
    two_letter_counter += check_two_letters(box_id)
    three_letter_counter += check_three_letters(box_id)

print(two_letter_counter * three_letter_counter)

file.close()