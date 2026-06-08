class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key() { return key; }
    public V value() { return value; }
}

class TimeMap {
    // Each key maps to a LIST of historical variations, ordered by timestamp
    private final Map<String, List<Pair<Integer, String>>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // If the key doesn't exist yet, initialize an empty list
        hm.putIfAbsent(key, new ArrayList<>());
        // Append the new timestamp pair (guaranteed to be strictly increasing order)
        hm.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the key doesn't exist at all, return empty string
        if (!hm.containsKey(key)) {
            return "";
        }

        // Get the list of all timestamped values for this specific key
        List<Pair<Integer, String>> list = hm.get(key);

        // Binary search within this specific key's history
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int currentTimestamp = list.get(mid).key();

            if (currentTimestamp == timestamp) {
                return list.get(mid).value();
            } else if (currentTimestamp < timestamp) {
                result = list.get(mid).value();
                left = mid + 1;                
            } else {
                right = mid - 1;               
            }
        }

        return result;
    }
}
