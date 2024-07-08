package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Embeddable //Item에 값 타입으로 사용하기 위해
@Getter
@Setter
public class Movie {
    private String director;
    private String actor;
}
