package fr.chakib.houd.kata.unit;

import fr.chakib.houd.kata.domain.manufacture.DrinkMaker;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DrinkMakerTest {

    DrinkMaker drinkMaker = new DrinkMaker();

    @Nested
    class WithoutSugar {
        @Test
        void shouldBeAbleToSendInstructionsForMakingATeaWithoutSugar() {
            drinkMaker.order("T::");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with no sugar and therefore no stick");
        }

        @Test
        void shouldBeAbleToSendInstructionsForMakingACoffeeWithoutSugar() {
            drinkMaker.order("C::");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
        }

        @Test
        void shouldBeAbleToSendInstructionsForMakingAChocolateWithoutSugar() {
            drinkMaker.order("H::");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with no sugar and therefore no stick");
        }

    }

    @Nested
    class WithSugar {
        @Test
        void shouldBeAbleToSendInstructionsForMakingATeaWitAtSugar() {
            drinkMaker.order("T:1:0");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
        }

        @Test
        void shouldBeAbleToSendInstructionsForMakingACoffeeWitAtSugar() {
            drinkMaker.order("C:1:0");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with 1 sugar and a stick");
        }

        @Test
        void shouldBeAbleToSendInstructionsForMakingAChocolateWitAtSugar() {
            drinkMaker.order("H:1:0");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 1 sugar and a stick");
        }
    }

    @Nested
    class CustomerInformation {
        @Test
        void shouldBeAbleToSendInstructionsToInformTheCustomerThatTheyWillReceiveAMessageForTheirOrder() {
            drinkMaker.order("M:message-content");

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent)
                    .isEqualTo("Drink maker forwards any message received onto the coffee machine interface for the customer to see");
        }
    }

}
