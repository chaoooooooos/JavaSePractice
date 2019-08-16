package gc.stack;

public class Main {
    public static void main(String[] args) {
        GcStack<Integer> stack = new GcStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
    }
}
