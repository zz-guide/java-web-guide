# 支付宝沙箱DEMO
- [sdk](https://opendocs.alipay.com/open/270/106291?pathHash=ddc8bd1e)
官方的示例是基于eclipse的，比较老，这里做些小修改，基于maven。

## 参数
- appid: 9021000136669516
- 应用的私钥: 控制台界面上查看
- 支付宝的公钥：控制台界面上查看
- 支付宝网关
- log_path
- notify_url
- return_url

## return_url
支付成功之后会跳转到这个页面，输出这些参数
```text
trade_no:2024051622001426200503271931
out_trade_no:202451601919275
total_amount:0.01
```

## notify_url
支付宝回调本地地址

## 查询交易
http://localhost:8080/alipay_sandbox_war/alipay.trade.query.jsp

```json
{"alipay_trade_query_response":
{"code":"10000","msg":"Success","buyer_logon_id":"cxj***@sandbox.com",
  "buyer_pay_amount":"0.00","buyer_user_id":"2088722034926203","buyer_user_type":"PRIVATE",
  "invoice_amount":"0.00","out_trade_no":"202451601919275","point_amount":"0.00","receipt_amount":"0.00",
  "send_pay_date":"2024-05-16 00:21:01","total_amount":"0.01","trade_no":"2024051622001426200503271931",
  "trade_status":"TRADE_SUCCESS"},
  "sign":"ZNZqAmIpwzKkFe2QJnDdrJdh9waunjSAbhMpJuFxk2Ec6Jbvql4GN6f4OLBFNisNhfMb4F4A/1pH/cA7x++L+vBKIQDqVyiTjZ6UWozNjSwAuc6sFqaKnzP9Y8u6DzklxKbWDyIc+7y526cEvhQvzApPygulwrsXBoEx2AXZ96+fs8hI+iuqKa132k8ANMhDfEDt/C4odzKd2I+8prnQlbE1g4L9S/6Ej2TBa7V8xJ/WICPd+o1ftqDWqy5wds8Vh2GRDl7BPBbOFKf1GiJXtrutCUaIHFJ68dku0fAztiuK9PjqvxhSG6kAputAT8xMXcB1mvxxXsgkzrI9+oIfdw=="
}
```

# 支付流程
subject: 订单名称
body: 商品名称
product_code: "FAST_INSTANT_TRADE_PAY" 固定值，沙箱支付
total_amount: 金额，单位元
```json
{
  "out_trade_no": "",
  "total_amount": "",
  "subject": "",
  "body": "",
  "product_code": "FAST_INSTANT_TRADE_PAY"
}
```

```java
class Pay{
    public void pay(){
        AlipayClient alipayClient = new DefaultAlipayClient(MyAlipayConfig.gatewayUrl, MyAlipayConfig.app_id, MyAlipayConfig.merchant_private_key, "json", MyAlipayConfig.charset, MyAlipayConfig.alipay_public_key, MyAlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(MyAlipayConfig.return_url);
        alipayRequest.setNotifyUrl(MyAlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "";
        //付款金额，必填
        String total_amount = "";
        //订单名称，必填
        String subject = "";
        //商品描述，可空
        String body = "";
        // 其他参数自行验证 timeout_express: 10m
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();
    }
}
```