package spring.demo.exception;

/***
 * 自定义错误代码接口 <br>
 * 规定：<br>
 * common：10000-20000 <br>
 * eUMS：20000-30000 <br>
 * logistics-track：40000-50000 <br>
 * logistics-engine：50000-6000 <br>
 * ePMS：60000-70000 <br>
 * customer：70000-80000 <br>
 * sale：80000-90000 <br>
 * old_pms_data：100000-110000 <br>
 * eFMS: 110000- 120000 <br>
 * DAS: 120000 - 130000<br>
 * 
 * @author Kevin
 */
public interface IErrorCode {
    /**
     * 获取错误代码code
     * 
     * @return code
     */
    public int getCode();

    /**
     * 获取错误代码的httpStatus
     * 
     * @return httpStatus
     */
    public int getHttpStatus();

    /**
     * 获取错误代码原因
     * 
     * @return reason
     */
    public String getReason();
}
