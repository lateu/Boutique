/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.metier.Impl.IsProduitImpl;
import com.lateu.boutique.metier.IsPersonnel;
import com.lateu.boutique.metier.IsProduit;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author ing-lateu
 */
public class Recette_J extends JPanel {

    private JButton nouveauBtn;
    private JButton buton;
    private JTable clientTable;
    private DefaultTableModel tableModel;
    private MenuPrincipal parent;
    private JXDatePicker dateText;
    private JButton btnEnregistrer;
    private IsProduit servproduit;

    public Recette_J(MenuPrincipal parentFrame) throws DataAccessException {
        servproduit = new IsProduitImpl();

        try {
            setLayout(new BorderLayout());
            this.parent = parentFrame;
            JPanel haut = new JPanel();
            haut.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lbl;
            haut.add(lbl = new JLabel("Recette Journaliere"));
            lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
            add(BorderLayout.BEFORE_FIRST_LINE, haut);
            JPanel contenu = new JPanel();
            contenu.setLayout(new BorderLayout());
            //JPanel bas = new JPanel();
            //bas.setLayout(new FlowLayout());
            DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
            builder.append("date", dateText = new JXDatePicker());
            builder.append(btnEnregistrer = new JButton("Evaluer"));
            add(BorderLayout.CENTER, builder.getPanel());
       


          btnEnregistrer.addActionListener(new ActionListener() {
              Date d=dateText.getDate();
                public void actionPerformed(ActionEvent ae) {
                   // try {
                        JOptionPane.showMessageDialog(null, "montant de la recette----------------"+servproduit.recetteJourn(d));
                        return;
                       // parent.setContenu(new NouveauProduitPanel(parent));
                  /*  } catch (DataAccessException ex) {
                        Logger.getLogger(Recette_J.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            });


           // bas.add(buton);

           // contenu.add(BorderLayout.AFTER_LAST_LINE, bas);

            //add(BorderLayout.CENTER, contenu);




        } catch (Exception ex) {
            Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
