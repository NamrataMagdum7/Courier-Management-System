package CourierManagement.main;

public class ParcelWeightCategory {
    public static void main(String[] args) {
        double weight = 7.2;
        int weightInt = (int) weight;

        switch (weightInt) {
            case 0, 1, 2, 3, 4:
                System.out.println("Category: Light");
                break;
            case 5, 6, 7, 8, 9:
                System.out.println("Category: Medium");
                break;
            default:
                System.out.println("Category: Heavy");
        }
    }
}