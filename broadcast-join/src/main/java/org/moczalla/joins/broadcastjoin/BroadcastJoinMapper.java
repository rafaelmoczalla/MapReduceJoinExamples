package org.moczalla.joins.broadcastjoin;


import org.moczalla.utils.*;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

import java.io.IOException;
import java.util.*;

public class BroadcastJoinMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    Map<String, Tuple4> s1 = new PrintableHashMap<String, Tuple4>() {{
        put("K09", new Tuple4("50", "05", "14", "45"));
        put("K51", new Tuple4("72", "12", "59", "40"));
        put("K66", new Tuple4("13", "22", "73", "21"));
        put("K95", new Tuple4("82", "40", "12", "94"));
        put("K33", new Tuple4("76", "56", "03", "92"));
        put("K56", new Tuple4("95", "58", "92", "58"));
        put("K41", new Tuple4("52", "50", "13", "37"));
        put("K24", new Tuple4("35", "36", "44", "36"));
        put("K82", new Tuple4("23", "13", "78", "40"));
        put("K14", new Tuple4("75", "90", "15", "71"));
        put("K83", new Tuple4("57", "37", "15", "63"));
        put("K75", new Tuple4("80", "22", "45", "57"));
        put("K57", new Tuple4("16", "09", "79", "66"));
        put("K78", new Tuple4("96", "17", "36", "28"));
        put("K50", new Tuple4("48", "30", "13", "70"));
    }};

    private String printArray(String[] elements) {
        return elements[1] + " " + elements[2] + " " + elements[3] + " " + elements[4];
    }

    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String line = value.toString();
        String[] s2 = line.split(" ");
        if (s1.containsKey(s2[0]))
            output.collect(new Text(s2[0]), new Text(printArray(s2) + "\t" + s1.get(s2[0]).toString()));
    }
}