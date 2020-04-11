package com.huazhou.util;

import java.io.Serializable;

public class ImageModel implements Serializable {
    private static final long UID = 1L;

    private String base64Str;
    private String imgVal;

    public String getBase64Str(){
        return base64Str;
    }

    public String getImgVal() {
        return imgVal;
    }

    public void setImgVal(String imgVal) {
        this.imgVal = imgVal;
    }

    public void setBase64Str(String base64Str){
        this.base64Str = base64Str;
    }
}
