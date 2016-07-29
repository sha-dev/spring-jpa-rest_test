package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;

import jp.co.scsac.entity.Book;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the rental_info database table.
 *
 */
@Entity
@Table(name="rental_info")
/*@NamedQuery(name="RentalInfo.findAll", query="SELECT r FROM RentalInfo r")*/
public class RentalInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(name="account_id")
    private String accountId;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name="rental_date")
    private Date rentalDate;

    @Temporal(TemporalType.DATE)
    @Column(name="return_date")
    private Date returnDate;

    @Temporal(TemporalType.DATE)
    @Column(name="return_due_date")
    private Date returnDueDate;

    @Column(name="update_account_id")
    private String updateAccountId;

    @Column(name="update_at")
    private Timestamp updateAt;

    private Integer version;

    //bi-directional many-to-one association to Book
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    public RentalInfo() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getRentalDate() {
        return this.rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDueDate() {
        return this.returnDueDate;
    }

    public void setReturnDueDate(Date returnDueDate) {
        this.returnDueDate = returnDueDate;
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

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}