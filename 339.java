/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sumCalculation(nestedList, 1, 0);
    }
    
    private int sumCalculation(List<NestedInteger> list, int recur, int sum){
        if(list == null){
            return sum;
        }
        
        List<NestedInteger> subList = new ArrayList<NestedInteger>();
        
        for(NestedInteger item: list){
            
            if(item.isInteger()){
              // System.out.println(item.getInteger() + "* " + recur + " = " + sum);
                sum += item.getInteger() * recur;
            }else{
                createSubList(subList, item.getList());
            }
        }
        
        if(!subList.isEmpty()){
            recur++;
            sum = sumCalculation(subList, recur, sum);                                
        }
        return sum;
    }
    
    private void createSubList(List<NestedInteger> subList, List<NestedInteger> list){
        for(NestedInteger e: list){
            if(e.isInteger()){
                subList.add(e);
            }else{
                subList.add(e);
            }
        }
    }
}
