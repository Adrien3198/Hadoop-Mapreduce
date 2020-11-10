package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictsListMapper extends Mapper<Object, Text, Text, NullWritable> {
    private final static NullWritable n = NullWritable.get();
    private final Text district = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] splitted = line.split(";");
        if (!splitted[0].equals("GEOPOINT")){
            district.set(splitted[1]);
            context.write(district, n);
        }
    }
}
