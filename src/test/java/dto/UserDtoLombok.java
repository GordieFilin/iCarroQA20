package dto;

import lombok.*;

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
