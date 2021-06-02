package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.usecase.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.Protocol;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DrinkMakerTest {

    DrinkMaker drinkMaker = new DrinkMaker();

    private void assertsThatInstructionsSentAreCorrect(String order, String instruction) {
        drinkMaker.order(new Protocol(order));
        assertThat(drinkMaker.sendInstruction()).isEqualTo(instruction);
    }

    @Nested
    class ShouldMakeADrink {
        @Nested
        class WithoutSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        "T:0:0.4",
                        "Drink maker makes 1 tea with no sugar and therefore no stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        "C:0:0.6",
                        "Drink maker makes 1 coffee with no sugar and therefore no stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        "H:0:0.5",
                        "Drink maker makes 1 chocolate with no sugar and therefore no stick"
                );
            }

        }

        @Nested
        class WithSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        "T:1:0.4",
                        "Drink maker makes 1 tea with 1 sugar and a stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        "C:2:0.6",
                        "Drink maker makes 1 coffee with 2 sugar and a stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        "H:1:0.5",
                        "Drink maker makes 1 chocolate with 1 sugar and a stick"
                );
            }
        }

        @Nested
        class WithExactAmount {
            @Test
            void forMakeATeaWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        "T:1:0.4",
                        "Drink maker makes 1 tea with 1 sugar and a stick"
                );
            }

            @Test
            void forMakeACoffeeWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        "C:0:0.6",
                        "Drink maker makes 1 coffee with no sugar and therefore no stick"
                );
            }

            @Test
            void forMakeAChocolateWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        "H:4:0.5",
                        "Drink maker makes 1 chocolate with 4 sugar and a stick"
                );
            }
        }
    }


    @Nested
    class ShouldNotMakeADrink {

        @Nested
        class WithAnInsufficientAmount {
            @Test
            void thenSendInstructionAboutTheMissingAmountForaTea(){
                assertsThatInstructionsSentAreCorrect(
                        "T:2:0.2",
                        "There are 0.20 cents missing to make a tea."
                );
            }
            @Test
            void thenSendInstructionAboutTheMissingAmountForaCoffee(){
                assertsThatInstructionsSentAreCorrect(
                        "C:0:0.1",
                        "There are 0.50 cents missing to make a coffee."
                );
            }

            @Test
            void thenSendInstructionAboutTheMissingAmountForaChocolate(){
                assertsThatInstructionsSentAreCorrect(
                        "H:1:0.3",
                        "There are 0.20 cents missing to make a chocolate."
                );
            }

        }
    }
    @Nested
    class CustomerInformation {

        @Test
        void shouldBeAbleToSendInstructionsToInformTheCustomerThatTheyWillReceiveAMessageForTheirOrder() {
            assertsThatInstructionsSentAreCorrect(
                    "M:message-content",
                    "Drink maker forwards any message received onto the coffee machine interface for the customer to see"
            );
        }
    }
}
