package com.leo.data.dao.db;

/**
 * @author leo, ZhangWei
 * @date 2018/4/25
 * @function
 */
public class MessageDAO {

    private Integer id;
    private String message_id;
    private String title;
    private String content;
    private String mct_id;
    private String is_read;
    private String ctime;

    public MessageDAO() {

    }

    public MessageDAO(String message_id, String title, String content, String mct_id, String is_read, String ctime) {
        this.message_id = message_id;
        this.title = title;
        this.content = content;
        this.mct_id = mct_id;
        this.is_read = is_read;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMct_id() {
        return mct_id;
    }

    public void setMct_id(String mct_id) {
        this.mct_id = mct_id;
    }

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "MessageDAO{" +
                "id=" + id +
                ", message_id='" + message_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mct_id='" + mct_id + '\'' +
                ", is_read='" + is_read + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
