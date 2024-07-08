package likelionjpa.shopping.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable //값 타입으로 사용하기 위해
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
