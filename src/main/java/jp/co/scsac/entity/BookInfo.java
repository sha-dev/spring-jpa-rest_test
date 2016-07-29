package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import jp.co.scsac.entity.Book;

/**
 * The persistent class for the book_info database table.
 *
 */
@Entity
@Table(name = "book_info")
public class BookInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String author;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private Integer isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "published_date")
    private Date publishedDate;

    @Column(name = "update_account_id")
    private String updateAccountId;

    @Column(name = "update_at")
    private Timestamp updateAt;

    private Integer version;

    // bi-directional many-to-one association to BookTag
    @OneToMany(mappedBy = "bookInfo")
    private List<BookTag> bookTags;

    // bi-directional many-to-one association to Book
    @OneToMany(mappedBy = "bookInfo")
    private List<Book> books;

    // bi-directional many-to-one association to RecommendedRecord
    @OneToMany(mappedBy = "bookInfo")
    private List<RecommendedRecord> recommendedRecords;

    // bi-directional many-to-one association to ReadingRecord
    @OneToMany(mappedBy = "bookInfo")
    private List<ReadingRecord> readingRecords;

    // bi-directional many-to-one association to BookStatusHistory
    @OneToMany(mappedBy = "bookInfo")
    private List<BookStatusHistory> bookStatusHistories;

    public BookInfo() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return this.publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
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

    public List<BookTag> getBookTags() {
        return this.bookTags;
    }

    public void setBookTags(List<BookTag> bookTags) {
        this.bookTags = bookTags;
    }

    public BookTag addBookTag(BookTag bookTag) {
        getBookTags().add(bookTag);
        bookTag.setBookInfo(this);

        return bookTag;
    }

    public BookTag removeBookTag(BookTag bookTag) {
        getBookTags().remove(bookTag);
        bookTag.setBookInfo(null);

        return bookTag;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book addBook(Book book) {
        getBooks().add(book);
        book.setBookInfo(this);

        return book;
    }

    public Book removeBook(Book book) {
        getBooks().remove(book);
        book.setBookInfo(null);

        return book;
    }

    public List<RecommendedRecord> getRecommendedRecords() {
        return this.recommendedRecords;
    }

    public void setRecommendedRecords(List<RecommendedRecord> recommendedRecords) {
        this.recommendedRecords = recommendedRecords;
    }

    public RecommendedRecord addRecommendedRecord(RecommendedRecord recommendedRecord) {
        getRecommendedRecords().add(recommendedRecord);
        recommendedRecord.setBookInfo(this);

        return recommendedRecord;
    }

    public RecommendedRecord removeRecommendedRecord(RecommendedRecord recommendedRecord) {
        getRecommendedRecords().remove(recommendedRecord);
        recommendedRecord.setBookInfo(null);

        return recommendedRecord;
    }

    public List<ReadingRecord> getReadingRecords() {
        return this.readingRecords;
    }

    public void setReadingRecords(List<ReadingRecord> readingRecords) {
        this.readingRecords = readingRecords;
    }

    public ReadingRecord addReadingRecord(ReadingRecord readingRecord) {
        getReadingRecords().add(readingRecord);
        readingRecord.setBookInfo(this);

        return readingRecord;
    }

    public ReadingRecord removeReadingRecord(ReadingRecord readingRecord) {
        getReadingRecords().remove(readingRecord);
        readingRecord.setBookInfo(null);

        return readingRecord;
    }

    public List<BookStatusHistory> getBookStatusHistories() {
        return this.bookStatusHistories;
    }

    public void setBookStatusHistories(List<BookStatusHistory> bookStatusHistories) {
        this.bookStatusHistories = bookStatusHistories;
    }

    public BookStatusHistory addBookStatusHistory(BookStatusHistory bookStatusHistory) {
        getBookStatusHistories().add(bookStatusHistory);
        bookStatusHistory.setBookInfo(this);

        return bookStatusHistory;
    }

    public BookStatusHistory removeBookStatusHistory(BookStatusHistory bookStatusHistory) {
        getBookStatusHistories().remove(bookStatusHistory);
        bookStatusHistory.setBookInfo(null);

        return bookStatusHistory;
    }

}