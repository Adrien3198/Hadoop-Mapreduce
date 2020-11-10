package com.opstty.reducer;

import com.opstty.writablesPerso.IntStringWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestTreeReducer extends Reducer<NullWritable, IntStringWritable, Text, NullWritable> {

    public void reduce(NullWritable key, Iterable<IntStringWritable> values, Context context) throws IOException, InterruptedException {
        int maxAge = 0;
        String district = "";
        for (IntStringWritable value : values){
            if (maxAge < value.getVint()){
                maxAge = value.getVint();
                district = value.getVstring();
            }
        }

        context.write(new Text(district), NullWritable.get());
    }
}