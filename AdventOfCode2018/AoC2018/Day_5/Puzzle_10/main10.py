file = open("Input_10.txt", "r")

original_polymer = [letter for letter in file.read()]
all_units = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
all_lengths = set()

for letter in all_units:
    polymer = [c for c in original_polymer if c != letter.lower() and c != letter.upper()]
    unit = 0
    length_od_polymer = len(polymer)
    while unit < length_od_polymer:
        next_unit = unit + 1
        if polymer[unit].isupper() != polymer[next_unit].isupper() and polymer[unit].casefold() == polymer[next_unit].casefold():
            polymer = polymer[:unit] + polymer[(unit + 2):]
            unit -= 2
            length_od_polymer = len(polymer) - 1
        unit += 1
    all_lengths.add(length_od_polymer + 1)
print(min(all_lengths))
file.close()