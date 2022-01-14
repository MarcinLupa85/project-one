package testdata;

import enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@With
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SduPurchaseData {
    String email;
    boolean membershipNumberNecessary;
    String membershipNumber;
    PaymentMethod paymentMethod;
    boolean fourteenDaysInstallation;

    public String getMembershipNumber() {
        Optional<String> number = Optional.ofNullable(membershipNumber);
        return number.isPresent() ? number.get() : EMPTY;
    }
}
