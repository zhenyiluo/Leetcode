class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            while(nums[i] != i+1){
                if(nums[i] <= 0 || nums[i] > n){
                    break;
                }
                if(nums[i] == nums[nums[i] -1]){
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp -1];
                nums[tmp -1] = tmp;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n + 1;
    }
}