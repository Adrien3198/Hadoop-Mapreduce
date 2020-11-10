package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SpeciesListMapper extends Mapper<Object, Text, Text, NullWritable> {
    private final static NullWritable n = NullWritable.get();
    private final Text specie = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] lineSplit = value.toString().split(";");
        if (!lineSplit[0].equals("GEOPOINT")) {
            specie.set(lineSplit[3]);
            context.write(specie, n);
        }
    }
}
