package CourierManagement.main;

public class CourierAssignment {
    public static void main(String[] args) {
        String[] couriers = {"Courier A", "Courier B", "Courier C"};
        int[] load = {2, 1, 3}; // Load assigned to each courier

        int minLoadIndex = 0;
        for (int i = 1; i < load.length; i++) {
            if (load[i] < load[minLoadIndex]) {
                minLoadIndex = i;
            }
        }

        System.out.println("Assigned to: " + couriers[minLoadIndex]);
    }
}
