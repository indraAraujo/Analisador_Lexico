

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Analisador_Lexico extends javax.swing.JFrame {

     ArrayList<String> readCharacters = new ArrayList<>();
     ArrayList<Token> result = new ArrayList<>();
    public Analisador_Lexico() {
        initComponents();
    }

  
                             
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        get_file_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        result_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        result_area.setEditable(false);
        result_area.setColumns(20);
        result_area.setRows(5);
        jScrollPane2.setViewportView(result_area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(get_file_button)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(get_file_button)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void get_file_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        //-------- LIDAR COM O ARQUIVO ------------
        String fileName ="";
        JFileChooser chooser = new JFileChooser(".");
        int res;
        //ABRIR ARQUIVO
         chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         res=chooser.showOpenDialog(null);
          if (res==JFileChooser.APPROVE_OPTION){
                Reader fileReader = null;
                File file;
               file=chooser.getSelectedFile();
               fileName = file.getAbsolutePath();
               fileReader = new Reader(fileName);
               //LER ARQUIVO
               readCharacters=fileReader.readFile();
               fileReader.closeReader();
           }
        
          //COLOCAR O RESULTADO NA TABELA
          //result = automata.getResult(); TODO! PASSAR O RESULTADO DA CLASSE AUTOMATA;

          result.add(new Token("Palavra Reservada", "nil"));
          result.add(new Token("Palavra Reservada", "car"));
          result.add(new Token("Operador", "leq"));
          result.add(new Token("Identificador", "Ab10_Bah"));
          
          result_area.setText(result.toString());

          //SALVAR O RESULTADO EM UM ARQUIVO
          Reader fileReader = new Reader(fileName);
          
          fileReader.saveFile(result);
          
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea result_area;
    // End of variables declaration                   
}
