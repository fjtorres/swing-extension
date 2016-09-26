package com.github.fjtorres.swingExtension;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Collections;

import javax.swing.JComponent;

public interface CustomComponent {

	/**
	 * @see {@link JComponent#getFont()}
	 */
	Font getFont();

	/**
	 * @see {@link JComponent#setFont(Font)}
	 */
	void setFont(Font font);

	/**
	 * Method to update the size of the text.
	 */
	default void setFontSize(int size) {

		setFont(getFont().deriveFont(Collections.singletonMap(TextAttribute.SIZE, size)));
	}

	/**
	 * Method to put text in Bold style.
	 */
	default void setBold() {

		setFont(getFont().deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD)));
	}
}
