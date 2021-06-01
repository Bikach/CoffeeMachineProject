package fr.chakib.houd.kata.domain.manufacture;

public class Protocole {

    private final String order;

    public Protocole(String order) {
        this.order = order;
    }

    public String drink() {
        if(order.contains("T"))
            return "tea";
        if(order.contains("C"))
            return "coffee";
        return "chocolate";
    }

    public String sugar(){
        if(order.contains("1"))
            return "1";
        return "no";
    }

    public String stick(){
        if(order.contains("1"))
            return "a";
        return "therefore no";
    }

    public boolean containInformationProtocole() {
        return order.contains("M");
    }
}
