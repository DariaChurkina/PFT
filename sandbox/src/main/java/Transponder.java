public class Transponder {

    double priceTruck;
    double priceBus;
    double priceCar;
    int counterTruck;
    int counterBus;
    int counterCar;
    int totalCount;
    double totalSum;

    public Transponder(double priceTruck, double priceBus, double priceCar) {

        this.priceBus = priceBus;
        this.priceTruck = priceTruck;
        this.priceCar = priceCar;
    }

    public double truck() {
        return counterTruck = counterTruck + 1;
    }

    public double bus() {
        return counterBus = counterBus + 1;
    }

    public double car() {
       return counterCar = counterCar + 1;
    }

    public double getTotalCount(int counterBus, int counterTruck, int counterCar) {

        totalCount = counterBus + counterTruck + counterCar;
        return totalCount;
    }

    public double getTotalSum() {
        totalSum = (counterBus + counterTruck + counterCar) * (priceTruck + priceBus + priceCar);
        return totalSum;
    }

    public static void main(String[] args) {

        Transponder transponder = new Transponder(10, 5.7, 3);

        transponder.truck();
        transponder.truck();
        transponder.truck();
        System.out.println(transponder.counterTruck);

        transponder.bus();
        transponder.bus();
        System.out.println(transponder.counterBus);

        transponder.car();
        transponder.car();
        transponder.car();
        transponder.car();
        transponder.car();
        transponder.car();
        System.out.println(transponder.counterCar);

        transponder.getTotalCount(transponder.counterTruck, transponder.counterBus, transponder.counterCar);
        System.out.println(transponder.totalCount);

        transponder.getTotalSum();
        System.out.println(transponder.totalSum);
    }

}
