package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.domain.Order;
import fr.chakib.houd.kata.manufacture.core.usecase.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.Protocol;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DrinkMakerTest {

    DrinkMaker drinkMaker = new DrinkMaker();

    private void assertsThatInstructionsSentAreCorrect(Order order, String instruction) {
        drinkMaker.protocolSelected(new Protocol(order));
        assertThat(drinkMaker.sendInstruction()).isEqualTo(instruction);
    }

    @Nested
    class ShouldMakeADrink {
        @Nested
        class WithoutSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("T::", new BigDecimal("0.4")),
                        "Drink maker makes 1 tea with no sugar and therefore no stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("C::", new BigDecimal("0.6")),
                        "Drink maker makes 1 coffee with no sugar and therefore no stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithoutStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("H::", new BigDecimal("0.5")),
                        "Drink maker makes 1 chocolate with no sugar and therefore no stick"
                );
            }

        }

        @Nested
        class WithSugar {
            @Test
            void thenSendInstructionsThatContainsATeaWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("T:1:0", new BigDecimal("0.4")),
                        "Drink maker makes 1 tea with 1 sugar and a stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsACoffeeWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("C:2:0", new BigDecimal("0.6")),
                        "Drink maker makes 1 coffee with 2 sugar and a stick"
                );
            }

            @Test
            void thenSendInstructionsThatContainsAChocolateWithAStick() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("H:1:0", new BigDecimal("0.5")),
                        "Drink maker makes 1 chocolate with 1 sugar and a stick"
                );
            }
        }

        @Nested
        class WithExactAmount {
            @Test
            void forMakeATeaWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("T:1:0", new BigDecimal("0.4")),
                        "Drink maker makes 1 tea with 1 sugar and a stick"
                );
            }

            @Test
            void forMakeACoffeeWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("C::", new BigDecimal("0.6")),
                        "Drink maker makes 1 coffee with no sugar and therefore no stick"
                );
            }

            @Test
            void forMakeAChocolateWithAnySugarNumber() {
                assertsThatInstructionsSentAreCorrect(
                        new Order("H:4:0", new BigDecimal("0.5")),
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
                        new Order("T:2:0", new BigDecimal("0.2")),
                        "There are 0.20 cents missing to make a tea."
                );
            }
            @Test
            void thenSendInstructionAboutTheMissingAmountForaCoffee(){
                assertsThatInstructionsSentAreCorrect(
                        new Order("C::", new BigDecimal("0.1")),
                        "There are 0.50 cents missing to make a coffee."
                );
            }

            @Test
            void thenSendInstructionAboutTheMissingAmountForaChocolate(){
                assertsThatInstructionsSentAreCorrect(
                        new Order("H:1:0", new BigDecimal("0.3")),
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
                    new Order("M:message-content", new BigDecimal("0")),
                    "Drink maker forwards any message received onto the coffee machine interface for the customer to see"
            );
        }
    }
}
