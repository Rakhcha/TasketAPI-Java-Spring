package ru.rakhcheev.tasket.api.tasketapi.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.rakhcheev.tasket.api.tasketapi.dto.description.DescriptionDTO;
import ru.rakhcheev.tasket.api.tasketapi.entity.UserEntity;

@Data
public class UserDTO {

    private Long id;
    private String login;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private DescriptionDTO description;

    private UserDTO() {
    }

    public static UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setLogin(userEntity.getLogin());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setDescription(DescriptionDTO.toDTO(userEntity.getDescription()));
        return userDTO;
    }

}
