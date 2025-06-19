import java.util.*;

class MyStack {
    Queue<Integer> stack;
    Queue<Integer> backup;

    public MyStack() {
        this.stack = new LinkedList<>();
        this.backup = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public int pop() {
        int size = stack.size();
        for (int i = 0; i < size -1; i++) {
            backup.add(stack.remove());
        }
        int result = stack.remove();
        size = backup.size();
        for (int i = 0; i < size; i++) {
            stack.add(backup.remove());
        }
        return (result);
    }
    
    public int top() {
        int size = stack.size();
        int result = 0;
        
        for (int i = 0; i < size; i++) {
            if (i == size -1) {
                result = stack.element();
            }
            backup.add(stack.remove());
        }
        size = backup.size();
        for (int i = 0; i < size; i++) {
            stack.add(backup.remove());
        }
        return (result);
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */