package io.yaoling.starter.weixin.mp.output;

public class JsTicketOutput extends JsonOutput {

    private String ticket;
    private int expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public int getExpires_in() {
        return expires_in;
    }

    @Override
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
