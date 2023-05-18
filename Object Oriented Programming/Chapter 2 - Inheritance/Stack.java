interface IStack {
    void push(int item);

    int pop();
}

class FixedStack implements IStack {
    private int tos;
    private int[] elements;

    FixedStack(int size) {
        elements = new int[size];
        tos = -1;
    }

    boolean isEmpty() {
        return tos == -1;
    }

    boolean isFull() {
        return tos == elements.length - 1;
    }

    public void push(int ele) {
        if (this.isFull()) {
            System.out.println("Throw an Error, Stack is full");
            return;
        }
        elements[++tos] = ele;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Throw an Error, stack is empty");
            return -9999;
        }
        return elements[tos--];
    }

    void printElements() {
        for (int ele : elements) {
            System.out.println(ele);
        }
    }
}

class DynamicStack implements IStack {
    private int tos;
    private int[] elements;

    DynamicStack(int size) {
        elements = new int[size];
        tos = -1;
    }

    boolean isEmpty() {
        return tos == -1;
    }

    boolean isFull() {
        return tos == elements.length - 1;
    }

    public void push(int ele) {
        if (this.isFull()) {
            int temp[] = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[++tos] = ele;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Throw an Error, stack is empty");
            return -9999;
        }
        return elements[tos--];
    }

    void printElements() {
        for (int ele : elements) {
            System.out.println(ele);
        }
    }
}

class Stack {
    public static void main(String args[]) {
        IStack ref1 = new FixedStack(3);
        IStack ref2 = new DynamicStack(3);

        // Runtime Polymorphism
        ref1.push(10);
        ref1.push(20);
        ref1.push(30);
        ref1.push(40);

        ref2.push(10);
        ref2.push(20);
        ref2.push(30);
        ref2.push(40);

        // ref1.print() will throw an error as using a reference object of type IStack
        // we cannot call method that is not part of IStack.

    }
}