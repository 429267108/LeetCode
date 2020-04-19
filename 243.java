class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int diff = words.length + 1;
        int temp1 = -1;
        int temp2 = -1;
        
        for(int i = 0; i < words.length; i++){
            
            if(words[i].equals(word1)){
                temp1 = i;
            }
            
            if(words[i].equals(word2)){
                temp2 = i;
            }
            
            if(temp1 >= 0 && temp2 >= 0){
                diff =  Math.min(Math.abs(temp1 - temp2), diff);
            }
            
        }
        
        return diff;
    }
}
