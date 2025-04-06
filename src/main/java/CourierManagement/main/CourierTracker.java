package CourierManagement.main;

public class CourierTracker {
    public static void main(String[] args) {
        String[] locations = {"Hub", "City Center", "Neighborhood", "Destination"};
        int index = 0;

        System.out.println("Courier Tracking:");

        while (index < locations.length) {
            System.out.println("Courier is at: " + locations[index]);
            index++;

            // Simulating a pause
            try {
                Thread.sleep(1000); // 1-second delay
            } catch (InterruptedException e) {
                System.out.println("Tracking interrupted.");
            }
        }

        System.out.println("Courier has reached the destination!");
    }
}