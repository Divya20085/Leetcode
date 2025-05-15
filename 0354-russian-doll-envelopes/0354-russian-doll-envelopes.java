class Solution {
    // O(nlog(n))
	private int binarySearchLis(int[] nums) {
		int[] temp = new int[nums.length];
		int index = 0;
		for (int num : nums) {
			int start = 0;
			int end = index;
			while (start != end) {
				int mid = (start + end) / 2;
				if (temp[mid] < num) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			temp[start] = num;
			if (start == index) {
				++index;
			}
		}
		return index;
	}

	// O(nlog(n))
	private int lis(int[] nums) {
		TreeSet<Integer> bst = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {// O(n)
			Integer higher = bst.ceiling(nums[i]);// O(log(n))
			if (higher == null) {
				bst.add(nums[i]);// O(log(n))
			} else {
				bst.remove(higher);// O(log(n))
				bst.add(nums[i]);// O(log(n))
			}
		}
		return bst.size();
	}

	public int maxEnvelopes(int[][] envelopes) {
		// O(nlog(n))
		Arrays.sort(envelopes, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o2[1], o1[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int[] nums = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			nums[i] = envelopes[i][1];
		}
		// return lis(nums);//O(nlog(n))
		return binarySearchLis(nums);// O(nlog(n))
	}
}