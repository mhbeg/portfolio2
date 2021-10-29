class MinHeap {
    int capacity;
    int currentSize;
    HeapNode[] minH;
    int[] indexes;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.minH = new HeapNode[capacity + 1];
        this.indexes = new int[capacity];
        this.minH[0] = new HeapNode();
        this.minH[0].key = -2147483648;
        this.minH[0].vertex = -1;
        this.currentSize = 0;
    }

    public void insert(HeapNode x) {
        ++this.currentSize;
        int index = this.currentSize;
        this.minH[index] = x;
        this.indexes[x.vertex] = index;
        this.moveUp(index);
    }

    public void moveUp(int position) {
        int parentIndex = position / 2;

        for(int currentIndex = position; currentIndex > 0 && this.minH[parentIndex].key > this.minH[currentIndex].key; parentIndex /= 2) {
            HeapNode currentNode = this.minH[currentIndex];
            HeapNode parentNode = this.minH[parentIndex];
            this.indexes[currentNode.vertex] = parentIndex;
            this.indexes[parentNode.vertex] = currentIndex;
            this.swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }

    }

    public HeapNode extractMin() {
        HeapNode min = this.minH[1];
        HeapNode lastNode = this.minH[this.currentSize];
        this.indexes[lastNode.vertex] = 1;
        this.minH[1] = lastNode;
        this.minH[this.currentSize] = null;
        this.moveDown(1);
        --this.currentSize;
        return min;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int heapSize() {
        return this.currentSize;
    }

    public void moveDown(int k) {
        int smallest = k;
        int leftChildIndex = 2 * k;
        int rightChildIndex = 2 * k + 1;
        if (leftChildIndex < this.heapSize() && this.minH[k].key > this.minH[leftChildIndex].key) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < this.heapSize() && this.minH[smallest].key > this.minH[rightChildIndex].key) {
            smallest = rightChildIndex;
        }

        if (smallest != k) {
            HeapNode smallestNode = this.minH[smallest];
            HeapNode kNode = this.minH[k];
            this.indexes[smallestNode.vertex] = k;
            this.indexes[kNode.vertex] = smallest;
            this.swap(k, smallest);
            this.moveDown(smallest);
        }

    }

    public void swap(int a, int b) {
        HeapNode temp = this.minH[a];
        this.minH[a] = this.minH[b];
        this.minH[b] = temp;
    }
}
