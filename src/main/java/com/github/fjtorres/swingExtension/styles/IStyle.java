package com.github.fjtorres.swingExtension.styles;

import java.awt.Color;
import java.awt.font.TextAttribute;
import java.util.Collections;

import javax.swing.JComponent;

/**
 * Style definition.
 * 
 * @author fjtorres
 *
 */
public interface IStyle {

	/**
	 * The background color.
	 * 
	 * @return
	 */
	Color getBackground();

	/**
	 * The foreground color.
	 * 
	 * @return
	 */
	Color getForeground();

	/**
	 * The font size.
	 * 
	 * @return
	 */
	Integer getFontSize();

	/**
	 * Apply styles to component.
	 * 
	 * @param component
	 */
	default void apply(JComponent component) {
		component.setBackground(getBackground());
		component.setForeground(getForeground());

		component.setFont(component.getFont().deriveFont(Collections.singletonMap(TextAttribute.SIZE, getFontSize())));
	}
}