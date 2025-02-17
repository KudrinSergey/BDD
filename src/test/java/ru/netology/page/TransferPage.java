package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private final SelenideElement amountInput = $("[data-test-id='amount'] input");
    private final SelenideElement fromInput = $("[data-test-id='from'] input");
    private final SelenideElement transferHead = $("[data-test-id=dashboard]");

    public TransferPage() {
        transferHead.should(visible);
    }

    public DashboardPage makeValidTransfer(String sum, DataHelper.CardInfo cardInfo) {
        makeTransfer(sum, cardInfo);
        return new DashboardPage();
    }

    public void makeTransfer(String sum, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(sum);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }
}