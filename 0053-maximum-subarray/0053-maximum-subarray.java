class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMaxSum = nums[0];
        for(int k = 1; k < nums.length; k++)
        {
            currentMaxSum = Math.max(currentMaxSum + nums[k], nums[k]);
            max = Math.max(max, currentMaxSum);
        }
        
        return max;
    }
}


// set current maxSum. to first num
// start the loop from index 1
// if that index + last sum > lastSum => lastSum = index + lastSum
// else lastSum = nums[index];

// 5

// curr = 5
// max = 5

// curr = 9
// max = 9

// curr = 9 - 1 = 8
// max = 9

// curr = 8 + 7 = 15
// max = 15

// curr = 15 + 8 = 23
// max = 23
    
    
//     -2,1,-3,4,-1,2,1,-5,4
    
// curr = -2
// max = -2

// curr = 1
// max = 1

// curr = -2
// max = 1

// curr = 4
// max = 4

// curr =