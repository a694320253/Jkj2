package cn.usho.jkj.bean;

import java.io.Serializable;

/**
 * 项目名称：cn.usho.sosho.model
 * 类描述：
 * 作者：   admin .
 * 日期：   2018/10/23 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class ResultInfo implements Serializable {
    public String message;
    public String title;
    public int affected;
    public String id;
    public String sex;
    public String city;
    public String province;
    public String unionid;
    public String openid;
    public String md5;
    public String access_token;
    public String timestamp;
    public String mobile;
    public String expire_timestamp;

    public String domain;
    public String qiniu_token;

    public String average_amount;
    public String donations_num;
    public String donation_num;
    public String donor_num;
    public String group_num;
    //点击数
    public String pv_num;
    public String received_amount;
    //独立IP访问数(浏览次数)
    public String uv_num;

    public String is_verified;
    public String file_url;

    public AnonymousInfo anonymous;
    public DailyInfo daily;
    public MonthlyInfo monthly;
    public ProjectsInfo projects;
    public ProjectInfo project;

    //评论相关返回结果
    public long reply_id;
    public String reply_user;
    public String reply_content;
    public String good_num;
    public String user_id;
    public String content;
    public String created_at;
    public String user_name;
    public String name;
    public String order;
    public String nickname;
    public String avatar_path;
    public boolean user_good_status;
}
