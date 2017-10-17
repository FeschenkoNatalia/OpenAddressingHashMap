package com.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    private HashMap hashMap;

    @Before
    public void init() {
        hashMap = new HashMap(16, 0.75f);
    }

    @Test
    public void putElementIntoHashMapTest() {
        Assert.assertEquals(true, hashMap.put(2, 1));
        Assert.assertEquals(1, hashMap.get(2));
    }

    @Test
    public void putElementsWithSameKeysTest() {
        hashMap.put(2, 1);
        hashMap.put(2, 0);
        Assert.assertEquals(0, hashMap.get(2));
    }

    @Test
    public void putEqualElementsTest() {
        hashMap.put(2, 0);
        boolean actual = hashMap.put(2, 0);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void getValueByKeyTest() throws RuntimeException {
        hashMap.put(5, 7);
        hashMap.put(8, 5);
        long expected = 7;
        Assert.assertEquals(expected, hashMap.get(5));
    }

    @Test(expected = RuntimeException.class)
    public void getNoSuchElementTest() throws Exception {
        hashMap.put(8, 1);
        hashMap.get(5);
    }

    @Test
    public void sizeTest() {
        hashMap.put(5, 4);
        hashMap.put(0, 1);
        hashMap.put(0, 0);
        int actual = hashMap.size();
        Assert.assertEquals(2, actual);
    }
}
