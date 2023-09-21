
package com.mycompany.minijuegotorrehanoi;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    int ContNumMov = 0;
    Pila PilaTorreA;
    Pila PilaTorreB;
    Pila PilaTorreC;
    
    DefaultTableModel ModeloTablaTorreA, ModeloTablaTorreB, ModeloTablaTorreC;
    
    int Objetivo = 0;
    
    double NumMinMov = 0;
    
    boolean Stop = false;
    
    public VentanaPrincipal() {
        initComponents();
        
        ModeloTablaTorreA = (DefaultTableModel) torreA.getModel();
        ModeloTablaTorreA.setRowCount(10);
        
        ModeloTablaTorreB = (DefaultTableModel) torreB.getModel();
        ModeloTablaTorreB.setRowCount(10);
        
        ModeloTablaTorreC = (DefaultTableModel) torreC.getModel();
        ModeloTablaTorreC.setRowCount(10);
        
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        torreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        torreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        torreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
    }
    
    
    private void Limpiar(){
    
        ContNumMov = 0;
        NumMinMov = 0;
        
        cbNumDiscos.setSelectedItem(String.valueOf(Objetivo));
    
    }
    
    
    private void PresentarCantMov(){
    
        ContNumMov ++;
        lbNumMov.setText(String.valueOf(ContNumMov));
    
    }
    
    private void Reiniciar(){
        try{
        
            if(!lbMinMov.getText().equals("")){
           
                Limpiar();
                Iniciar();
                
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
        
    }
    
    private void Iniciar(){
        
        try{
            
        PilaTorreA = new Pila();
        PilaTorreB = new Pila();
        PilaTorreC = new Pila();
        
        Objetivo = Integer.parseInt(cbNumDiscos.getSelectedItem().toString());
        
        NumMinMov = Math.pow(2, Objetivo) -1;
        
        lbNumMov.setText(String.valueOf(ContNumMov));
        lbMinMov.setText(String.valueOf(String.format("%.0f",NumMinMov)));
        
        for(int x = Objetivo; x>=1; x--){
        
            Nodo Plataforma = new Nodo();
            
            String Disco = "";
            
            for(int y = x; y > 0; y--){
            
                Disco+= "O";
            
            }
            
            Plataforma.setDato(Disco);
            
            PilaTorreA.Push(Plataforma);
        
        }
        
        PresentarTorreA();
        PresentarTorreB();
        PresentarTorreC();
        
        
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
    }
    
    private void PresentarTorreA(){
    
        ((DefaultTableModel)torreA.getModel()).setRowCount(0);
        
        ModeloTablaTorreA.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreA.getContNodo());
        
        if(PilaTorreA.getContNodo() > 0){
            
            for(K = PilaTorreA.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        torreA.setModel(ModeloTablaTorreA);
        ModeloTablaTorreA.setRowCount(10);
    
    }
    
    private void PresentarTorreB(){
    
        ((DefaultTableModel)torreB.getModel()).setRowCount(0);
        
        ModeloTablaTorreB.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreB.getContNodo());
        
        if(PilaTorreB.getContNodo() > 0){
            
            for(K = PilaTorreB.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        torreB.setModel(ModeloTablaTorreB);
        ModeloTablaTorreB.setRowCount(10);
    
    }
    
    private void PresentarTorreC(){
    
        ((DefaultTableModel)torreC.getModel()).setRowCount(0);
        
        ModeloTablaTorreC.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreC.getContNodo());
        
        if(PilaTorreC.getContNodo() > 0){
            
            for(K = PilaTorreC.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        torreC.setModel(ModeloTablaTorreC);
        ModeloTablaTorreC.setRowCount(10);
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        torreA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        torreC = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        torreB = new javax.swing.JTable();
        btnA_C = new javax.swing.JButton();
        btnA_B = new javax.swing.JButton();
        btnB_C = new javax.swing.JButton();
        btnB_A = new javax.swing.JButton();
        btnC_B = new javax.swing.JButton();
        btnC_A = new javax.swing.JButton();
        cbNumDiscos = new javax.swing.JComboBox<>();
        lbMinMov = new javax.swing.JLabel();
        lbNumMov = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        torreA.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        torreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        torreA.setAutoscrolls(false);
        torreA.setFocusable(false);
        torreA.setInheritsPopupMenu(true);
        torreA.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(torreA);
        if (torreA.getColumnModel().getColumnCount() > 0) {
            torreA.getColumnModel().getColumn(0).setResizable(false);
        }

        torreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        torreC.setAutoscrolls(false);
        torreC.setFocusable(false);
        torreC.setInheritsPopupMenu(true);
        torreC.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(torreC);
        if (torreC.getColumnModel().getColumnCount() > 0) {
            torreC.getColumnModel().getColumn(0).setResizable(false);
        }

        torreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        torreB.setAutoscrolls(false);
        torreB.setFocusable(false);
        torreB.setInheritsPopupMenu(true);
        torreB.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(torreB);
        if (torreB.getColumnModel().getColumnCount() > 0) {
            torreB.getColumnModel().getColumn(0).setResizable(false);
        }

        btnA_C.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnA_C.setText("C");
        btnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_CActionPerformed(evt);
            }
        });

        btnA_B.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnA_B.setText("B");
        btnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_BActionPerformed(evt);
            }
        });

        btnB_C.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnB_C.setText("C");
        btnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_CActionPerformed(evt);
            }
        });

        btnB_A.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnB_A.setText("A");
        btnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_AActionPerformed(evt);
            }
        });

        btnC_B.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnC_B.setText("B");
        btnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_BActionPerformed(evt);
            }
        });

        btnC_A.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnC_A.setText("A");
        btnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_AActionPerformed(evt);
            }
        });

        cbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        lbMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNumMov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNumMov.setForeground(new java.awt.Color(255, 51, 0));
        lbNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbNumMov.setFocusable(false);
        lbNumMov.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Número de Discos:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Número minimo de movimientos:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Número de Movimientos:");

        btnReiniciar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnIniciar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnResolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbMinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(431, 431, 431))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbMinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Iniciar();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    
    private void MoverDeA_B(){
        try{
            
            if(PilaTorreA.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreB.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreB.Push(Plataforma);
                
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }    
    }
    
    
    
    private void btnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_BActionPerformed
        MoverDeA_B();
    }//GEN-LAST:event_btnA_BActionPerformed

    private void MoverDeA_C(){
        try{
            
            if(PilaTorreA.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreC.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreC.Push(Plataforma);
                
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
                
                if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad ","Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades lo has resuelto\n\nIntenta superar el objetivo con el minimo de movimientos","Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }    
    
    }
    
    private void btnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_CActionPerformed
        MoverDeA_C();
    }//GEN-LAST:event_btnA_CActionPerformed
    
    private void MoverDeB_A(){
        try{
            
            if(PilaTorreB.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreA.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreB.Pop();
                PilaTorreA.Push(Plataforma);
                
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }    
    }
    
    private void btnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_AActionPerformed
        MoverDeB_A();
    }//GEN-LAST:event_btnB_AActionPerformed
    private void MoverDeB_C(){
        try{
            
            if(PilaTorreB.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreC.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreB.Pop();
                PilaTorreC.Push(Plataforma);
                
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
                
                if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad ","Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades lo has resuelto\n\nIntenta superar el objetivo con el minimo de movimientos","Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }  
    }
    private void btnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_CActionPerformed
        MoverDeB_C();
    }//GEN-LAST:event_btnB_CActionPerformed
    private void MoverDeC_A(){
    try{
            
            if(PilaTorreC.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreA.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreC.Pop();
                PilaTorreA.Push(Plataforma);
                
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }   
    }
    private void btnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_AActionPerformed
        MoverDeC_A();
    }//GEN-LAST:event_btnC_AActionPerformed
    public void MoverDeC_B(){
        try{
            
            if(PilaTorreC.getContNodo() > 0){
            
                Nodo Plataforma = new Nodo ();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreB.getContNodo() > 0){
                
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        return;
                    }
                }
                PilaTorreC.Pop();
                PilaTorreB.Push(Plataforma);
                
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
                
                if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad ","Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades lo has resuelto\n\nIntenta superar el objetivo con el minimo de movimientos","Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        } 
    }
    private void btnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_BActionPerformed
        MoverDeC_B();
    }//GEN-LAST:event_btnC_BActionPerformed
    
    
    private void MoverPlataforma(Pila Origen, Pila Destino){
        if(Stop== false){
            Nodo Plataforma = new Nodo();
            
            Plataforma.setDato(Origen.Peek());
            
            Origen.Pop();
            
            Destino.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarCantMov();
            
            JOptionPane pane = new JOptionPane("Paso #"+lbNumMov.getText()+"\n\n¿Continuar?",JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        
            JDialog dialog = pane.createDialog("Numero de Pasos");
            
            dialog.setLocation(600,400);
            
            dialog.setVisible(true);
            
            int opt = (int) pane.getValue();
            
            if(opt == JOptionPane.NO_OPTION){
                Stop = true;
            }
        }
    }
    
    private void ResolverHanoiRecursivo(int n,Pila Origen, Pila Auxiliar,Pila Destino){
        if(n==1){
            MoverPlataforma(Origen, Destino);
        }else{
            ResolverHanoiRecursivo(n -1, Origen, Destino, Auxiliar);
             
                MoverPlataforma(Origen, Destino);
             
                    ResolverHanoiRecursivo(n -1, Auxiliar, Origen, Destino);
            
        }
    }
    
    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        if(!lbMinMov.getText().equals("") && PilaTorreC.getContNodo() != Objetivo){
            Reiniciar();
            Stop=false;
            ResolverHanoiRecursivo(Objetivo, PilaTorreA,PilaTorreB,PilaTorreC);
            
        }
    }//GEN-LAST:event_btnResolverActionPerformed

    
    public static void main(String args[]) {
   
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA_B;
    private javax.swing.JButton btnA_C;
    private javax.swing.JButton btnB_A;
    private javax.swing.JButton btnB_C;
    private javax.swing.JButton btnC_A;
    private javax.swing.JButton btnC_B;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JComboBox<String> cbNumDiscos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbMinMov;
    private javax.swing.JLabel lbNumMov;
    private javax.swing.JTable torreA;
    private javax.swing.JTable torreB;
    private javax.swing.JTable torreC;
    // End of variables declaration//GEN-END:variables
}
