import datetime
import os
import csv

csvfile = open('avg_duration_time_native.csv', 'wb')
writer = csv.writer(csvfile, delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL)
writer.writerow(['Number', 'Duration', ''])

durations = []
sum = 0
avg = 0

os.chdir("../sample-app-java-x11/selenium-hello/")
for i in range(0, 30):
    start = datetime.datetime.now()
    os.system("mvn clean test")

    end = datetime.datetime.now()
    duration = end - start

    seconds = duration.total_seconds()
    sum = sum + seconds
    durations.append(seconds)

    writer.writerow([i, duration])

avg = sum / len(durations)
print durations
print avg

writer.writerow(['AVERAGE', avg])

os.chdir("../../")
