import datetime
import os
import csv

# folder_name = "sample-app-java-xvfb"
folder_name = "sample-app-java-x11"

csvfile = open('{}.csv'.format(folder_name), 'wb')
# csvfile = open('{}_{}.csv'.format(folder_name, "native"), 'wb')
writer = csv.writer(csvfile, delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL)
writer.writerow(['Number', 'Duration', ''])

durations = []
sum = 0
avg = 0

os.chdir("../{}/selenium-hello/".format(folder_name))
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
