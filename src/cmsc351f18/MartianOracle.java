package cmsc351f18;

class MartianOracle {
	final private int m_totalSize;
	private MinHeap minHeap;
	private MaxHeap maxHeap;
	/**
	 * constructor of the class
	 * @param size The first number in the stream, denoting the total number of positive integers
	 */
	MartianOracle(int size) {
		m_totalSize = size;
		minHeap = new MinHeap((2*size) / 3);
		maxHeap = new MaxHeap(size/3);
	}
	
	/**
	 * process a positive integer
	 * @param value The new positive integer to process
	 */
	void process(int value) {
		if(maxHeap.peek() != null && value < maxHeap.peek()){
			maxHeap.add(value);
			if( maxHeap.size() > minHeap.size()/2 + 1 ) {
				minHeap.add(maxHeap.pop());
			}
		} else {
			minHeap.add(value);
			if( minHeap.size() > maxHeap.size() * 2) {
				maxHeap.add(minHeap.pop());
			}
		}
	}
	
	/**
	 * query the \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 * @return The current \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 */
	int query() {
		return maxHeap.peek();
	}
}
