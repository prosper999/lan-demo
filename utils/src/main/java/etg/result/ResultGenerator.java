package etg.result;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult(){
        return new Result(ResultCode.SUCCESS,DEFAULT_SUCCESS_MESSAGE,null);
    }

    public static Result genSuccessResult(Object data){
        return new Result(ResultCode.SUCCESS,DEFAULT_SUCCESS_MESSAGE,data);
    }

    public static Result genFailedResult(String message){
        return new Result(ResultCode.FAILED,message, null);
    }
}
