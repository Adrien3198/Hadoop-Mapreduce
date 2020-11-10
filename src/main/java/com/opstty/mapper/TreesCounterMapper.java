package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TreesCounterMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final Text specie = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] lineSplit = value.toString().split(";");
        if (!lineSplit[0].equals("GEOPOINT")) {
            specie.set(lineSplit[3]);
            context.write(specie, one);
        }
    }
}
