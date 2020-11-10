package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;

public class TreesCounterReducer extends Reducer<Text, IntWritable, Text, IntWritable > {
    private final IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        result.set(sum);
        context.write(key, result);
    }

}
