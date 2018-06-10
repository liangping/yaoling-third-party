package io.yaoling.third.file;

import java.io.InputStream;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public interface FileStorage {
    String save(InputStream is, String toName);
}
