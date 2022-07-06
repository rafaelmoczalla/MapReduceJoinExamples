package org.moczalla.joins.repartitionjoin;


import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.util.*;

public class HadoopDriver {
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(HadoopDriver.class);
        conf.setJobName("map reduce repartition join");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setReducerClass(RepartitionJoinReducer.class);

        conf.setMapOutputKeyClass(Text.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        MultipleInputs.addInputPath(conf, new Path(args[0]), TextInputFormat.class, RepartitionJoinMapperS1.class);
        MultipleInputs.addInputPath(conf, new Path(args[1]), TextInputFormat.class, RepartitionJoinMapperS2.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));

        JobClient.runJob(conf);

        System.exit(0);
    }
}