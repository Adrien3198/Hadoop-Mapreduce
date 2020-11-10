package com.opstty.mapper;

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

public class DistrictsListMapperTest extends TestCase {
    @Mock
    private Mapper.Context context;
    private DistrictsListMapper districtsListMapper;

    @Before
    public void setup(){
        this.districtsListMapper = new DistrictsListMapper();
    }

    @Test
    public void testMap() throws IOException, InterruptedException{
        String value = "(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)\n";

        this.districtsListMapper.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new Text("12"), NullWritable.get());

    }
}