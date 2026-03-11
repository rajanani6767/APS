class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    // Constructor to initialize slots
    public ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }

    // Method to add a car
    public boolean addCar(int carType) {
        if (carType == 1) { // Big car
            if (bigSlots > 0) {
                bigSlots--;
                return true;
            }
        } else if (carType == 2) { // Medium car
            if (mediumSlots > 0) {
                mediumSlots--;
                return true;
            }
        } else if (carType == 3) { // Small car
            if (smallSlots > 0) {
                smallSlots--;
                return true;
            }
        }
        return false; // No slot available
    }
}