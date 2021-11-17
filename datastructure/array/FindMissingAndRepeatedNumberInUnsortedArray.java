package array;

//Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array.
public class FindMissingAndRepeatedNumberInUnsortedArray {

	//Input: arr[] = {4, 3, 6, 2, 1, 1}
	// 0 1 2 3 4 5
	// 0 0 0 0   0 
	//Output: Missing = 5, Repeating = 1
	public static void main(String[] args) {
	//	int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		int arr[] = {12 ,7, 5, 1, 13, 1, 10, 8, 11, 9, 2, 4, 3, 6}; //8,4,5,6,6,7,3
		findNumber(arr);
	}
	
	//time complexity O(n)  and space complexity O(1)
	private static void findNumber(int[] arr) {
		int size = arr.length;
		int i;
        System.out.print("The repeating element is ");
 
        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]); //index
            if (arr[abs_val - 1] > 0) //assuming all elements in array is positive initially
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }
 
        System.out.print("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
        
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
	}

}

/**
 * Definition for a binary tree node. */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return false;
        return checkUniValTree(root, root.val);
    }
    
    private boolean checkUniValTree(TreeNode root , int data){
        
        if(root == null)
            return true;
        
          if(root.val!= data )
            return false;
        
return  checkUniValTree(root.left , data) &&  checkUniValTree(root.right , data);
        
     }
}
