package io.yaoling.starter.weixin.message;

import io.yaoling.starter.weixin.message.parts.News;

import java.util.List;

public interface NewsMessage extends Message {

	public Integer getArticleCount();

	public void setArticleCount(Integer articleCount);

	public List<News> getArticles();

	public void setArticles(List<News> articles);

}
