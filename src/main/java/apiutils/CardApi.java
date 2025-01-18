package apiutils;

import java.io.IOException;
import card.CardData;
import utils.FileReaderUtil;
import utils.JsonUtil;

public class CardApi {

    public String owner;
    public String number;
    public String date;
    public String cvv;

    public void setCardOwner(String cardOwner) {
        owner = cardOwner;
    }

    public void setCardNumber(String cardNumber) {
        owner = cardNumber;
    }

    public void setCardDate(String cardDate) {
        owner = cardDate;
    }

    public void setCardCvvCode(String cardCvvCode) {
        owner = cardCvvCode;
    }

    private CardData getCardJson(String stringToParse) throws IOException {
            CardData card = JsonUtil.createObjectFromJson(stringToParse, CardData.class);
            card.owner = owner;
            card.number = number;
            card.date = date;
            card.cvv = cvv;

            return card;
        }

        public void postCardData() throws IOException {
            String requestUrl = "https://localhost:7135/CardValidation/card/credit/validate";
            String fileName = "src/test/java/jsonFiles/cardData.json";
            String acceptHeader = "application/json";

            String stringToParse = JsonUtil.createJsonFormObject(getCardJson(FileReaderUtil.readFile(fileName)));

            ResponseHandler
                    .getPostApiResponse(
                            acceptHeader,
                            stringToParse,
                            requestUrl,
                            "",
                            200).asString();
        }
}
