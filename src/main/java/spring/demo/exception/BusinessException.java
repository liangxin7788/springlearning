package spring.demo.exception;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Arrays;

/***
 * 业务异常类
 * 
 * @author Kevin
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -4033171327412143319L;
    /**
     * 自定义错误代码
     */
    private IErrorCode errorCode;

    /**
     * 参数
     */
    private Object[] args;

    /**
     * 异常发生类
     */
    private String clazz;

    /**
     * 时间戳
     */
    private long timestamp = new Timestamp(System.currentTimeMillis()).getTime();

    /**
     * 异常携带的信息
     */
    private String msg;

    public BusinessException(String msg) {
        super(msg);
        timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public BusinessException(IErrorCode errorCode) {
        this.errorCode = errorCode;
        timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public BusinessException(IErrorCode errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
        timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public BusinessException(IErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        if (cause != null) {
            this.clazz = cause.getClass().getName();
        }
        timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    @Override
    public String toString() {
        return "BusinessException [errorCode=" + errorCode + ", args=" + Arrays.toString(args) + ", timestamp="
                + timestamp + ", msg=" + msg + ", message=" + super.getMessage() + " - " + getStackTraceDesc() + "]";
    }

    private String getStackTraceDesc() {
        StackTraceElement[] eles = getStackTrace();
        if (ArrayUtils.isEmpty(eles)) {
            return "";
        }

        if (eles.length == 1) {
            return eles[0].toString();
        }

        return eles[0].toString() + "->" + eles[1].toString();
    }
}
