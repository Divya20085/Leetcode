class Solution {
    public int maxArea(int[] height) 
    {
        int l=0;
        int r=height.length-1;
        int maxarea=0;
        while(l<r)
        {
            int w=r-l;
            int h=Math.min(height[l],height[r]);
            int area = h*w;
            maxarea = Math.max(area, maxarea);
            if(height[l]<height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxarea;

    }
}
// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int maxArea = 0;

//         while(left<right)
//         {
//             int width = right-left;
//             int currentHeight = Math.min(height[left] , height[right]);
//             int area = currentHeight * width;
//             maxArea = Math.max(area , maxArea);
//             if(height[left]  < height[right])
//             {
//                 left++; 
//             }
//             else
//             {
//                 right--;
//             }
            
//         }
//         return maxArea;

//     }
// }