//Ques:
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

//If target is not found in the array, return [-1, -1].

//You must write an algorithm with O(log n) runtime complexity.

//Example 1:

//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:

//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]


//ANSWER:
//Merge Sort - O(log n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                start=i;
                break;
            }
        }
        if (start == -1){
            int a[]=new int[]{-1,-1};
            return a;
        }
        
        int stop=0;
        MergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                stop=i;
            }
        }
        int b[]=new int[]{start,stop};
        return b;
    }
    public static void MergeSort(int[] nums,int l,int r){
          if (l < r) {
        int mid=l+(r-l)/2;
        MergeSort(nums,l,mid);
        MergeSort(nums,mid+1,r);
        Merge(nums,l,mid,r);
          }
    }
    public static void Merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
       // return arr;
    }
}
