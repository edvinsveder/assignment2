void main() {
    // Instance of this class
    CarController cc = new CarController();

    boolean carChoice = true;

    if (carChoice) {
        Volvo240 volvo = new Volvo240();
        volvo.setStartPos(50, 50);
        cc.cars.add(volvo);
    } else {
        Saab95 saab = new Saab95();
        saab.setStartPos(150, 150);
        cc.cars.add(saab);
    }

    // Start a new view and send a reference to the controller as well as which car was chosen
    cc.frame = new CarView("CarSim 1.0", cc, carChoice);
    cc.startTimer();
}