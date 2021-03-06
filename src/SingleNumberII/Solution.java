class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int num: nums){
                count += ((num >> i) & 1);
            }
            if(count % 3 != 0){
                ret |= (1 << i);
            }
        }
        return ret;
    }
}