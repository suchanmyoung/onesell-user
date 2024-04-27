package com.onesell.user.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paging {

    private int size;
    private int number;
    private long totalElement;
    private int totalPages;

}
