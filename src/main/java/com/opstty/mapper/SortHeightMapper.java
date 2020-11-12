package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortHeightMapper extends Mapper<Object, Text, FloatWritable, IntWritable> {
    private final static FloatWritable height = new FloatWritable();
    private final static IntWritable num = new IntWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] line = value.toString().split(";");
        // ignore the header and lines where height is not provided
        if (!line[0].toString().equals("GEOPOINT") && !line[6].equals("")) {

            height.set(Float.parseFloat(line[6]));
            num.set(Integer.parseInt(line[11]));
            context.write(height, num);
        }
    }
}