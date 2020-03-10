import java.io.Serializable;

/**
 * @Author: liyi
 * @Date: 2019-01-04 14:50
 */
public class HttpResponse<T> implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * success : true
     * code : 200
     * msg : success
     * data : {"id":213}
     */

    private boolean success;
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
