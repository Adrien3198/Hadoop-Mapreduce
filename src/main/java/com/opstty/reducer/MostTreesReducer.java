package com.opstty.reducer;

import com.opstty.writablesPerso.IntStringWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MostTreesReducer extends Reducer<NullWritable, IntStringWritable, Text, IntWritable>{
        private final IntWritable resultValue = new IntWritable();
    private final Text resultKey = new Text();

        public void reduce(NullWritable key, Iterable<IntStringWritable> values, Context context)
                throws IOException, InterruptedException {
            int maxNumber = 0;
            String district = "";
            for (IntStringWritable val : values) {
                if (maxNumber < val.getVint()) {
                    maxNumber = val.getVint();
                    district = val.getVstring();
                }
            }
            resultValue.set(maxNumber);
            resultKey.set(district);
            context.write(resultKey, resultValue);
        }
    }
