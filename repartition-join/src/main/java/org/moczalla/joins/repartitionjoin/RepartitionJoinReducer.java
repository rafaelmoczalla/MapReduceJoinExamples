package org.moczalla.joins.repartitionjoin;


import java.io.IOException;
import java.util.*;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class RepartitionJoinReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        ArrayList<String> s1 = new ArrayList();
        ArrayList<String> s2 = new ArrayList();
        String[] kv;


        Integer nr1 = 0;
        Integer nr2 = 0;
		while (values.hasNext()) {
			Text node = values.next();
            kv = node.toString().split(" ", 2);

            if (kv[0].compareTo("S1") == 0) {
                s1.add(kv[1]);
                nr1++;
            } else {
                s2.add(kv[1]);
                nr2++;
            }
		}

        Iterator<String> i1 = s1.iterator();
        Iterator<String> i2 = s2.iterator();

        String r1;
        String r2;

        if (!i1.hasNext())
            return;

        if (!i2.hasNext())
            return;

        while (i1.hasNext()) {
            i2 = s2.iterator();
            r1 = i1.next();

            while (i2.hasNext()) {
                r2 = i2.next();
                output.collect(key, new Text(r1 + "\t" + r2));
            }
        }
   }
}