file = open("input.txt", "r")

numbers = [int(line.strip()) for line in file]
is_done = False
frequency = 0
all_frequencies = set()

while not is_done:
    for number in numbers:
        frequency += number
        if frequency in all_frequencies:
            is_done = True
            print(frequency)
            break
        else:
            all_frequencies.add(frequency)

file.close()