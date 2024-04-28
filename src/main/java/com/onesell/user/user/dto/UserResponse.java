package com.onesell.user.user.dto;

import com.onesell.user.user.persistence.UserEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String userId;
    private String nickname;
    private String name;
    private String cellphone;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static UserResponse byEntity(final UserEntity userEntity) {
        return UserResponse.builder()
            .userId(userEntity.getUserId())
            .nickname(userEntity.getNickname())
            .name(userEntity.getName())
            .cellphone(userEntity.getCellphone())
            .email(userEntity.getEmail())
            .createdAt(userEntity.getCreatedAt())
            .modifiedAt(userEntity.getModifiedAt())
            .build();
    }
}
