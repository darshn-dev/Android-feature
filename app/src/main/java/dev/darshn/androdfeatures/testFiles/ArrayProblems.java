package dev.darshn.androdfeatures.testFiles;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArrayProblems {


    /**
     * https://leetcode.com/problems/contains-duplicate/
     *Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     * @return
     */
    public boolean findRepeatedItems(){
        int[] nums = {1,58,8,2,6,3,2,1};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }


    public boolean findRepeatedItemsSol2(){
        int[] nums = {1,8,8,2,6,3,2,1};
        Set<Integer> unique = new HashSet<>(nums.length);

        for (int num:
             nums) {
            if(unique.contains(num))
                return true;

            unique.add(num);
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/rotate-array/
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     *Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     */
    public void rotateArray(){
        int[] nums = {1,2,3,4,5,6,7};

        int prev = nums[0];
        int rotate= 3;
        while (rotate > 0){
            prev = nums[nums.length-1];
            for (int i = 0; i < nums.length; i++) {

                    int temp = nums[i];
                    nums[i] = prev;
                    prev = temp;

            }
            rotate--;
        }

    }
}
