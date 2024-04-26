package com.onesell.user.user.persistence;

import com.onesell.user.user.dto.UserJoinRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ONESELL_USER")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq_seq", allocationSize = 1)
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
    private String cellphone;

    @Column
    private String email;

    public static UserEntity byUserJoinRequest(final UserJoinRequest userJoinRequest) {
        return UserEntity.builder()
            .userId(userJoinRequest.getUserId())
            .password(userJoinRequest.getPassword())
            .name(userJoinRequest.getName())
            .nickname(userJoinRequest.getNickname())
            .email(userJoinRequest.getEmail())
            .build();
    }

    public void applyEncryptPassword(final String encryptPassword) {
        this.password = encryptPassword;
    }
}
