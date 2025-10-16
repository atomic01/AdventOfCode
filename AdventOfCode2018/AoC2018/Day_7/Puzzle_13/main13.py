def find_first_steps(list_of_steps):
    steps = []
    first_step = []

    for line in lines:
        steps.append(line[36])
    for line in lines:
        if line[5] not in steps and line[5] not in first_step:
            first_step.append(line[5])
    first_step.sort()
    return first_step


def check_if_next_step_available(next_step, fin_steps, lines):
    for line in lines:
        if line[36] == next_step and line[5] not in fin_steps:
            return False
    return True


file = open("Input_13.txt", "r")
lines = [line.strip() for line in file.readlines()]
file.close()

available_steps = find_first_steps(lines)
finished_steps = []

while len(available_steps) > 0:
    current_step = available_steps.pop(0)
    finished_steps.append(current_step)

    for line in lines:
        if line[5] == current_step:
            if check_if_next_step_available(line[36], finished_steps, lines):
                available_steps.append(line[36])

    available_steps.sort()

for step in finished_steps:
    print(step, end="")