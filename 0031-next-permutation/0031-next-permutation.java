class Solution {
    public void nextPermutation(int[] nums) 
    {
        int n=nums.length;
        int i=n-2;
        while(i>=0&&nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j=n-1;
            while(nums[j]<=nums[i])
            {
                j--;
            }
            swap(nums,i,j);
        }
        rev(nums,i+1);
}
        public void swap(int nums[], int i, int j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        public void rev(int nums[], int start)
        {
            int e=nums.length-1;
            while(start<e)
            {
                swap(nums,start,e);
                start++;
                e--;
            }
        }
    }
