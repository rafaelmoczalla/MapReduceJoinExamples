package org.moczalla.utils;


import java.util.stream.Collectors;

public class PrintableHashMap<K,V> extends java.util.HashMap<K, V> {
    public PrintableHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public PrintableHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public PrintableHashMap() {
        super();
    }

    public PrintableHashMap(java.util.Map<? extends K,? extends V> m) {
        super(m);
    }

    public String toString() {
        return super.entrySet()
            .stream()
            .map(entry -> entry.getValue().toString())
            .collect(Collectors.joining(" "));
    }
}