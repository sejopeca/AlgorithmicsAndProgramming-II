
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author sdariza
 */
public class Main extends javax.swing.JFrame {
 //hola
    int numUsers = 0;
    String data[][] = new String[100][8];

    /**
     *
     * @param string
     * @return
     */
    public static boolean integerValidator(String string) {
        int tam = string.length(), i = 0;
        boolean sw = true;
        while (i < tam && sw) {
            String h = string.substring(i, i + 1);
            if (h.equals("0") || h.equals("1") || h.equals("2") || h.equals("3")
                    || h.equals("4") || h.equals("5") || h.equals("6") || h.equals("7")
                    || h.equals("8") || h.equals("9")) {
                i++;
            } else {
                sw = false;
            }
        }
        return sw;
    }

    /**
     *
     * @param string
     * @param tam
     * @return
     */
    public static int dotCount(String string, int tam) {
        int cont = 0, i = 0;
        while (i < tam && cont <= 1) {
            String h = string.substring(i, i + 1);
            if (h.equals(".")) {
                cont++;
            }
            i++;
        }
        return cont;
    }

    public static boolean floatValidator(String string, int tam) {
        if (tam < 3 || tam >= 5) {
            return false;
        }
        int dotCount = dotCount(string, tam);
        if (dotCount > 1 || dotCount == 0) {
            return false;
        }
        String izq = string.substring(0, 1);
        String der;
        if (tam == 3) {
            der = string.substring(2, 3);
        } else {
            der = string.substring(2, 4);
        }
        if (integerValidator(izq) && integerValidator(der)) {
            if (Integer.parseInt(izq) > 5 || (Integer.parseInt(izq) == 5 && Integer.parseInt(der) != 0)) {
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean idValidator(String string, int tam) {
        if (tam != 8) {
            return false;
        }
        return integerValidator(string);
    }

    /**
     * Calcule min length between 2 Strings
     *
     * @param cad1: string
     * @param cad2: String
     * @return min lenght between cad1 and cad2
     */
    public static int minLength(String cad1, String cad2) {
        if (cad1.length() > cad2.length()) {
            return cad2.length();
        } else if (cad2.length() > cad1.length()) {
            return cad1.length();
        }
        return cad1.length();
    }

    public static int compareTo(String cad1, String cad2) {
        int minLength = minLength(cad1, cad2);
        cad1 = cad1.toLowerCase();
        cad2 = cad2.toLowerCase();
        boolean sw = false;
        int i = 0, diff = 0;
        while (!sw && i < minLength) {
            if (cad1.charAt(i) != cad2.charAt(i)) {
                sw = true;
                diff = (int) cad1.charAt(i) - (int) cad2.charAt(i);
            } else {
                i++;
            }
        }
        if (!sw) {
            diff = cad1.length() - cad2.length();
        }

        return diff;
    }

    public static void swapping(String vec[], int pos) {
        String temp = vec[pos];
        vec[pos] = vec[pos + 1];
        vec[pos + 1] = temp;
    }

    public static void sort(String M[][], int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareTo(M[j][1], M[j + 1][1]) > 0) {
                    for (int j2 = 0; j2 < m; j2++) {
                        String temp = M[j][j2];
                        M[j][j2] = M[j + 1][j2];
                        M[j + 1][j2] = temp;
                    }
                }
            }
        }
    }

    public void populateTable() {
        String columnNames[] = {"id", "Primer Apellido", "Primer Nombre", "N1", "N2", "N3", "N4", "N5"};
        String realData[][] = new String[numUsers][columnNames.length];
        for (int i = 0; i < numUsers; i++) {
            for (int j = 0; j < columnNames.length; j++) {
                realData[i][j] = data[i][j];
            }
        }
        DefaultTableModel table = new DefaultTableModel(realData, columnNames);
        jTableM.setModel(table);
    }

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableM = new javax.swing.JTable();
        jPanelReg = new javax.swing.JPanel();
        jLabeltitle = new javax.swing.JLabel();
        jLabelTitleCode = new javax.swing.JLabel();
        jLabelCode = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jSeparatorCode = new javax.swing.JSeparator();
        jLabelTitleLName = new javax.swing.JLabel();
        jLabelLName = new javax.swing.JLabel();
        jTextFieldLName = new javax.swing.JTextField();
        jSeparatorLName = new javax.swing.JSeparator();
        jLabelTitleName = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jSeparatorName = new javax.swing.JSeparator();
        jLabelTitleMark1 = new javax.swing.JLabel();
        jLabelMark1 = new javax.swing.JLabel();
        jTextFieldMark1 = new javax.swing.JTextField();
        jSeparatorMark1 = new javax.swing.JSeparator();
        jLabelTitleMark2 = new javax.swing.JLabel();
        jLabelMark2 = new javax.swing.JLabel();
        jTextFieldMark2 = new javax.swing.JTextField();
        jSeparatorMark2 = new javax.swing.JSeparator();
        jLabelTitleMark3 = new javax.swing.JLabel();
        jLabelMark3 = new javax.swing.JLabel();
        jTextFieldMark3 = new javax.swing.JTextField();
        jSeparatorMark3 = new javax.swing.JSeparator();
        jLabeltitleMark4 = new javax.swing.JLabel();
        jLabelMark4 = new javax.swing.JLabel();
        jTextFieldMark4 = new javax.swing.JTextField();
        jSeparatorMark4 = new javax.swing.JSeparator();
        jLabelTitleMark5 = new javax.swing.JLabel();
        jLabelMark5 = new javax.swing.JLabel();
        jTextFieldMark5 = new javax.swing.JTextField();
        jSeparatorMark5 = new javax.swing.JSeparator();
        jButtonAdd = new javax.swing.JButton();
        jButtonSort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableM.setBackground(new java.awt.Color(204, 204, 204));
        jTableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableM.setEnabled(false);
        jScrollPane1.setViewportView(jTableM);

        jPanelBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 580));

        jPanelReg.setBackground(new java.awt.Color(255, 255, 255));
        jPanelReg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabeltitle.setText("Centro médico UN");
        jPanelReg.add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabelTitleCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleCode.setText("Código");
        jPanelReg.add(jLabelTitleCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabelCode.setForeground(new java.awt.Color(204, 204, 204));
        jLabelCode.setText("Ingrese el código del estudiante");
        jPanelReg.add(jLabelCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 280, 20));

        jTextFieldCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCode.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldCode.setBorder(null);
        jTextFieldCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodeKeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 283, 20));

        jSeparatorCode.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 283, 10));

        jLabelTitleLName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleLName.setText("Primer Apellido");
        jPanelReg.add(jLabelTitleLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabelLName.setForeground(new java.awt.Color(204, 204, 204));
        jLabelLName.setText("Ingrese el primer apellido");
        jPanelReg.add(jLabelLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 280, 20));

        jTextFieldLName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldLName.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldLName.setBorder(null);
        jTextFieldLName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldLNameKeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 283, 20));

        jSeparatorLName.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 283, 10));

        jLabelTitleName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleName.setText("Primer Nombre");
        jPanelReg.add(jLabelTitleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabelName.setForeground(new java.awt.Color(204, 204, 204));
        jLabelName.setText("Ingrese el primer nombre");
        jPanelReg.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 280, 20));

        jTextFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldName.setBorder(null);
        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 283, 20));

        jSeparatorName.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 283, 10));

        jLabelTitleMark1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleMark1.setText("Nota 1");
        jPanelReg.add(jLabelTitleMark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabelMark1.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMark1.setText("Nota 1");
        jPanelReg.add(jLabelMark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 20));

        jTextFieldMark1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMark1.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldMark1.setBorder(null);
        jTextFieldMark1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMark1KeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldMark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 20));

        jSeparatorMark1.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorMark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, 10));

        jLabelTitleMark2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleMark2.setText("Nota 2");
        jPanelReg.add(jLabelTitleMark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        jLabelMark2.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMark2.setText("Nota 2");
        jPanelReg.add(jLabelMark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 110, 20));

        jTextFieldMark2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMark2.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldMark2.setBorder(null);
        jTextFieldMark2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMark2KeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldMark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 110, 20));

        jSeparatorMark2.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorMark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 110, 10));

        jLabelTitleMark3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleMark3.setText("Nota 3");
        jPanelReg.add(jLabelTitleMark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabelMark3.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMark3.setText("Nota 3");
        jPanelReg.add(jLabelMark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, 20));

        jTextFieldMark3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMark3.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldMark3.setBorder(null);
        jTextFieldMark3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMark3KeyReleased(evt);
            }
        });
        jPanelReg.add(jTextFieldMark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, 20));

        jSeparatorMark3.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorMark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 10));

        jLabeltitleMark4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabeltitleMark4.setText("Nota 4");
        jPanelReg.add(jLabeltitleMark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jLabelMark4.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMark4.setText("Nota 4");
        jPanelReg.add(jLabelMark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 110, 20));

        jTextFieldMark4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMark4.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldMark4.setBorder(null);
        jPanelReg.add(jTextFieldMark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 110, 20));

        jSeparatorMark4.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorMark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 110, 10));

        jLabelTitleMark5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabelTitleMark5.setText("Nota 5");
        jPanelReg.add(jLabelTitleMark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabelMark5.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMark5.setText("Nota 5");
        jPanelReg.add(jLabelMark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, -1));

        jTextFieldMark5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMark5.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldMark5.setBorder(null);
        jPanelReg.add(jTextFieldMark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, 20));

        jSeparatorMark5.setForeground(new java.awt.Color(0, 0, 0));
        jPanelReg.add(jSeparatorMark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 10));

        jButtonAdd.setBackground(new java.awt.Color(204, 255, 204));
        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAdd.setText("Ingresar");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAddMouseExited(evt);
            }
        });
        jPanelReg.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        jButtonSort.setBackground(new java.awt.Color(204, 255, 204));
        jButtonSort.setText("Ordenar por apellido");
        jButtonSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonSortMousePressed(evt);
            }
        });
        jPanelReg.add(jButtonSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jPanelBackground.add(jPanelReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 340, 580));

        getContentPane().add(jPanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        String id = jTextFieldCode.getText();
        String name = jTextFieldName.getText();
        String lName = jTextFieldLName.getText();
        String n1 = jTextFieldMark1.getText();
        String n2 = jTextFieldMark2.getText();
        String n3 = jTextFieldMark3.getText();
        String n4 = jTextFieldMark4.getText();
        String n5 = jTextFieldMark5.getText();
        //JTextField myTextField[] = {jTextFieldCode,jTextFieldCode,jTextFieldCode,jTextFieldCode,jTextFieldCode};

        if (idValidator(id, id.length()) && floatValidator(n1, n1.length()) && floatValidator(n2, n2.length()) && floatValidator(n3, n3.length()) && floatValidator(n4, n4.length()) && floatValidator(n5, n5.length())) {
            data[numUsers][0] = id;
            data[numUsers][1] = lName;
            data[numUsers][2] = name;
            data[numUsers][3] = n1;
            data[numUsers][4] = n2;
            data[numUsers][5] = n3;
            data[numUsers][6] = n4;
            data[numUsers][7] = n5;

            numUsers++;
            populateTable();
            jTextFieldLName.setText("");
            jTextFieldName.setText("");
            jTextFieldMark1.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor valida la nota. Debe ser entre 0.0 y 5.0");
        }

    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseEntered
        jButtonAdd.setBackground(Color.decode("#A3CC9C"));
        jButtonAdd.setForeground(Color.red);
    }//GEN-LAST:event_jButtonAddMouseEntered

    private void jButtonAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseExited
        jButtonAdd.setBackground(new Color(204, 255, 204));
        jButtonAdd.setForeground(Color.black);
    }//GEN-LAST:event_jButtonAddMouseExited

    private void jButtonSortMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSortMousePressed
        sort(data, numUsers, 8);
        populateTable();
    }//GEN-LAST:event_jButtonSortMousePressed

    private void jTextFieldCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodeKeyReleased
        // TODO add your handling code here:
        if (jTextFieldCode.getText().length() == 0) {
            jLabelCode.setText("Ingrese el código del estudiante");
            jLabelCode.setVisible(true);

        } else {
            jLabelCode.setVisible(false);
            jTextFieldCode.setForeground(Color.black);
        }

    }//GEN-LAST:event_jTextFieldCodeKeyReleased

    private void jTextFieldLNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLNameKeyReleased

        if (jTextFieldLName.getText().length() == 0) {
            jLabelLName.setText("Ingrese el primer apellido");
            jLabelLName.setVisible(true);

        } else {
            jLabelLName.setVisible(false);
            jTextFieldLName.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldLNameKeyReleased

    private void jTextFieldNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyReleased
        // TODO add your handling code here:
        if (jTextFieldName.getText().length() == 0) {
            jLabelName.setText("Ingrese el primer apellido");
            jLabelName.setVisible(true);

        } else {
            jLabelName.setVisible(false);
            jTextFieldName.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldNameKeyReleased

    private void jTextFieldMark1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMark1KeyReleased
        // TODO add your handling code here:
        if (jTextFieldMark1.getText().length() == 0) {
            jLabelMark1.setText("Ingrese el primer apellido");
            jLabelMark1.setVisible(true);

        } else {
            jLabelMark1.setVisible(false);
            jTextFieldMark1.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldMark1KeyReleased

    private void jTextFieldMark2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMark2KeyReleased
        // TODO add your handling code here:
        if (jTextFieldMark2.getText().length() == 0) {
            jLabelMark2.setText("Ingrese el primer apellido");
            jLabelMark2.setVisible(true);

        } else {
            jLabelMark2.setVisible(false);
            jTextFieldMark2.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldMark2KeyReleased

    private void jTextFieldMark3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMark3KeyReleased
        // TODO add your handling code here:
        if (jTextFieldMark3.getText().length() == 0) {
            jLabelMark3.setText("Ingrese el primer apellido");
            jLabelMark3.setVisible(true);

        } else {
            jLabelMark3.setVisible(false);
            jTextFieldMark3.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldMark3KeyReleased

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
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelLName;
    private javax.swing.JLabel jLabelMark1;
    private javax.swing.JLabel jLabelMark2;
    private javax.swing.JLabel jLabelMark3;
    private javax.swing.JLabel jLabelMark4;
    private javax.swing.JLabel jLabelMark5;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTitleCode;
    private javax.swing.JLabel jLabelTitleLName;
    private javax.swing.JLabel jLabelTitleMark1;
    private javax.swing.JLabel jLabelTitleMark2;
    private javax.swing.JLabel jLabelTitleMark3;
    private javax.swing.JLabel jLabelTitleMark5;
    private javax.swing.JLabel jLabelTitleName;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JLabel jLabeltitleMark4;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelReg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorCode;
    private javax.swing.JSeparator jSeparatorLName;
    private javax.swing.JSeparator jSeparatorMark1;
    private javax.swing.JSeparator jSeparatorMark2;
    private javax.swing.JSeparator jSeparatorMark3;
    private javax.swing.JSeparator jSeparatorMark4;
    private javax.swing.JSeparator jSeparatorMark5;
    private javax.swing.JSeparator jSeparatorName;
    private javax.swing.JTable jTableM;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldLName;
    private javax.swing.JTextField jTextFieldMark1;
    private javax.swing.JTextField jTextFieldMark2;
    private javax.swing.JTextField jTextFieldMark3;
    private javax.swing.JTextField jTextFieldMark4;
    private javax.swing.JTextField jTextFieldMark5;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
