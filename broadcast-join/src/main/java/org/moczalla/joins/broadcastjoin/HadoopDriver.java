package org.moczalla.joins.broadcastjoin;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class HadoopDriver {
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(HadoopDriver.class);
        conf.setJobName("map reduce broadcast join");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(BroadcastJoinMapper.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        conf.setNumReduceTasks(0);

        FileInputFormat.addInputPath(conf, new Path(args[1]));
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));

        JobClient.runJob(conf);
    }
}