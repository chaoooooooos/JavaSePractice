package gc.structure;


import java.util.Arrays;

public class GCStack {

    public static void main(String[] args) {
        GCStack stack = new GCStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.capacity);

    }

    private Object[] arr;
    private int size = 0;
    private int capacity = 0;

    public GCStack() {
        capacity = 16;
        arr = new Object[16];
    }

    public GCStack(int c) {
        arr = new Object[c];
        capacity = c;
    }

    public void push(Object obj)  {
        if (size == capacity)
            resize();
        arr[size++] = obj;
    }

    public void print(){
        for(Object obj : arr)
            System.out.print(obj+"  ");
    }

    private void resize() {
        System.out.println("扩容");
        Object[] newArr;
        if (size >= Integer.MAX_VALUE)
            try {
                throw new Exception("already full!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        if (2 * size <= Integer.MAX_VALUE) {
            newArr = Arrays.copyOf(arr, 2 * size);
        } else
            newArr = Arrays.copyOf(arr, Integer.MAX_VALUE);

        arr = newArr;
        capacity = arr.length;
    }

    public Object pop()  {
        if (size == 0)
            try {
                throw new Exception("empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return arr[size--];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }

}
