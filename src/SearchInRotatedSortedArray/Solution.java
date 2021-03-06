class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        return dfs(nums, 0, nums.length -1, target);
    }

    private int dfs(int[] nums, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + ((end - start) >> 1);
        if(nums[mid] == target) return mid;
        if(nums[mid] >= nums[start]){
            if(target >= nums[start] && target < nums[mid]){
                return dfs(nums, start, mid -1, target);
            }else{
                return dfs(nums, mid+1, end, target);
            }
        }else{
            if(target > nums[mid] && target <= nums[end]){
                return dfs(nums, mid+1, end, target);
            }else{
                return dfs(nums, start, mid-1, target);
            }
        }
    }
}