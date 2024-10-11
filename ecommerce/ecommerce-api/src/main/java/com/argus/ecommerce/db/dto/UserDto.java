package com.argus.ecommerce.db.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto extends BaseDto {
    private String username;
    private String email;
    private String enabled;
    private LocalDateTime creationTime;
}