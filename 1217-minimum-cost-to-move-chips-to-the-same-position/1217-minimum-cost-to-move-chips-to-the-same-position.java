class Solution {
    public int minCostToMoveChips(int[] position) {
        int evensum = 0;
        int oddsum = 0;
        int odc = 0;
        int evc = 0;
        int n = position.length;
        for(int i = 0; i < n; i++){
            if(position[i] %2 == 0){
                evensum += position[i];
                evc++;
            } 
            else{
                oddsum += position[i];
                odc++;
            }
        }
        return evc > odc ? odc : evc;
    }
}