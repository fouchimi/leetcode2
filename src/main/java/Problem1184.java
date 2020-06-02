public class Problem1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int startIndex = start, firstSum = 0, secondSum = 0;
        while (startIndex != destination) {
            firstSum += distance[startIndex];
            startIndex = (startIndex + 1) % distance.length;
        }
        startIndex = destination;
        while (startIndex != start) {
            secondSum += distance[startIndex];
            startIndex = (startIndex + 1) % distance.length;

        }
        return Math.min(firstSum, secondSum);
    }

    public static void main(String[] args) {
        Problem1184 problem1184 = new Problem1184();
        System.out.println(problem1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(problem1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(problem1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }
}
