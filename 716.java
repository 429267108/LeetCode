class MaxStack {

    private List<Integer> maxStack = null;
    
    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new ArrayList<>();    
    }
    
    public void push(int x) {
        maxStack.add(x);
        
    }
    
    public int pop() {
        int lastIndex = maxStack.size() - 1;
        int res = maxStack.get(lastIndex);
        maxStack.remove(lastIndex);
        return res;
    }
    
    public int top() {
        return maxStack.get(maxStack.size() - 1);
    }
    
    public int peekMax() {
        return Collections.max(maxStack);
    }
    
    public int popMax() {
        int res = peekMax();
        int peekIndex = maxStack.lastIndexOf(res);
        maxStack.remove(peekIndex);
        return res;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
