class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0 ;
        List<int[]> result = new ArrayList<>();
        // now adding the all elements coming less than the Intervals
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        // now checking the overlaping conditions for the new interval
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // adding all remaining elements from intervals;

        while( i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);


    }
}