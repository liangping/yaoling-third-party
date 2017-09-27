package io.yaoling.third.file;

/**
 *
 * 上传文件后的文件名及路劲的命名规则配置
 *
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public interface FileNaming {
    String getName(String srcName);
}
