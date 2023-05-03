package com.hxzy.controller.back;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/3-15:33
 * @description TODO
 */

import cn.hutool.core.util.StrUtil;
import com.hxzy.common.constants.RedisConstant;
import com.hxzy.common.controller.BaseController;
import com.hxzy.common.domain.SMSProperties;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.vo.Result;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20210111.models.SendStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  短信发送API
 *
 * @author tonneyyy
 */
@Api(tags = "短信发送API")
@RestController
@RequestMapping(value = "/api/sms")
public class SMSController extends BaseController {

    @Autowired
    private SMSProperties smsProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "忘记密码发短信")
    @GetMapping(value = "/forget/pwd")
    public Result sendForgetPwdSMS(String phone) {

        if(StrUtil.isBlank(phone)){
            return Result.build(AckCode.PHONE_NUMBER_NOTNULL);
        }

        //验证电话号码有效性
        String phoneExg="^0?(13|15|17|18|14|19)[0-9]{9}$";
        //定义一个正则表达式
        Pattern pattern = Pattern.compile(phoneExg);
        //创建一个匹配器，匹配正则表达式
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()){
            return Result.build(AckCode.PHONE_NUMBER_NOTNULL);
        }

        String code = "";
        String status = "";
        try {
            Credential cred = new Credential(smsProperties.getSecretId(), smsProperties.getSecretKey());

            // 实例化一个http选项，可选，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            /* 指定接入地域域名，默认就近地域接入域名为 sms.tencentcloudapi.com ，也支持指定地域域名访问，例如广州地域的域名为 sms.ap-guangzhou.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            /* 实例化要请求产品(以sms为例)的client对象
             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，支持的地域列表参考 https://cloud.tencent.com/document/api/382/52071#.E5.9C.B0.E5.9F.9F.E5.88.97.E8.A1.A8 */
            SmsClient client = new SmsClient(cred, "ap-guangzhou");
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            SendSmsRequest req = new SendSmsRequest();

            /* 填充请求参数,这里request对象的成员变量即对应接口的入参
             * 你可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台: https://console.cloud.tencent.com/smsv2
             * 腾讯云短信小助手: https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            // 应用 ID 可前往 [短信控制台](https://console.cloud.tencent.com/smsv2/app-manage) 查看
            String sdkAppId = smsProperties.getSdkAppId();
            req.setSmsSdkAppId(sdkAppId);

            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名 */
            // 签名信息可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-sign) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-sign) 的签名管理查看
            String signName = smsProperties.getSignName();
            req.setSignName(signName);

            /* 模板 ID: 必须填写已审核通过的模板 ID */
            // 模板 ID 可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-template) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-template) 的正文模板管理查看
            String templateId = "473168";
            req.setTemplateId(templateId);

            /* 模板参数: 模板参数的个数需要与 TemplateId 对应模板的变量个数保持一致，若无模板参数，则设置为空 */
            //(0-8999)+1000
            code = (new Random().nextInt(9000) + 1000) + "";
            String[] templateParamSet = {code, this.smsProperties.getExpired() + ""};
            req.setTemplateParamSet(templateParamSet);

            /* 下发手机号码，采用 E.164 标准，+[国家或地区码][手机号]
             * 示例如：+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号 */
            String[] phoneNumberSet = {"+86" + phone};
            req.setPhoneNumberSet(phoneNumberSet);


            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
            SendSmsResponse res = client.SendSms(req);

            // 输出json格式的字符串回包
            SendStatus[] sendStatusSetList = res.getSendStatusSet();
            for (SendStatus send : sendStatusSetList) {
                status = send.getCode();
            }
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        } finally {
            //短信发送成功后，存储到redis中保存起来
            if (status.equalsIgnoreCase("OK")) {
                String uuid = UUID.randomUUID().toString();
                String redisKey = RedisConstant.getRedisKey(RedisConstant.SMS_REDIS_KEY, uuid);
                this.redisTemplate.opsForValue().set(redisKey, code , this.smsProperties.getExpired(), TimeUnit.MINUTES);
                return Result.okHasData(uuid);
            } else {
                return Result.build(AckCode.SMS_SEND_ERROR);
            }
        }

    }
}
