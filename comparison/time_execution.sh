#!/bin/bash
cd selenium-hello

x=30
output_file="output_file.csv"
echo "" > $output_file
echo "EXECUTION_NUMBER, START, END" > $output_file

while [ $x -gt 0 ]; do
    start=$(date +%s%N | cut -b1-13)
    mvn clean test
    end=$(date +%s%N | cut -b1-13)
    echo "$x, $start, $end" >> $output_file
    x=$(($x-1))
done

cat $output_file
cd ../