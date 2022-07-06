#!/bin/bash

hdfs dfs -mkdir -p /tmp;
hdfs dfs -copyFromLocal -f /opt/hadoop/s1 /tmp/s1
hdfs dfs -copyFromLocal -f /opt/hadoop/s2 /tmp/s2

$HADOOP_HOME/bin/hadoop jar $JAR_FILEPATH $PARAMS

echo ">>>> Output <<<<"
hdfs dfs -cat /tmp/output/*
echo ">>>> Output End <<<<"
hdfs dfs -rm -r /tmp