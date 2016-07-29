package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the book_tag database table.
 *
 */
@Entity
@Table(name = "book_tag")
public class BookTag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "update_account_id")
    private String updateAccountId;

    @Column(name = "update_at")
    private Timestamp updateAt;

    private Integer version;

    @ManyToOne
    @JoinColumn(name = "tag_name_management_id")
    private TagNameManagement tagNameManagement;

    @ManyToOne
    @JoinColumn(name = "book_info_id")
    private BookInfo bookInfo;

    public BookTag() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAccountId() {
        return this.updateAccountId;
    }

    public void setUpdateAccountId(String updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

    public Timestamp getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BookInfo getBookInfo() {
        return this.bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public TagNameManagement getTagNameManagement() {
        return tagNameManagement;
    }

    public void setTagNameManagement(TagNameManagement tagNameManagement) {
        this.tagNameManagement = tagNameManagement;
    }

}