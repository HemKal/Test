package com.lca.phx.interview.garage;

public class Ticket {

	private long spaceId;

	public Ticket(long spaceId) {
		this.spaceId = spaceId;
	}

	public long getSpaceId() {
		return spaceId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [spaceId=").append(spaceId).append("]");
		return builder.toString();
	}
	
}
