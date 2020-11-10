package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortTreeMapper extends Mapper<Object, Text,DoubleWritable, NullWritable> {
    private final NullWritable n = NullWritable.get();
    private final DoubleWritable height = new DoubleWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineSplit = line.split(";");
        String h = lineSplit[6];
        if (!lineSplit[0].equals("GEOPOINT") && !h.equals("")){
            height.set(Double.parseDouble(h));
            context.write(height, n);
        }
    }
}
