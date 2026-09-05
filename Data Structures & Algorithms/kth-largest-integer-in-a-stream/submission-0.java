class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int n: nums) {
            this.minHeap.offer(n);
            while (minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (minHeap.size() > k) {
            this.minHeap.poll();
        }
        

        return this.minHeap.peek();
    }
}
