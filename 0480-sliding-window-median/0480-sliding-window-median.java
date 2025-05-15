class Solution {
    // Max-heap for the smaller half
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    // Min-heap for the larger half
    PriorityQueue<Integer> right = new PriorityQueue<>();
    // HashMap to track elements marked for lazy deletion
    HashMap<Integer, Integer> del_num = new HashMap<>();
    int leftcnt = 0, rightcnt = 0;

    // Adds a number to one of the heaps and rebalances
    private void addNum(int num) {
        // Add to the appropriate heap
        if (right.size() > 0 && num >= right.peek()) {
            right.offer(num);
            rightcnt++;
        } else {
            left.offer(num);
            leftcnt++;
        }
        balance();
    }

    // Removes a number by marking it in the HashMap and rebalancing
    private void removeNum(int num) {
        del_num.put(num, del_num.getOrDefault(num, 0) + 1);
        if (num <= left.peek()) {  // Check if it’s in the max-heap
            leftcnt--;
            if (num == left.peek()) {
                delNumInHeap(left);
            }
        } else {  // Otherwise, it’s in the min-heap
            rightcnt--;
            if (num == right.peek()) {
                delNumInHeap(right);
            }
        }
        balance();
    }

    // Clears any elements from the top of the heap that should be deleted
    private void delNumInHeap(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && del_num.containsKey(heap.peek())) {
            int num = heap.peek();
            del_num.put(num, del_num.get(num) - 1);
            if (del_num.get(num) == 0) {
                del_num.remove(num);
            }
            heap.poll();
        }
    }

    // Balances the sizes of the two heaps
    private void balance() {
        if (leftcnt - rightcnt == 2) {
            right.offer(left.poll());
            leftcnt--;
            rightcnt++;
            delNumInHeap(left);
            delNumInHeap(right);
        } else if (rightcnt - leftcnt == 2) {
            left.offer(right.poll());
            leftcnt++;
            rightcnt--;
            delNumInHeap(left);
            delNumInHeap(right);
        }
    }

    // Returns the median of the current window
    private double getMedian() {
        if (leftcnt == rightcnt) {
            return ((long) left.peek() + (long) right.peek()) / 2.0;
        } else if (leftcnt > rightcnt) {
            return left.peek() * 1.0;
        } else {
            return right.peek() * 1.0;
        }
    }

    // Main function that slides the window across the array
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        ans[0] = getMedian();

        for (int i = k; i < nums.length; i++) {
            addNum(nums[i]);
            removeNum(nums[i - k]);
            ans[i - k + 1] = getMedian();
        }

        return ans;
    }
}