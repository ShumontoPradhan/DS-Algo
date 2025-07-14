class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(n == 0) return true;
        if(m == 1){
            if(flowerbed[0] == 0){
                n--;
                if(n == 0) return true;
                else return false;
            }
        }
        for(int i = 0; i < m; i++){
            if(flowerbed[i] == 1) continue;
            if(i == 0 && i+1 < m && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
            else if(i == m-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
            else if(i+1 < m && i-1 >= 0 && (flowerbed[i+1] == 0 && flowerbed[i-1] == 0)){
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
        }
        return false;
    }
}