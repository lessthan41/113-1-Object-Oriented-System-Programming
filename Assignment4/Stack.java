import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<I> implements StackOperations<I> {
    /**
     * Stack container to store data
     */
    private LinkedList<I> stack;

    /**
     * Constructor
     */
    public Stack() {
        this.stack = new LinkedList<I>();
    }

    /**
     * Push item into the stack
     * @param item is the item to be pushed
     */
    @Override
    public void push(I item) {
//        System.out.println("push item: "+item);
        this.stack.add(item);
    }

    /**
     * Remove the top item of the stack
     */
    @Override
    public void pop() throws EmptyStackException {
//        System.out.println("pop item");
        if (this.stack.isEmpty()) {
            throw new EmptyStackException();
        }
        this.stack.removeLast();
    }

    /**
     * Get the item at the top of the stack
     * @return the item at the top of the stack
     */
    @Override
    public I peek() throws EmptyStackException {
//        System.out.println("peek top item");
        if (this.stack.isEmpty()) {
             throw new EmptyStackException();
        }
        return this.stack.getLast();
    }

    /**
     * Get the size of the stack
     * @return Integer shows the size of the stack
     */
    @Override
    public int size() {
//        System.out.println("return size");
        return this.stack.size();
    }

    /**
     * Return the stack is empty or not
     * @return Boolean shows the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Return the string representation of this Stack class
     * @return String representation of this Stack class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack:\n");

        for (int i = this.size() - 1; i >= 0; i--) {
            if (i == this.size() - 1) {
                str.append("top: ");
            } else {
                str.append("     ");
            }
            str.append(this.stack.get(i));
            if (i != 0) {
                str.append("\n");
            }
        }

        return str.toString();
    }

    /**
     * Regression test
     * @param args is not used in this regression test
     */
    public static void main(String[] args) {
        Stack<String> s1 = new Stack<String>();
        Stack<Integer> s2 = new Stack<Integer>();
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        s1.push("hello");
        s1.push("world");
        s1.push("!");
        s2.push(5);
        System.out.println(s1.size());
        System.out.println(s2.size());
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s1.peek());
        System.out.println(s2.peek());
        s1.pop();
        s2.pop();
        try {
            s2.pop(); // cause exception
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty to pop");
        }
        try {
            s2.peek(); // cause exception
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty to peep");
        }
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s1);
        System.out.println(s2);
    }
}
