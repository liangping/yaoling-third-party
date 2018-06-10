package io.yaoling.starter.weixin.mp.input;

import io.yaoling.starter.weixin.message.parts.News;

import java.util.List;

public class CustomNewsMessageInput {
	
	public static class InnerNews {
		private List<News> articles;

		public List<News> getArticles() {
			return articles;
		}
		public void setArticles(List<News> articles) {
			this.articles = articles;
		}
	}
	
	public CustomNewsMessageInput() {
		super();
	}
	public CustomNewsMessageInput(String touser, List<News> articles) {
		super();
		this.touser = touser;
		this.news.setArticles(articles);
	}
	private String touser;
	private String msgtype = "news";
	private InnerNews news = new InnerNews();
	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}
	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}
	/**
	 * @return the msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @param msgtype the msgtype to set
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public InnerNews getNews() {
		return news;
	}
	public void setNews(InnerNews news) {
		this.news = news;
	}
}
