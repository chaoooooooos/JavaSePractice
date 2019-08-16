package gc.stack;

import java.util.Arrays;

public class GcStack<T> {
    private int size = 0;
    private int cap = 10;
    private T[] arr;

    public GcStack(int c) {
        this.cap = c;
        T[] arr = (T[]) new Object[cap];
    }

    public GcStack() {
        T[] arr = (T[]) new Object[cap];
    }

    public T pop(){
        return arr[--size];
    }

    public void push(T obj) {
        System.out.println(arr.length);
        if (size == cap) {
            resize();
        }
        arr[size++] = obj;
    }

    private void resize() {
        cap = 2 * cap > Integer.MAX_VALUE ? Integer.MAX_VALUE : 2 * cap;
        //创建泛型数组
        // 1）使用强转  // 2）使用setter方法
        T[] arr_ = (T[])new Object[cap];
        arr_ = Arrays.copyOf(arr,cap);
        arr = arr_;
    }

    public int size(){
        return size;
    }

}
