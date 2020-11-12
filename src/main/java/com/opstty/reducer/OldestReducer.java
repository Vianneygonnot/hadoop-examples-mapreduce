package com.opstty.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import com.opstty.DBWritable;

public class OldestReducer extends Reducer<IntWritable, DBWritable, IntWritable, NullWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(IntWritable key, Iterable<DBWritable> values, Context context)
            throws IOException, InterruptedException {
        Integer minYear = null;
        Integer district = 0;
        for (DBWritable val : values) {
            if (minYear == null || minYear > val.getV2().get()) {
                minYear = val.getV2().get();
                district = val.getV1().get();
            }
        }
        result.set(district);
        context.write(result, NullWritable.get());
    }
}