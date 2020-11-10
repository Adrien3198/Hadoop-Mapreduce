package com.opstty.mapper.mostTreesMappers;

import com.opstty.writablesPerso.IntStringWritable;
import junit.framework.TestCase;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Mapper2Test extends TestCase {
    @Mock
    private Mapper.Context context;
    private Mapper2 mapper2;
    @Before
    public void setup(){this.mapper2 = new Mapper2();}
    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "1\t 8";

        this.mapper2.map(null, new Text(value), this.context);
        verify(this.context, times(1)).write(NullWritable.get(), new IntStringWritable(8, "1"));
    }
}