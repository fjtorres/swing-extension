package com.github.fjtorres.swingExtension;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.github.fjtorres.swingExtension.styles.IStyle;

/**
 * Extension class of {@link JLabel} with utility methods.
 * 
 * @author fjtorres
 *
 */
public class Label extends JLabel implements CustomComponent {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 4876189404134746845L;

	/**
	 * Constructor
	 */
	public Label() {
		super();
	}

	/**
	 * @param image
	 */
	public Label(Icon image) {
		this(image, null);
	}
	
	/**
	 * @param text
	 */
	public Label(String text) {
		this(text, null);
	}
	
	/**
	 * @param image
	 */
	public Label(Icon image, IStyle style) {
		super(image);
		
		if (style != null) {
			style.apply(this);
		}
	}

	/**
	 * @param text
	 */
	public Label(String text, IStyle style) {
		super(text);
		
		if (style != null) {
			style.apply(this);
		}
	}
	
}
