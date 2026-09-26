class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        double maxTime = 0.0;
        int fleet = 0;
        for (int i = 0; i < position.length; i++) {
            double time = cars[i][1];
            
            if (time > maxTime) {
                fleet++;
                maxTime = time;
            }
        }
        return fleet;
    }
}
