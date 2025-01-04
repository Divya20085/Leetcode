class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int  arr[]= new int [nums1.length+nums2.length];
        int m=nums1.length+nums2.length;
        int c=0;
        for(int i=0;i<nums1.length;i++)
        {
            arr[i]=nums1[i];
            c++;
        }
        for(int i=0;i<nums2.length;i++)
        {
            arr[c]=nums2[i];
            c++;
        }
        Arrays.sort(arr);
        int w=0;
        double z=0;
        if(m%2==0)
        {
            w=arr[arr.length/2-1]+arr[arr.length/2];
            z=w/2.0;
            
        }
        else
        {
            z=arr[arr.length/2];
        }
       return z;
    }
}