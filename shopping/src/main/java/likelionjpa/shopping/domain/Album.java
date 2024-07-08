package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable //값 타입으로 사용하기 위해
//첨부된 DB 결과물 사진읇 보니 값 타입으로 사용된거 같음
@Getter
@Setter
public class Album {
    private String artist;
    private String etc;
}
