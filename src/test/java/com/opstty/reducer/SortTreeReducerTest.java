package com.opstty.reducer;

import junit.framework.TestCase;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sun.util.resources.cldr.uk.CurrencyNames_uk;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SortTreeReducerTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private SortTreeReducer sortTreeReducer;
    @Before
    public void setup(){this.sortTreeReducer = new SortTreeReducer();}
    @Test
    public void testReduce() throws IOException, InterruptedException {
        NullWritable value = NullWritable.get();
        Iterable<NullWritable> values = Arrays.asList(value,value,value);

        this.sortTreeReducer.reduce(new DoubleWritable(25.0), values, this.context);
        verify(this.context).write(new DoubleWritable(25.0), NullWritable.get());
    }
}