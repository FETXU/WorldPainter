/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pepsoft.worldpainter.operations;

import org.pepsoft.worldpainter.WorldPainterDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

import static java.util.Arrays.stream;
import static org.pepsoft.util.GUIUtils.SYSTEM_UI_SCALE_FLOAT;

/**
 *
 * @author pepijn
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"}) // Managed by NetBeans
public class TextDialog extends WorldPainterDialog {
    /**
     * Creates new form TextDialog
     */
    public TextDialog(Window parent, String defaultFont, int defaultSize, String text) {
        super(parent);

        initComponents();

        final String[] fontFamilyNames = stream(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
                .filter(name -> {
                    final Font font = new Font(name, Font.PLAIN, previewSize);
                    // This is intended to weed out symbol fonts and the like, not fonts for non-western scripts.
                    // Hopefully those will always also include the latin script
                    if (font.canDisplay('A')) {
                        logger.debug("Including font: {}", name);
                        return true;
                    } else {
                        logger.debug("Excluding font because it cannot display 'A': {}", name);
                        return false;
                    }
                })
                .toArray(String[]::new);
        comboBoxFont.setModel(new DefaultComboBoxModel<>(fontFamilyNames));
        comboBoxFont.setSelectedItem(defaultFont);

        spinnerSize.setValue(defaultSize);

        if (text != null) {
            textArea.setText(text);
            textArea.selectAll();
        }
        textArea.requestFocusInWindow();
        
        rootPane.setDefaultButton(buttonOK);
        scaleToUI();
        pack();
        setLocationRelativeTo(parent);
        fontSelected();
    }

    public String getText() {
        return textArea.getText();
    }
    
    public Font getSelectedFont() {
        return new Font((String) comboBoxFont.getSelectedItem(), (toggleButtonBold.isSelected() ? Font.BOLD : Font.PLAIN) | (toggleButtonItalic.isSelected() ? Font.ITALIC : Font.PLAIN), (Integer) spinnerSize.getValue());
    }

    public int getSelectedAngle() {
        return comboBoxAngle.getSelectedIndex();
    }

    private void fontSelected() {
        textArea.setFont(new Font((String) comboBoxFont.getSelectedItem(), (toggleButtonBold.isSelected() ? Font.BOLD : Font.PLAIN) | (toggleButtonItalic.isSelected() ? Font.ITALIC : Font.PLAIN), previewSize));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef", "DuplicatedCode", "SpellCheckingInspection"}) // Managed by NetBeans
    private void initComponents() {

        comboBoxFont = new javax.swing.JComboBox<>();
        spinnerSize = new javax.swing.JSpinner();
        toggleButtonBold = new javax.swing.JToggleButton();
        toggleButtonItalic = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        buttonCancel = new javax.swing.JButton();
        buttonOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxAngle = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter Text");

        comboBoxFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFontActionPerformed(evt);
            }
        });

        spinnerSize.setModel(new javax.swing.SpinnerNumberModel(18, 1, 999, 1));

        toggleButtonBold.setFont(toggleButtonBold.getFont().deriveFont(toggleButtonBold.getFont().getStyle() | java.awt.Font.BOLD));
        toggleButtonBold.setText("B");
        toggleButtonBold.setToolTipText("Bold");
        toggleButtonBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonBoldActionPerformed(evt);
            }
        });

        toggleButtonItalic.setFont(toggleButtonItalic.getFont().deriveFont((toggleButtonItalic.getFont().getStyle() | java.awt.Font.ITALIC)));
        toggleButtonItalic.setText("I");
        toggleButtonItalic.setToolTipText("Italic");
        toggleButtonItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonItalicActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        jLabel1.setText("Font:");

        jLabel2.setText("Size:");

        jLabel3.setText("Angle:");

        comboBoxAngle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 °", "-90 °", "180 °", "90 °" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonBold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonItalic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toggleButtonBold)
                    .addComponent(toggleButtonItalic)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonOK))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        ok();
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        cancel();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void comboBoxFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFontActionPerformed
        fontSelected();
    }//GEN-LAST:event_comboBoxFontActionPerformed

    private void toggleButtonBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonBoldActionPerformed
        fontSelected();
    }//GEN-LAST:event_toggleButtonBoldActionPerformed

    private void toggleButtonItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonItalicActionPerformed
        fontSelected();
    }//GEN-LAST:event_toggleButtonItalicActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<String> comboBoxAngle;
    private javax.swing.JComboBox<String> comboBoxFont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerSize;
    private javax.swing.JTextArea textArea;
    private javax.swing.JToggleButton toggleButtonBold;
    private javax.swing.JToggleButton toggleButtonItalic;
    // End of variables declaration//GEN-END:variables

    private final int previewSize = (int) (18 * SYSTEM_UI_SCALE_FLOAT);

    private static final Logger logger = LoggerFactory.getLogger(TextDialog.class);
}