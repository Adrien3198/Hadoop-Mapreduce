package com.opstty.mapper.mostTreesMappers;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Mapper1 extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final Text district = new Text();

    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        String[] lineSplit = value.toString().split(";");
        if (!lineSplit[0].equals("GEOPOINT") && !lineSplit[1].equals("")) {
            district.set(lineSplit[1]);
            context.write(district, one);
        }
    }
}
