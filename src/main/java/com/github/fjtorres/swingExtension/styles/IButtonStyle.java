package com.github.fjtorres.swingExtension.styles;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.github.fjtorres.swingExtension.IHoverComponent;

/**
 * Button style definition.
 * 
 * @author fjtorres.
 *
 */
public interface IButtonStyle extends IStyle {

	/**
	 * The button hover background color.
	 * 
	 * @return
	 */
	Color getHoverBackground();

	/**
	 * The button border
	 * 
	 * @return
	 */
	Border getBorder();

	boolean isPreferredSize();

	/**
	 * The button width
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * The button height
	 * 
	 * @return
	 */
	int getHeight();

	/**
	 * The button icon.
	 * 
	 * @return
	 */
	Icon getIcon();

	/**
	 * @see com.zerocopy.printingPoint.styles.IStyle#apply(javax.swing.JComponent)
	 */
	default void apply(JComponent component) {

		IStyle.super.apply(component);

		component.setBorder(getBorder());

		if (isPreferredSize()) {
			component.setPreferredSize(new Dimension(getWidth(), getHeight()));
		}

		if (component instanceof IHoverComponent) {
			((IHoverComponent) component).setHoverBackgroundColor(getHoverBackground());
		}

		if (component instanceof AbstractButton) {
			((AbstractButton) component).setIcon(getIcon());
		}
	}
}
