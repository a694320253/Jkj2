package cn.usho.jkj.bean;


import android.media.ExifInterface;

public class TestLocalMedia  {

    String datetime ;// 拍摄时间
    String deviceName ;// 设备品牌
    String deviceModel ; // 设备型号
    String latValue ;
    String lngValue ;
    String latRef ;
    String lngRef ;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getLatValue() {
        return latValue;
    }

    public void setLatValue(String latValue) {
        this.latValue = latValue;
    }

    public String getLngValue() {
        return lngValue;
    }

    public void setLngValue(String lngValue) {
        this.lngValue = lngValue;
    }

    public String getLatRef() {
        return latRef;
    }

    public void setLatRef(String latRef) {
        this.latRef = latRef;
    }

    public String getLngRef() {
        return lngRef;
    }

    public void setLngRef(String lngRef) {
        this.lngRef = lngRef;
    }
}
