package com.lions_internationals.util.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends ModelBase {
    private HttpStatus httpStatus;
    private String message;
    private Integer code;
    private T data;
}
