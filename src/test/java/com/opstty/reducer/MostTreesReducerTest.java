package com.opstty.reducer;

import com.opstty.writablesPerso.IntStringWritable;
import junit.framework.TestCase;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MostTreesReducerTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private MostTreesReducer mostTreesReducer;
    @Before
    public void setup(){this.mostTreesReducer = new MostTreesReducer();}
    @Test
    public void testReduce() throws IOException, InterruptedException {
        Iterable<IntStringWritable> values = Arrays.asList(
                new IntStringWritable(12, "2"),
                new IntStringWritable(16, "3"),
                new IntStringWritable(10, "4")
        );
        this.mostTreesReducer.reduce(NullWritable.get(), values, this.context);
        verify(this.context).write(new Text("3"), new IntWritable(16));
    }
}