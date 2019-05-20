package cn.usho.jkj.utils;

import android.Manifest;

import com.blankj.utilcode.util.SPUtils;

/**
 * 项目名称：cn.usho.sosho.utils
 * 类描述：
 * 作者：   admin .
 * 日期：   2018/4/17 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class GlobalConstance {
    public static final int TASK_ONE = 0; //第一个请求
    public static final int TASK_TWO = 2; //第二个请求
    public static final int TASK_THREE = 3; //第三个请求
    public static final int TASK_FOURE = 4; //第四个请求

    public static final String PARAM_KEY = "appkey"; //请求key
    public static final String PARAM_KEY_VALUE = "android"; //请求key值
    public static final String URL_APP_INFO = "tool/version"; //获取app信息
    public static final String H5_BUILD = "20160415"; //h5端build

    public static final String UID_KEY = "uid";
    public static final String DATA_ID_KEY = "data_id";
    public static final String GROUP_ID_KEY = "group_id";
    public static final String WEB_URL_KEY = "web_url";
    public static final String USER_NAME_KEY = "user_name";
    public static final String USER_SEX_KEY = "user_sex";
    public static final String USER_BIRTHDAY_KEY = "user_birthday";
    public static final String USER_AREA_KEY = "user_area";
    public static final String USER_MOBILE_KEY = "user_mobile";
    public static final String USER_EMAIL_KEY = "user_email";
    public static final String USER_COMPANY_KEY = "user_company";
    public static final String USER_POSITION_KEY = "user_position";
    public static final String USER_EDUCATION_KEY = "user_education";
    public static final String QINIU_PIC_DOMAIN_KEY = "qiniu_pic_domain";
    public static final String QINIU_PIC_TOKEN_KEY = "qiniu_pic_token";
    public static final String QINIU_FILE_DOMAIN_KEY = "qiniu_file_domain";
    public static final String QINIU_FILE_TOKEN_KEY = "qiniu_file_token";
    public static final String QINIU_UPLOAD_DOMAIN_KEY = "qiniu_upload_domain";
    public static final String QINIU_UPLOAD_TOKEN_KEY = "qiniu_upload_token";
    public static final String QINIU_FILE_PATH_KEY = "file_paths";
    public static final String QINIU_KEY_KEY = "key";
    public static final String QINIU_PIC_BUCKET_VALUE = "pics";
    public static final String QINIU_FILE_BUCKET_VALUE = "attachments";
    public static final String COMMUNITY_ID_KEY = "com_id";
    public static final String SMS_ID_KEY = "sms_id";
    public static final String LOG_ID_KEY = "log_id";
    public static final String CLUB_ID_KEY = "club_id";
    public static final String EXPRESS_NAME_KEY = "express_name";
    public static final String EXPRESS_COMPANY_KEY = "express_company";
    public static final String EXPRESS_NO_KEY = "express_no";
    public static final String TRACKING_NO_KEY = "tracking_no";
    public static final String FILE_PATH_KEY = "file_paths";
    public static final String COMMUNITY_NAME_KEY = "com_name";
    public static final String COMMUNITY_BEAN_KEY = "com_bean";
    public static final String RESULT_BEAN_KEY = "result_bean";
    public static final String EVENT_FORM_KEY = "event_form";
    public static final String FORM_ID_KEY = "form_id";
    public static final String FORM_LABEL_KEY = "form_label";
    public static final String FORM_SELECT_OPTION_KEY = "form_select_option";
    public static final String FORM_LIST_KEY = "form_list";
    public static final String FORM_TITLE_KEY = "form_title";
    public static final String FORM_STATUS = "status";
    public static final String FORM_INTRO_KEY = "form_intro";
    public static final String FORM_TYPE_KEY = "form_type";
    public static final String FORM_TYPE_TEXT_KEY = "text";
    public static final String FORM_TYPE_TEXTAREA_KEY = "textarea";
    public static final String FORM_TYPE_RADIO_KEY = "radio";
    public static final String FORM_TYPE_CHECKBOX_KEY = "checkbox";
    public static final String FORM_TYPE_IMAGE_KEY = "image";
    public static final String FORM_TYPE_SELECT_KEY = "select";
    public static final String FORM_TYPE_NUMBER_KEY = "number";
    public static final String FORM_TYPE_EMAIL_KEY = "email";
    public static final String FORM_TYPE_MOBIL_KEY = "mobile";
    public static final String FORM_TYPE_ATTACHMENT_KEY = "attachment";
    public static final String FORM_OPTIONS_KEY = "form_options";
    public static final String FORM_POSITION_KEY = "form_position";
    public static final String FORM_EXTENDED_KEY = "form_extended";
    public static final String FORM_SHOW_CONDITION_KEY = "form_show_condition";
    public static final String FEE_TITLE_KEY = "fee_title";
    public static final String FEE_AMOUNT_KEY = "fee_amount";
    public static final String FEE_NUM_KEY = "fee_num";
    public static final String FEE_DESC_KEY = "fee_desc";
    public static final String FEE_LIST_KEY = "fee_list";
    public static final String CLOUD_CARD_TYPE_KEY = "cloud_card_type";
    public static final String PAY_METHOD_ONLINE = "2";
    public static final String PAY_METHOD_OFFLINE = "1";
    public static final String PAY_METHOD_FREE = "0";
    public static final String GROUP_NAME_KEY = "event_group_name";
    public static final String GROUP_PLACES_KEY = "event_group_places";
    public static final String GROUP_DESC_KEY = "event_group_desc";
    public static final String GROUP_WECHAT_KEY = "event_group_wechat";
    public static final String TYPE_COMMUNITY = "community";
    public static final String TYPE_PERSONAL = "personal";
    public static final String TYPE_PARTNER = "partner";
    public static final String TYPE_TEXT = "text";
    public static final String PHOTO_NAME_KEY = "photo_name";
    public static final String CARD_NAME_KEY = "card_name";
    public static final String BANNER_KEY = "banner";
    public static final String CARD_COUPON_ID_KEY = "card_coupon_id";
    public static final String COUPON_ID_KEY = "coupon_id";
    public static final String DESC_NUM_KEY = "desc_num";
    public static final String USED_NUM_KEY = "used_num";
    public static final String START_AT_KEY = "start_at";
    public static final String END_AT_KEY = "en_at";
    public static final String ADD_PIC_KEY = "add_pic";
    public static final String COM_MEMBER_LIST_KEY = "com_member_list";
    public static final String COM_GROUP_LIST_KEY = "com_group_list";
    public static final String SELECTOR_ALL_KEY = "select_all";
    public static final String SELECTOR_GROUP_KEY = "select_group";
    public static final String SELECTOR_CONTACT_KEY = "select_contact";
    public static final String SELECTOR_TYPE_ALL = "all";
    public static final String SELECTOR_TYPE_GROUP = "group";
    public static final String SELECTOR_TYPE_CONTACT = "specific";
    public static final String PICTURE_LIST_KEY = "picture_list";
    public static final String POSITION_KEY = "position";
    public static final String KEYWORD_KEY = "keyword";
    public static final String ABBREVIATION_KEY = "abbreviation";
    public static final String DAILY_TOTAL_NUM_KEY = "daily_total_num";
    public static final String DAILY_TOTAL_AMOUNT_KEY = "daily_total_amount";
    public static final String MONTHLY_TOTAL_NUM_KEY = "monthly_total_num";
    public static final String MONTHLY_TOTAL_AMOUNT_KEY = "monthly_total_amount";
    public static final String ANONYMOUS_TOTAL_NUM_KEY = "anonymous_total_num";
    public static final String REAL_NAME_NUM_KEY = "real_name_num";
    public static final String ANONYMOUS_TOTAL_AMOUNT_KEY = "anonymous_total_amount";
    public static final String REAL_NAME_AMOUNT_KEY = "real_name_amount";
    public static final String REASON_TEXT_KEY = "reason_text";
    public static final String CONTENT_DATA_KEY = "content_data";
    public static final String SHARE_WECHAT_FAVIRITE_KEY = "WechatFavorite";
    public static final String SHARE_WECHAT_KEY = "Wechat";
    public static final String SHARE_WECHAT_MOMENT_KEY = "WechatMoments";
    public static final String H5MODULE_NAME_KEY = "module_name";
    public static final String H5MODULE_ID_KEY = "module_id";
    public static final String INDEX_SHOW_KEY = "index_show";
    public static final String FRAGMENT_INDEX_KEY = "fragment_index";
    public static final String DOC_ID_KEY = "doc_id";
    public static final String WALLET_ID_KEY = "wallet_id";
    public static final String URL_KEY = "url";
    public static final String PARAMS_KEY = "key";
    public static final String PARAMS_VALUE = "value";
    public static final String ALI_PAY_KEY = "ali_pay";
    public static final String WECHAT_PAY_KEY = "wechat_pay";
    public static final String SCODE_KEY = "scode";
    public static final String BIND_MOBILE_COUNT = "bind_mobile_count";
    public static final String BIND_MOBILE_TIME = "bind_mobile_time";

    public static final String SMS_TYPE_SINGLE = "single";
    public static final String SMS_TYPE_BIRTHDAY = "birthday";
    public static final String LOCATION_KEY = "location";
    public static final String LOCATION_ADDRESS_NAME_KEY = "location_name";
    public static final String LOCATION_ADDRESS_KEY = "location_address";
    public static final String LOCATION_ADDRESS_DETAIL_KEY = "location_address_detail";
    public static final String REFUND_1_KEY = "not_support";
    public static final String REFUND_2_KEY = "before_end_signup";
    public static final String REFUND_3_KEY = "before_end_activity";
    public static final String IS_REQUIRED_KEY = "is_required";
    public static final String IS_SYSTEM_KEY = "is_system";
    public static final String IS_MODIFY_KEY = "is_modify";
    public static final String IS_EXPORT_KEY = "isExport";
    public static final String IS_PREVIEW_KEY = "isPreview";
    public static final String IS_APPLY_JOIN_KEY = "isApplyJoin";
    public static final String IS_UPDATE_PAY_METHOD_KEY = "is_update_pay_method";
    public static final String IS_USER_REQUIRED_KEY = "is_user_required";
    public static final String PROJECT_ID_KEY = "project_id";
    public static final String ARTICLE_ID_KEY = "article_id";
    public static final String ACTIVITY_ID_KEY = "activity_id";
    public static final String PRODUCT_ID_KEY = "product_id";
    public static final String PRODUCT_NAME_KEY = "product_nam";
    public static final String SKU_ID_KEY = "sku_id";
    public static final String PRICE_KEY = "price";
    public static final String STOCK_NUM_KEY = "stock_num";
    public static final String WEIGHT_KEY = "weight_num";
    public static final String ORDER_ID_KEY = "order_id";
    public static final String TRANSACTION_ID_KEY = "transaction_id";
    public static final String SIGN_ID_KEY = "sign_id";
    public static final String SIGN_NUM_KEY = "sign_num";
    public static final String COUNTRY_ID_KEY = "country_id";
    public static final String PROVINCE_ID_KEY = "province_id";
    public static final String CITY_ID_KEY = "city_id";
    public static final String COUNTRY_NAME_KEY = "country_name";
    public static final String PROVINCE_NAME_KEY = "province_name";
    public static final String CITY_NAME_KEY = "city_name";
    public static final String TEAM_ID_KEY = "team_id";
    public static final String ALBUM_ID_KEY = "album_id";
    public static final String PHOTO_ID_KEY = "photo_id";
    public static final String PAYMENT_METHOD_KEY = "payment_method";
    public static final String REFUND_METHOD_KEY = "refund_method";
    public static final String VOTE_ID_KEY = "vote_id";
    public static final String VOTE_NAME_KEY = "vote_name";
    public static final String OPTION_ID_KEY = "option_id";
    public static final String ORDER_BY_DESC = "DESC";
    public static final String ORDER_BY_ASC = "ASC";
    public static final String ORDER_KEY = "order";
    public static final String AREA_CODE_KEY = "area_code";
    public static final String RANK_KEY = "rank";
    public static final String PERCENT_KEY = "percent";
    public static final String COUNT_KEY = "count";
    public static final String IMG_PATH_KEY = "img_path";
    public static final String LOGO_PATH_KEY = "logo_path";
    public static final String COVER_PATH_KEY = "cover_path";
    public static final String COVER_URL_KEY = "cover_url";
    public static final String CREATE_ACTIVITY_KEY = "create_activity";
    public static final String MESSAGE_VERIFY_KEY = "message_verify";
    public static final String JOIN_VERIFY_KEY = "join_verify";
    public static final String JOIN_DECLARE_KEY = "join_declare";
    public static final String CONTENT_KEY = "content";
    public static final String CONTENT_HINT_KEY = "content_hint";
    public static final String CONTENT_MIN_LINES_KEY = "content_min_lines";
    public static final String IS_SHOW_CONTENT_LENGTH_KEY = "is_show_content_length";
    public static final String SIGNATURE_KEY = "signature";
    public static final String DESCRIPTION_KEY = "description";
    public static final String NAME_KEY = "name";
    public static final String CATEGORY_ID_KEY = "category_id";
    public static final String CATEGORY_NAME_KEY = "category_name";
    public static final String CATEGORY_NUMBER_KEY = "category_number";
    public static final String TEXT_KEY = "text";
    public static final String TITLE_KEY = "title";
    public static final String SUBCLASS_KEY = "sub_class";
    public static final String HTML_KEY = "html";
    public static final String INTRO_KEY = "intro";
    public static final String MALL_NAME_KEY = "mall_name";
    public static final String APP_MAIN_SEARCH_HINT_KEY = "search_hint";
    public static final String APP_MAIN_SEARCH_RIGHT_TEXT_KEY = "right_text";
    public static final String APP_MAIN_SEARCH_KEYWORD_KEY = "search_keyword";
    public static final String IS_HINT_PIC_SHOW_KEY = "is_hint_pic_show";
    public static final String IS_RIGHT_TEXT_SHOW_KEY = "is_right_text_show";
    public static final String SHARE_NUM_KEY = "share_num";
    public static final String MEMBER_NUM_KEY = "member_num";
    public static final String COMMENT_NUM_KEY = "comment_num";
    public static final String HITS_NUM_KEY = "hits_num";
    public static final String IS_CLOSED_KEY = "is_closed";
    public static final String IS_SUSPEND_KEY = "is_suspend";
    public static final String IS_PAUSED_KEY = "is_paused";
    public static final String IS_PUBLIC_KEY = "is_public";
    public static final String IS_DRAFT_KEY = "is_draft";
    public static final String IS_LOAD_KEY = "is_load";
    public static final String IS_OPEN_TEAM_KEY = "is_open_team";
    public static final String IS_SHOW_SHARE_KEY = "is_show_share";
    public static final String IS_VERIFIED_KEY = "is_verified";
    public static final String IS_SIGN_VERIFY_KEY = "is_sign_verify";
    public static final String IS_ANONYMOUS_KEY = "is_anonymous";
    public static final String IS_CHAIRMAN_KEY = "is_chairman";
    public static final String IS_ADMIN_KEY = "is_admin";
    public static final String IS_CAN_CREATE_TEAM_KEY = "is_can_create_team";
    public static final String USER_MOBILE = "user_mobile";
    public static final String TAG_IS_LOGIN = "tag_is_login";
    public static final String TOKEN_KEY = "token";
    public static final String JURSCLICTION_DATA= "jurscliction_data";//权限管理数据
    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final String EXPIRE_TIMESTAMP_KEY = "expire_timestamp";
    public static final String TIMESTAMP_KEY = "timestamp";
    public static final String API_SERVER = "api_server";
    public static final String INTEGER_TRUE = "1";
    public static final String INTEGER_FALSE = "0";
    public static final String URL_H5_LOGIN = "app/authen";//h5端登陆
    public static final String QINIU_TOKEN_ERROR_MSG = "上传七牛云图片缺少token";
    public static final String QINIU_DOMAIN_ERROR_MSG = "上传七牛云图片缺少domain";
    public static final String QINIU_FILE_PATH_ERROR_MSG = "上传七牛云图片缺少file_path";
    public static final String QINIU_FILE_EXSITS_ERROR_MSG = "文件不存在,请重新选择文件";
    public static final String QINIU_KEY_ERROR_MSG = "上传七牛云图片缺少key";
    public static final String QINIU_PARAMS_ERROR_MSG = "上传七牛云图片参数不能为空";

    public static final String URL_LOGIN = "account/login";  //登录
    public static final String URL_REGISTER = "account/register";  //注册
    public static final String URL_GET_SCODE = "account/send_scode";  //获取手机验证码

    public static final String ACTION_PASSWORD = "action_password";  //密码登录
    public static final String ACTION_SCODE = "action_scode";  //验证码登录
    public static final String ACTION_OTHER = "action_other";  //第三方登录

    public static final String ACTION_GROUP_CREATE = "event_group_create";
    public static final String ACTION_GROUP_UPDATE = "event_group_update";
    public static final String ACTION_SELECT_LOGO = "select_logo";
    public static final String ACTION_SELECT_COVER = "select_cover";
    public static final String ACTION_SELECT_AREA = "select_area";
    public static final String ACTION_COM_MEMBER_FIELD = "com_member_field";
    public static final String ACTION_EVENT_SIGNIN = "event_signin";
    public static final String ACTION_EVENT_SIGNUP = "event_signup";
    public static final String ACTION_EVENT_SIGNIN_VERIFY = "event_signin_verify";
    public static final String ACTION_EVENT_SIGNUP_VERIFY = "event_signup_verify";
    public static final String ACTION_ITEM_NO_TITLE = "item_no_title";
    public static final String ACTION_FROM = "start_from";
    public static final String ACTION_CLUB_CREATE = "club_create";
    public static final String ACTION_CLUB_UPDATE = "club_update";


    public static final String EVENT_PAY_PRIVATE = "1"; //线下支付活动
    public static final String EVENT_PAY_ONLINE = "2"; //线上支付活动

    public static final String ITEM_CONTACT = "contacts";
    public static final String ITEM_FORM = "form";
    public static final String ITEM_ACTIVITY = "activity";
    public static final String ITEM_COM_MEMBER = "member";
    public static final String ITEM_LOG = "log";
    public static final String ITEM_SMS = "sms";
    public static final String ITEM_MESSAGE = "message";
    public static final String ITEM_DONATE = "donate";
    public static final String ITEM_SUB_COMMUNITY = "sub_community";
    public static final String ITEM_CLUB = "club";
    public static final String ITEM_VOTE = "vote";
    public static final String ITEM_ARTICLE = "article";
    public static final String ITEM_ALBUM = "album";
    public static final String ITEM_MALL = "mall";
    public static final String ITEM_CLOUD_CARD = "cloud_card";

    public static final String MAIN_TAB1_LIST_TAG1 = "com_member_list";
    public static final String MAIN_TAB1_LIST_TAG2 = "com_Manage_list";
    public static final String MAIN_TAB1_LIST_TAG3 = "weekly_list";
    public static final String MAIN_TAB1_LIST_TAG4 = "recommend_title";
    public static final String MAIN_TAB1_LIST_TAG5 = "activity_list";
    public static final String MAIN_TAB1_LIST_TAG6 = "article_list";
    public static final String MAIN_TAB1_LIST_TAG7 = "check_more_list";
    public static final String TYPE_RECM_ACTIVITY = "activity";
    public static final String TYPE_RECM_ARTICLE = "article";
    public static final String TYPE_GROUP_DELETE = "group_delete";
    public static final String TYPE_COM_DELETE = "com_delete";
    public static final String TYPE_ID_KEY = "type_id";
    public static final String AGGREGATE_ID_KEY = "aggregate_id";
    public static final String SCHOOL_NAME_KEY = "school_name";
    public static final String EDUCATION_KEY = "education";
    public static final String EDUCATION_ID_KEY = "education_id";
    public static final String START_YEAR_KEY = "start_year";
    public static final String END_YEAR_KEY = "end_year";
    public static final String MAJOR_KEY = "major";
    public static final String UPDATE_TAG_KEY = "isToUpdate";

    public static String KEY_CACHE_COMMUNITY = "left_cache_community";

    //获取社群基本信息
    public static final String URL_GET_COMMUNITY_BASE_INFO = "community_manage/base";
    //社群成员列表
    public static final String URL_COMMUNITY_MEM = "community_manage/members";
    public static final String URL_HOME_MANAGE_LIST_DATA = "community_manage/modules";
    public static final String URL_HOME_MANAGE_COUNT_DATA = "community_manage/modules_statistics";
    public static final String URL_MY_MESSAGE_TYPE_DETAILS = "personal/messages/list"; //我的通知具体消息详情
    public static final String URL_GET_RECOMMEND_LIST = "operate/recommend/primary";

    public static final String URL_MY_COMMUNITIES = "personal/communities"; //我的社群
    public static final String URL_MY_FORMS= "form_manage/forms/index"; //表单列表
    public static final String URL_MY_FORMS_RECORD= "form_manage/forms/record"; //表单填写记录
    public static final String URL_MY_FORMS_VIEW= "form_manage/forms/view"; //表单统计
    public static final String URL_MY_EVENTS = "personal/activities"; //我的活动
    public static final String URL_COMMUNITY = "community";//发现-社群
    public static final String URL_ACTIVITY = "activity";//发现-活动
    public static final String URL_COMMUNITY_EVENT_LIST = "community_manage/activities"; //社群活动列表
    public static final String URL_COMMUNITY_ARTICLE_LIST = "community_manage/articles";//文章管理列表
    public static final String URL_COMMUNITY_VOTE_LIST = "vote_manage/votes"; //获取所发布的投票
    public static final String URL_COMMUNITY_MANAGE_CHILD = "community_manage/communities"; //子社群管理列表
    public static final String URL_COMMUNITY_CONTACT_LIST = "contacts_manage/contacts";//获取联系人
    public static final String URL_COMMUNITY_MSG_LIST = "community_manage/messages"; //社群管理留言列表
    public static final String URL_COMMUNITY_LOG_LIST = "log/";
    public static final String URL_COMMUNITY_LOG_VIEW = "log/view";
    public static final String URL_EXPORT_MEMBER_INFO = "goserver/activity_manage/export_members";

    //获取店铺信息
    public static final String URL_COMMUNITY_MALL_INFO = "mall_manage/overview";
    //获取云卡设置数据
    public static final String URL_COMMUNITY_CLOUD_CARD_INFO = "cloudcard_manage/settings";
    //获取社群相册列表
    public static final String URL_COMMUNITY_ALBUM_LIST = "community_manage/gallery/albums";
    public static final String URL_DELETE_ALBUM = "community_manage/gallery/delete_albums";
    public static final String URL_CREATE_ALBUM = "community_manage/gallery/create_album";
    public static final String URL_COMMUNITY_PHOTO_LIST = "community_manage/gallery/photos";
    public static final String URL_COMMUNITY_UPLOAD_PHOTO = "community_manage/gallery/upload_photos";
    public static final String URL_COMMUNITY_PHOTO_INFO = "community_manage/gallery/photos/photo_info";
    public static final String URL_DELETE_PHOTOS = "community_manage/gallery/delete_photos";
    public static final String URL_UPDATE_PHOTO_INFO = "community_manage/gallery/photos/update";
    public static final String URL_UPDATE_ALBUM = "community_manage/gallery/update_album";

    public static final String URL_CLUB_LIST = "community_manage/groups"; //俱乐部管理列表
    public static final String URL_CLUB_DELETE = "community_manage/delete_groups";
    public static final String URL_CLUB_DETAIL = "group/view";
    public static final String URL_CLUB_MEMBER_LIST = "group/members";
    public static final String URL_CLUB_MANAGE = "group_manage/dashboard";
    public static final String URL_CLUB_MANAGE_MEMBER_LIST = "group_manage/members";
    public static final String URL_CLUB_MANAGE_EVENT_LIST = "group_manage/activities";
    public static final String URL_CLUB_MANAGE_SETTING = "group_manage/member_setting";
    public static final String URL_CLUB_MANAGE_DELETE_MEMBER = "group_manage/del_members";
    public static final String URL_CLUB_MANAGE_DELETE_EVENT = "group_manage/del_activities";
    public static final String URL_CLUB_MANAGE_EVENT_SETTING = "group_manage/activity_setting";
    public static final String URL_COMMUNITY_SETTING = "community_manage/settings"; //俱乐部管理列表
    public static final String URL_AUTO_MANAGE = "auth_manage/role/priviledges"; //获取权限控制

    //获取基金会下属项目列表
    public static final String URL_FOUNDATION_MANAGE_PROJECTS = "foundation_manage/projects";

    //获取指定社群小额捐赠统计信息
    public static final String URL_FOUNDATION_DONATE_MANAGE_INFO = "foundation_manage/statistics";
    //社群成员管理
    public static final String URL_COMMUNITY_MEMBER_SETTING = "community_manage/member_setting";
    public static final String URL_EVENT_MEMBER_SETTING = "activity_manage/member_setting";
    public static final String URL_EVENT_MEMBER_DELETE = "activity_manage/del_members";
    public static final String URL_PROJECT_STATISTICS = "foundation_manage/project/statistics";

    public static final String URL_COMMUNITY_ARTICLE_DEL = "community_manage/del_articles";//删除文章
    public static final String URL_MALL_MANAGE_ORDER_SETTING = "mall_manage/order/setting";

    public static final String URL_VOTE_VIEW = "votes/view";//投票详情
    public static final String URL_DELETE_VOTE = "vote_manage/delete_votes";//删除投票
    public static final String URL_VOTE_TOGGLESTATE = "vote_manage/votes/toggleState";//状态开关
    public static final String URL_COMMUNITY_SMS_LIST = "community_manage/sms/";
    public static final String URL_COMMUNITY_SMS_NUM = "account_manage/sms/account";
    public static final String URL_COMMUNITY_ACTIVITY_SETTING = "community_manage/activity_setting";
    public static final String URL_COMMUNITY_EVENT_SETTINGS = "activity_manage/settings";
    public static final String URL_COMMUNITY_EVENT_MANAGE = "activity_manage/dashboard"; //活动管理面板
//    public static final String URL_COMMUNITY_EVENT_DEL = "activity_manage/delete"; //取消活动
    public static final String URL_COMMUNITY_EVENT_MEMBERS = "activity_manage/members"; //活动成员列表
    public static final String URL_COMMUNITY_EVENT_MEMBERS_SIGNIN = "activity_manage/signin"; //活动签到成员列表
    public static final String URL_COMMUNITY_EVENT_COMMENTS = "activity_manage/comments"; //活动评论列表
    public static final String URL_COMMUNITY_EVENT_NOTICES = "activity_manage/notices"; //活动通知列表
    public static final String URL_CREATE_EVENT_NOTIFY = "activity_manage/create_notice"; //活动群发通知
    public static final String URL_CREATE_EVENT = "activity/create"; //发布活动
    public static final String URL_EVENT_GET_COM_INFO = "activity/create_activity_com"; //发布活动可选社群列表
    public static final String URL_CATEGORIES = "/categorys"; //分类
    public static final String URL_EVENT_FORMS = "personal/activity_forms"; //表单
    public static final String URL_EVENT_TAGS = "activity/create_activity_tags"; //创建活动可选标签
    public static final String URL_EVENT_CLUB = "activity/create_activity_group"; //创建活动可选俱乐部
    public static final String URL_QINIU_TOKEN = "tool/upload_token"; //获取token

    public static final String URL_EVENT_CONTENT_EDIT = "activity_manage/edit"; //活动内容修改
    public static final String URL_EVENT_UPDATE = "activity_manage/update"; //活动内容修改
    public static final String URL_FEES_OPTIONS = "activity/fees_options"; //活动费用选项列表

    public static final String URL_EVENT_PIC_LIST = "activity_manage/photos"; //活动相册管理列表
    public static final String URL_UPLOAD_ALBUM_PIC = "album/upload";  //活动照片上传
    public static final String URL_DELETE_EVENT_PHOTO = "activity_manage/del_photo"; //活动删除照片
    public static final String URL_TRANSACTION_RECORD = "activity_manage/transactions"; //活动交易记录
    public static final String URL_EVENT_TEAM_LIST = "activity_manage/teams"; //活动队伍
    public static final String URL_EVENT_TEAM_MEMBER_LIST = "activity_team_manage/members"; //活动队伍成员
    public static final String URL_EVENT_TEAM_MERGE = "activity_manage/merge_teams"; //活动管理合并队伍
    public static final String URL_CREATE_TEAM = "activity_manage/create_team"; //创建活动报名小队
    public static final String URL_EDIT_TEAM = "activity_manage/edit_team"; //编辑活动报名小队
    public static final String URL_EVENT_TEAM_DEL = "activity_manage/disband_teams"; //活动管理解散队伍
    public static final String URL_PROJECT_MEMBERS = "foundation_manage/project/donations";
    public static final String URL_PROJECT_UPDATE = "foundation_manage/update_project";
    public static final String URL_PROJECT_COMMENTS = "foundation_manage/project/comments";
    public static final String URL_CREATE_COMMENT = "comment/create"; //发表评论
    public static final String URL_CREATE_COMMUNITY_COMMENT = "community/create_message"; //发表评论
    public static final String URL_DELETE_COMMENT_PROJECT = "foundation_manage/project/del_comments";//项目删除评论
    public static final String URL_VOTE_COMMENT_LIST = "vote_manage/comments"; //投票评论管理
    public static final String URL_DELETE_COMMENT_VOTE = "vote_manage/comments/delete"; //投票删除评论
    public static final String URL_DELETE_COMMENT_EVENT = "activity_manage/del_comment"; //活动评论删除
    public static final String URL_DELETE_COMMENT_ARTICLE = "community_manage/del_article_comments";//删除文章评论
    public static final String URL_DELETE_COMMENT_COMMUNITY = "community_manage/del_messages"; //留言管理删除
    public static final String URL_COM_COMMENT_SETTING = "community_manage/message/setting";
    public static final String URL_COMMENT_GOOD = "comment/good"; //评论点赞

    public static final String URL_UPDATE_PROJECT_SETTING = "foundation_manage/project_setting";
    public static final String URL_UPDATE_ARTICLE_SETTING = "community_manage/article_setting"; //文章设置
    public static final String URL_ARTICLE_COMMENTS = "community_manage/article_comments"; //文章评论管理

    public static final String URL_CREATE_ARTICLE = "community_manage/create_article";//创建文章
    public static final String URL_UPDATE_ARTICLE = "community_manage/update_article";//保存文章修改结果
    public static final String URL_EDIT_ARTICLE = "community_manage/edit_article";//编辑文章
    public static final String URL_ARTICLE_CATEGORYS = "community_manage/article/categorys";

    public static final String URL_VOTE_COUNT = "vote_manage/votes/options"; //投票选项统计
    public static final String URL_VOTE_CREATE = "votes/create";
    public static final String URL_VOTE_UPDATE = "vote_manage/votes/update";
    public static final String URL_CARD_COUPON_LIST = "community_manage/coupon/list";
    public static final String URL_CARD_PARTNER_LIST = "cloudcard_manage/partnership";
    public static final String URL_CARD_PARTNER_DELETE = "cloudcard_manage/partnership/terminate";
    public static final String URL_CARD_SCAN_RECORD_LIST = "cloudcard_manage/scan_history";
    public static final String URL_UPDATE_CLOUD_CARD_INFO = "cloudcard_manage/settings";
    public static final String URL_COUPON_AUTO_SENT_LIST = "community_manage/coupon/edit";
    public static final String URL_UPDATE_AUTO_SENT_WAY = "community_manage/coupon/update_association";
    public static final String URL_CONNECT_EVENT_LIST = "community_manage/coupon/activities";
    public static final String URL_CONNECT_EVENT = "community_manage/coupon/associate";
    public static final String URL_DISCONNECT_EVENT = "community_manage/coupon/unassociate";
    public static final String URL_MANUAL_SENT_LIST = "community_manage/coupon/member_coupons";
    public static final String URL_MANUAL_SENT_CARD_COUPON = "community_manage/coupon/grant";
    public static final String URL_CARD_SEND_RECORD_LIST = "community_manage/coupon/grant_history";
    public static final String URL_MALL_ORDER_LIST = "mall_manage/orders";
    public static final String URL_MALL_ORDER_VIEW = "mall_manage/order/view";
    public static final String URL_MALL_PRODUCT_LIST = "mall_manage/products";
    public static final String URL_MALL_MANAGE_PRODUCT_VIEW = "mall_manage/product/view";
    public static final String URL_PRODUCT_CATEGORY_LIST = "mall_manage/product_categories";
    public static final String URL_PRODUCT_MANAGE_SETTING = "mall_manage/product/setting";
    public static final String URL_PRODUCT_DELETE = "mall_manage/product/delete";
    public static final String URL_PRODUCT_CATEGORY_DELETE = "mall_manage/product_category/delete";
    public static final String URL_PRODUCT_CATEGORY_CREATE = "mall_manage/product_category/create";
    public static final String URL_PRODUCT_CATEGORY_UPDATE = "mall_manage/product_category/update";
    public static final String URL_MALL_SETTING = "mall_manage/settings";
    public static final String URL_MALL_SETTING_UPDATE = "mall_manage/setting/update";
    public static final String URL_CREATE_LOG = "log/create";
    public static final String URL_COMMUNITY_CATEGORY = "community/categorys";
    public static final String URL_COMMUNITY_TAG = "tag/create_community_tags"; //社群分类信息
    public static final String URL_COMMUNITY_CREATE = "community_manage/create_community"; //创建子社群
    public static final String URL_BASIC_AREA_CODE = "basic/area_code"; //获取国家（手机）区号列表
    public static final String URL_BASIC_COUNTRY = "basic/countries";//获取国家地区列表
    public static final String URL_BASIC_PROVINCE = "basic/provinces";//获取国家下属省份
    public static final String URL_BASIC_CITY = "basic/cities";//获取省份下属市
    public static final String URL_SUB_COM_TYPE = "community/sub_community_type";
    public static final String URL_COMMUNITY_COUPON_REVOKE = "community_manage/coupon/revoke";//收回卡券
    public static final String URL_CONTACT_GROUP_LIST = "contacts_manage/groups";
    public static final String URL_CONTACT_SETTING = "contacts_manage/contacts/setting";
    public static final String URL_CONTACT_CREATE_GROUP = "contacts_manage/group/create";
    public static final String URL_CONTACT_DELETE_GROUP = "contacts_manage/group/delete";
    public static final String URL_CONTACT_DELETE = "contacts_manage/contacts/delete";
    public static final String URL_INVITE_MANAGER = "community_manage/create_invitation";
    public static final String URL_CONTACT_IMPORT = "contacts_manage/import_contacts";
    public static final String URL_COMMUNITY_CREATE_CLUB = "community_manage/create_group";
    public static final String URL_CLUB_SETTING = "group_manage/settings";
    public static final String URL_DONATE_AMOUNT_DATA = "foundation_manage/project/amount-distribution";
    public static final String URL_DONATE_METRIC_DATA = "foundation_manage/project/metric-distribution";
    public static final String URL_DONATE_CHANNEL_DATA = "foundation_manage/project/amount-channel-distribution";
    public static final String URL_DONATE_GROUP_DATA = "foundation_manage/project/donation_group/basic_summary";
    public static final String URL_DONATE_BASIC_DATA = "foundation_manage/project/basic_summary";
    public static final String URL_COMMUNITY_INSERT_URL = "c/";//h5端社群详情
    public static final String URL_CREATE_SMS = "community_manage/sms/create";
    public static final String URL_UPDATE_SMS = "community_manage/sms/update";
    public static final String URL_SEND_SMS = "community_manage/sms/send";
    public static final String URL_SMS_SELECTOR_INFO = "contacts_manage/selectors";
    public static final String URL_SMS_VIEW = "community_manage/sms/view";
    public static final String URL_SMS_LOG_LIST = "community_manage/sms/logs";
    public static final String URL_SMS_DELETE = "community_manage/sms/delete";
    public static final String URL_SMS_STATUS = "community_manage/sms/status";
    public static final String URL_COMMUNITY_MEMBER_INFO = "community_manage/member_info";
    public static final String URL_MEMBER_FILE = "community_manage/member_files";
    public static final String URL_MEMBER_BIND_FILE = "community_manage/bind_member_file";
    public static final String URL_MEMBER_UNBIND_FILES = "community_manage/unbind_member_file";
    public static final String URL_MEMBER_RECORD_DELETE = "community_manage/del_members";
    public static final String URL_CONTACT_VIEW = "contacts_manage/contacts/view";
    public static final String URL_CONTACT_EDIT = "contacts_manage/contacts/edit";
    public static final String URL_CONTACT_UPDATE_FORM = "contacts_manage/contacts/update";
    public static final String URL_SHARE_TOOL = "tool/share";
    public static final String URL_COM_H5_MODULE_LIST = "community_manage/index_modules";
    public static final String URL_COM_H5_MODULE_UPDATE = "community_manage/update_index_module";
    public static final String URL_COM_MEMBER_FIELD_LIST = "community_manage/member_fields";
    public static final String URL_COM_MEMBER_FIELD_UPDATE = "community_manage/member_field/update";
    public static final String URL_COM_MEMBER_FIELD_CREATE = "community_manage/member_field/create";
    public static final String URL_COM_MEMBER_FIELD_DELETE = "community_manage/member_field/delete";
    public static final String URL_EVENT_MEM_SIGN_INFO = "activity_manage/signup_info";
    public static final String URL_HELP_FAQ_LIST = "help/faqs";
    public static final String URL_HELP_CATEGORY_LIST = "help/categorys";
    public static final String URL_HELP_QUESTION_VIEW = "help/document/view";
    public static final String URL_HELP_IS_USEFUL = "help/document/addNumber";
    public static final String URL_HELP_DOCUMENT_LIST = "help/documents";
    public static final String URL_CONTACT_US = "about/feedback";
    public static final String URL_OP_TRACK = "push_content/view";
    public static final String URL_RECOMMEND_ARTICLE = "operate/recommend/article";
    public static final String URL_RECOMMEND_EVENT = "operate/recommend/activity";
    public static final String URL_USER_INFO = "personal/view";
    public static final String URL_USER_INFO_SETTING = "personal/settings";
    public static final String URL_MESSAGE_INDEX = "personal/messages/index";
    public static final String URL_USER_BIND_MOBILE = "personal/rebind_mobile";
    public static final String URL_USER_EDUCATION_LIST = "personal/education";
    public static final String URL_USER_EDUCATION_CREATE = "personal/create_education";
    public static final String URL_USER_EDUCATION_UPDATE = "personal/update_education";
    public static final String URL_USER_GET_SCHOOL_INFO= "server/api/basic/school";
    public static final String URL_USER_EDUCATION_DELETE = "personal/del_education";
    public static final String URL_USER_EDUCATION = "basic/education";
    public static final String URL_USER_EDUCATION_View = "personal/edit_education";
    public static final String URL_APP_VERSION = "tool/versions";
    public static final String URL_APP_RESET_PASSWORD = "account/change_password";
    public static final String URL_APP_PUSH_MESSAGE_TYPE = "personal/messages/type";
    public static final String URL_USER_WALLET = "personal/wallet";
    public static final String URL_USER_WALLET_DETAILS = "personal/wallet_transactions";
    public static final String URL_USER_WITHDRAW_ACCOUNT = "personal/withdraw_accounts";
    public static final String URL_USER_WITHDRAW_DETAIL = "personal/cal_withdraw_fee";
    public static final String URL_USER_WITHDRAW = "personal/withdraw";
    public static final String URL_USER_WITHDRAW_ACCOUNT_CREATE = "personal/create_withdraw_account";
    public static final String URL_ACCOUNT_SEARCH_BIND = "account/bind_search";
    public static final String URL_ACCOUNT_BIND = "account/bind";
    public static final String URL_MY_COMMUNITY_LIST = "community/my-communities";
    public static final String URL_COM_ACTIVITY = "community/activities"; //社群活动
    public static final String URL_GET_PAY_ORDER = "pay/order";
    public static final String URL_PAY_BY_ALIPAY = "pay/alipay/app_request";
    public static final String URL_PAY_BY_WECHAT = "pay/weixin/unified_order";
    public static final String URL_ALIPAY_RESULT_NOTIFY = "pay/alipay/result_notify";
    public static final String URL_TRANSACTION_RECORD_VIEW = "personal/wallet_transaction/view";
    public static final String URL_MEMBER_TRANSACTION_RECORD_VIEW = "activity_manage/transaction/view";
    public static final String URL_EVENT_REFUND = "activity_manage/transaction/refound";
    public static final String URL_PRODUCT_LIST = "mall_manage/product_sku";
    public static final String URL_PRODUCT_SETTING = "mall_manage/product_sku/one_update";

    public static final String WEB_URL_CLOUD_CARD = "card/result.html?partnership_id=";
    public static final String WEB_URL_WEEKLY = "track.sosho.cn/push_content/view";
    public static final String WEB_ACTION_EVENT = "web_action_event";
    public static final String WEB_ACTION_COMMUNITY = "web_action_community";
    public static final String WEB_ACTION_ARTICLE = "web_action_article";
    public static final String WEB_ACTION_ARTICLE2 = "web_action_article2";
    public static final String WEB_ACTION_VOTE = "web_action_vote";
    public static final String WEB_ACTION_PROJECT = "web_action_project";
    public static final String WEB_ACTION_CARD = "web_action_card";
    public static final String WEB_ACTION_GROUP = "web_action_group";
    public static final String WEB_ACTION_PRODUCT = "web_action_product";
    public static final String WEB_ACTION_MALL = "web_action_mall";
    public static final String WEB_ACTION_CLUB = "web_action_club";
    public static final String WEB_ACTION_PARTNER = "web_action_partner";
    public static final String WEB_ACTION_OTHER = "web_action_other";
    public static final String WEB_ACTION_OP_TRACK = "web_action_op_track";
    public static final String WEB_ACTION_SOFT_WARE_AGREEMENT = "web_action_soft_ware_agreement";

    public static final String WEB_URL_TEL = "tel:";
    public static final String WEB_URL_PDF = ".pdf";
    public static final String WEB_ALIAS_INFO = "getInfo";
    public static final String WEB_ALIAS_ACTION = "webSignUp";

    public static final String EDIT_ACTION_NAME = "name";
    public static final String EDIT_ACTION_ABBREVIATION = "abbreviation";
    public static final String EDIT_ACTION_AREA = "area";
    public static final String EDIT_ACTION_ADDRESS = "address";
    public static final String EDIT_ACTION_TEL = "tel";
    public static final String EDIT_ACTION_INTRO = "intro";
    public static final String EDIT_ACTION_REMARK = "remark";

    public static final String EVENT_ID_EVENT_TYPE = "11001";
    public static final String EVENT_ID_COM_TYPE = "11002";
    public static final String EVENT_ID_ARTICLE_TYPE = "11003";
    public static final String EVENT_ID_NORMAL_TYPE = "11004";
    public static final String EVENT_ID_OTHER_TYPE = "11005";

    public static final String JS_SHARE_LOGO = "javascript:window.getInfo.getLogoUrl(document.getElementById('app-share-logo-img').src);";
    public static final String JS_SHARE_INTRO = "javascript:window.getInfo.getShareInfo(document.getElementById('app-share-description').innerText);";
    public static final String JS_VOTE_INTRO = "javascript:window.getInfo.getVoteInfo(document.getElementById('vote-description').innerText);";
    public static final String JS_ARTICLE_INTRO = "javascript:window.getInfo.getActInfo(document.getElementById('act-intro').innerText);";
    public static final String JS_DONATE_INTRO = "javascript:window.getInfo.getDonateInfo(document.getElementById('J-info-content').innerText);";
    public static final String JS_EVENT_INTRO = "javascript:window.getInfo.getEventInfo(document.getElementById('activityInfoContent').innerText);";
    public static final String JS_UPLOAD_PIC_CANCEL = "javascript:imgUploadCancel()";
    public static final String JS_UPLOAD_FILE_CANCEL = "javascript:fileUploadCancel()";

    public static final String ACTION_REFRESH_ARTICLE_LIST = "cn.usho.sosho.REFRESH_ARTICLE_LIST";
    public static final String ACTION_REFRESH_VOTE_LIST = "cn.usho.sosho.REFRESH_VOTE_LIST";
    public static final String ACTION_REFRESH_PROJECT_LIST = "cn.usho.sosho.REFRESH_PROJECT_LIST";
    public static final String ACTION_REFRESH_PHOTO_LIST = "cn.usho.sosho.REFRESH_PHOTO_LIST";
    public static final String ACTION_REFRESH_ALBUM_LIST = "cn.usho.sosho.REFRESH_ALBUM_LIST";
    public static final String ACTION_REFRESH_CLOUD_CARD = "cn.usho.sosho.REFRESH_CLOUD_CARD";
    public static final String ACTION_REFRESH_AUTO_SENT_LIST = "cn.usho.sosho.REFRESH_AUTO_SENT_LIST";
    public static final String ACTION_REFRESH_MEMBER_LIST = "cn.usho.sosho.REFRESH_MEMBER_LIST";
    public static final String ACTION_REFRESH_GROUP_LIST = "cn.usho.sosho.REFRESH_GROUP_LIST";
    public static final String ACTION_REFRESH_EVENT_GROUP_LIST = "cn.usho.sosho.REFRESH_EVENT_GROUP_LIST";
    public static final String ACTION_REFRESH_ORDER_LIST = "cn.usho.sosho.REFRESH_ORDER_LIST";
    public static final String ACTION_REFRESH_EVENT_MEMBER_LIST = "cn.usho.sosho.REFRESH_EVENT_MEMBER_LIST";
    public static final String ACTION_REFRESH_SEARCH_EVENT_MEMBER_LIST = "cn.usho.sosho.REFRESH_SEARCH_EVENT_MEMBER_LIST";
    public static final String ACTION_REFRESH_SIGNIN_LIST = "cn.usho.sosho.REFRESH_SIGNIN_LIST";
    public static final String ACTION_REFRESH_SIGNUP_LIST = "cn.usho.sosho.REFRESH_SIGNUP_LIST";
    public static final String ACTION_REFRESH_VERIFY_LIST = "cn.usho.sosho.REFRESH_VERIFY_LIST";
    public static final String ACTION_REFRESH_COM_BASIC_INFO = "cn.usho.sosho.REFRESH_COM_BASIC_INFO";
    public static final String ACTION_REFRESH_COM_FIELD_LIST = "cn.usho.sosho.REFRESH_COM_FIELD_LIST";
    public static final String ACTION_REFRESH_PRODUCT_TAB1_FRAGMENT = "cn.usho.sosho.REFRESH_PRODUCT_TAB1_FRAGMENT";
    public static final String ACTION_REFRESH_PRODUCT_TAB2_FRAGMENT = "cn.usho.sosho.REFRESH_PRODUCT_TAB2_FRAGMENT";
    public static final String ACTION_REFRESH_PRODUCT_LIST= "cn.usho.sosho.REFRESH_PRODUCT_LIST";
    public static final String ACTION_REFRESH_CONTACT_FILE = "cn.usho.sosho.REFRESH_CONTACT_FILE";
    public static final String ACTION_REFRESH_H5_MODULE_LIST = "cn.usho.sosho.REFRESH_H5_MODULE_LIST";
    public static final String ACTION_REFRESH_USER_INFO = "cn.usho.sosho.REFRESH_USER_INFO";
    public static final String ACTION_REFRESH_USER_ACCOUNT_LIST = "cn.usho.sosho.REFRESH_USER_ACCOUNT_LIST";
    public static final String ACTION_REFRESH_PUSH_MSG = "cn.usho.sosho.REFRESH_PUSH_MSG";
    public static final String ACTION_REFRESH_CLUB_DATA = "cn.usho.sosho.REFRESH_CLUB_DATA";
    public static final String ACTION_REFRESH_EVENT_LIST = "cn.usho.sosho.REFRESH_EVENT_LIST";
    public static final String ACTION_REFRESH_MY_EVENT_LIST = "cn.usho.sosho.REFRESH_MY_EVENT_LIST";
    public static final String ACTION_GO_BACK_AND_RESET_WEBVIEW = "cn.usho.sosho.GO_BACK_AND_RESET_WEBVIEW";

    public static final String SHARE_H5_EVENT = "a/";//活动分享
    public static final String SHARE_H5_COM = "c/";//社群分享
    public static final String SHARE_H5_CLUB = "g/";//俱乐部分享
    public static final String SHARE_H5_CLUB_INTRO = "forapp/info.html?";
    public static final String SHARE_H5_ART = "art/";//社群文章分享
    public static final String SHARE_H5_ARTICLE = "article/detail.html?";//社群文章分享
    public static final String SHARE_H5_COM_VOTE = "vote/";//社群文章分享
    public static final String SHARE_H5_VOTE = "vote/detail.html?";//社群文章分享
    public static final String SHARE_H5_INVITE = "iv/gsG=";//成员邀请分享
    public static final String SHARE_H5_SOSHO_ART = "doc/";//社汇文章分享
    public static final String SHARE_H5_TEAM = "t/";//活动队伍分享
    public static final String SHARE_H5_SIGNIN_CODE = "activity/checkin.html?";//h5端扫描二维码
    public static final String SHARE_H5_PROJECT = "fs/project/detail.html?";//项目
    public static final String SHARE_H5_QUESTION_INFO = "doc/content.html?";//使用帮助
    public static final String SHARE_H5_CARD = "card/detail.html?";//云卡详情
    public static final String SHARE_H5_GROUP = "activity/team/detail.html?";//活动小队分享
    public static final String SHARE_H5_PRODUCT = "shop/offer/detail.html?";//商品详情
    public static final String SHARE_H5_MALL = "shop/mall.html?";//店铺详情
    public static final String SHARE_H5_PARTNER = "card/result.html?";//合作机构详情
    public static final String SHARE_H5_HELP = "doc/help.html?";//帮助中心详情
    public static final String SHARE_H5_MEMBER_INFO = "admin/community/member.html?";//成员详情
    public static final String SHARE_H5_COM_ALBUM = "community/gallery/photos.html?";
    public static final String SHARE_H5_SURVEY= "survey/index.html?";
    public static final String SHARE_H5_RESULT= "survey/result.html?";

    //相机相关权限
    public static final String[] CAMERA_PERMISSIONS = {Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //读取联系人权限
    public static final String[] CONTACTS_PERMISSIONS = {Manifest.permission.READ_CONTACTS};

    //照片选择模式
    public final static String ACTION_PHOTO_SELECT_MODE = "select_mode";
    //最大选择数量
    public final static String ACTION_PHOTO_MAX_NUM = "max_num";
    public final static String ACTION_EVENT_CREATE = "event_create";
    public final static String ACTION_EVENT_CREATE2 = "event_create2";
    public final static String ACTION_EVENT_UPDATE = "event_update";
    public final static String ACTION_ARTICLE_CREATE = "article_create";
    public final static String ACTION_ARTICLE_UPDATE = "article_update";
    public final static String ACTION_VOTE_CREATE = "vote_create";
    public final static String ACTION_VOTE_UPDATE = "vote_update";
    public final static String ACTION_SMS_CREATE = "sms_create";
    public final static String ACTION_SMS_UPDATE = "sms_update";
    public final static String ACTION_CATEGORY_CREATE = "category_create";
    public final static String ACTION_CATEGORY_UPDATE = "category_update";
    public final static String ACTION_EVENT_CREATE_AGAIN = "event_create_again";
    public final static String ACTION_EVENT_LOCATION = "event_logcation";
    public final static String ACTION_LOG_LOCATION = "log_location";
    public final static String ACTION_SEARCH_PHOTO = "search_photo";
    public final static String ACTION_SEARCH_ALBUM = "search_album";
    public final static String ACTION_CHECK_PIC = "check_pic";
    public final static String ACTION_EDIT_PIC = "edit_pic";
    public static final String ACTION_PREVIEW_REPORT = "preview_report";
    public static final String ACTION_PREVIEW_NORMAL = "preview_normal";
    public static final String ACTION_SMS_SEND = "sms_send";
    public static final String ACTION_SMS_REPORT = "sms_report";
    public static final String ACTION_SMS_DELETE = "sms_delete";
    public static final String ACTION_SMS_CLOSE = "sms_close";
    public static final String ACTION_CONTACT_EDIT = "contact_edit";
    public static final String ACTION_CONTACT_COPY = "contact_copy";
    public static final String ACTION_CONTACT_MANAGE = "contact_manage";
    public static final String ACTION_CONTACT_DELETE = "contact_delete";
    public final static String ACTION_SELECT_CONTACT_FOR_MSG = "select_contact_for_msg";
    public final static String ACTION_SELECT_CONTACT_FOR_LOG = "select_contact_for_log";
    public final static String PHOTO_RESULT_LIST_KEY = "photo_result_list";
    public final static String ACTION_REFUSE_REASON_TAG1 = "reason_tag1";
    public final static String ACTION_REFUSE_REASON_TAG2 = "reason_tag2";
    public final static String ACTION_REFUSE_REASON_TAG3 = "reason_tag3";
    public static final String ACTION_EDUCATION_CREATE = "education_create";
    public static final String ACTION_EDUCATION_UPDATE = "education_update";
    public static final String ACTION_SUB_COMMUNITY = "sub_community";
    public static final String ACTION_MAIN_COMMUNITY = "main_community";
    public static final String ACTION_START_FROM = "start_from";
    public static final String ACTION_JPUSH_MSG = "sosho.jpush.msg"; //发送广播action

    public static final String ACTION_DOWNLOAD_CANCEL = "download_cancel";
    public static final String ACTION_DOWNLOAD_FINISH = "download_finish";
    public static final String ACTION_DOWNLOAD_PERCENT = "download_percent";

    public static final String CONTENT_TYPE_IMAGE = "image";
    public static final String CONTENT_TYPE_RADIO = "radio";
    public static final String CONTENT_TYPE_CHECKBOX = "checkbox";
    public static final String CONTENT_TYPE_TEXT = "text";
    public static final String CONTENT_TYPE_TEXTAREA = "textarea";
    public static final String CONTENT_TYPE_NUMBER = "number";
    public static final String CONTENT_TYPE_MOBILE = "mobile";
    public static final String CONTENT_TYPE_EMAIL = "email";
    public static final String CONTENT_TYPE_SELECT = "select";
    public static final String CONTENT_TYPE_ATTACHMENT = "attachment";

    //本地缓存时效默认3天
    public final static int LOCAL_CACHE_TIME_3_DAYS = 60 * 60 * 24 * 3;
    //账号密码缓存时效默认7天
    public final static int LOCAL_CACHE_TIME_7_DAYS = 60 * 60 * 24 * 7;
    //七牛云上传图片数据缓存半小时
    public final static int LOCAL_CACHE_TIME_HALF_HOURS = 60 * 30;

    // / 没有连接
    public static final String NETWORK_NONE = "NETWORK_NONE";
    // / wifi连接
    public static final String NETWORK_WIFI = "NETWORK_WIFI";
    // / 手机网络数据连接
    public static final String NETWORK_2G = "NETWORK_2G";
    public static final String NETWORK_3G = "NETWORK_3G";
    public static final String NETWORK_4G = "NETWORK_4G";
    public static final String NETWORK_MOBILE = "NETWORK_MOBILE";
    public static final String DOWNLOAD_FLAG_KEY = "download_flag";
    public static final String DOWNLOAD_URL_KEY = "download_url";
    //普通更新
    public static final int FLAG_UPDATE = 1;
    //应用强制更新
    public static final int FLAG_UPDATE_NOW = 2;

    public static final String ICO_PATH = "?imageView2/0/w/%d/h/%d/q/100";
    public static final String SHARE_APP_LOGO = "http://pics.sosho.cn/soshologo.jpg!square96";
    public static final String SHARE_APP_DOWNLOAD = "qrcode.html";
    public static final String SOFT_WARE_AGREEMENT1 = "http://h5.sosho.cn/doc/content.html?id=1";
    public static final String SOFT_WARE_AGREEMENT2 = "http://h5.sosho.cn/doc/content.html?id=67";
    public static final String SERVICE_CHARGE_EXPLAIN = "http://h5.sosho.cn/doc/content.html?id=11";
    public static final String WECHAT_APPID = "wx9228faf2b39f8b82";
    public static final String MOB_APPID = "7fcae59a62342e7e2759e9e397c82bdd";
    public static final String BUGLY_APPID = "3db39d61ad";
    public static boolean MY_COM_HEADER_TAG = true;
    public static final String[] APP_ALL_PERMISSIONS = {Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS,
            Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    public static String jsUploadPicSuccess(String path) {
        return "javascript:imgUploadSuccess('" + path + "')";
    }

    public static String jsUploadFileSuccess(String path) {
        return "javascript:fileUploadSuccess('" + path + "')";
    }

//    public static String getH5Url(String mode) {
//        String WEB_SERVER = "https://h5.sosho.cn/";  //master
//        //String WEB_SERVER = "http://test.h5.sosho.cn/"; //test
//        //String WEB_SERVER = "http://dev.h5.sosho.cn/"; //dev
//        String api = (String) DataCacheUtils.get(BaseApplicationLike.getMyApplicationContext(), API_SERVER, "");
//        if ("master".equals(api)) {
//            WEB_SERVER = "https://h5.sosho.cn/";
//        } else if ("test".equals(api)) {
//            WEB_SERVER = "http://test.h5.sosho.cn/";
//        } else if ("dev".equals(api)) {
//            WEB_SERVER = "http://dev.h5.sosho.cn/";
//        }
//        return WEB_SERVER + mode;
//    }
//
//    public static String getBaseUrl() {
//        String SERVER = "https://api.sosho.cn/";  //master
//        //String SERVER = "http://test.api.sosho.cn/"; //test
//        //String SERVER = "http://dev.api.sosho.cn/"; //dev
//        String api = (String) DataCacheUtils.get(BaseApplicationLike.getMyApplicationContext(), API_SERVER, "");
//        if ("master".equals(api)) {
//            SERVER = "https://api.sosho.cn/";
//        } else if ("test".equals(api)) {
//            SERVER = "http://test.api.sosho.cn/"; //test
//        } else if ("dev".equals(api)) {
//            SERVER = "http://dev.api.sosho.cn/"; //dev
//        }
//
//        return SERVER;
//    }
//
    public static String getBaseUrl(String mode) {
//        String SERVER = "https://api.sosho.cn/";  //master
        String SERVER = "http://test.api.sosho.cn/"; //test
        //String SERVER = "http://dev.api.sosho.cn/"; //dev
        String api = SPUtils.getInstance().getString(API_SERVER);
        if ("master".equals(api)) {
            SERVER = "https://api.sosho.cn/";
        } else if ("test".equals(api)) {
            SERVER = "http://test.api.sosho.cn/"; //test
        } else if ("dev".equals(api)) {
            SERVER = "http://dev.api.sosho.cn/"; //dev
        }

        return SERVER + mode;
    }
//    public static String getBaseServerUrl(String mode) {
//        String SERVER = "https://admin.sosho.cn/";  //master
//        //String SERVER = "http://test.api.sosho.cn/"; //test
//        String api = (String) DataCacheUtils.get(BaseApplicationLike.getMyApplicationContext(), API_SERVER, "");
//        if ("master".equals(api)) {
//            SERVER = "https://admin.sosho.cn/";
//        } else if ("test".equals(api)) {
//            SERVER = "http://test.admin.sosho.cn/"; //test
//        }
//
//        return SERVER + mode;
//    }
//
//    public static String getMainBaseUrl(String mode) {
//        String SERVER = "https://api.sosho.cn/";  //master
//        return SERVER + mode;
//    }
//
//    public static String getOpUrl(String model) {
//        String OP_SOCKET_HOST = "http://track.sosho.cn/";
//        //String OP_SOCKET_HOST = "http://dev.track.sosho.cn/"; //dev
//        //String OP_SOCKET_HOST = "http://test.track.sosho.cn/"; //test
//        String api = (String) DataCacheUtils.get(BaseApplicationLike.getMyApplicationContext(), API_SERVER, "");
//        if ("master".equals(api)) {
//            OP_SOCKET_HOST = "http://track.sosho.cn/";
//        } else if ("test".equals(api)) {
//            OP_SOCKET_HOST = "http://test.track.sosho.cn/";
//        } else if ("dev".equals(api)) {
//            OP_SOCKET_HOST = "http://dev.track.sosho.cn/";
//        }
//        return OP_SOCKET_HOST + model;
//    }
//
//    public static String getWeeklyParamsId() {
//
//        /*String id = "92343";
//
//        String api = (String) DataCacheUtils.get(BaseApplication.getInstance().getApplicationContext(), ParameterUtils.API_SERVER, "");
//        if ("master".equals(api)) {
//            id = "92343";
//        } else if ("test".equals(api)) {
//            id = "14"; //test
//        }*/
//
//        return "11005";
//    }

}
