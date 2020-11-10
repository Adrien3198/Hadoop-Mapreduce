package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
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
public class MaxHeightMapperTest {
    @Mock
    private Mapper.Context context;
    private MaxHeightMapper maxHeightMapper;

    @Before
    public void setup(){ this.maxHeightMapper = new MaxHeightMapper();}

    @Test
    public void testMap() throws IOException, InterruptedException{
        String value = "(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées\n";
        this.maxHeightMapper.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new Text("decurrens"), new DoubleWritable(20.0));
    }
}