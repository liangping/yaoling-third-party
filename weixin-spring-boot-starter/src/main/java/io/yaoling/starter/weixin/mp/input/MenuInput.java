package io.yaoling.starter.weixin.mp.input;

import io.yaoling.starter.weixin.mp.output.elements.MenuButton;

import java.util.List;

/**
 * 创建菜单的数据结构包装类，字段名不能变
 * @author liangping
 *
 */
public class MenuInput {
	
	public MenuInput() {
		super();
	}

	public MenuInput(List<MenuButton> button) {
		super();
		this.button = button;
	}

	private List<MenuButton> button;

	public List<MenuButton> getButton() {
		return button;
	}

	public void setButton(List<MenuButton> button) {
		this.button = button;
	}
}
