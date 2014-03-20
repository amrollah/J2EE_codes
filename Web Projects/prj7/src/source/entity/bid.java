package source.entity;

public class bid {
	private int id;
	private double bid;
	private int auction_id;
	private user user;

	public bid(double bid, int auction_id, source.entity.user user) {
		super();
		this.bid = bid;
		this.auction_id = auction_id;
		this.user = user;
	}

	public int getAuction_bid() {
		return auction_id;
	}

	public void setAuction_bid(int auction_id) {
		this.auction_id = auction_id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public bid() {

		// TODO Auto-generated constructor stub
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

}
