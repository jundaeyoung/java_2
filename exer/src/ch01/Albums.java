package ch01;

public class Albums {

	private int userId;
	private int id;
	private String title;

	
	
	@Override
	public String toString() {
		return "Albums [userId=" + userId + ", id=" + id + ", title=" + title + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
