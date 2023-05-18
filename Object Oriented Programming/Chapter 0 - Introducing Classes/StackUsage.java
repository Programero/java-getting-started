class Stack {
    private int tos = -1;
    private int eleStack[];

    Stack(int size) {
        this.eleStack = new int[size];
    }

    public boolean isEmpty() {
        return tos == -1 ? true : false;
    }

    public boolean isFull() {
        return tos == eleStack.length - 1 ? true : false;
    }

    public void push(int ele) {
        if (this.isFull()) {
            System.out.println("Stack is full, cannot insert");
            return;
        }
        this.eleStack[++tos] = ele;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return -9999;
        }
        return this.eleStack[tos--];
    }

    public void printStack() {
        for (int ele : this.eleStack) {
            System.out.println(ele);
        }
    }
}

public class StackUsage {
    public static void main(String args[]) {
        Stack s = new Stack(3);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.printStack();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.pop();
        s.pop();
    }
}