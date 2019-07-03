class Car {
    private int wheelCount;
    private String vin;
    Car(String vin) {
        this.vin = vin;
        this.wheelCount = 4;
    }
    String drive() {
        return "zoom-zoom";
    }
    String getInfo() {
        return "VIN: " + vin + " wheels: " + wheelCount;
    }
}
class Tuk extends Car {
    Tuk(String vin) {
        this.wheelCount = 3;
    }
}