package etg.result;

//import io.swagger.annotations.ApiModelProperty;

public class Result<T> {
    private static final long serialVersionUID = -5372450875750675775L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

//    @ApiModelProperty("响应代码")
    private ResultCode code;
//    @ApiModelProperty("响应信息")
    private String message;
//    @ApiModelProperty("业务数据")
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Result(ResultCode code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
