package com.aishang.rulemanager.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 唯一编号生成器
 */
public class UniqueCodeGenerator {

    //时间格式化
    private static final String TIME_FORMAT = "yyyyMMddHHmmssSSS";

    /**
     * 生成子应用系统编号
     *
     * @return
     */
    public static String generateAppCode() {
        StringBuffer sb = new StringBuffer(Constants.APP_PREFIX);
        sb.append(formatDate());
        return sb.toString();
    }

    /**
     * 生成子应用系统编号
     * @return
     */
    public static String generateRoleCode() {
        StringBuffer sb = new StringBuffer(Constants.ROLE_PREFIX);
        sb.append(formatDate());
        return sb.toString();
    }

    /**
     * 格式化时间
     *
     * @return
     */
    private static String formatDate() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    /**
     * 格式化随机数（00）
     *
     * @return
     */
    private static String getRandomString() {
        return String.format("%02d", ThreadLocalRandom.current().nextInt(100));
    }

}
