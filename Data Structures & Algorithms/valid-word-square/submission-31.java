class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();

        for(int i = 0; i < rows; i++){
            int cols = words.get(i).length();
            for(int j = 0; j < cols; j++){
                System.out.print(words.get(i).charAt(j) + " | ");

                if(j >= rows || i >= words.get(j).length()){
                    return false;
                }

                char topLeft = words.get(i).charAt(j);
                char bottomLeft = words.get(j).charAt(i);
                if(topLeft != bottomLeft) return false;
            }
            System.out.println();
        }

        return true;
    }
}
