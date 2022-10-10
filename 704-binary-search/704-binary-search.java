class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid])
            {start = mid+1;}
            else if(target < nums[mid])
            {end = mid-1;}
        }
        return -1;
    }
}

// 5 - 0 /2 = 2
//     nums[2] = 3


//     if(9 > 3) start = 2, end = 5
//         5-2 = 3/2 = 1
        
    