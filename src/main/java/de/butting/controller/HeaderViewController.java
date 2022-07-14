package de.butting.controller;

import java.util.Objects;

import de.butting.views.HeaderView;

/**
 *
 * @author Daniel Niebuhr
 *
 */

public class HeaderViewController extends ViewController<HeaderView> {

	private HeaderView headerView;

	@Override
	public HeaderView getView() {
		if (Objects.isNull(this.headerView)) {
			createView();
		}
		return this.headerView;
	}

	@Override
	public void createView() {
		this.headerView = new HeaderView().createView();
		initActionHandlers();
	}

	private void initActionHandlers() {
	}

}
