package com.opstty.mapper;

import com.opstty.writablesPerso.IntStringWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Calendar;

public class OldestTreeMapper extends Mapper<Object, Text, NullWritable, IntStringWritable> {
    private static final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private static final NullWritable n = NullWritable.get();
    private final IntStringWritable intStringWritable = new IntStringWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineSplit = line.split(";");
        if (!lineSplit[0].equals("GEOPOINT") && !lineSplit[1].equals("") && !lineSplit[5].equals("")){
            String district = lineSplit[1];
            int age = currentYear - Integer.parseInt(lineSplit[5]);
            intStringWritable.set(age, district);
            context.write(n, intStringWritable);
        }

    }

}