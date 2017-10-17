package com.map;

public class Pair {
    private int key;
    private long value;

    public Pair(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return (getKey() == pair.getKey()) && (getValue() == pair.getValue());
    }

    @Override
    public int hashCode() {
        return 31 * getKey() + (int) (getValue() ^ (getValue() >>> 32));
    }
}
