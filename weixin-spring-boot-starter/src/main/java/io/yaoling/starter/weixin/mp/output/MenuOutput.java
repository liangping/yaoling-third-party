package io.yaoling.starter.weixin.mp.output;


import io.yaoling.starter.weixin.mp.output.elements.Menu;

import java.util.List;

public class MenuOutput extends JsonOutput {
	private Menu menu;
	private List<Menu> conditionalmenu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * @return the conditionalmenu
	 */
	public List<Menu> getConditionalmenu() {
		return conditionalmenu;
	}

	/**
	 * @param conditionalmenu the conditionalmenu to set
	 */
	public void setConditionalmenu(List<Menu> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}
}
