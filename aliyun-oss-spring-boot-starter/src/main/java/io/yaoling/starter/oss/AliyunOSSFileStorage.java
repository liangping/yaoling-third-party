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
public class AliyunOSSFileStorage implements FileStorage {

    @Autowired
    private AliyunOssPropertiesConfig config;

    @Autowired
    private FileNaming nameStrategy;

    public String save(InputStream is, String toName) {
        //生成文件名
        String filename = nameStrategy.getName(toName);

        //upload file
        OSSClient ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        ossClient.putObject(config.getBucketName(), filename, is);
        ossClient.shutdown();

        StringBuilder url = new StringBuilder(config.getPrefix());
        if (!config.getPrefix().endsWith("/")) {
            url.append("/");
        }
        url.append(filename);
        return url.toString();
    }

}
