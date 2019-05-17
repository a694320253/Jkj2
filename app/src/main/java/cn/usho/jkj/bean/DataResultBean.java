package cn.usho.jkj.bean;

import java.util.ArrayList;

/**
 * 项目名称：cn.usho.sosho
 * 类描述：  服务器返回数据公共抽象类
 * 实体业务数据一般取item或items
 * (有的接口可能并不是这个格式,会比较反人类,后台写的什么一坨屎,懒得搞)
 * 作者：   Even_for .
 * 日期：   2017/9/14 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */

public class DataResultBean<T> {

    public ResultInfo result;
    public CountInfo counts;
    public CountInfo count;
    public ArrayList<T> items;
    public T item;
    public int  errno;
    public String errmsg;
}
