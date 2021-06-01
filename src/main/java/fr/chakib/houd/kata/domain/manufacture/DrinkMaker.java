package fr.chakib.houd.kata.domain.manufacture;

public class DrinkMaker {

    private String protocole;

    public void order(String protocole) {
        this.protocole = protocole;
    }

    public String sendInstruction() {
        if(protocole.contains("T")){
            if(protocole.contains("1"))
                return "Drink maker makes 1 tea with 1 sugar and a stick";
            return "Drink maker makes 1 tea with no sugar and therefore no stick";
        }
        if(protocole.contains("H")){
            if(protocole.contains("1"))
                return "Drink maker makes 1 chocolate with 1 sugar and a stick";
            return "Drink maker makes 1 chocolate with no sugar and therefore no stick";
        }
        if(protocole.contains("C")) {
            if (protocole.contains("1"))
                return "Drink maker makes 1 coffee with 1 sugar and a stick";
            return "Drink maker makes 1 coffee with no sugar and therefore no stick";
        }
        return "Drink maker forwards any message received onto the coffee machine interface for the customer to see";
    }
}
