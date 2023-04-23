package com.hxzy.controller.back;

import com.hxzy.common.constants.WaiMaiConstant;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.vo.Result;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/21-0:16
 * @description TODO
 */
@Api(tags = "文件上传API")
@RestController
@RequestMapping(value = "/api/upload")
public class TencentUploadController {


    /**
     * COS（Cloud Object Storage）服务器是腾讯云推出的一种对象存储服务，可以存储和管理大量的非结构化数据，如图片、音频、视频、文档等。
     * COS服务器具有高可靠性、高可用性、高扩展性、高安全性等特点，可以满足用户对于数据存储、备份、共享、分发等需求。
     * COS服务器可以通过API、SDK、控制台等方式进行操作，支持多种存储类型和访问方式，如标准存储、低频存储、归档存储、CDN加速等。
     * @return
     */
    private COSClient createCOSClient() {
        // 设置用户身份信息。
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDgOuFLDtLYV0JOEoBLHzUqxohQyTkncDa";
        String secretKey = "A6pMgngRmskNo10nNnDUYaVEj082rVvB";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // ClientConfig 中包含了后续请求 COS 的客户端设置：
        ClientConfig clientConfig = new ClientConfig();

        // 设置 bucket 的地域
        // COS_REGION 请参见 https://cloud.tencent.com/document/product/436/6224
        // 地域（Region）是腾讯云托管机房的分布地区，对象存储（Cloud Object Storage，COS）的数据存放在这些地域的存储桶中。
        // 您可以通过 COS，将数据进行多地域存储。通常情况下，COS 建议您选择在与您业务最近的地域上创建存储桶，以满足低延迟、低成本以及合规性要求。
        clientConfig.setRegion( new Region("ap-chongqing"));

        // 设置请求协议, http 或者 https
        // 5.6.53 及更低的版本，建议设置使用 https 协议
        // 5.6.54 及更高版本，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 以下的设置，是可选的：
        // 设置 socket 读取超时，默认 30s
        clientConfig.setSocketTimeout(30*1000);
        // 设置建立连接超时，默认 30s
        clientConfig.setConnectionTimeout(30*1000);

        // 生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }


    @ApiOperation(value = "图片上传，只支持(png,jpg,gif)")
    @PostMapping(value = "/image")
    public Result imageUpload(@RequestPart MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return Result.build(AckCode.FILE_NOT_EMPTY);
        }

        //上传文件的名称
        String originalFileName=file.getOriginalFilename();
        //得到文件扩展名
        int lastIndex=originalFileName.lastIndexOf(".");
        if(lastIndex<=0){
            return Result.build(AckCode.UPLOAD_TYPE_ERROR);
        }

        String ext=originalFileName.substring(lastIndex);

        boolean contains = Arrays.asList(".png", ".jpg", ".jpeg").contains(ext.toLowerCase(Locale.ROOT));
        if(!contains){
            return Result.build(AckCode.UPLOAD_TYPE_ERROR_IMAGE);
        }

        //生成一个文件名
        String newFileName= UUID.randomUUID().toString()+ext;

        //开始上传
        COSClient cosClient = this.createCOSClient();
        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = "waimai-1300180953";
        // 对象键(Key)是对象在存储桶中的唯一标识 (文件名)
        String key = "/images/"+newFileName;

        // 这里创建一个 ByteArrayInputStream 来作为示例，实际中这里应该是您要上传的 InputStream 类型的流
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 上传的流如果能够获取准确的流长度，则推荐一定填写 content-length
        // 如果确实没办法获取到，则下面这行可以省略，但同时高级接口也没办法使用分块上传了
        objectMetadata.setContentLength(file.getSize());

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(), objectMetadata);

        // 设置存储类型（如有需要，不需要请忽略此行代码）, 默认是标准(Standard), 低频(standard_ia)
        // 更多存储类型请参见 https://cloud.tencent.com/document/product/436/33417
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);

        try {
            PutObjectResult putObjectResult  = cosClient.putObject(putObjectRequest);

            //自定义返回结果
            Map<String,String> dataMap=new HashMap<>();
            dataMap.put("image_url", WaiMaiConstant.TENCENT_IMAGE_SERVICE+key);
            dataMap.put("file_name",originalFileName);

            return Result.okHasData(dataMap);

        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }finally {
            // 确认本进程不再使用 cosClient 实例之后，关闭之
            cosClient.shutdown();
        }
        return Result.build(AckCode.FAIL);
    }

}
