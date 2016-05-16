/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.gui;

import classroom.database.ConnectionDB;
import classroom.modal.Person;
import classroom.modal.Student;
import classroom.modal.Work;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KS
 */
public class TE_Analytics extends javax.swing.JFrame {

    /**
     * Creates new form TE_Analytics
     */
    ArrayList<Work> worklist = new ArrayList<Work>();
    ArrayList<Work> alWork = new ArrayList<Work>();

    public TE_Analytics() throws SQLException {
        initComponents();
        this.AWORK.setText(countW("all") + "");
        this.APWORK.setText(countW("approve") + "");
        this.SEWORK.setText(countW("pending") + "");
        this.USENT.setText(countW("unsent") + "");
        initWork();
        initListHL();
        initListAL();
    }

    private int countW(String command) throws SQLException {
        int count = 0;
        Connection tcud = ConnectionDB.getConnection();
        PreparedStatement pps;
        if (command.equals("all")) {
            pps = tcud.prepareStatement("select * from Work where tch=?");
            pps.setInt(1, TE_Home.tch.getId());
        } else {
            pps = tcud.prepareStatement("select * from Work where tch=? and status=?");
            pps.setInt(1, TE_Home.tch.getId());
            if (command.equals("unsent")) {
                pps.setInt(2, 0);
            } else if (command.equals("pending")) {
                pps.setInt(2, 1);
            } else {
                pps.setInt(2, 2);
            }
        }
        ResultSet result = pps.executeQuery();
        while (result.next()) {
            count++;
        }
        tcud.close();
        return count;
    }

    private void initWork() throws SQLException {
        Connection tcud = ConnectionDB.getConnection();
        ArrayList<Work> listWork = new ArrayList<Work>();
        PreparedStatement pps;
        pps = tcud.prepareStatement("select * from Work where tch=? and std=9");
        pps.setInt(1, TE_Home.tch.getId());
        ResultSet result = pps.executeQuery();
        while (result.next()) {
            worklist.add(new Work(result.getInt("id")));
        }

        double work[][] = new double[worklist.size()][4];

        Vector vec = new Vector();
        vec.add("#");
        vec.add("Name");
        vec.add("Unsent");
        vec.add("Pending");
        vec.add("Approve");
        vec.add("AVG Score");
        TableModel model = new DefaultTableModel(vec, worklist.size());
        this.jTable1.setModel(model);

        for (int i = 0; i < worklist.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    pps = tcud.prepareStatement("select * from Work where tch=? and name=? and status=0");
                } else if (j == 1) {
                    pps = tcud.prepareStatement("select * from Work where tch=? and name=? and status=1");
                } else {
                    pps = tcud.prepareStatement("select * from Work where tch=? and name=? and status=2");
                }
                pps.setInt(1, TE_Home.tch.getId());
                pps.setString(2, worklist.get(i).getName());
                result = pps.executeQuery();
                while (result.next()) {
                    work[i][j]++;
                    work[i][3] += result.getInt("score");
                }
            }
            double sum = work[i][0] + work[i][1] + work[i][2];
            this.jTable1.setValueAt(i + 1, i, 0);
            this.jTable1.setValueAt(worklist.get(i).getName(), i, 1);
            this.jTable1.setValueAt(work[i][0] + " (" + (work[i][0] / sum) * 100 + "%)", i, 2);
            this.jTable1.setValueAt(work[i][1] + " (" + (work[i][1] / sum) * 100 + "%)", i, 3);
            this.jTable1.setValueAt(work[i][2] + " (" + (work[i][2] / sum) * 100 + "%)", i, 4);
            this.jTable1.setValueAt(work[i][3] / work[i][2], i, 5);
        }
        tcud.close();
    }

    public void initListHL() throws SQLException {
        Connection tcud = ConnectionDB.getConnection();
        ArrayList<Student> list = new ArrayList<Student>();
        PreparedStatement pps;
        pps = tcud.prepareStatement("select * from Person where position='STUDENT'");
        ResultSet result = pps.executeQuery();
        while (result.next()) {
            list.add(new Student(result.getString("user")));
        }
        
        // Reverse | High Score
        
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student w2, Student w1) {
                try {
                    return w1.getAllScore()-w2.getAllScore();
                } catch (SQLException ex) {
                }
                    return 0;
            }
        });
        
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < list.size(); i++) {
            model.addElement(list.get(i).getName() + " : " + list.get(i).getAllScore()+" point.");
            
        }
        this.Hscore.setModel(model);
        
        // Reverse | Low Score
        
        DefaultListModel model2 = new DefaultListModel();
        for (int i = list.size()-1; i >=0 ; i--) {
            model2.addElement(list.get(i).getName() + " : " + list.get(i).getAllScore()+" point.");
            
        }
        this.Lscore.setModel(model2);
        
        tcud.close();
    }
    public void initListAL() throws SQLException {
        Connection tcud = ConnectionDB.getConnection();
        ArrayList<Student> list = new ArrayList<Student>();
        PreparedStatement pps;
        pps = tcud.prepareStatement("select * from Person where position='STUDENT'");
        ResultSet result = pps.executeQuery();
        while (result.next()) {
            list.add(new Student(result.getString("user")));
        }
        
        // Reverse | High Score
        
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student w2, Student w1) {
                try {
                    return w1.countWorkApprove()-w2.countWorkApprove();
                } catch (SQLException ex) {
                }
                    return 0;
            }
        });
        
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < list.size(); i++) {
            model.addElement(list.get(i).getName() + " : " + list.get(i).countWorkApprove()+" work.");
            
        }
        this.Aworker.setModel(model);
        
        // Reverse | Low Score
        
        DefaultListModel model2 = new DefaultListModel();
        for (int i = list.size()-1; i >=0 ; i--) {
            model2.addElement(list.get(i).getName() + " : " + list.get(i).countWorkApprove()+" work.");
            
        }
        this.Lworker.setModel(model2);
        
        tcud.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AWORK = new javax.swing.JLabel();
        APWORK = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SEWORK = new javax.swing.JLabel();
        USENT = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Hscore = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lworker = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Lscore = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        Aworker = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "WORK NAME", "SENT", "PENDING", "APPROVE", "AVG SCORE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("ANALYTICS");

        AWORK.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        AWORK.setText("200");

        APWORK.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        APWORK.setText("99");

        jLabel4.setText("Approved :");

        jLabel5.setText("All of Work :");

        jLabel6.setText("HIGH SCORE :");

        jLabel7.setText("ACTIVE WORKER :");

        jLabel8.setText("LOW SCORE :");

        jLabel9.setText("LAZY WORKER :");

        jLabel10.setText("Pending :");

        SEWORK.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SEWORK.setText("99");

        USENT.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        USENT.setText("99");

        jLabel13.setText("Unsent :");

        Hscore.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Hscore);

        Lworker.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(Lworker);

        Lscore.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(Lscore);

        Aworker.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(Aworker);

        jButton1.setBackground(new Color(0,0,0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classroom/gui/deco/back.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(APWORK, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AWORK, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(USENT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addComponent(SEWORK, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(USENT)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SEWORK)
                                    .addComponent(jLabel10)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(APWORK)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AWORK)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(36, 36, 36))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            TE_Home th = new TE_Home(TE_Home.tch);
            th.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
//            Logger.getLogger(TE_SHOW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TE_Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TE_Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TE_Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TE_Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TE_Analytics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APWORK;
    private javax.swing.JLabel AWORK;
    private javax.swing.JList Aworker;
    private javax.swing.JList<String> Hscore;
    private javax.swing.JList<String> Lscore;
    private javax.swing.JList<String> Lworker;
    private javax.swing.JLabel SEWORK;
    private javax.swing.JLabel USENT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
