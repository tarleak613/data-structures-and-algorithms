class Solution {
    private int fun(int[][] mat, int day, int last){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i <= 2; i++){
                if(i != last){
                    maxi = Math.max(maxi, mat[0][i]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last){
                int points = mat[day][i] + fun(mat, day-1, i);
                maxi = Math.max(maxi, points);
            }
        }
        return maxi;
    }
    private int memo(int[][] mat, int[][] dp, int day, int last){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i <= 2; i++){
                if(i != last){
                    maxi = Math.max(maxi, mat[0][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last){
                int points = mat[day][i] + memo(mat, dp, day-1, i);
                maxi = Math.max(maxi, points);
            }
        }
        dp[day][last] = maxi;
        return dp[day][last];
    }
    public int maximumPoints(int mat[][]) {
        // code here
        
        //recursion
        // int n = mat.length;
        // return fun(mat, n-1, 3);
        
        //memoization
        // int n = mat.length;
        // int[][] dp = new int[n][4];
        
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return memo(mat, dp, n-1, 3);
        
        //tabulation
        int n = mat.length;
        int[][] dp = new int[n][4];
        
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        
        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;
                for(int i = 0; i <= 2; i++){
                    if(i != last){
                        int points = mat[day][i] + dp[day-1][i];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}