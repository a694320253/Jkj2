package cn.usho.jkj.bean;

import java.io.Serializable;

/**
 * @Class: Photo
 * @Description: 照片实体
 * @author: lling(www.liuling123.com)
 * @Date: 2015/11/4
 */
public class PhotoModel implements Serializable {

    private static final long serialVersionUID = -1419914578504225432L;
    public int id;
    public String pic_path;  //图片
    public boolean isShowSelector;
    public boolean isSelected;
    public boolean isShowCamera;

    public PhotoModel(String path, boolean isShowCamera) {
        pic_path = path;
        this.isShowCamera = isShowCamera;
    }
    public PhotoModel(String path, boolean isShowCamera, boolean isShowSelector) {
        pic_path = path;
        this.isShowCamera = isShowCamera;
        this.isShowSelector = isShowSelector;
    }

    public PhotoModel(String path) {
        pic_path = path;
    }
}
