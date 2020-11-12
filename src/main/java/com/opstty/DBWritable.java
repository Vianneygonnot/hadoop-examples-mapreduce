package com.opstty;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class DBWritable implements Writable {
    private IntWritable v1;
    private IntWritable v2;

    public DBWritable() {
        this.v1 = new IntWritable(0);
        this.v2 = new IntWritable(0);
    }

    public DBWritable(IntWritable v1, IntWritable v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public IntWritable getV1() {
        return v1;
    }

    public IntWritable getV2() {
        return v2;
    }

    public void setV1(IntWritable v1) {
        this.v1 = v1;
    }

    public void setV2(IntWritable v2) {
        this.v2 = v2;
    }

    @Override
    public void readFields(DataInput arg0) throws IOException {
        v1.readFields(arg0);
        v2.readFields(arg0);
    }

    @Override
    public void write(DataOutput arg0) throws IOException {
        v1.write(arg0);
        v2.write(arg0);
    }

    @Override
    public boolean equals(Object o) {
        DBWritable diw = (DBWritable) o;
        if (this.v1.get() == diw.getV1().get() &&
                this.v2.get() == diw.getV2().get()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return v1.toString() + "\t" + v2.toString();
    }
}