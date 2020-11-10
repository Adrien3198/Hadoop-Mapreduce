package com.opstty.mapper;

import junit.framework.TestCase;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SortTreeMapperTest extends TestCase {
    @Mock
    private Mapper.Context context;
    private SortTreeMapper sortTreeMapper;

    @Before
    public void setup(){this.sortTreeMapper = new SortTreeMapper();}

    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées\n";
        this.sortTreeMapper.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new DoubleWritable(20.0), NullWritable.get());
    }
}