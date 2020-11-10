package com.opstty.writablesPerso;

import org.apache.hadoop.io.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class IntStringWritable implements WritableComparable<IntStringWritable>{

    private int vint;
    private String vstring;

    public IntStringWritable(){}
    public IntStringWritable(int vint, String vstring) {
        this.set(vint, vstring);
    }

    public void set(int age, String district){
        this.setVint(age);
        this.setVstring(district);
    }
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(vint);
        dataOutput.writeChars(vstring);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.vint = dataInput.readInt();
        this.vstring = dataInput.readLine();
    }

    public int getVint() {
        return vint;
    }

    public void setVint(int vint) {
        this.vint = vint;
    }

    public String getVstring() {
        return vstring;
    }

    public void setVstring(String vstring) {
        this.vstring = vstring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntStringWritable)) return false;
        IntStringWritable that = (IntStringWritable) o;
        return getVint() == that.getVint() &&
                Objects.equals(getVstring(), that.getVstring());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVint(), getVstring());
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(IntStringWritable intStringWritable) {
        return Integer.compare(vint, intStringWritable.vint);
    }
}
