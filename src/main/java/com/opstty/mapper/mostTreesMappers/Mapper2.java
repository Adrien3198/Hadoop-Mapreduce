package com.opstty.mapper.mostTreesMappers;

import com.opstty.writablesPerso.IntStringWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Mapper2 extends Mapper<Object, Text, NullWritable, IntStringWritable> {

    private final IntStringWritable pair = new IntStringWritable();
    private final NullWritable n = NullWritable.get();
    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        String[] splitted = value.toString().split("[\t ]+");
        if (splitted.length > 1 && (!splitted[1].equals("") || !splitted[0].equals(""))) {
            pair.set(Integer.parseInt(splitted[1]), splitted[0]);
            context.write(n, pair);
        }
    }
}