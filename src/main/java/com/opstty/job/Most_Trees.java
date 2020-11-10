package com.opstty.job;

import com.opstty.writablesPerso.IntStringWritable;
import com.opstty.mapper.mostTreesMappers.*;
import com.opstty.reducer.MostTreesReducer;
import com.opstty.reducer.TreesCounterReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Most_Trees {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: most_trees <in> [<in>...] <out>");
            System.exit(2);
        }

        Path out = new Path(otherArgs[otherArgs.length - 1]);

        Job job1 = Job.getInstance(conf, "count_trees");
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job1, new Path(otherArgs[i]));
        }

        job1.setJarByClass(Most_Trees.class);
        job1.setMapperClass(Mapper1.class);
        job1.setCombinerClass(TreesCounterReducer.class);
        job1.setReducerClass(TreesCounterReducer.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);
        FileOutputFormat.setOutputPath(job1, new Path(out, "out1"));
        if (!job1.waitForCompletion(true)) {
            System.exit(1);
        }

        Configuration conf2 = new Configuration();
        Job job2 = Job.getInstance(conf2, "get_most_trees");
        job2.setJarByClass(Most_Trees.class);
        job2.setMapperClass(Mapper2.class);
        job2.setReducerClass(MostTreesReducer.class);
        job2.setOutputKeyClass(NullWritable.class);
        job2.setOutputValueClass(IntStringWritable.class);
        FileInputFormat.addInputPath(job2, new Path(out, "out1"));

        FileOutputFormat.setOutputPath(job2,new Path(out, "final-output"));
        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}
