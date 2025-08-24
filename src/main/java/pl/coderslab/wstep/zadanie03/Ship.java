package pl.coderslab.wstep.zadanie03;

public class Ship {

    Captain captain;
    String name;

    public Ship(Captain captain) {
        this.captain = captain;
    }

    public Captain getCaptain() {
        return captain;
    }
}
