package domain;

public class ProductVO {

	private long pno;
	private String pname;
	private int price;
	private String madeBy;
	private String regAt;
	private String writer;
	private String category;
	private String description;
	private String modAt;
	private int readCount;
	private String imgFile;

	public ProductVO() {
	}
	//register
		public ProductVO(String pname, int price, String madeBy, String writer, String category, String description,
				String imgFile) {
			this.pname = pname;
			this.price = price;
			this.madeBy = madeBy;
			this.writer = writer;
			this.category = category;
			this.description = description;
			this.imgFile = imgFile;
		}
		// list
		public ProductVO(long pno, String pname, int price, String writer, String modAt, int readCount, String imgFile) {
			this.pno = pno;
			this.pname = pname;
			this.price = price;
			this.writer = writer;
			this.modAt = modAt;
			this.readCount = readCount;
			this.imgFile = imgFile;
		}
		// modify
		public ProductVO(long pno, String pname, int price, String madeBy, String category, String description,
				String imgFile) {
			this.pno = pno;
			this.pname = pname;
			this.price = price;
			this.madeBy = madeBy;
			this.category = category;
			this.description = description;
			this.imgFile = imgFile;
		}
		// detail
		public ProductVO(long pno, String pname, int price, String madeBy, String regAt, String writer, String category,
				String description, String modAt, int readCount, String imgFile) {
			this.pno = pno;
			this.pname = pname;
			this.price = price;
			this.madeBy = madeBy;
			this.regAt = regAt;
			this.writer = writer;
			this.category = category;
			this.description = description;
			this.modAt = modAt;
			this.readCount = readCount;
			this.imgFile = imgFile;
		}
	
	public long getPno() {
		return pno;
	}

	public void setPno(long pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModAt() {
		return modAt;
	}

	public void setModAt(String modAt) {
		this.modAt = modAt;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", made_by=" + madeBy + ", reg_at="
				+ regAt + ", writer=" + writer + ", category=" + category + ", description=" + description + ", mod_at="
				+ modAt + ", read_count=" + readCount + ", img_file=" + imgFile + "]";
	}

}
