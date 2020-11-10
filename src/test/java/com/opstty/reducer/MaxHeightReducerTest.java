package com.opstty.reducer;

import junit.framework.TestCase;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MaxHeightReducerTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private MaxHeightReducer maxHeightReducer;

    @Before
    public void setup(){ this.maxHeightReducer = new MaxHeightReducer(); }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "key";
        Iterable<DoubleWritable> values = Arrays.asList(
                new DoubleWritable(30.0),
                new DoubleWritable(31.0),
                new DoubleWritable(29.0));
        this.maxHeightReducer.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key), new DoubleWritable(31.0));
    }
}