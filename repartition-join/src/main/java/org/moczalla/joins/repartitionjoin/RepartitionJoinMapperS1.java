package org.moczalla.joins.repartitionjoin;


import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

import java.io.IOException;

public class RepartitionJoinMapperS1 extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String line = value.toString();
        String[] keyValue = line.split(" ", 2);
        output.collect(new Text(keyValue[0]), new Text("S1 " + keyValue[1]));
    }
}