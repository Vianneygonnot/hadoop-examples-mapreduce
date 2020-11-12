package com.opstty.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ShowReducer extends Reducer<Text, NullWritable, Text,NullWritable> {
    public void reduce(Text showKey,Iterable<NullWritable>values, Context context) throws IOException, InterruptedException{
        context.write(showKey,NullWritable.get());
    }
}

