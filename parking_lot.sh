#! /bin/bash
#
# Usages:
# parking_lot.sh -> Build application, Run tests, and start application
#
#

set -e

BUILD_COMMAND="mvn clean install"
START_COMMAND="java -jar parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar"

if [ $# -eq 1 ]
  then
     START_COMMAND="java -jar parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar "$1
     echo $START_COMMAND
fi

$BUILD_COMMAND && cd target && $START_COMMAND