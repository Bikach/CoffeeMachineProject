package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.usecase.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.DrinkProtocoleException;
import fr.chakib.houd.kata.manufacture.core.domain.Protocol;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DrinkMakerTest {

    DrinkMaker drinkMaker = new DrinkMaker();

    @Nested
    class ShouldMakeADrink {
        @Nested
        class WithoutSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithoutStick() {
                drinkMaker.order(new Protocol("T:0:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with no sugar and therefore no stick");
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithoutStick() {
                drinkMaker.order(new Protocol("C:0:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithoutStick() {
                drinkMaker.order(new Protocol("H:0:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with no sugar and therefore no stick");
            }

        }

        @Nested
        class WithSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithAStick() {
                drinkMaker.order(new Protocol("T:1:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithAStick() {
                drinkMaker.order(new Protocol("C:2:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with 2 sugar and a stick");
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithAStick() {
                drinkMaker.order(new Protocol("H:1:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 1 sugar and a stick");
            }
        }

        @Nested
        class WithExactAmount {
            @Test
            void forMakeATeaWithAnySugarNumber() {
                drinkMaker.order(new Protocol("T:1:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
            }

            @Test
            void forMakeACoffeeWithAnySugarNumber() {
                drinkMaker.order(new Protocol("C:0:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
            }

            @Test
            void forMakeAChocolateWithAnySugarNumber() {
                drinkMaker.order(new Protocol("H:4:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 4 sugar and a stick");
            }
        }
    }


    @Nested
    class ShouldNotMakeADrink {
        @Nested
        class WithAnInsufficientAmount {
            @Test
            void thenSendInstructionAboutTheMissingAmountForaTea(){
                drinkMaker.order(new Protocol("T:2:0.2"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("There are 0.20 cents missing to make a tea.");
            }

            @Test
            void thenSendInstructionAboutTheMissingAmountForaCoffee(){
                drinkMaker.order(new Protocol("C:0:0.1"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("There are 0.50 cents missing to make a coffee.");
            }

            @Test
            void thenSendInstructionAboutTheMissingAmountForaChocolate(){
                drinkMaker.order(new Protocol("H:1:0.3"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("There are 0.20 cents missing to make a chocolate.");
            }
        }
    }

    @Nested
    class CustomerInformation {
        @Test
        void shouldBeAbleToSendInstructionsToInformTheCustomerThatTheyWillReceiveAMessageForTheirOrder() {
            drinkMaker.order(new Protocol("M:message-content"));

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent)
                    .isEqualTo("Drink maker forwards any message received onto the coffee machine interface for the customer to see");
        }
    }
}
