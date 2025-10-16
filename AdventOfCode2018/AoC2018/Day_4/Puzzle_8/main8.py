file = open("Input_8.txt", "r")
lines = [line.strip() for line in file.readlines()]
records = []
lines.sort()
is_first = True
max_minutes_slept = [0 for i in range(0, 60)]

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
# find the guard that slept most on the same minute and that minute
for record in records:
    minutes = [0 for i in range(0, 60)]
    guard_total_work = []
    minutes_slept = 0
    for guard in records:
        if guard[1] == record[1]:
            guard_total_work.append(guard)
    for day in guard_total_work:
        for i in range(0, 60):
            if day[2][i] == '#':
                minutes[i] += 1
    if max(minutes) > max(max_minutes_slept):
        max_minutes_slept = minutes
        sleepiest_guard = day[1]
result = int(sleepiest_guard) * max_minutes_slept.index(max(max_minutes_slept))
print(result)
file.close()