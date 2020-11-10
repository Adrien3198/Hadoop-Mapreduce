package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortTreeReducer extends Reducer<DoubleWritable, Iterable<NullWritable>, DoubleWritable, NullWritable> {
    private final NullWritable n = NullWritable.get();

    public void reduce(DoubleWritable key, Iterable<NullWritable> values, Context context)
            throws IOException, InterruptedException {
        //for (DoubleWritable value : values) context.write(value, NullWritable.get());
        context.write(key, n);
    }
}
