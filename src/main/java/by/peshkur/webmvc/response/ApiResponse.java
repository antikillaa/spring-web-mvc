package by.peshkur.webmvc.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    public static final String SUCCESS = "Success";
    public static final String FAIL = "Fail";

    private String code;
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(String code) {
        this.code = code;
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
