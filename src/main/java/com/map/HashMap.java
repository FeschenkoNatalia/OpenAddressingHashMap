package com.map;

public class HashMap {
    private Pair[] pairs;
    private int size = 0;
    private final float loadFactor;

    public HashMap() {
        this(16);
    }

    public HashMap(int capacity) {
        this(capacity, 0.75f);
    }

    public HashMap(int capacity, float loadFactor) {
        pairs = new Pair[capacity];
        this.loadFactor = loadFactor;
    }

    public boolean put(int key, long value) {
        Pair currentPair = new Pair(key, value);
        overwriteHashMapIfFull();
        for(int i = 0; i < pairs.length; i++) {
            int index = hash(key, i);
            if (pairs[index] == null) {
                pairs[index] = currentPair;
                size++;
                return true;
            } else if(pairs[index].equals(currentPair)) {
                return false;
            } else if(pairs[index].getKey() == key) {
                pairs[index].setValue(value);
                return true;
            }
        }
        return false;
    }

    public long get(int key){
        for(int i = 0; i < pairs.length; i++) {
            int index = hash(key, i);
            if(pairs[index] == null) {
                throw new RuntimeException("The value of this key does not exist");
            } else if (pairs[index].getKey() == key) {
                return pairs[index].getValue();
            }
        }
        throw new RuntimeException("The value of this key does not exist");
    }

    public int size() {
        return size;
    }

    private int hash(int hash, int coefficient) {
        return (hash + coefficient) % pairs.length;
    }

    private void overwriteHashMapIfFull() {
        if(size >= loadFactor * pairs.length) {
            size = 0;
            Pair[] pair = pairs;
            pairs = new Pair[pairs.length * 2];
            for(int i = 0; i < pair.length; i++) {
                if(pair[i] != null) {
                    put(pair[i].getKey(), pair[i].getValue());
                }
            }
        }
    }
}
