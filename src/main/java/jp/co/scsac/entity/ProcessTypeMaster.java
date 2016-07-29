package jp.co.scsac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the process_type_master database table.
 *
 */
@Entity
@Table(name="process_type_master")
public class ProcessTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="process_type_name")
	private String processTypeName;

	@Column(name="update_account_id")
	private String updateAccountId;

	@Column(name="update_at")
	private Timestamp updateAt;

	private Integer version;

	//bi-directional many-to-one association to BookStatusHistory
	@OneToMany(mappedBy="processTypeMaster")
	private List<BookStatusHistory> bookStatusHistories;

	public ProcessTypeMaster() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getProcessTypeName() {
		return this.processTypeName;
	}

	public void setProcessTypeName(String processTypeName) {
		this.processTypeName = processTypeName;
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

	public List<BookStatusHistory> getBookStatusHistories() {
		return this.bookStatusHistories;
	}

	public void setBookStatusHistories(List<BookStatusHistory> bookStatusHistories) {
		this.bookStatusHistories = bookStatusHistories;
	}

	public BookStatusHistory addBookStatusHistory(BookStatusHistory bookStatusHistory) {
		getBookStatusHistories().add(bookStatusHistory);
		bookStatusHistory.setProcessTypeMaster(this);

		return bookStatusHistory;
	}

	public BookStatusHistory removeBookStatusHistory(BookStatusHistory bookStatusHistory) {
		getBookStatusHistories().remove(bookStatusHistory);
		bookStatusHistory.setProcessTypeMaster(null);

		return bookStatusHistory;
	}

}