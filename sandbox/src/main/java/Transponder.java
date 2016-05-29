public class Transponder {

    double priceTruck;
    double priceBus;
    double priceCar;
    int counterTruck;
    int counterBus;
    int counterCar;

    public Transponder(double priceTruck, double priceBus, double priceCar) {
        this.priceTruck = priceTruck;
        this.priceBus = priceBus;
        this.priceCar = priceCar;

    }

    public void truck() {
        counterTruck ++;
    }

    public void bus() {
        counterBus ++;
    }

    public void car() {
        counterCar ++;
    }

    public int getTruckCount() {
        return counterTruck;
    }

    public int getBusCount() {
        return counterBus;
    }

    public double getTotalSum() {
        return (counterTruck * priceTruck) + (counterBus * priceBus)+ (counterCar * priceCar);
    }
    public int getTotalCount() {
        return counterTruck + counterBus + counterCar;
    }



    public static void main(String[] args) {



    }

}
