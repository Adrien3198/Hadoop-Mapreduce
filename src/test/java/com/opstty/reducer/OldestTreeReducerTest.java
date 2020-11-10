package com.opstty.reducer;

import com.opstty.writablesPerso.IntStringWritable;
import junit.framework.TestCase;
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
public class OldestTreeReducerTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private OldestTreeReducer oldestTreeReducer;
    @Before
    public void setup(){this.oldestTreeReducer = new OldestTreeReducer();}
    @Test
    public void testReduce() throws IOException, InterruptedException {
        Iterable<IntStringWritable> values = Arrays.asList(
                new IntStringWritable(30, "1"),
                new IntStringWritable(70, "2"),
                new IntStringWritable(40, "3")
        );
        this.oldestTreeReducer.reduce(NullWritable.get(), values, this.context);
        verify(this.context).write(new Text("2"), NullWritable.get());
    }
}