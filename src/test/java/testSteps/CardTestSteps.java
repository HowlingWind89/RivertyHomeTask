package testSteps;

import apiutils.CardApi;
import io.cucumber.java.en.And;

import java.io.IOException;

public class CardTestSteps {
    private CardApi cardApi;

    public CardTestSteps(CardApi cardApi) {
        this.cardApi = cardApi;
    }

    @And("I set card owner as {}")
    public void setOwner(String cardOwner) {
        cardApi.setCardOwner(cardOwner);
    }

    @And("I set card number as {}")
    public void setNumber(String cardNumber) {
        cardApi.setCardNumber(cardNumber);
    }

    @And("I set card date as {}")
    public void setDate(String cardDate) {
        cardApi.setCardDate(cardDate);
    }

    @And("I set card cvv code as {}")
    public void setCvvCode(String cardCvvCode) {
        cardApi.setCardCvvCode(cardCvvCode);
    }

    @And("I post card data")
    public void postCardData() throws IOException {
        cardApi.postCardData();
    }
}
