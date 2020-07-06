package demo;

public class HashMap<K, V> implements Map<K, V> {

    private Entry<K, V> [] table = null;

    private int size = 0;

    private static int defaultLength = 1<<4;

    public HashMap(){
        table = new Entry[defaultLength];
    }

    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            table[index] = new Entry<>(k, v, null, index);
            ++size;
        } else {
            table[index] = new Entry<>(k, v, entry, index);
        }

        return table[index].getValue();
    }

    @Override
    public V get(K k) {
        if (0 == size) {
            return null;
        }
        int index = hash(k);
        Entry entry = getEntry(k, index);

        return entry == null ? null : (V) entry.getValue();
    }

    private Entry<K, V> getEntry(K k, int index) {
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == index && (k == e.getKey() || k.equals(e.getKey()))) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(K k) {
        int index = k.hashCode() % (defaultLength - 1);
        return Math.abs(index);
    }

    class Entry<K, V> implements Map.Entry {
        K k;
        V v;
        Entry<K, V> next;
        int hash;

        public Entry(K k, V v, Entry<K, V> next, int hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        System.out.println(map.get("a"));
        map.put("ab", "2");
        System.out.println(map.get("ab"));
        map.put("abc", "3");
        System.out.println(map.get("abc"));
        map.put("abcd", "4");
        System.out.println(map.get("abcd"));
    }
}
