package testdata;

import enums.PaymentMethod;
import lombok.*;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@With
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseData {
    @NonNull
    String email;

    PaymentMethod paymentMethod;
    boolean fourteenDaysInstallation;
    boolean membershipNumberNecessary;
    String membershipNumber;
    String phone;

    public String getMembershipNumber() {
        Optional<String> number = Optional.ofNullable(membershipNumber);
        return number.orElse(EMPTY);
    }

    public String getPhone() {
        Optional<String> number = Optional.ofNullable(phone);
        return number.orElse(EMPTY);
    }
}
