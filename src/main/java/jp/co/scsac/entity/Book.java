package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the book database table.
 *
 */
@Entity
public class Book implements Serializable {
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

    // bi-directional many-to-one association to BookStatusHistory
    @OneToMany(mappedBy = "book")
    private List<BookStatusHistory> bookStatusHistories;

    // bi-directional many-to-one association to RentalInfo
    @OneToMany(mappedBy = "book")
    private List<RentalInfo> rentalInfos;

    // bi-directional many-to-one association to BookStatusMaster
    @ManyToOne
    @JoinColumn(name = "book_status_master_id")
    private BookStatusMaster bookStatusMaster;

    public Book() {
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

    public List<BookStatusHistory> getBookStatusHistories() {
        return this.bookStatusHistories;
    }

    public void setBookStatusHistories(List<BookStatusHistory> bookStatusHistories) {
        this.bookStatusHistories = bookStatusHistories;
    }

    public BookStatusHistory addBookStatusHistory(BookStatusHistory bookStatusHistory) {
        getBookStatusHistories().add(bookStatusHistory);
        bookStatusHistory.setBook(this);

        return bookStatusHistory;
    }

    public BookStatusHistory removeBookStatusHistory(BookStatusHistory bookStatusHistory) {
        getBookStatusHistories().remove(bookStatusHistory);
        bookStatusHistory.setBook(null);

        return bookStatusHistory;
    }

    public List<RentalInfo> getRentalInfos() {
        return this.rentalInfos;
    }

    public void setRentalInfos(List<RentalInfo> rentalInfos) {
        this.rentalInfos = rentalInfos;
    }

    public RentalInfo addRentalInfo(RentalInfo rentalInfo) {
        getRentalInfos().add(rentalInfo);
        rentalInfo.setBook(this);

        return rentalInfo;
    }

    public RentalInfo removeRentalInfo(RentalInfo rentalInfo) {
        getRentalInfos().remove(rentalInfo);
        rentalInfo.setBook(null);

        return rentalInfo;
    }

    public BookStatusMaster getBookStatusMaster() {
        return this.bookStatusMaster;
    }

    public void setBookStatusMaster(BookStatusMaster bookStatusMaster) {
        this.bookStatusMaster = bookStatusMaster;
    }

}