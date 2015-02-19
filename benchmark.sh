#!/bin/bash

JAVA_OPTIONS="-server -XX:+AggressiveOpts -XX:+UseFastAccessorMethods -Xmx512m"

if [[ ! -e "./target/benchmarks.jar" ]]; then
    mvn clean package
fi

if [[ "quick" == "$1" ]]; then
    java -jar ./target/benchmarks.jar -jvmArgs "$JAVA_OPTIONS" -wi 3 -i 8 -t 8 -f 2 $2 $3 $4 $5 $6 $7 $8 $9
elif [[ "medium" == "$1" ]]; then
    java -jar ./target/benchmarks.jar -jvmArgs "$JAVA_OPTIONS" -wi 3 -t 8 -f 3 $2 $3 $4 $5 $6 $7 $8 $9
else
    java -jar ./target/benchmarks.jar -jvmArgs "$JAVA_OPTIONS" -wi 3 -i 15 -t 8 $1 $2 $3 $4 $5 $6 $7 $8 $9
fi
