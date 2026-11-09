class Solution {
    public int lastStoneWeight(int[] stones) {
        int weight = 0;
        while(true) {
            stones = maxHeap(stones);
            if(stones.length <= 1) break;
            
            int maxIndex = 1;
            if(2 < stones.length && stones[2] > stones[1])
                maxIndex = 2;
            
            weight = Math.abs(stones[0] - stones[maxIndex]);
            
            stones[maxIndex] = weight;
            stones = Arrays.copyOfRange(stones, 1, stones.length);
            
        }
        
        return stones.length == 1 ? stones[0] : 0;
        
        
    }
    
    private int[] maxHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //dua phan tu o vi tri i vao trong heap (0 -> i)
            int current = i;
            int father = (i - 1) / 2;
            while(current > 0 && arr[current] > arr[father]) {
                int temp = arr[current];
                arr[current] = arr[father];
                arr[father] = temp;
                current = father;
                father = (current - 1) / 2;
            }
        }
        
        return arr;
    }
}
