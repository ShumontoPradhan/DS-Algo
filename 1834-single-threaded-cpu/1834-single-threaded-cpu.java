class Solution {
    class Task{
        int index;
        int enqueueTime;
        int processingTime;
        Task(int i, int e, int p){
            this.index = i;
            this.enqueueTime = e;
            this.processingTime = p;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task arr[] = new Task[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(arr, (a, b) -> {  //sorted in increasing order
            return Integer.compare(a.enqueueTime, b.enqueueTime);
        });  //sorted in increasing order

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if(a.processingTime == b.processingTime){
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        });

        int[] ans = new int[n];
        int i = 0;
        int taskIdx = 0;
        int time = 0;
        while(i < n){
            while(taskIdx < n && arr[taskIdx].enqueueTime <= time){
                pq.offer(arr[taskIdx++]);
            }
            if(pq.isEmpty()){
                time = arr[taskIdx].enqueueTime;
            }else{
                time += pq.peek().processingTime;
                ans[i++] = pq.poll().index;
            }
        }
        return ans;
    }
}