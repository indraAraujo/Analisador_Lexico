
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author indra
 */
public class Analisador_Lexico extends javax.swing.JFrame {

     ArrayList<String> readCharacters = new ArrayList<>();
    public Analisador_Lexico() {
        initComponents();
    }

  
                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        get_file_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        result_table.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        result_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Token"
            }
        ));
        result_table.setGridColor(new java.awt.Color(255, 255, 255));
        result_table.setSelectionBackground(new java.awt.Color(228, 255, 246));
        jScrollPane1.setViewportView(result_table);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel1.setText("Resultado da análise léxica");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel2.setText("Selecione o programa em Scheme");

        get_file_button.setBackground(new java.awt.Color(0, 51, 255));
        get_file_button.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        get_file_button.setForeground(new java.awt.Color(255, 255, 255));
        get_file_button.setText("Abrir arquivo");
        get_file_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_file_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(get_file_button)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(get_file_button)
                    .addComponent(jLabel2))
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void get_file_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                
       //-------- LIDAR COM O ARQUIVO ------------
        Reader fileReader;
        File file;
        JFileChooser chooser = new JFileChooser(".");
        int res;
        //ABRIR ARQUIVO
         chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         res=chooser.showOpenDialog(null);
          if (res==JFileChooser.APPROVE_OPTION){
               file=chooser.getSelectedFile();
               fileReader = new Reader(file.getAbsolutePath());
               //LER ARQUIVO
               readCharacters=fileReader.readFile();
               fileReader.closeReader();
           }
        
          //COLOCAR O RESULTADO NA TABELA
          //result = automata.getResult(); TODO! PASSAR O RESULTADO DA CLASSE AUTOMATA;
          Object[][] result = {
                {"operador", "+"},
                {"palavra reservada","nil"},                
                {"palavra reservada","T"},
                {"palavra reservada","car"},

           };
          DefaultTableModel dtm_result = (DefaultTableModel)result_table.getModel();
          for(int i=0; i<result.length; i++){
              dtm_result.addRow(result[i]);
          }
          
    }                                               


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisador_Lexico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton get_file_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable result_table;
    // End of variables declaration                   
}
