package CourierManagement.main;

public class NearestCourierFinder {

    public static void main(String[] args) {
        String[] couriers = {"Courier A - 10km", "Courier B - 5km", "Courier C - 8km"};
        int[] distances = {10, 5, 8};

        int minDistance = distances[0];
        int index = 0;

        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < minDistance) {
                minDistance = distances[i];
                index = i;
            }
        }

        System.out.println("Nearest Courier: " + couriers[index]);
    }
}
