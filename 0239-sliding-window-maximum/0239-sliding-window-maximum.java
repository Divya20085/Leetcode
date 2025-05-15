import java.util.Stack;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        // Build the Next Greater Element (NGE) array
        st.push(n - 1);
        nge[n - 1] = n; // No next greater for last element

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        // Process each sliding window
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans[i] = nums[j];
        }

        return ans;
    }
}