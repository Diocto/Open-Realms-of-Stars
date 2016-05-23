package org.openRealmOfStars.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import org.openRealmOfStars.gui.GuiStatics;


/**
 * 
 * Open Realm of Stars game project
 * Copyright (C) 2016  Tuomo Untinen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/
 * 
 * 
 * Class for creating cool looking space button with a text
 * 
 */
public class SpaceButton extends JButton {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Space Button with blue background and golden text
   * @param text Text shown in button
   * @param actionCommand Action command as String
   */
  public SpaceButton(String text, String actionCommand) {
    super(text);
    this.setActionCommand(actionCommand);
    this.setBackground(GuiStatics.COLOR_COOL_SPACE_BLUE);
    this.setForeground(GuiStatics.COLOR_GOLD);
    this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    Dimension size = this.getPreferredSize();    
    size.width = GuiStatics.getTextWidth(GuiStatics.FONT_NORMAL, text)+20;
    size.height = GuiStatics.getTextHeight(GuiStatics.FONT_NORMAL, text)+10;
    this.setMinimumSize(size);
    this.setPreferredSize(size);
    this.setMaximumSize(size);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    GradientPaint gradient = new GradientPaint(0,0, GuiStatics.COLOR_COOL_SPACE_BLUE,
        this.getWidth(),this.getHeight(), GuiStatics.COLOR_COOL_SPACE_BLUE_DARK, true);

    if (this.getModel().isPressed()) {
      gradient = new GradientPaint(0,0, GuiStatics.COLOR_COOL_SPACE_BLUE_DARK,
          this.getWidth(),this.getHeight(), GuiStatics.COLOR_DEEP_SPACE_BLUE, true);
      this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
      
    } else {
      if (!this.isEnabled()) {
        gradient = new GradientPaint(0,0, GuiStatics.COLOR_GREY_160,
            this.getWidth(),this.getHeight(), GuiStatics.COLOR_GREY_80, true);
      }
      this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    Insets inset = this.getBorder().getBorderInsets(this);
    int sx = inset.left;
    int sy = inset.top;
    int width = getWidth()-inset.left-inset.right;
    int height = getHeight()-inset.top-inset.bottom;
    Graphics2D g2d = (Graphics2D) g;

    g2d.setPaint(gradient);    
    g2d.fillRect(sx, sy, width, height);

    int textWidth = GuiStatics.getTextWidth(GuiStatics.FONT_NORMAL, getText());
    int textHeight = GuiStatics.getTextHeight(GuiStatics.FONT_NORMAL, getText());
    if (this.isEnabled())
    {
      if (this.getModel().isRollover()) {
        g2d.setColor(GuiStatics.COLOR_GOLD_DARK);
      } else {
        g2d.setColor(Color.black);
      }
    } else {
      g2d.setColor(GuiStatics.COLOR_GOLD_DARK);
    }
    g.setFont(GuiStatics.FONT_NORMAL);
    int offsetX = width/2-textWidth/2+sx;
    if (offsetX < 0) {
      offsetX = sx;
    }
    g2d.drawString(getText(), offsetX, textHeight+sy);
    
  }


}