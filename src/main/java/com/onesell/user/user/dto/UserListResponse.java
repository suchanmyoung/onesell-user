package com.onesell.user.user.dto;

import com.onesell.user.user.persistence.UserEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListResponse {

    private List<UserEntity> users;
    private int size;
    private int number;
    private long totalElement;
    private int totalPages;

    public static UserListResponse from(final Page<UserEntity> userEntityPage) {
        return UserListResponse.builder()
            .users(userEntityPage.getContent())
            .size(userEntityPage.getSize())
            .number(userEntityPage.getNumber())
            .totalElement(userEntityPage.getTotalElements())
            .totalPages(userEntityPage.getTotalPages())
            .build();
    }
}
