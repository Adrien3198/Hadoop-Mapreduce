package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightMapper extends Mapper<Object, Text, Text, DoubleWritable> {
    private final Text specie = new Text();
    private final DoubleWritable height = new DoubleWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineSplit = line.split(";");
        String h = lineSplit[6];
        if (!lineSplit[0].equals("GEOPOINT") && !h.equals("")){
            specie.set(lineSplit[3]);
            height.set(Double.parseDouble(h));
            context.write(specie, height);
        }
    }
}
