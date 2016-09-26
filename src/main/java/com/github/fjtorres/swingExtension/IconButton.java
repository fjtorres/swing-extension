package com.github.fjtorres.swingExtension;

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * Extension class of {@link JButton} for buttons only with Icon.
 * 
 * @author fjtorres
 *
 */
public class IconButton extends JButton {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -1404847036657403050L;

	/**
	 * Constructor.
	 * 
	 * @param icon
	 */
	public IconButton(Icon icon) {
		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setIcon(icon);
		setRolloverIcon(icon);
		setPressedIcon(icon);
		setDisabledIcon(icon);

		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Constructor.
	 * 
	 * @param icon
	 * @param listener
	 */
	public IconButton(Icon icon, ActionListener listener) {
		this(icon);
		addActionListener(listener);
	}
}
