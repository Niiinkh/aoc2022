package de.aboueldahab.aoc.day07;

public class AocFile {

    private String name;
    private long size;

    public AocFile() {

    }

    public AocFile(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long size() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
