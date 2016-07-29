package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tag_name_management database table.
 *
 */
@Entity
@Table(name="tag_name_management")
public class TagNameManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="tag_name")
	private String tagName;

	@Column(name="update_account_id")
	private String updateAccountId;

	@Column(name="update_at")
	private Timestamp updateAt;

	private Integer version;

	//bi-directional many-to-one association to BookTag
	@OneToMany(mappedBy="tagNameManagement")
	private List<BookTag> bookTags;

	public TagNameManagement() {
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

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
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
		bookTag.setTagNameManagement(this);

		return bookTag;
	}

	public BookTag removeBookTag(BookTag bookTag) {
		getBookTags().remove(bookTag);
		bookTag.setTagNameManagement(null);

		return bookTag;
	}

}