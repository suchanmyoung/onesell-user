package com.onesell.user.user.persistence;

import com.onesell.user.user.dto.UserJoinRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ONESELL_USER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserEntity {

    @Id
    @Column
    private Long id;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String email;

    public static UserEntity byUserJoinRequest(UserJoinRequest userJoinRequest) {
        return UserEntity.builder()
            .userId(userJoinRequest.getUserId())
            .password(userJoinRequest.getPassword())
            .name(userJoinRequest.getName())
            .nickname(userJoinRequest.getNickname())
            .email(userJoinRequest.getEmail())
            .build();
    }

    public void applyEncryptPassword(String encryptPassword) {
        this.password = encryptPassword;
    }
}
