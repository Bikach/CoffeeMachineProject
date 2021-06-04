package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.domain.Order;
import fr.chakib.houd.kata.manufacture.core.domain.OrderTranslator;
import fr.chakib.houd.kata.manufacture.core.usecase.SendTranslatedOrders;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SendTranslatedOrdersTest {

    private void assertsThatOrderSentAreCorrect(Order order, String orderTranslated) {
        // Arrange
        var drinkMaker = new InMemoryDrinkMaker();
        var sendTranslatedOrders = new SendTranslatedOrders(new OrderTranslator(order), drinkMaker);
        // Act
        var orderSent = sendTranslatedOrders.send();
        // Assert
        assertThat(orderSent).isEqualTo(orderTranslated);
        assertThat(drinkMaker.verifyOrderSent()).isTrue();
    }

    @Nested
    class ShouldMakeADrink {
        @Nested
        class WithoutSugar {
            @Nested
            class WithoutExtraHot {
                @Test
                void thenSendOrderThatContainsATeaWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("T::", new BigDecimal("0.4")),
                            "(Drink maker will make one tea with no sugar)"
                    );
                }

                @Test
                void thenSendOrderThatContainsACoffeeWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("C::", new BigDecimal("0.6")),
                            "(Drink maker will make one coffee with no sugar)"
                    );
                }

                @Test
                void thenSendOrderThatContainsAChocolateWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("H::", new BigDecimal("0.5")),
                            "(Drink maker will make one chocolate with no sugar)"
                    );
                }

                @Test
                void thenSendOrderThatContainsAOrangeJuice() {
                    assertsThatOrderSentAreCorrect(
                            new Order("O::", new BigDecimal("0.6")),
                            "(Drink maker will make one orange juice)"
                    );
                }
            }

            @Nested
            class WithExtraHot {
                @Test
                void thenSendOrderThatContainsATeaWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Th::", new BigDecimal("0.4")),
                            "(Drink maker will make an extra hot tea with no sugar)"
                    );
                }

                @Test
                void thenSendOrderThatContainsACoffeeWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Ch::", new BigDecimal("0.6")),
                            "(Drink maker will make an extra hot coffee with no sugar)"
                    );
                }

                @Test
                void thenSendOrderThatContainsAChocolateWithoutStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Hh::", new BigDecimal("0.5")),
                            "(Drink maker will make an extra hot chocolate with no sugar)"
                    );
                }
            }


        }

        @Nested
        class WithSugar {
            @Nested
            class WithoutExtraHot {
                @Test
                void thenSendOrderThatContainsATeaWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("T:1:0", new BigDecimal("0.4")),
                            "(Drink maker will make one tea with one sugar and a stick)"
                    );
                }

                @Test
                void thenSendOrderThatContainsACoffeeWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("C:2:0", new BigDecimal("0.6")),
                            "(Drink maker will make one coffee with two sugar and a stick)"
                    );
                }

                @Test
                void thenSendOrderThatContainsAChocolateWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("H:1:0", new BigDecimal("0.5")),
                            "(Drink maker will make one chocolate with one sugar and a stick)"
                    );
                }
            }

            @Nested
            class WithExtraHot {
                @Test
                void thenSendOrderThatContainsATeaWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Th:1:0", new BigDecimal("0.4")),
                            "(Drink maker will make an extra hot tea with one sugar and a stick)"
                    );
                }

                @Test
                void thenSendOrderThatContainsACoffeeWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Ch:2:0", new BigDecimal("0.6")),
                            "(Drink maker will make an extra hot coffee with two sugar and a stick)"
                    );
                }

                @Test
                void thenSendOrderThatContainsAChocolateWithAStick() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Hh:1:0", new BigDecimal("0.5")),
                            "(Drink maker will make an extra hot chocolate with one sugar and a stick)"
                    );
                }
            }
        }

        @Nested
        class WithExactAmount {
            @Nested
            class WithoutExtraHot {
                @Test
                void forMakeATeaWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("T:1:0", new BigDecimal("0.4")),
                            "(Drink maker will make one tea with one sugar and a stick)"
                    );
                }

                @Test
                void forMakeACoffeeWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("C::", new BigDecimal("0.6")),
                            "(Drink maker will make one coffee with no sugar)"
                    );
                }

                @Test
                void forMakeAChocolateWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("H:2:0", new BigDecimal("0.5")),
                            "(Drink maker will make one chocolate with two sugar and a stick)"
                    );
                }

                @Test
                void forMakeAOrangeJuice() {
                    assertsThatOrderSentAreCorrect(
                            new Order("O::", new BigDecimal("0.6")),
                            "(Drink maker will make one orange juice)"
                    );
                }
            }

            @Nested
            class WithExtraHot {
                @Test
                void forMakeATeaWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Th:1:0", new BigDecimal("0.4")),
                            "(Drink maker will make an extra hot tea with one sugar and a stick)"
                    );
                }

                @Test
                void forMakeACoffeeWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Ch::", new BigDecimal("0.6")),
                            "(Drink maker will make an extra hot coffee with no sugar)"
                    );
                }

                @Test
                void forMakeAChocolateWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Hh:2:0", new BigDecimal("0.5")),
                            "(Drink maker will make an extra hot chocolate with two sugar and a stick)"
                    );
                }
            }
        }


        @Nested
        class TooMuchMoney {
            @Nested
            class WithoutExtraHot {
                @Test
                void forMakeATeaWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("T:1:0", new BigDecimal("1.0")),
                            "(Drink maker will make one tea with one sugar and a stick)"
                    );
                }

                @Test
                void forMakeACoffeeWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("C::", new BigDecimal("0.9")),
                            "(Drink maker will make one coffee with no sugar)"
                    );
                }

                @Test
                void forMakeAChocolateWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("H:2:0", new BigDecimal("7.5")),
                            "(Drink maker will make one chocolate with two sugar and a stick)"
                    );
                }

                @Test
                void forMakeAOrangeJuice() {
                    assertsThatOrderSentAreCorrect(
                            new Order("O::", new BigDecimal("0.9")),
                            "(Drink maker will make one orange juice)"
                    );
                }
            }

            @Nested
            class WithExtraHot {
                @Test
                void forMakeATeaWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Th:1:0", new BigDecimal("1.0")),
                            "(Drink maker will make an extra hot tea with one sugar and a stick)"
                    );
                }

                @Test
                void forMakeACoffeeWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Ch::", new BigDecimal("0.9")),
                            "(Drink maker will make an extra hot coffee with no sugar)"
                    );
                }

                @Test
                void forMakeAChocolateWithAnySugarNumber() {
                    assertsThatOrderSentAreCorrect(
                            new Order("Hh:2:0", new BigDecimal("7.5")),
                            "(Drink maker will make an extra hot chocolate with two sugar and a stick)"
                    );
                }
            }
        }

    }

    @Nested
    class ShouldNotMakeADrink {
        @Nested
        class WithAnInsufficientAmount {
            @Nested
            class WithoutExtraHot {
                @Test
                void thenSendInstructionAboutTheMissingAmountForATea(){
                    assertsThatOrderSentAreCorrect(
                            new Order("T:2:0", new BigDecimal("0.2")),
                            "(There are 0.20 cents missing to make one tea)"
                    );
                }

                @Test
                void thenSendInstructionAboutTheMissingAmountForACoffee(){
                    assertsThatOrderSentAreCorrect(
                            new Order("C::", new BigDecimal("0.1")),
                            "(There are 0.50 cents missing to make one coffee)"
                    );
                }

                @Test
                void thenSendInstructionAboutTheMissingAmountForAChocolate(){
                    assertsThatOrderSentAreCorrect(
                            new Order("H:1:0", new BigDecimal("0.3")),
                            "(There are 0.20 cents missing to make one chocolate)"
                    );
                }

                @Test
                void thenSendInstructionAboutTheMissingAmountForaOrangeJuice(){
                    assertsThatOrderSentAreCorrect(
                            new Order("O::", new BigDecimal("0.2")),
                            "(There are 0.40 cents missing to make one orange juice)"
                    );
                }
            }

            @Nested
            class WithExtraHot {
                @Test
                void thenSendInstructionAboutTheMissingAmountForATea(){
                    assertsThatOrderSentAreCorrect(
                            new Order("Th:2:0", new BigDecimal("0.2")),
                            "(There are 0.20 cents missing to make one tea)"
                    );
                }

                @Test
                void thenSendInstructionAboutTheMissingAmountForACoffee(){
                    assertsThatOrderSentAreCorrect(
                            new Order("Ch::", new BigDecimal("0.1")),
                            "(There are 0.50 cents missing to make one coffee)"
                    );
                }

                @Test
                void thenSendInstructionAboutTheMissingAmountForAChocolate(){
                    assertsThatOrderSentAreCorrect(
                            new Order("Hh:1:0", new BigDecimal("0.3")),
                            "(There are 0.20 cents missing to make one chocolate)"
                    );
                }
            }
        }
    }
    @Nested
    class CustomerInformation {

        @Test
        void shouldBeAbleToSendOrderToInformTheCustomerThatTheyWillReceiveAMessageForTheirOrder() {
            assertsThatOrderSentAreCorrect(
                    new Order("M:message-content", new BigDecimal("0")),
                    "Drink maker forwards any message received onto the coffee machine interface for the customer to see"
            );
        }
    }
}
