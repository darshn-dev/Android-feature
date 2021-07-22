package dev.darshn.androdfeatures.testFiles;

class Solution {
    public void solution() {

        //Check stock Price
//        StockProfitCheck stockProfitCheck = new StockProfitCheck();
//        stockProfitCheck.checkPrice();

        new ArrayProblems().rotateArray();


    }

}

//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }

//    int[] nums1 = {4,5,6,0,0,0};
//    int[] nums2 = {1,2,3};
//    int m = 3, n = 3;
//    int totalLen = m + n;
//    int j = 0;
//        for (int i = m ; i < totalLen ; i++) {
//        nums1[i] = nums2[j];
//        j++;
//        }
//
//
//        //Sorting array
//        for (int i = 0; i < totalLen; i++) {
//        for (int k = i+1; k < totalLen; k++) {
//        if(nums1[i]>nums1[k]){
//        int temp = nums1[i];
//        nums1[i] = nums1[k];
//        nums1[k] = temp;
//        }
//        }
//        }