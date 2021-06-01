package fr.chakib.houd.kata.unit;

import fr.chakib.houd.kata.domain.manufacture.DrinkMaker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DrinkMakerTest {

    DrinkMaker drinkMaker = new DrinkMaker();

    @Test
    void shouldBeAbleToSendInstructionsForMakingATeaWithoutSugar() {
        drinkMaker.analyze("T::");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with no sugar and therefore no stick");
    }

    @Test
    void shouldBeAbleToSendInstructionsForMakingACoffeeWithoutSugar() {
        drinkMaker.analyze("C::");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
    }

    @Test
    void shouldBeAbleToSendInstructionsForMakingAChocolateWithoutSugar() {
        drinkMaker.analyze("H::");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with no sugar and therefore no stick");
    }

    @Test
    void shouldBeAbleToSendInstructionsForMakingATeaWitAtSugar() {
        drinkMaker.analyze("T:1:0");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
    }

    @Test
    void shouldBeAbleToSendInstructionsForMakingACoffeeWitAtSugar() {
        drinkMaker.analyze("C:1:0");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with 1 sugar and a stick");
    }


    @Test
    void shouldBeAbleToSendInstructionsForMakingAChocolateWitAtSugar() {
        drinkMaker.analyze("H:1:0");

        var instructionsSent = drinkMaker.sendInstruction();

        assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 1 sugar and a stick");
    }
}
