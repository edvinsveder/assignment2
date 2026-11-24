void main() {
    // Instance of this class
    CarController cc = new CarController();

    boolean carChoice = false;

    if (carChoice) {
        cc.cars.add(new Volvo240());
    } else {
        cc.cars.add(new Saab95());
    }

    // Start a new view and send a reference to the controller as well as which car was chosen
    cc.frame = new CarView("CarSim 1.0", cc, carChoice);
    cc.startTimer();
}