/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let sum = nums.length * (nums.length+1) / 2;
    for(let k = 0; k < nums.length ; k++)
    {
         sum -=  nums[k];
    }
    return sum;
};