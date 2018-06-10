package io.yaoling.third.file;

import java.util.UUID;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public class UUIDFileNaming implements FileNaming {
    public String getName(String srcName) {
        int len = srcName.lastIndexOf(".");
        return new StringBuilder(UUID.randomUUID().toString())
                .append(".").append(len>0?srcName.substring(len):"")//扩展名
                .toString();
    }
}
