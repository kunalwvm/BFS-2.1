// Time  0(m*n)
// space 0(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int freshOranges=0;
        Queue<int[]> q= new LinkedList<>();
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    freshOranges++;
                }
                else if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        if(freshOranges==0)
        {
            return 0;
        }
        int time =0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                for(int[] dir: dirs)
                {
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                        freshOranges--;
                        q.add(new int[]{nr,nc});
                        grid[nr][nc]=2;
                    }
                }
            }
            time ++;
        }
        if(freshOranges!=0)
        {
            return -1;
        }
        return time-1;
    }
}