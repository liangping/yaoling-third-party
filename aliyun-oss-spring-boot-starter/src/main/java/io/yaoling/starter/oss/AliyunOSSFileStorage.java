package io.yaoling.starter.oss;

import com.aliyun.oss.OSSClient;
import io.yaoling.third.file.FileNaming;
import io.yaoling.third.file.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;


/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public class AliyunOSSFileStorage implements FileStorage{

    @Autowired
    private AliyunOssPropertiesConfig config;

    @Autowired
    private FileNaming nameStrategy;

    public String save(InputStream is, String toName) {
        OSSClient ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        ossClient.putObject(config.getBucketName(), nameStrategy.getName(toName), is );
        ossClient.shutdown();
        return new StringBuilder(config.getEndpoint()).append(toName).toString();
    }

}
