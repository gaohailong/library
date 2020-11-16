package cbf.domain;

public class BorrowInfo {
	private String uid;
	private String name;
	private int level;//0-学生 1-工作者 2-管理员
	private String bid;
	private String bookname;
	private String writer;
	private String publication;
	private String borrowTime;
	private String returnTime;
	private int inhistory;//1表示借过且还了  0借过还没还 -1表示是申请借书，-2表示申请还书
	/*
	 * 一个逻辑关系：比如学生申请借书，即inhistory=-1，工作者需要确定其是否借书，确定则改成inhistory=0，
	 * 而且book的isBorrowed改为1表示被借走；	
	 * 学生申请还书，即inhistory=-2，工作者需要确定其是否还书成功，确定则改成inhistory=1，
	 * 而且book的isBorrowed改为0表示未被借走；	
	 * 
	 * 工作者：当借书成功的时候，则将时间获得并存入borrowTime，而还书成功时，则获得时间并存入returnTime
	 * */
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
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
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public int getInhistory() {
		return inhistory;
	}
	public void setInhistory(int inhistory) {
		this.inhistory = inhistory;
	}
	
}
