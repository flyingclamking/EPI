import java.util.NoSuchElementException;

public class CircularQueue<K> {
	
	private static final int DEFAULT_CAPACITY = 2;
	
	private K[] queue;
	private int capacity;
	private int size;
	
	private int head;
	private int tail;
	
	public CircularQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		queue = (K[]) new Object[capacity];
		head = 0;
		tail = 0;
	}
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void enqueue(K k) {
		if (size == capacity) {
			doubleSize();
		}
		
		queue[tail] = k;
		tail = (tail + 1) % capacity;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	private void doubleSize() {
		capacity <<= 1;
		K[] temp = (K[]) new Object[capacity];
		
		int curr = 0;
		while (!isEmpty()) {
			temp[curr++] = dequeue();
		}
		queue = temp;
		head = 0;
		tail = curr;
		size = curr;
	}
	
	public K dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		K result = queue[head];
		head = (head + 1) % capacity;
		size--;
		return result;
	}
	
	
	public static void main(String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
	
}
