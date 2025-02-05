class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int m=nums1.length;
        int n=nums2.length;
        int h=nums1.length+nums2.length;
        int a[] = new int[m+n];
        int c=0;
        for(int i=0;i<m;i++)
        {
            a[i]=nums1[i];
            c++;
        }
        for(int i=0;i<n;i++)
        {
            a[c]=nums2[i];
            c++;
        }
    
        Arrays.sort(a);
        double w=0;
        if(h%2==0)
        {
            int z=a[a.length/2-1]+a[a.length/2];
            w=z/2.0;
        }
        else
        {
            w=a[a.length/2];
        }
        return w;
    }
}