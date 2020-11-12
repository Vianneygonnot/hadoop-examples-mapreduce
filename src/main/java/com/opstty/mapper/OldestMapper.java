package com.opstty.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.opstty.DBWritable;

public class OldestMapper extends Mapper<Object, Text, IntWritable, DBWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final static IntWritable district = new IntWritable();
    private final static IntWritable years = new IntWritable();
    private final static DBWritable year = new DBWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] line = value.toString().split(";");
        // ignore the header and lines where year is not provided
        if (!line[0].toString().equals("GEOPOINT") && !line[5].equals("")) {
            district.set(Integer.parseInt(line[1]));
            years.set(Integer.parseInt(line[5]));
            year.setV1(district);
            year.setV2(years);

            context.write(one, year);
        }
    }
}
