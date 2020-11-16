package cbf.domain;

public class Book {
	private String bid;
	private String bookname;
	private String writer;
	private String publication;
	private int isBorrowed;//1表示被借走   0表示未被借走
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getIsBorrowed() {
		return isBorrowed;
	}
	public void setIsBorrowed(int isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
}
