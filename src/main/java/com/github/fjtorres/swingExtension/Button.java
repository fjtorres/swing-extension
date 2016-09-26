package com.github.fjtorres.swingExtension;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;

import com.github.fjtorres.swingExtension.styles.IButtonStyle;

/**
 * Extension class of {@link JButton} with utility methods.
 * 
 * @author fjtorres
 *
 */
public class Button extends JButton implements IHoverComponent, CustomComponent {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6071615181220373075L;

	/**
	 * Hover background color.
	 */
	private Color hoverBackgroundColor;

	/**
	 * Default background color.
	 */
	private Color defaultBackgroundColor;

	/**
	 * The button style.
	 */
	private IButtonStyle style;

	/**
	 * Constructor
	 * 
	 * @param text
	 * @param icon
	 */
	public Button(String text, Icon icon) {
		this(text, icon, null);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 */
	public Button(String text) {
		this(text, (IButtonStyle) null);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 * @param icon
	 * @param style
	 */
	public Button(String text, Icon icon, IButtonStyle style) {
		super(text, icon);

		this.style = style;

		init();
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 * @param style
	 */
	public Button(String text, IButtonStyle style) {
		super(text);

		this.style = style;

		init();
	}

	/**
	 * Initialize component
	 */
	private void init() {
		setFocusPainted(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setToolTipText(getText());

		if (style != null) {
			style.apply(this);

			this.setHoverBackgroundColor(style.getHoverBackground());
		}

		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				defaultBackgroundColor = Button.this.getBackground();
				Button.this.setBackground(getHoverBackgroundColor());
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				Button.this.setBackground(defaultBackgroundColor);
				defaultBackgroundColor = null;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				UIManager.put("Button.select", defaultBackgroundColor);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.select", getHoverBackgroundColor());
			}

		});
	}

	public Color getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(Color hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}
}
