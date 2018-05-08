package datastructure;

import java.util.Arrays;
import java.util.EmptyStackException;
	
public class ArrayStack {
	
	private Object[] elementData;
	//栈顶指针
	private int top;
	//栈的总容量
	private int size;
	
	public ArrayStack() {
		
		this.elementData = new Object[10];
		this.top = -1;
		this.size = 10;
	}
	
	public ArrayStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("栈初始容量不能小于0:"+capacity);
		}
		this.elementData = new Object[capacity];
		this.top = -1;
		this.size = capacity;
	}
	//入栈
	public Object push(Object item) {
//		System.out.println(elementData.length);
		isGrow(top+1);
		elementData[++top] = item;
		return item;
		
	}
	//出栈
	public Object pop() {
		
		Object obj = peek();
		remove(top);
		return obj;
	}
	//取栈顶元素
	public Object peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return elementData[top];
		
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public void remove(int top) {
		elementData[top] = null;
		this.top--;
	}
	//扩充栈容量
	public boolean isGrow(int minCapacity) {
		int oldCapacity= size;
		if (minCapacity >= oldCapacity) {
			int newCapacity = 0;
			
			if ((oldCapacity<<1) - Integer.MAX_VALUE > 0) {
				newCapacity = Integer.MAX_VALUE;
			}
			else {
				newCapacity = oldCapacity<<1;//左移一位，等价于*2
			}
			//栈容量扩大
			size = newCapacity;
			
/*		
 			等价于elementData = Arrays.copyOf(elementData,size);
 			Object[] newArray = new Object[size];
//			复制栈中内容到新数组
			System.arraycopy(elementData,0,newArray,0,elementData.length);
			Arrays.fill(elementData,null);
//			指向新栈
			this.elementData = newArray;
*/
			
			elementData = Arrays.copyOf(elementData,size);
			return true;
				
			}
		
		else {
			return false;
		}
	}
}
