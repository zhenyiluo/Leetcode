public class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int numTrees(int n) {
        if(n < 0) {
            return 0;
        }
        
        if(n <=1) {
            return 1;
        }
        
        if(!cache.containsKey(n)) {
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                ans += numTrees(i-1) * numTrees(n - i);
            }
            cache.put(n, ans);
        }
        
        return cache.get(n);
    }
}