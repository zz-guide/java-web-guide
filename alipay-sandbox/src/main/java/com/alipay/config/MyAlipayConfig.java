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

public class MyAlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "9021000136669516";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCL6KjSUXMESRcBtE8Xe2ckbZopsTv/qjAY9sPrSUQxhnXmfHtpK+61MQWkRcP/kCf4MZJCoXagh7JYH2xuSbLbm5GeOJ9fZfAI2IqKX2vZ2pQOxc3EVN25gMjI2rpWRtED0hpm2fpSTeuvsMC9+XGPssIPS+h/RLpMB+tzEMF94qq5gc/8DNjQQZGJj0UnJTUBDI0pbef4wGY7ikD63JuFfbfviBv8emZDF4XE7tXBCWI23bsWaZZ8OB2KoQKmimDeiPCH1njLPgEkmbr/p5M7Zt92RJ3myiN+8716Ew2NBCDD/yy7xMldflUM1tepNsJJwhv1JGfn45ZMwqeQgo5fAgMBAAECggEAHiQukrj3ZXn1melljLKKQv/V0ZucSHU6zXYEOWFcbqsAJXq1/692StTX2U8qbZl58u+DChXM/8KcOn3yl0QLY2J9ma+rLhtA/jbgifUKwDFl6lTVArIh3oAPQa5VrJavGvqds4DMfATLfNtAeu0NeR7SzgbVfO2qkQy3vd9jQCJLha0HLv58aokTp3Dp9W2sTzSMqNk2FfnkuMLnPmOBb67aOYJKufPKuo9Wb30XqCdCbA1n1PmmW4S7eY8ARuhnZB/g6GMS55J5ghSlc+ajJV9rkpF1jWt8EZhEqj9nrMiEj5vbr687ek4NiB8ah6e8nvdiKrsamUbdIqW1ag1xEQKBgQD4IDKgMy2RKqZL+lb2GS7aNCULJOXrzEXTNlrVCond7QedoFCPQV9FgSx+aa9PKk/zHXPXg7adxH2b8hrrtBzGT0UQ39fm+DZ/pQpAsmYzY5JeiIHzes482g1zWkj92BSPZ7wRbf5md3b3WgkKsSvxKA/8Dtq2QfpH077BN1zXaQKBgQCQWUt45A60ZlrGMZiifWyF5sM1/BWOyE1XaOpy7qjeba8E/4426NxYEhOgHke39ObApkf3gsn5eeXueINM49/PKv4VpbXNX/o7aNtd7x1PTpBLJpDttdn3xu0swoA/wIlakH3dpYPlEtvMerYb5m5/2mJX2gIDhgJt8J0zieyGhwKBgFY++tnscB5RcNRgA/Iu9rYqAeZJwRGhQ3QTJKeArkNRrKABpX7l/jOunsSh/6nIz1l2F1oGEmfscKzQDsN3K7lSvHMNG4LRLEBaIaIzYIrkRXBOir0TJrTIJny+GTkC7sKaECkOzqrXQ6beyN3Kj7eXcVbv4t4POOvWkiufDsphAoGAVFIFF1JJELJ1ti7Ela6klTdusvtVcHmrTDM6OPcW6A+0XDwYTBUMmdm9YxwtEtVZchHwGjJpX3UIjpwRPvoiA/d+QxDwuU6mcsvW0PFb8rbW7T9TC7jd4bJvW2Um25bR5XhgPfhwqoCwqqrH9FZQGBlutxjfckV259fVTIT2CMMCgYBkB6NkSUOj2DV8f0++q33iomzN2trxjFv557gutvn5dpaVWEb9IJOl0oguDGEu3RTjvoz7b7jDmXyw8nBKGcHUKgO241JuvvhVJyzTtLrdba6ZHanHFgf5IfNKDyMvFOlLANiR0ibERFCYBuazovFy5yP9HKlLReL2W2KjL9HRVA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwoOBHqcdUDTFUPNH/wT5nhFf0KWLpRlwCX+2KzjrJWsa1Nih9llnNB85dc//GXjOX1sA8sjVC1eX3gcNbq9MJKNSeGmjLiEPSlxa6loCzU02wcDKytajwBvb0PxelwutrjtZYNYtN3+QCd2N+KwXB9ydUu3miVx8JkD3lCP0LHD8BL/FvO94m9dl0pN1VoCWCjl27zj7g05GTOef4mQBZ3Bc5nLE9a6XJuUK5XL3M495wXtCJKJTOxlrm4vDHUG4AdfSgNJ2Bi7+zmIfd8oifss7tNkNcG2U6r6rm56hCJsJYH6j6P23v4Fx5LPAhhjT55pcA+AULGeD5ELHsT5sywIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://muydfe.natappfree.cc/alipay_sandbox_war/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://muydfe.natappfree.cc/alipay_sandbox_war/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\jungle\\github\\zz-guide\\java-web-guide\\alipay-sandbox";


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

