package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxHeightReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    private final DoubleWritable result = new DoubleWritable();

    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        double curr;
        double max = 0;
        for (DoubleWritable val : values) {
            curr = val.get();
            if (curr > max) max = curr;
        }
        result.set(max);
        context.write(key, result);
    }
}
