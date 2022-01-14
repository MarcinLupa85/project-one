package testdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientInfo {
    String address;
    String city;
    String zipcode;
    String comment;
    boolean fourteenDaysInstallation;
}
