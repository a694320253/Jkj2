package cn.usho.jkj.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称：cn.usho.jkj.bean
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/23 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
@Entity
public class PicBean {
    @Id(autoincrement = true)
    Long id;
    long time;
    double lan;
    double lon;
    String path;
    String addtime;
    String name;
    String title;

    @Generated(hash = 1282617391)
    public PicBean(Long id, long time, double lan, double lon, String path,
            String addtime, String name, String title) {
        this.id = id;
        this.time = time;
        this.lan = lan;
        this.lon = lon;
        this.path = path;
        this.addtime = addtime;
        this.name = name;
        this.title = title;
    }

    @Generated(hash = 461998603)
    public PicBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
