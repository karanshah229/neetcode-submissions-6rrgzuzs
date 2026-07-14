class StringIterator {
    int index = 0;
    String s = "";

    public StringIterator(String compressedString) {
        char prev = '-';
        String aq = "";
        for(char ch: compressedString.toCharArray()){
            System.out.println(ch);
            int chInt = (int) ch;
            if(chInt >= 48 && chInt <= 57) aq += String.valueOf(ch);
            else {
                if(prev == '-') prev = ch;
                else {
                    int num = Integer.parseInt(aq);
                    System.out.println("num " + num);
                    while(num-- != 0) s += String.valueOf(prev);
                    prev = ch;
                    aq = "";
                }
            }
        }
    }
    
    public char next() {
        return s.charAt(index++);
    }
    
    public boolean hasNext() {
        return index != s.length()-2;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
