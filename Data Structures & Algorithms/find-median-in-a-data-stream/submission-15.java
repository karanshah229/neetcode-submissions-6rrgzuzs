class MedianFinder {
    List<Integer> al;

    public MedianFinder() {
        al = new ArrayList<>();
    }
    
    public void addNum(int num) {
        al.add(num);
        Collections.sort(al);
    }
    
    public double findMedian() {
        int length = al.size();
        if(length % 2 == 0) {
            return ((double) al.get(length / 2) + al.get((length - 1) / 2)) / 2;
        }

        return (double) al.get(length / 2);
    }
}
