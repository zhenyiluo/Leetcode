class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int diff = 0;
        for(int num: nums){
            diff ^= num;
        }
        int lsb = diff & (-diff);

        for(int num: nums){
            if((num & lsb) == 0){
                ans[0] ^= num;
            }else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}