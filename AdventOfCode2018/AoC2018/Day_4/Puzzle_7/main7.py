file = open("Input_7.txt", "r")
lines = [line.strip() for line in file.readlines()]
records = []
lines.sort()
is_first = True
max_minutes_slept = 0

# load all the data into the list records[]
for line in lines:
    if '#' in line:
        if not is_first:
            records.append([date, guard, minutes])
        is_first = False
        guard = line[line.index('#') + 1:line.index('#') + 5]
        minutes = list('.' * 60)
    elif 'falls' in line:
        date = line[6:11]
        time_when_fell_asleep = int(line[15:17])
        for i in range(0, 60):
            if i >= time_when_fell_asleep:
                minutes[i] = '#'
    elif 'wakes' in line:
        time_when_woke_up = int(line[15:17])
        for i in range(0, 60):
            if i >= time_when_woke_up:
                minutes[i] = '.'

# find the guard who sleeps the most
for record in records:
    guard_total_work = []
    minutes_slept = 0
    for guard in records:
        if guard[1] == record[1]:
            guard_total_work.append(guard)
    for day in guard_total_work:
        minutes_slept += day[2].count('#')
    if minutes_slept > max_minutes_slept:
        max_minutes_slept = minutes_slept
        sleepiest_guard = guard_total_work

# find the minute when the guard sleeps the most
minutes = [0 for i in range(0, 60)]
for day in sleepiest_guard:
    for i in range(0, 60):
        if day[2][i] == '#':
            minutes[i] += 1
result = int(sleepiest_guard[0][1]) * minutes.index(max(minutes))
print(result)
file.close()