class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        if(capacity < plants[0]) return 0;
        int n = plants.length;
        int i = 0;
        int steps = 0;
        int reset = capacity;
        while(i < n){
            if(capacity >= plants[i]){
                capacity -= plants[i++];
                steps++;
            }else{
                capacity = reset;
                steps += (i*2)+1;
                capacity -= plants[i];
                i++;
            }
        }
        return steps;
    }
}