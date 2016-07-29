package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;

import jp.co.scsac.entity.Book;

import java.sql.Timestamp;

/**
 * The persistent class for the book_status_history database table.
 *
 */
@Entity
@Table(name = "book_status_history")
public class BookStatusHistory implements Serializable {
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

    // bi-directional many-to-one association to BookInfo
    @ManyToOne
    @JoinColumn(name = "book_info_id")
    private BookInfo bookInfo;

    // bi-directional many-to-one association to Book
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // bi-directional many-to-one association to ProcessTypeMaster
    @ManyToOne
    @JoinColumn(name = "process_type_master_id")
    private ProcessTypeMaster processTypeMaster;

    public BookStatusHistory() {
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

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ProcessTypeMaster getProcessTypeMaster() {
        return this.processTypeMaster;
    }

    public void setProcessTypeMaster(ProcessTypeMaster processTypeMaster) {
        this.processTypeMaster = processTypeMaster;
    }

}