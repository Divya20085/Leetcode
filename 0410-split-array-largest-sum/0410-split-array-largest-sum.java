class Solution {
    public int splitArray(int[] nums, int k) {
        int n= nums.length;
        int left=Integer.MIN_VALUE, right=0;
        int result=-1;
        for(int num:nums){
            left=Math.max(left,num); // Minimum possible max sum
            right+=num; // Minimum possible max sum
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canSplit(nums,k,mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    private static boolean canSplit(int[] nums, int k, int maxSum){
        int count=1; int currentSum=0;
        for(int num:nums){
            if(currentSum+num>maxSum){
                count++;
                currentSum=num;
                if(count>k) return false;
            }
            else{
                currentSum+=num;
            }
        }
        return true;
    }
}