package com.opstty.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ShowMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // filter line base on header value to skip header
        if (!value.toString().contains("ESPECE")) {
            Text show = new Text(value.toString().split(";")[3]);
            context.write(show, NullWritable.get());


        }
    }
}