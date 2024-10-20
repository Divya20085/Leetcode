class Solution {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        int max = nums[0];
        int u=0;
        for(int i=0;i<n;i++)
        {
            if(max<nums[i])
            {
                max=nums[i];
                u=i;
            }
        }
        return u;
    }
}