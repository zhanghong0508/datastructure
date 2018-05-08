package datastructure;

public class MyQueue {
	
	private Object[] queArray;
	//队列总大小
	private int maxSize;
	//队头
	private int front;
	//队尾
	private int rear;
	//队列中实际数目
	private int nItems;
	
	public MyQueue(int s) {
		// TODO 自动生成的构造函数存根
		maxSize = s;
		queArray = new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
		
	}
	//添加数据
	public void insert(int value) {
		if(isFull()) {
			System.out.println("队列已满！");
		}
		else {
			if(rear == maxSize - 1) {
				rear = -1;
			}
		queArray[++rear] = value;
		nItems++;
		}
	}
	//删除数据并返回数据，若删除失败则返回null
	public Object remove() {
		Object removeObject = null;
		if(!isEmpty()) {
			removeObject = queArray[front];
			queArray[front] = null;
			front++;
			if(front == maxSize) {
				front = 0;
			}
			nItems--;
			return removeObject;
		}
		return removeObject;
	}
	
	public Object peek() {
		return queArray[front];
		
	}
	//判队满
	public boolean isFull() {
		return (nItems == maxSize);
		
	}
	//判队空
	public boolean isEmpty() {
		return (nItems == 0);
		
	}
	//获取队列中元素个数
	public int getSize() {
		return nItems;
		
	}
}
