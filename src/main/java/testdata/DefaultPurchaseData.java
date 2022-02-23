package testdata;

import enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DefaultPurchaseData {
    String email;
    PaymentMethod paymentMethod;
    boolean fourteenDaysInstallation;
}
