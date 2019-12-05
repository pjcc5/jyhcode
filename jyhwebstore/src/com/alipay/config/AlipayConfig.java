package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101700704769";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1ro0tyNCwA3T8lL7fhE0MBGph8hq8seeS+SO504FvkYNgJhVlUdCn7oq1N0ueEZdGWIyRQe0h5xBl7Y+9SNnJDHGQE36ta7T8aNvmi+NQ1A2G3antUmlv7bpTKeRK0KyQYwSBRZmbtChoN7YshtIRCPBjT+PNueAoe0PcEHyCspobE+67xNQGVy4U35BynEicdegAMVB+tZ8tymVVC/YGBDPKLAdv5iPqRbGbaLRDfZsSoOIwL9A+329VgZDEPSR9X2Qt5BBMgakftG73rwaQXVwffbXzkRCTF5kbMiJwfKCUWnfb5W8hwKhy1tYcYGkC4XQfkXL1OvNN19IrzG0dAgMBAAECggEBAKfZ8E0Qbt1vFDIXKpFOpfAoVDDRgKo8ovpCeyM/qSHuijXWeYX2JJRB6pypzY7oKZ6wSI4bHn5n/9prtJToLW11taWqnSqTi853AlLpgsY2Y5jqSggcT5U9SRt0ZJpKWGO9V3gnWVdlBr/iWMiidomOfKkEMi7rP5Gm8HbsNFx6GiCMRU9SjYg2+pUkmhH6q8zcKYMCVocg1dIWMYBABcYSU1kZ8saxf4uHa9RVHQgIXb43U8UaZdCpfp395OQsPHkR/JqF6NsdetKstqf9/sicorvkbtBHC+M4PZRyFIAcJn7rebWKuyFTxX628dN+yuJZel1o1bOzxs2LZhCGe4ECgYEA/N0UgGQBMATLTcxyrV5KKlyjmRdNwKXWUVbTnHFZrmjB8VZAgtaMzPqhjMrbNVs90OeaFn4+8/cpXbP9Ol98ElbnlU2egAKrKO9CZSlb9Tvxpqr2ItUhxKxGDBJDcMOXkERpQwcVurwhHMRFnDnpe/b+GyEeWgXnWmKbxJgycbkCgYEAt+9yhxH32FIY2CofQ2rS1FP7JCRrpdxTN14xpBQCFHIu2vPa9iC/NZBhDknkzsME/tJeRivitaPEadjeUKsjU/vjvBWefZia5Nmab5j2tyA/wbsxOfi/Gr7FGaPZf8IZlP4P2T9W5eG/G9kQ1+KQO8SVrwxFLz1jFA0RDAVeGIUCgYAtw4FTX0YLv8JfuTHECL2Zfxyot1v+EsWAARvZQ3Z8pz76g6a3R0dCTdXxGkGkHXhJl7D+gyi3lLLq34lkCCX3V70f+2VFO7ZoeSzmDB81efzZMjXLxhEPfDJNOvzzqqKCnK8ET4LyQdwoTalfheeo5OHGXS8WEd12MUSJxxXSGQKBgDITPEjNeX4pC55+CTjfcjpgCrVSPQRQsU8Xk8gpsk9CrsLpNKlhTO0WO3YaY/JuYYPGXegYtoXg6e4vHoczsFCC+QMRl651x2WaYFMVf8VnQDRL9CDmOZDccuiCFQqVG0XWzRXGCrBW/yJjvBQqGD5NTLr1SjiMK9cfn454P5/JAoGBAKWVtbbRs2xRSNCLv6Dyd9nIxhTybYhvZ87tjTW/fIOV31ZY6Ze7Q3eJhoYiLKr8cb0/LuzJcXEaQw6Kyyv0r/Z7SDOsAetTuVYCJtLMJchxWkfErinASWO4oVCqVNCTYa++ApaQj3iFEzmr0TQb7trT1YU3Dt+46d81+a+L4NfK";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0FRovvPYxyjojSMrrK9xIrlqkZvrzLjV2Ld77lLuhs020Ml9VJLfiTZQ/aW3edkLeL+BdA8oNla7bPvZBcGYb5NSdpqN/1P8N/LNyMAvdY8KlWsPqqT4TSEWE/XxjUQF7ciET0g6nOLDNkOLJdDB4uaWbYeKpNLxkytI1gJSz+2Ar8QdNQOKngzZ9Sgp7kU4RV0V5Tvir5olOczpFHmEOxWjzehzYxMlhKdX+NtHlh0FVWJECDTrlWdbeDsv7SzLTaVFAY8/l/0557qY22/R78hGqG3ABN/ELr3WrFCvyRMpGeeqO5qGIBcJowHdguUtZYqVmvKpjuDsy3O7lUSk0wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/jyhwebstore/store/html/operation/order.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/jyhwebstore/store/html/operation/order.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

