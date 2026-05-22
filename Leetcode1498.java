//1498. Number of Subsequences That Satisfy the Given Sum Condition

import java.util.Arrays;

public class Leetcode1498 {
    
    public static int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0]=1;
        for(int i=1;i<n;i++){
           power[i] = (power[i-1]*2)%mod;
        }
        int start = 0;
        int end = n-1;
        int ans = 0;
        while(start<=end){
            if(nums[start]+nums[end]<=target){
                ans = (ans+power[end-start])%mod;
                start++;
            }else{
                 end--;
            }
        }
        return ans;
    }

    
  
}
