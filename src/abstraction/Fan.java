package abstraction;

class Fan extends Nerd {

    @Override
    void turnON() {
        System.out.println("Fan is switched ON");
    }

    @Override
    void turnOFF() {
        System.out.println("Fan is switched OFF");
    }

}
