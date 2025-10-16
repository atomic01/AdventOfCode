file = open("Input_9.txt", "r")
polymer = [letter for letter in file.read()]
unit = 0
length_od_polymer = len(polymer)
while unit < length_od_polymer:
    next_unit = unit + 1
    if polymer[unit].isupper() != polymer[next_unit].isupper() and polymer[unit].casefold() == polymer[next_unit].casefold():
        polymer = polymer[:unit] + polymer[(unit + 2):]
        unit -= 2
    unit += 1
    length_od_polymer = len(polymer) - 1
print(length_od_polymer + 1)
file.close()