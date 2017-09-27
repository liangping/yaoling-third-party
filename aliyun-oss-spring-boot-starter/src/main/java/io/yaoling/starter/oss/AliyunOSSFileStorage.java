package io.yaoling.starter.oss;

import com.aliyun.oss.OSSClient;
import io.yaoling.third.file.FileNaming;
import io.yaoling.third.file.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public class AliyunOSSFileStorage implements FileStorage{

    @Autowired
    private AliyunOssPropertiesConfig config;

    public String save(InputStream is, String toName) {
        OSSClient ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        String key = UUID.randomUUID().toString();
        ossClient.putObject(config.getBucketName(), toName, is );
        ossClient.shutdown();
        return toName;
    }
}
