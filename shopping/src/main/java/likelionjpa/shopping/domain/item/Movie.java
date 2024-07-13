package likelionjpa.shopping.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class Movie extends Item{
    private String director;
    private String actor;
}
