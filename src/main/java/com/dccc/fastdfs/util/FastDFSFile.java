package com.dccc.fastdfs.util;

import java.util.Arrays;

/**
 * Created by ShineYoung on 2017/10/21.
 */

public class FastDFSFile{

    private static final long serialVersionUID = 1L;
/**
     * 文件名
     */

    private String name;
    /**
     * 内容
     */

    private byte[] content;
    /**
     * 文件类型
     */

    private String ext;
    /**
     * 文件大小
     */
    private String length;

    public FastDFSFile(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(String name, byte[] content, String ext, String length) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.length = length;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "FastDFSFile{" +
                "name='" + name + '\'' +
                ", content=" + Arrays.toString(content) +
                ", ext='" + ext + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
