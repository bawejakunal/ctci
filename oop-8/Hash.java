/**
 *
 * Implement a hashtable
 *
 **/

import java.util.*;

class Cell<K, V> {
    private K key;
    private V value;

    Cell(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    void setValue(V value) {
        this.value = value;
    }

    boolean equivalent(K key) {
        if (key == null)
            return false;
        return this.key.equals(key);
    }

    boolean equivalent(Cell<K, V> cell) {
        if (cell == null)
            return false;
        return this.equivalent(cell.getKey());
    }
}

public class Hash<K, V> {
    private int MAX_SIZE = 10;
    private LinkedList<Cell<K, V>> []items;

    public Hash() {
        this.items = (LinkedList<Cell<K, V>>[]) new LinkedList[this.MAX_SIZE];
    }

    public Hash(int size) {
        this.MAX_SIZE = size;
        this.items = (LinkedList<Cell<K, V>>[]) new LinkedList[this.MAX_SIZE];
    }

    private int hashOfKey(K key) {
        return key.toString().length() % this.MAX_SIZE;
    }

    private Cell<K, V> getCell(K key) {
        if (key != null) {
            int h = hashOfKey(key);
            if (this.items[h] != null) {
                for (Cell<K, V> c : items[h]) {
                    if (key.equals(c.getKey()))
                        return c;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return getCell(key) != null;
    }

    public V put(K key, V value) {
        Cell<K, V> cell = this.getCell(key);
        V prevVal = null;

        // mapping present
        if (cell != null) {
            prevVal = cell.getValue();
            cell.setValue(value);
        }
        else {
            int h = hashOfKey(key);
            if (items[h] == null)
                items[h] = new LinkedList<Cell<K, V>>();
            Cell<K, V> newCell = new Cell<K, V>(key, value);
            items[h].addFirst(newCell);     // add to head O(1) time
        }
        return prevVal;
    }

    public V get(K key) {
        if (key == null)
            return null;
        Cell<K, V> cell = getCell(key);
        if (cell == null)
            return null;
        return cell.getValue();
    }
}