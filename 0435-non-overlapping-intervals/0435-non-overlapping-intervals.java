class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prev = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= prev){
                prev = intervals[i][1];
            }else{
                count++;
            }
        }
        return count;
    }
}