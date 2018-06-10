package io.yaoling.starter.weixin.message;


import io.yaoling.starter.weixin.message.parts.Music;

public interface MusicMessage extends Message {

	public Music getMusic();

	public void setMusic(Music music);
}
