package io.yaoling.starter.weixin.mp.output.elements;

import java.util.List;

public class Menu {
	private List<MenuButton> button;
	private long menuid;
	private MenuMatchRule matchrule;

	public List<MenuButton> getButton() {
		return button;
	}

	public void setButton(List<MenuButton> button) {
		this.button = button;
	}

	/**
	 * @return the menuid
	 */
	public long getMenuid() {
		return menuid;
	}

	/**
	 * @param menuid the menuid to set
	 */
	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	/**
	 * @return the matchrule
	 */
	public MenuMatchRule getMatchrule() {
		return matchrule;
	}

	/**
	 * @param matchrule the matchrule to set
	 */
	public void setMatchrule(MenuMatchRule matchrule) {
		this.matchrule = matchrule;
	}
}
