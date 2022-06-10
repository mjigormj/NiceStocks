//A biblioteca Jsoup precisa ser instalada para que o programa efetue as buscas online
package nicestocksv2;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StockList extends javax.swing.JFrame {

    private class Stock {

        private String name;
        private Double marcketValue = 0.0;
        private Double avgCust = 0.0;
        private Double totalPrice = 0.0;
        private int stockQtd = 0;
        private Document doc;

        private void criarStock(String name) throws IOException {

            this.setName(name);
            this.setDoc(Jsoup.connect("https://www.google.com/finance/quote/" + this.getName() + ":BVMF").get());
            this.setMarcketValue(getDoc());

        }

        // Metodos especiais
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name.toUpperCase();
        }

        public Document getDoc() {
            return doc;
        }

        public void setDoc(Document doc) throws IOException {
            this.doc = doc;
        }

        public Double getAvgCust() {
            return avgCust;
        }

        public void setAvgCust(Double totalPrice, int stockQtd) {
            this.avgCust = totalPrice / stockQtd;
        }

        public int getStockQtd() {
            return stockQtd;
        }

        public void setStockQtd(int stockQtd) {
            this.stockQtd = stockQtd;
        }

        public Double getMarcketValue() {
            return marcketValue;
        }

        public void setMarcketValue(Document doc) {
            this.marcketValue = Double.parseDouble(doc.getElementsByClass("YMlKec fxKbKc").text().replace("R$", ""));
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double marcketValue) {
            this.totalPrice = marcketValue;
        }

    }

    public StockList() {
        this.titulos = new ArrayList();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public ArrayList<Stock> titulos;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        btnRefreshTable = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNewStock = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        nice = new javax.swing.JLabel();
        lucroCarteira = new javax.swing.JLabel();
        labelValorAtual = new javax.swing.JLabel();
        labelValorInvestido = new javax.swing.JLabel();

        jScrollPane3.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);

        btnRefreshTable.setText("refresh");
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNewStock.setText("Adc Novo Titulo");
        btnNewStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStockActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        nice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nice.setText("Nice Stocks - Calculadora de Ações");
        nice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelValorAtual.setText("Valor atual da carteira: R$");

        labelValorInvestido.setText("Valor investido: R$ ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(nice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lucroCarteira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelValorAtual)
                            .addComponent(labelValorInvestido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefreshTable))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewStock)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(nice)
                .addGap(15, 15, 15)
                .addComponent(labelValorAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lucroCarteira)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefreshTable)
                            .addComponent(labelValorInvestido))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnNewStock)
                            .addComponent(btnEditar))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        try {
            tituloRead();
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            tituloRead();
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnNewStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStockActionPerformed
        try {
            inserirTitulo(titulos);
            tituloRead();
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNewStockActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            int linhaSelecionada = stockTable.getSelectedRow();
            if (linhaSelecionada >= 0) {
                deletarTitulo(stockTable.getValueAt(linhaSelecionada, 0).toString());
                val.removeRow(linhaSelecionada);
                stockTable.setModel(val);
                tituloRead();

            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
            }
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            int linhaSelecionada = stockTable.getSelectedRow();
            if (linhaSelecionada >= 0) {
                atualizarTitulo(stockTable.getValueAt(linhaSelecionada, 0).toString());
                tituloRead();
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
            }
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockList().setVisible(true);
            }
        });
    }

    // Methods
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Carrega informações presentes na Lista de ações na tabela
    public void tituloRead() throws IOException {
        try {
            Double valorAtualCarteira = 0.0;
            Double valorInvestidoCarteira = 0.0;
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            val.setRowCount(0);
            for (Stock titulo : titulos) {
                String valorAtual = df.format(titulo.getMarcketValue());
                String tituloQtd = String.valueOf(titulo.getStockQtd());
                String precoMedio = df.format(titulo.getAvgCust());
                String valorTotal = df.format(titulo.getMarcketValue() * titulo.getStockQtd());
                String lucro = df.format(titulo.getMarcketValue() * titulo.getStockQtd() - titulo.getTotalPrice());
                val.addRow(new String[]{titulo.getName(), valorAtual, precoMedio, tituloQtd, valorTotal, lucro});
                valorAtualCarteira += titulo.getMarcketValue() * titulo.getStockQtd();
                valorInvestidoCarteira += titulo.getTotalPrice();
            }
                labelValorAtual.setText("Valor atual da carteira R$: " + df.format(valorAtualCarteira));
                labelValorInvestido.setText("Valor Investido: R$ " + df.format(valorInvestidoCarteira));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informação incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserirTitulo(ArrayList<Stock> titulos) {
        try {
            Stock novoTitulo = new Stock();
            novoTitulo.criarStock(JOptionPane.showInputDialog("Qual o nome da ação que deve ser comprada?").toUpperCase());
            String qtdStock = JOptionPane.showInputDialog(novoTitulo.getName() + "\n Quantidade a ser comprada", 1);
            String valorPago = JOptionPane.showInputDialog("\n Preço da compra de cada ação R$:", novoTitulo.getMarcketValue()).replace(",", ".");
            for (Stock titulo : titulos) {
                if (titulo.getName().equals(novoTitulo.getName())) {
                    titulo.setStockQtd(Integer.parseInt(qtdStock));
                    titulo.setTotalPrice(titulo.getTotalPrice() + Double.parseDouble(valorPago));
                    titulo.setAvgCust(titulo.getTotalPrice(), titulo.getStockQtd());
                    return;
                }
            }

            novoTitulo.setStockQtd(Integer.parseInt(qtdStock));
            novoTitulo.setTotalPrice(Double.parseDouble(valorPago) * novoTitulo.getStockQtd());
            novoTitulo.setAvgCust(novoTitulo.getTotalPrice(), novoTitulo.getStockQtd());

            titulos.add(novoTitulo);

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Informação incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTitulo(String nmTitulo) throws IOException {
        try {
            for (Stock titulo : titulos) {
                if (titulo.getName().equals(nmTitulo)) {
                    String qtdStock = JOptionPane.showInputDialog(titulo.getName() + "\n Quantidade de ações na carteira", titulo.getStockQtd());
                    String valorPago = JOptionPane.showInputDialog("\n Preço gasto na compra de cada ação R$: ", (titulo.getAvgCust() * titulo.getStockQtd())).replace(",", ".");
                    titulo.setStockQtd(Integer.parseInt(qtdStock));
                    titulo.setTotalPrice(Double.parseDouble(valorPago) * titulo.getStockQtd());
                    titulo.setAvgCust(titulo.getTotalPrice(), titulo.getStockQtd());
                    return;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informação incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletarTitulo(String nmTitulo) {
        for (Stock titulo : titulos) {
            if (titulo.getName().equals(nmTitulo)) {
                titulos.remove(titulo);
                return;
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNewStock;
    private javax.swing.JButton btnRefreshTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel labelValorAtual;
    private javax.swing.JLabel labelValorInvestido;
    private javax.swing.JLabel lucroCarteira;
    private javax.swing.JLabel nice;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
