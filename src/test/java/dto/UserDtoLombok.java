package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserDtoLombok {
    String name;

    String lastname;

    String email;

    String password;
}
