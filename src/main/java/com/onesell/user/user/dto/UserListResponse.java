package com.onesell.user.user.dto;

import com.onesell.user.user.persistence.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
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

    private List<UserResponse> users;
    private Paging paging;

    public static UserListResponse byEntity(final Page<UserEntity> userEntityPage) {
        final List<UserResponse> users = userEntityPage.getContent()
            .stream()
            .map(UserResponse::byEntity)
            .collect(Collectors.toList());

        final Paging paging = Paging.builder()
            .size(userEntityPage.getSize())
            .number(userEntityPage.getNumber())
            .totalElement(userEntityPage.getTotalElements())
            .totalPages(userEntityPage.getTotalPages())
            .build();

        return UserListResponse.builder()
            .users(users)
            .paging(paging)
            .build();
    }
}
