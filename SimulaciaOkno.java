
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jožko
 */
public class SimulaciaOkno extends javax.swing.JFrame implements Observer {
    
    boolean koniec = false;
    private static int ktoruZapisem = 0;
    private static int pocetReplikacii = 0;
    private static int preskoceniex = 0;
    
    Parkovisko p;
    MonteCarlo mc;
    SimulaciaOkno o;
    
    private double priemer1min = Double.MAX_VALUE;
    private double priemer1max = Double.MIN_VALUE;
    
    private double priemer2min = Double.MAX_VALUE;
    private double priemer2max = Double.MIN_VALUE;
    
    private double priemer3min = Double.MAX_VALUE;
    private double priemer3max = Double.MIN_VALUE;

    // xy graf 1
    private final XYSeriesCollection dataset1 = new XYSeriesCollection();
    private final XYSeries series1 = new XYSeries("Priemerná úspešnosť zaparkovania");
    private final JFreeChart chart1 = ChartFactory.createXYLineChart(
        "",
        "Počet replikácií",
        "Priemerná úspešnosť",
        dataset1,
        PlotOrientation.VERTICAL,
        true, true, false);
    ChartPanel panel1 = new ChartPanel(chart1);
    
    // xy graf 2
    private final XYSeriesCollection dataset2 = new XYSeriesCollection();
    private final XYSeries series2 = new XYSeries("Priemerná úspešnosť zaparkovania");
    private final JFreeChart chart2 = ChartFactory.createXYLineChart(
        "",
        "Počet replikácií",
        "Priemerná úspešnosť",
        dataset2,
        PlotOrientation.VERTICAL,
        true, true, false);
    ChartPanel panel2 = new ChartPanel(chart2);
    
    // xy graf 3
    private final XYSeriesCollection dataset3 = new XYSeriesCollection();
    private final XYSeries series3 = new XYSeries("Priemerná úspešnosť zaparkovania");
    private final JFreeChart chart3 = ChartFactory.createXYLineChart(
        "",
        "Počet replikácií",
        "Priemerná úspešnosť",
        dataset3,
        PlotOrientation.VERTICAL,
        true, true, false);
    ChartPanel panel3 = new ChartPanel(chart3);
    
    // histogram 1
    
    DefaultCategoryDataset dataset4 = new DefaultCategoryDataset( );
    JFreeChart barChart4 = ChartFactory.createBarChart(
         "",           
         "Parkovacie miesto",            
         "Počet zaparkovaní",            
         dataset4,          
         PlotOrientation.VERTICAL,           
         true, true, false); 
    ChartPanel panel4 = new ChartPanel(barChart4);
    
    // histogram 2
    
    DefaultCategoryDataset dataset5 = new DefaultCategoryDataset( );
    JFreeChart barChart5 = ChartFactory.createBarChart(
         "",           
         "Parkovacie miesto",            
         "Počet zaparkovaní",            
         dataset5,          
         PlotOrientation.VERTICAL,           
         true, true, false); 
    ChartPanel panel5 = new ChartPanel(barChart5);
    
    // histogram 3
    
    DefaultCategoryDataset dataset6 = new DefaultCategoryDataset( );
    JFreeChart barChart6 = ChartFactory.createBarChart(
         "",           
         "Parkovacie miesto",            
         "Počet zaparkovaní",            
         dataset6,          
         PlotOrientation.VERTICAL,           
         true, true, false); 
    ChartPanel panel6 = new ChartPanel(barChart6);
    
    /**
     * Creates new form SimulaciaOkno
     */
    public SimulaciaOkno(int pocetRep, int kazdyxkrok, int preskoc) {
        initComponents();
        
        jPanel1.setSize(871, 444);
        jPanel1.add(panel1);
        dataset1.addSeries(series1);
        
        jPanel8.setSize(871, 444);
        jPanel8.add(panel2);
        dataset2.addSeries(series2);
        
        jPanel9.setSize(871, 444);
        jPanel9.add(panel3);
        dataset3.addSeries(series3);
        
        
        jPanel10.setSize(871, 444);
        jPanel10.add(panel4);
        
        jPanel11.setSize(871, 444);
        jPanel11.add(panel5);
        
        jPanel12.setSize(871, 444);
        jPanel12.add(panel6);
        
        ktoruZapisem = kazdyxkrok;
        pocetReplikacii = pocetRep;
        preskoceniex = preskoc;      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        j3 = new javax.swing.JTextField();
        j2 = new javax.swing.JTextField();
        j1 = new javax.swing.JTextField();
        j0 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(376, 210));
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 1 - priemer", jPanel2);

        jPanel10.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 1 - početnosť", jPanel3);

        jPanel8.setMaximumSize(new java.awt.Dimension(376, 210));
        jPanel8.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 2 - priemer", jPanel4);

        jPanel11.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 2 - početnosť", jPanel5);

        jPanel9.setMaximumSize(new java.awt.Dimension(376, 210));
        jPanel9.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 3 - priemer", jPanel6);

        jPanel12.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Taktika 3 - početnosť", jPanel7);

        jButton1.setText("Stop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Štart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("M:");

        jLabel2.setText("R:");

        jLabel3.setText("K:");

        jLabel4.setText("P:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j0, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.koniec = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    o = this;
    ktoruZapisem = Integer.parseInt(j2.getText());
    preskoceniex = Integer.parseInt(j3.getText());
    Thread t1 = new Thread(new Runnable() {
        public void run()
        {
            p = new Parkovisko(Integer.parseInt(j0.getText()));
            mc = new MonteCarlo(Integer.parseInt(j1.getText()), p);
            p.nastavMC(mc);
            mc.addObserver(o);
            mc.simulacia();
        }});  
    t1.start();
        
    /*
        p = new Parkovisko(12);
        mc = new MonteCarlo(Integer.parseInt(j1.getText()), p);
        p.nastavMC(mc);
        mc.addObserver(this);
        mc.simulacia();
    */
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SimulaciaOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulaciaOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulaciaOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulaciaOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulaciaOkno(pocetReplikacii, ktoruZapisem, preskoceniex).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField j0;
    private javax.swing.JTextField j1;
    private javax.swing.JTextField j2;
    private javax.swing.JTextField j3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        Parkovisko p = (Parkovisko) arg;
        
        if (p.dajCisloReplikacie() % ktoruZapisem == 0 && p.dajCisloReplikacie() >= preskoceniex) {
            NumberAxis range = (NumberAxis) chart1.getXYPlot().getRangeAxis();
            NumberAxis range2 = (NumberAxis) chart2.getXYPlot().getRangeAxis();
            NumberAxis range3 = (NumberAxis) chart3.getXYPlot().getRangeAxis();
            if (series1.getItemCount() == 0 && series2.getItemCount() == 0 && series3.getItemCount() == 0) {
                series1.add(p.dajCisloReplikacie(), p.pocetnost1priemer());
                range.setRange(p.pocetnost1priemer() - 0.1, p.pocetnost1priemer() + 0.1);
                priemer1min = p.pocetnost1priemer() - 0.0000000000000001;
                priemer1max = p.pocetnost1priemer() + 0.0000000000000001;
                
                series2.add(p.dajCisloReplikacie(), p.pocetnost2priemer());
                range2.setRange(p.pocetnost2priemer() - 0.1, p.pocetnost2priemer() + 0.1);
                priemer2min = p.pocetnost2priemer() - 0.0000000000000001;
                priemer2max = p.pocetnost2priemer() + 0.0000000000000001;
                
                series3.add(p.dajCisloReplikacie(), p.pocetnost3priemer());
                range3.setRange(p.pocetnost3priemer() - 0.1, p.pocetnost3priemer() + 0.1);
                priemer3min = p.pocetnost3priemer() - 0.0000000000000001;
                priemer3max = p.pocetnost3priemer() + 0.0000000000000001;
            } else {
                series1.add(p.dajCisloReplikacie(), p.pocetnost1priemer());
                if (p.pocetnost1priemer() > this.priemer1max) {
                    this.priemer1max = p.pocetnost1priemer();
                }
                if (p.pocetnost1priemer() < this.priemer1min) {
                    this.priemer1min = p.pocetnost1priemer();
                }
                range.setRange(priemer1min, priemer1max);
                
                series2.add(p.dajCisloReplikacie(), p.pocetnost2priemer());
                if (p.pocetnost2priemer() > this.priemer2max) {
                    this.priemer2max = p.pocetnost2priemer();
                }
                if (p.pocetnost2priemer() < this.priemer2min) {
                    this.priemer2min = p.pocetnost2priemer();
                }
                range2.setRange(priemer2min, priemer2max);
                
                series3.add(p.dajCisloReplikacie(), p.pocetnost3priemer());
                if (p.pocetnost3priemer() > this.priemer3max) {
                    this.priemer3max = p.pocetnost3priemer();
                }
                if (p.pocetnost3priemer() < this.priemer3min) {
                    this.priemer3min = p.pocetnost3priemer();
                }
                range3.setRange(priemer3min, priemer3max);
            }
            
            
            series2.add(p.dajCisloReplikacie(), p.pocetnost2priemer());
            series3.add(p.dajCisloReplikacie(), p.pocetnost3priemer());
        }
        
        for (int i = 0; i < p.dajVelkostParkoviska() + 1; i++) {
            dataset4.setValue(p.dajPocetnostPrvaTaktika()[i], "Početnosť", "" + (i + 1));
            
            dataset5.setValue(p.dajPocetnostDruhaTaktika()[i], "Početnosť", "" + (i + 1));
            
            dataset6.setValue(p.dajPocetnostTretiaTaktika()[i], "Početnosť", "" + (i + 1));
        }
        if (koniec == true) {
            p.dajMC().zmenaBehu(false);
        }
    }
}
