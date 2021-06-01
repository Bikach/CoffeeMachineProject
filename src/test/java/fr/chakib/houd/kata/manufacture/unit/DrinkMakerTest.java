package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.domain.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.DrinkProtocoleException;
import fr.chakib.houd.kata.manufacture.core.domain.Protocole;
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
                drinkMaker.order(new Protocole("T:0:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with no sugar and therefore no stick");
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithoutStick() {
                drinkMaker.order(new Protocole("C:0:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithoutStick() {
                drinkMaker.order(new Protocole("H:0:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with no sugar and therefore no stick");
            }

        }

        @Nested
        class WithSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithAStick() {
                drinkMaker.order(new Protocole("T:1:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithAStick() {
                drinkMaker.order(new Protocole("C:2:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with 2 sugar and a stick");
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithAStick() {
                drinkMaker.order(new Protocole("H:1:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 1 sugar and a stick");
            }
        }

        @Nested
        class WithExactAmount {
            @Test
            void forMakeATeaWithAnySugarNumber() {
                drinkMaker.order(new Protocole("T:1:0.4"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
            }

            @Test
            void forMakeACoffeeWithAnySugarNumber() {
                drinkMaker.order(new Protocole("C:0:0.6"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
            }


            @Test
            void forMakeAChocolateWithAnySugarNumber() {
                drinkMaker.order(new Protocole("H:4:0.5"));

                var instructionsSent = drinkMaker.sendInstruction();

                assertThat(instructionsSent).isEqualTo("Drink maker makes 1 chocolate with 4 sugar and a stick");
            }
        }
    }


    @Nested
    class ShouldNotMakeADrink {
        @Nested
        class WithABadDrinkInstruction {
            @Test
            void thenSendInstructionThatTheDrinkProtocolIsNotSupported() {
                assertThatThrownBy(() -> {
                    drinkMaker.order(new Protocole("Z::"));
                    drinkMaker.sendInstruction();
                }).isInstanceOf(DrinkProtocoleException.class)
                    .hasMessageContaining("the drink protocol is not supported by the machine.");
            }
        }
    }

    @Nested
    class CustomerInformation {
        @Test
        void shouldBeAbleToSendInstructionsToInformTheCustomerThatTheyWillReceiveAMessageForTheirOrder() {
            drinkMaker.order(new Protocole("M:message-content"));

            var instructionsSent = drinkMaker.sendInstruction();

            assertThat(instructionsSent)
                    .isEqualTo("Drink maker forwards any message received onto the coffee machine interface for the customer to see");
        }
    }



}
