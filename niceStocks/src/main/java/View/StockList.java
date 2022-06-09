package View;

import Controller.CRUD;
import Model.Stock;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class StockList extends javax.swing.JFrame {

    String stockName;

    public StockList() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        btnRefreshTable = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNewStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jlEmail.setText("Nome do Usuario:");

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Preço Atual", "VL Medio Pago", "Qtd", "Valor em Posse", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);

        btnRefreshTable.setText("refresh");
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setText("Deletar");

        btnNewStock.setText("Adc Novo Titulo");
        btnNewStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEmail)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnNewStock)
                .addGap(18, 18, 18)
                .addComponent(btnRefreshTable)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlEmail)
                .addGap(94, 94, 94)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshTable)
                    .addComponent(btnDelete)
                    .addComponent(btnNewStock))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        try {
            tituloList();
        } catch (SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            tituloList();
        } catch (SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnNewStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStockActionPerformed
        StockSearch ss = new StockSearch();
        ss.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNewStockActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockList().setVisible(true);
            }
        });
    }

    // Methods
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void tituloList() throws SQLException, IOException {
        
        ArrayList<Stock> titulos = CRUD.returnStockFromTable();
        try {
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            val.setRowCount(0);
            for (Stock titulo : titulos) {
                String valorAtual = df.format(titulo.getMarcketValue());
                String tituloQtd = String.valueOf(titulo.getStockQtd());
                String precoMedio = df.format(titulo.getAvgCust());
                String valorTotal = df.format(titulo.getMarcketValue() * titulo.getStockQtd());
                String lucro = df.format(titulo.getMarcketValue() * titulo.getStockQtd() - titulo.getAvgCust() * titulo.getStockQtd());
                val.addRow(new String[]{titulo.getName(), valorAtual, precoMedio, tituloQtd, valorTotal, lucro });
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewStock;
    private javax.swing.JButton btnRefreshTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
