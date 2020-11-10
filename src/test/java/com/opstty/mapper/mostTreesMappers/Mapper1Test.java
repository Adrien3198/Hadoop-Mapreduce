package com.opstty.mapper.mostTreesMappers;

import junit.framework.TestCase;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Mapper1Test extends TestCase {
    @Mock
    private Mapper.Context context;
    private Mapper1 mapper1;
    @Before
    public void setup(){this.mapper1 = new Mapper1();}
    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)\n";

        this.mapper1.map(null, new Text(value), this.context);
        verify(this.context, times(1)).write(new Text("12"), new IntWritable(1));
    }
}