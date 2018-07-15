#!/bin/bash

PATH="/Users/neeharika/NCSU/NCSU/2ndSem/Algoss/Project2/Generated_ip_v1"
#FILE=$1
#ANOTHER_FILE=$2 

#exec 4> "$ANOTHER_FILE"
for f in $PATH/*
do
    echo "$f"
	/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home/bin/java -jar QuickSelect.jar <"$f"  #>&4
done
