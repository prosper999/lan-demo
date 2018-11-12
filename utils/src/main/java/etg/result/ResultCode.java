package etg.result;

public enum ResultCode {
    //资源响应成功
    SUCCESS(200),
    //Bad Request请求出现错误
    FAILED(400),
    //访问被拒绝
    UNAUTHORIZED(401),
    //资源不可用
    FORBIDDEN(403),
    //无法找到指定位置的资源
    NOT_FOUND(404),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                '}';
    }

    ResultCode(int code){
        this.code = code;
    }

}
