file = open("input.txt", "r")

numbers = [int(line.strip()) for line in file]
print(sum(numbers))

file.close()