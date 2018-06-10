package io.yaoling.starter.weixin.mp.output;

public class ApiTicketOutput extends JsonOutput {
	private String ticket;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
