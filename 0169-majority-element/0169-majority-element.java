class Solution {
    public int majorityElement(int[] nums) 
    {
        // Map<Integer, Integer> map= new HashMap<>();
        // for(int i=0;i<nums.length;i++)
        // {
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);    
        // }
        // int s=nums.length/2;    
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(map.get(nums[i])>s)
        //     {
        //         return nums[i];
        //     }
        // }
        // return 0;
        int m=nums[0];  //3
        int v=1;
        for(int i=1;i<nums.length;i++)
        {
            if(v==0)
            {
                v=1;
                m=nums[i]; //m=2
            }
            else if(m==nums[i])  //2==2
            {
                
                v++;
            }
            else{
                v--; //1
            }
        }
        return m;
    }
}