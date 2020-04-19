class WordDistance {
    
    Map<String, List<Integer>> wordsMap = new HashMap<>();
    
    Map<String, Integer> cacheMap = new HashMap<>();
    
    public WordDistance(String[] words) {
        
        for(int i = 0; i < words.length; i++){
            List<Integer> curDistance = wordsMap
                .getOrDefault(words[i], new ArrayList<>());
            curDistance.add(i);
            wordsMap.put(words[i], curDistance);
        }    
    }
    
    public int shortest(String word1, String word2) {
        String key = word1 + "," + word2;
        Integer minDistance = cacheMap.getOrDefault(key, null);
        if(minDistance != null){
            return minDistance;
        }
        
        minDistance = Integer.MAX_VALUE - 1;
        List<Integer> indexList1 = wordsMap.get(word1);
        List<Integer> indexList2 = wordsMap.get(word2);
        
        
        int i = 0, j = 0;
        while(i < indexList1.size() && j < indexList2.size()){
              minDistance = Math.min(
                   Math.abs(indexList1.get(i) - indexList2.get(j)), minDistance);
            
            if(indexList1.get(i) > indexList2.get(j)){
                j++;
            }else{
                i++;
            }
        }
        
        cacheMap.put(key, minDistance);
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
