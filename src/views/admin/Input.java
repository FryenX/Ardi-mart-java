/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.admin;

import Config.UserSession;
import Config.constant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.image.Bitonal;
import com.github.anastaciocintra.escpos.image.BitonalThreshold;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.EscPosImage;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.github.anastaciocintra.output.TcpIpOutputStream;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import views.Login;

/**
 *
 * @author FryenX
 */
public final class Input extends javax.swing.JFrame {

    /**
     * Creates new form Input
     */
    public Input() {
        this.fieldValues = new HashMap<>();
        initComponents();
        Icon();
        txtSession.setText(UserSession.getName());
        try {
            generateInvoice("", txtInvoice);
            currentDate("", txtDate);
            getCustomer("", txtCustomer);
            txtBarcode.requestFocus();
            txtQty.setText("1");
            txtQty.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    txtQty.selectAll();
                }
            });
            txtProduct.setFocusable(false);

            fetchTempTransactions();
            sumTempTransactions();
            customizeTable();
            txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        evt.consume(); // Prevent default behavior
                        txtBarcodeActionPerformed(null); // Call the login method
                    }
                }
            });
        } catch (SQLException e) {

        }
    }
    private final Connection conn = (Connection) constant.connect();
    private final Map<JTextField, Integer> fieldValues;
    private JTextField txtDiscPercent;
    private JTextField txtDiscIDR;
    private JTextField totalAmount;
    private JTextField txtPayment;
    private JTextField changeAmount;
    private double originalTotal;
    private String lastInvoice;
    private JDialog paymentDialog;

    private void Icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInvoice = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelCustomer = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtCustomer = new javax.swing.JTextField();
        btnCancelTransactions = new javax.swing.JButton();
        btnConfirmTransactions = new javax.swing.JButton();
        txtBarcode = new javax.swing.JTextField();
        labelBarcode = new javax.swing.JLabel();
        labelProduct = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        labelQuantity = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTempTransactions = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTransactions = new javax.swing.JLabel();
        btnHome = new javax.swing.JLabel();
        iconHome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnUsers = new javax.swing.JLabel();
        btnCategories = new javax.swing.JLabel();
        btnUnits = new javax.swing.JLabel();
        btnProducts = new javax.swing.JLabel();
        btnLevels = new javax.swing.JLabel();
        iconCategories = new javax.swing.JLabel();
        iconUnits = new javax.swing.JLabel();
        iconProducts = new javax.swing.JLabel();
        iconLevels = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        iconTransactions = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSession = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        labelCategories = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelInvoice.setText("Invoice");

        labelDate.setText("Date");

        labelCustomer.setText("Customer");

        txtInvoice.setBackground(new java.awt.Color(204, 204, 204));
        txtInvoice.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtInvoice.setForeground(new java.awt.Color(255, 0, 51));
        txtInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoiceActionPerformed(evt);
            }
        });

        txtDate.setBackground(new java.awt.Color(204, 204, 204));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        txtCustomer.setBackground(new java.awt.Color(204, 204, 204));
        txtCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerActionPerformed(evt);
            }
        });

        btnCancelTransactions.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelTransactions.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnCancelTransactions.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelTransactions.setText("DELETE");
        btnCancelTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelTransactionsActionPerformed(evt);
            }
        });

        btnConfirmTransactions.setBackground(new java.awt.Color(51, 255, 0));
        btnConfirmTransactions.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnConfirmTransactions.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmTransactions.setText("CONFIRM");
        btnConfirmTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmTransactionsActionPerformed(evt);
            }
        });

        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });

        labelBarcode.setText("Barcode");

        labelProduct.setText("Product");

        txtProduct.setBackground(new java.awt.Color(204, 204, 204));
        txtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductActionPerformed(evt);
            }
        });

        labelQuantity.setText("Quantity");

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        labelTotal.setText("Total");

        txtTotal.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        tblTempTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Barcode", "Product", "Qty", "Price", "Sub Total", "#", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTempTransactions);
        if (tblTempTransactions.getColumnModel().getColumnCount() > 0) {
            tblTempTransactions.getColumnModel().getColumn(0).setMinWidth(40);
            tblTempTransactions.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblTempTransactions.getColumnModel().getColumn(0).setMaxWidth(40);
            tblTempTransactions.getColumnModel().getColumn(1).setMinWidth(150);
            tblTempTransactions.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblTempTransactions.getColumnModel().getColumn(1).setMaxWidth(150);
            tblTempTransactions.getColumnModel().getColumn(6).setMinWidth(80);
            tblTempTransactions.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblTempTransactions.getColumnModel().getColumn(6).setMaxWidth(80);
            tblTempTransactions.getColumnModel().getColumn(7).setMinWidth(0);
            tblTempTransactions.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblTempTransactions.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnTransactions.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnTransactions.setForeground(new java.awt.Color(255, 255, 255));
        btnTransactions.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTransactions.setText("Transactions");
        btnTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransactionsMouseClicked(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setText("Home");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });

        iconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/chart-simple-solid.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/users-solid.png"))); // NOI18N

        btnUsers.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(255, 255, 255));
        btnUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsers.setText("Users");
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsersMouseClicked(evt);
            }
        });

        btnCategories.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnCategories.setForeground(new java.awt.Color(255, 255, 255));
        btnCategories.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCategories.setText("Categories");
        btnCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriesMouseClicked(evt);
            }
        });

        btnUnits.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnUnits.setForeground(new java.awt.Color(255, 255, 255));
        btnUnits.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUnits.setText("Units");
        btnUnits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnitsMouseClicked(evt);
            }
        });

        btnProducts.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnProducts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProducts.setText("Products");
        btnProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductsMouseClicked(evt);
            }
        });

        btnLevels.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnLevels.setForeground(new java.awt.Color(255, 255, 255));
        btnLevels.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLevels.setText("Levels");
        btnLevels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLevelsMouseClicked(evt);
            }
        });

        iconCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/list-solid.png"))); // NOI18N

        iconUnits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/list-solid.png"))); // NOI18N

        iconProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/table-solid.png"))); // NOI18N

        iconLevels.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/share-solid.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        iconTransactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Menu/table-solid.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(194, 40));

        txtSession.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtSession.setText("NAME");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(txtSession)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSession)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(iconTransactions)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(iconHome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHome))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(iconCategories)
                                .addComponent(iconUnits)
                                .addComponent(iconLevels)
                                .addComponent(iconProducts))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCategories)
                                .addComponent(btnUsers)
                                .addComponent(btnUnits)
                                .addComponent(btnProducts)
                                .addComponent(btnLevels)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconHome)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsers)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCategories)
                    .addComponent(iconCategories))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUnits)
                    .addComponent(iconUnits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProducts)
                    .addComponent(iconProducts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLevels)
                    .addComponent(iconLevels))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTransactions)
                    .addComponent(iconTransactions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        btnAddItem.setBackground(new java.awt.Color(0, 102, 255));
        btnAddItem.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAddItem.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItem.setText("ADD");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        labelCategories.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        labelCategories.setText("Transaction");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInvoice)
                            .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCustomer)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelTransactions)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConfirmTransactions))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBarcode)
                            .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelProduct)
                            .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddItem))
                            .addComponent(labelQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotal)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCategories))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(labelCategories)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInvoice)
                    .addComponent(labelDate)
                    .addComponent(labelCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantity)
                    .addComponent(labelProduct)
                    .addComponent(labelBarcode)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoiceActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerActionPerformed

    private void btnCancelTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelTransactionsActionPerformed
        String invoice = txtInvoice.getText();

        String totalString = txtTotal.getText(); // Get the text from the field
// Remove "Rp" and any commas or spaces before parsing to double
        String cleanedTotalString = totalString.replace("Rp", "").replace(",", "").trim();
        double total = Double.parseDouble(cleanedTotalString);
        if (total > 0) {
            deleteTempTransactions(invoice);
        } else {
            JOptionPane.showMessageDialog(
                    this, // The parent component (usually the frame)
                    "Please add item before proceeding", // The message
                    "Error", // Title of the dialog
                    JOptionPane.ERROR_MESSAGE // Error icon
            );
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelTransactionsActionPerformed

    private void btnConfirmTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmTransactionsActionPerformed
        String invoice = txtInvoice.getText();
        String totalString = txtTotal.getText(); // Get the text from the field
// Remove "Rp" and any commas or spaces before parsing to double
        String cleanedTotalString = totalString.replace("Rp", "").replace(",", "").trim();
        double total = Double.parseDouble(cleanedTotalString);
        if (total > 0) {
            showPaymentModal(invoice);
        } else {
            JOptionPane.showMessageDialog(
                    this, // The parent component (usually the frame)
                    "Please add item before proceeding", // The message
                    "Error", // Title of the dialog
                    JOptionPane.ERROR_MESSAGE // Error icon
            );
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmTransactionsActionPerformed

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        checkCode();
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void txtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionsMouseClicked
        Transactions transactions = new Transactions(); // Instantiate the Input class
        transactions.setVisible(true);    // Show the Input window
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransactionsMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        AdminDashboard adminDashboard = new AdminDashboard(); // Instantiate the Input class
        adminDashboard.setVisible(true);    // Show the Input window
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseClicked
        ManageUsers manageUser = new ManageUsers(); // Instantiate the Input class
        manageUser.setVisible(true);    // Show the Input window
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnUsersMouseClicked

    private void btnCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriesMouseClicked
        ManageCategories manageCategories = new ManageCategories(); // Instantiate the Input class
        manageCategories.setVisible(true);    // Show the Input window
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriesMouseClicked

    private void btnUnitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnitsMouseClicked
        ManageUnits manageUnits = new ManageUnits(); // Instantiate the Input class
        manageUnits.setVisible(true);    // Show the Input window
        this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_btnUnitsMouseClicked

    private void btnProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseClicked
        ManageProducts manageProducts = new ManageProducts(); // Instantiate the Input class
        manageProducts.setVisible(true);    // Show the Input window
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnProductsMouseClicked

    private void btnLevelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLevelsMouseClicked
        ManageLevels manageLevels = new ManageLevels(); // Instantiate the Input class
        manageLevels.setVisible(true);    // Show the Input window
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnLevelsMouseClicked

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        try {
            int qty = Integer.parseInt(txtQty.getText());
            // Get the barcode entered by the user
            long barcode = Long.parseLong(txtBarcode.getText()); // Use Long for large barcodes

            // SQL query to fetch the current stock for the product
            String query = "SELECT stocks FROM products WHERE barcode = ?";

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, barcode);  // Set the product barcode (using Long)

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int stock = rs.getInt("stocks");

                        // Compare stock with qty
                        if (stock >= qty) {
                            // If stock is sufficient, proceed with the insertTemp() operation
                            insertTemp(); // Make sure insertTemp() method handles the actual insert of item
                        } else {
                            // If stock is not sufficient, display a message
                            JOptionPane.showMessageDialog(this, "Stocks not enough", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // If no product found, show an error
                        JOptionPane.showMessageDialog(this, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            // Handle case if user enters invalid number for quantity or barcode
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and barcode", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        UserSession.clearSession();

        Login login = new Login();
        login.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input().setVisible(true);
            }
        });

    }

    public void generateInvoice(String lastInvoice, JTextField txtInvoice) throws SQLException {
        // Get the current date
        Date currentDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");  // Use yyyy-MM-dd format for query consistency
        String formattedDate = dateFormatter.format(currentDate);

        // Query to get the last invoice based on the current date
        String query = "SELECT MAX(invoice) AS noInvoice FROM transactions WHERE strftime('%Y-%m-%d', date_time) = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, formattedDate);  // Set the formatted date for comparison

        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            lastInvoice = resultSet.getString("noInvoice");
        } else {
        }

        String userUuid = UserSession.getUuid();  // Make sure UserSession has the uuid set
        String uuid = userUuid.length() >= 3 ? userUuid.substring(userUuid.length() - 3) : userUuid;

        String newInvoice = null; // Variable to hold the new invoice
        if (lastInvoice != null && !lastInvoice.isEmpty()) {
            // Extract last number from the last invoice
            String lastNum = lastInvoice.substring(lastInvoice.length() - 4); // Get the last 4 digits
            int nextNum = Integer.parseInt(lastNum) + 1; // Increment the number
            String formattedNextNum = String.format("%04d", nextNum); // Format it to 4 digits

            // Create the new invoice with date and formatted number
            newInvoice = "T" + formattedDate.replace("-", "") + uuid + formattedNextNum;  // Use formatted date without dashes
        } else {
            // If no invoice exists, start with the first one (e.g., T202501010001)
            newInvoice = "T" + formattedDate.replace("-", "") + uuid + "0001";  // Use formatted date and default first number
        }

        // Set the new invoice number in the JTextField
        txtInvoice.setText(newInvoice);
        txtInvoice.setEditable(false);
        txtInvoice.setFocusable(false);
    }

    public void currentDate(String date, JTextField txtDate) throws SQLException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormatter.format(currentDate);

        txtDate.setText(formattedDate);
        txtDate.setEditable(false);
        txtDate.setFocusable(false);
    }

    public void getCustomer(String customer, JTextField txtCustomer) throws SQLException {
        txtCustomer.setText("-");
        txtCustomer.setEditable(false);
        txtCustomer.setFocusable(false);
        fieldValues.put(txtCustomer, 0);
    }

    private void checkCode() {
        String barcode = txtBarcode.getText().trim(); // Get the barcode input

        if (barcode.isEmpty()) {
            showProductModal(null); // Show all products if barcode is empty
        } else {
            // Check if there's a product with this barcode
            String countSql = "SELECT COUNT(*) FROM products WHERE barcode LIKE ? OR name LIKE ?";

            try (PreparedStatement ps = conn.prepareStatement(countSql)) {
                ps.setString(1, "%" + barcode + "%");
                ps.setString(2, "%" + barcode + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1); // Get the count of products with this barcode
                        if (count == 1) {
                            // If only one product matches, fetch the product name
                            String productSql = "SELECT barcode, name FROM products WHERE barcode LIKE ? OR name LIKE ?";
                            try (PreparedStatement ps2 = conn.prepareStatement(productSql)) {
                                ps2.setString(1, "%" + barcode + "%");
                                ps2.setString(2, "%" + barcode + "%");
                                try (ResultSet rs2 = ps2.executeQuery()) {
                                    if (rs2.next()) {
                                        String productBarcode = rs2.getString("barcode");
                                        String productName = rs2.getString("name");
                                        txtBarcode.setText(productBarcode);
                                        txtProduct.setText(productName);
                                        txtQty.requestFocus();
                                        txtQty.selectAll();
                                    }
                                }
                            }
                        } else if (count > 1) {
                            // If more than one product matches, update search query and show modal
                            showProductModal(barcode); // Use barcode as search query
                        } else {
                            // If no product matches, show error dialog
                            JOptionPane.showMessageDialog(this, "Error: No product with such barcode", "Product Not Found", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error fetching product details: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showProductModal(String initialSearchQuery) {
        JDialog modal = new JDialog();
        modal.setTitle("Product List");
        modal.setSize(800, 600);
        modal.setModal(true);
        modal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Components for search and pagination
        JTextField txtSearch = new JTextField(20);
        JComboBox<Integer> cmbPageSize = new JComboBox<>(new Integer[]{10, 25, 50});
        JLabel lblPageInfo = new JLabel("Page 1 of 1");
        JButton btnPrev = new JButton("Previous");
        JButton btnNext = new JButton("Next");

        DefaultTableModel tableProduct = new DefaultTableModel(new Object[]{"No", "Barcode", "Product", "Category", "Stocks", "Price", "#"}, 0);
        JTable table = new JTable(tableProduct) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Make the table non-editable
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);

        // Pagination state
        final int[] currentPage = {0};
        final int[] totalPages = {0};
        final int[] pageSize = {10};

        // Fetch data and populate table
        Runnable fetchProducts = () -> {
            int offset = currentPage[0] * pageSize[0];
            String innerSearchQuery = txtSearch.getText().trim(); // Search text from the modal's field

            // SQL query with both constraints
            String sql = "SELECT barcode, products.name AS product, categories.name AS category, stocks, sell_price "
                    + "FROM products "
                    + "JOIN categories ON products.category_id = categories.id "
                    + "WHERE (products.name LIKE ? OR barcode LIKE ? OR categories.name LIKE ?) "
                    + "AND (products.name LIKE ? OR barcode LIKE ? OR categories.name LIKE ?) "
                    + "LIMIT ? OFFSET ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // Inner refinement (txtSearch)
                ps.setString(1, "%" + innerSearchQuery + "%");
                ps.setString(2, "%" + innerSearchQuery + "%");
                ps.setString(3, "%" + innerSearchQuery + "%");

                // Outer constraint (initialSearchQuery)
                String outerConstraint = initialSearchQuery != null && !initialSearchQuery.isEmpty() ? "%" + initialSearchQuery + "%" : "%";
                ps.setString(4, outerConstraint);
                ps.setString(5, outerConstraint);
                ps.setString(6, outerConstraint);

                // Pagination parameters
                ps.setInt(7, pageSize[0]);
                ps.setInt(8, offset);

                try (ResultSet rs = ps.executeQuery()) {
                    tableProduct.setRowCount(0); // Clear table
                    int no = offset + 1;
                    while (rs.next()) {
                        String barcode = rs.getString("barcode");
                        String product = rs.getString("product");
                        String category = rs.getString("category");
                        Double stocks = rs.getDouble("stocks");
                        Double sellPrice = rs.getDouble("sell_price");

                        JButton selectButton = new JButton("Select");
                        selectButton.setBackground(Color.BLUE);   // Set the background color to blue
                        selectButton.setForeground(Color.WHITE);  // Set the text color to white for better contrast
                        selectButton.setFocusPainted(false);      // Remove focus border when clicked
                        selectButton.addActionListener(e -> {
                            txtBarcode.setText(barcode);
                            txtProduct.setText(product);
                            modal.dispose();
                            txtQty.requestFocus();
                            txtQty.selectAll();
                        });

                        tableProduct.addRow(new Object[]{no++, barcode, product, category, stocks, sellPrice, selectButton});
                    }
                }

                // Update pagination details
                calculateTotalPages(innerSearchQuery, totalPages, pageSize[0]);
                lblPageInfo.setText("Page " + (currentPage[0] + 1) + " of " + totalPages[0]);

                btnPrev.setEnabled(currentPage[0] > 0);
                btnNext.setEnabled(currentPage[0] < totalPages[0] - 1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(modal, "Error fetching products: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        // Set custom renderer and editor for the button column
        table.getColumn("#").setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
            if (value instanceof JButton) {
                return (JButton) value; // Ensure the button is displayed correctly
            }
            return null;
        });

        table.getColumn("#").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                return (Component) value; // Allow button interaction
            }
        });

        // Listener for txtSearch to update search
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                currentPage[0] = 0; // Reset to the first page
                fetchProducts.run(); // Trigger fetching with the new search text
            }
        });

        cmbPageSize.addActionListener(e -> {
            pageSize[0] = (int) cmbPageSize.getSelectedItem();
            currentPage[0] = 0; // Reset to the first page
            fetchProducts.run();
        });

        btnPrev.addActionListener(e -> {
            if (currentPage[0] > 0) {
                currentPage[0]--;
                fetchProducts.run();
            }
        });

        btnNext.addActionListener(e -> {
            if (currentPage[0] < totalPages[0] - 1) {
                currentPage[0]++;
                fetchProducts.run();
            }
        });

        // Layout
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search:"));
        topPanel.add(txtSearch);
        topPanel.add(new JLabel("Rows per page:"));
        topPanel.add(cmbPageSize);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnPrev);
        bottomPanel.add(lblPageInfo);
        bottomPanel.add(btnNext);

        modal.setLayout(new BorderLayout());
        modal.add(topPanel, BorderLayout.NORTH);
        modal.add(scrollPane, BorderLayout.CENTER);
        modal.add(bottomPanel, BorderLayout.SOUTH);

        fetchProducts.run(); // Initial fetch with constraints applied
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }

    void calculateTotalPages(String searchQuery, int[] totalPages, int pageSize) {
        JDialog modal = new JDialog();
        String countQuery = "SELECT COUNT(*) FROM products WHERE name LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(countQuery)) {
            ps.setString(1, "%" + searchQuery + "%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int totalRows = rs.getInt(1);
                    totalPages[0] = (int) Math.ceil((double) totalRows / pageSize);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(modal, "Error calculating total pages: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertTemp() {
        JDialog modal = new JDialog();
        modal.setTitle("Product List");

        String barcode = txtBarcode.getText();
        if (barcode.isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Barcode cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String query = "SELECT name, sell_price, purchase_price FROM products WHERE barcode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, barcode);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(modal, "Product not found for the given barcode.", "Data Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Retrieve product details
                Double sellPrice = resultSet.getDouble("sell_price");
                Double purchasePrice = resultSet.getDouble("purchase_price");

                // Parse and validate quantity
                String qtyText = txtQty.getText();
                Double qty;
                try {
                    qty = Double.valueOf(qtyText);
                    if (qty <= 0) {
                        JOptionPane.showMessageDialog(modal, "Quantity must be greater than zero.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(modal, "Invalid quantity. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insert data into temp_transactions table
                String insertSQL = "INSERT INTO temp_transactions (invoice, barcode, purchase_price, sell_price, qty, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement tempStmt = conn.prepareStatement(insertSQL)) {
                    String invoice = txtInvoice.getText();
                    if (invoice.isEmpty()) {
                        JOptionPane.showMessageDialog(modal, "Invoice cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Double subtotal = sellPrice * qty;

                    tempStmt.setString(1, invoice);
                    tempStmt.setString(2, barcode);
                    tempStmt.setDouble(3, purchasePrice);
                    tempStmt.setDouble(4, sellPrice);
                    tempStmt.setDouble(5, qty);
                    tempStmt.setDouble(6, subtotal);

                    tempStmt.executeUpdate();

                    // Refresh temporary transaction data
                    fetchTempTransactions();
                    sumTempTransactions();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(modal, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveData(String invoice, double grossTotal, double total, double payment, double change, double discPercent, double discIDR) throws IOException {
        JDialog confirmTransactions = new JDialog(this, "Add New User", true);
        confirmTransactions.setSize(400, 300);
        confirmTransactions.setLayout(new BorderLayout());
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.toString();
        Integer customerId = fieldValues.get(txtCustomer);

        try {
            // Step 1: Insert transaction data into the database
            String insertTransactionData = "INSERT INTO transactions (invoice, date_time, customer_id, discount_percent, "
                    + "discount_idr, gross_total, net_total, payment_amount, payment_change "
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstTransactions = conn.prepareStatement(insertTransactionData)) {
                pstTransactions.setString(1, invoice);
                pstTransactions.setString(2, dateTime);
                pstTransactions.setInt(3, customerId);
                pstTransactions.setDouble(4, discPercent);
                pstTransactions.setDouble(5, discIDR);
                pstTransactions.setDouble(6, grossTotal);
                pstTransactions.setDouble(7, total);
                pstTransactions.setDouble(8, payment);
                pstTransactions.setDouble(9, change);

                int rowTransactions = pstTransactions.executeUpdate();
                if (rowTransactions > 0) {
                    conn.setAutoCommit(false);
                    try {
                        // Step 2: Fetch temp transaction data and insert into transaction detail
                        String fetchTempDataQuery = "SELECT barcode, purchase_price, sell_price, qty, subtotal FROM temp_transactions WHERE invoice = ?";
                        try (PreparedStatement psFetchTempData = conn.prepareStatement(fetchTempDataQuery)) {
                            psFetchTempData.setString(1, invoice);
                            try (ResultSet rsTempData = psFetchTempData.executeQuery()) {
                                // Prepare insert statement for transaction details
                                String insertDetailQuery = "INSERT INTO transactions_detail (invoice, barcode, purchase_price, sell_price, qty, sub_total) VALUES (?, ?, ?, ?, ?, ?)";
                                try (PreparedStatement psInsertDetail = conn.prepareStatement(insertDetailQuery)) {
                                    while (rsTempData.next()) {
                                        String barcode = rsTempData.getString("barcode");
                                        double purchasePrice = rsTempData.getDouble("purchase_price");
                                        double sellPrice = rsTempData.getDouble("sell_price");
                                        double qty = rsTempData.getDouble("qty");
                                        double subtotal = rsTempData.getDouble("subtotal");

                                        // Insert into transaction details
                                        psInsertDetail.setString(1, invoice);
                                        psInsertDetail.setString(2, barcode);
                                        psInsertDetail.setDouble(3, purchasePrice);
                                        psInsertDetail.setDouble(4, sellPrice);
                                        psInsertDetail.setDouble(5, qty);
                                        psInsertDetail.setDouble(6, subtotal);
                                        psInsertDetail.executeUpdate();
                                    }
                                }
                            }
                        }

                        // Step 3: Generate the PDF invoice
                        generateInvoiceESCPos(invoice, grossTotal, total, payment, change, discPercent, discIDR, customerId, dateTime);

                        // Step 4: Delete temp transaction data
                        String deleteTempDataQuery = "DELETE FROM temp_transactions WHERE invoice = ?";
                        try (PreparedStatement psDeleteTempData = conn.prepareStatement(deleteTempDataQuery)) {
                            psDeleteTempData.setString(1, invoice);
                            psDeleteTempData.executeUpdate();
                        }

                        conn.commit();
                        JOptionPane.showMessageDialog(paymentDialog, "Transactions completed successfully.");
                        paymentDialog.dispose();
                        generateInvoice(lastInvoice, txtInvoice);
                        fetchTempTransactions();
                        sumTempTransactions();
                        txtBarcode.setText("");
                        txtProduct.setText("");

                    } catch (SQLException ex) {
                        conn.rollback();
                        System.out.println("Error during transaction. Changes rolled back: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(confirmTransactions, "Failed to process transaction");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        confirmTransactions.setLocationRelativeTo(this);
    }

// Method to generate PDF invoice
    private void generateInvoiceESCPos(String invoice, double grossTotal, double total,
            double payment, double change, double discPercent, double discIDR,
            Integer customerId, String dateTime) throws IOException {
        try {
            // Get the default printer
            PrintService defaultPrintService = PrinterOutputStream.getPrintServiceByName(
                    PrintServiceLookup.lookupDefaultPrintService().getName()
            );

            // Check if a default printer is available
            if (defaultPrintService == null) {
                JOptionPane.showMessageDialog(null,
                        "No default printer is set. Please check your printer settings.",
                        "Printer Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            PrinterOutputStream printerOutputStream = new PrinterOutputStream(defaultPrintService);
            try (EscPos escpos = new EscPos(printerOutputStream)) {
                // Create styles with appropriate widths for thermal paper
                Style titleStyle = new Style()
                        .setFontSize(Style.FontSize._2, Style.FontSize._2)
                        .setBold(true)
                        .setJustification(EscPosConst.Justification.Center);

                Style normalStyle = new Style()
                        .setFontSize(Style.FontSize._1, Style.FontSize._1)
                        .setJustification(EscPosConst.Justification.Center);

                Style centerStyle = new Style()
                        .setFontSize(Style.FontSize._1, Style.FontSize._1)
                        .setJustification(EscPosConst.Justification.Center);

                Style footerStyle = new Style()
                        .setBold(true)
                        .setJustification(EscPosConst.Justification.Center);

                // Initialize receipt
                escpos.feed(2);
//                String logoPath = "/image/Icon/invoice-logo.png";
//                BufferedImage imageBufferedImage = ImageIO.read(new File(logoPath));
//
//                RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();
//                Bitonal algorithm = new BitonalThreshold();
//                EscPosImage escposImage = new EscPosImage(new CoffeeImageImpl(imageBufferedImage), algorithm);
//                escpos.write(imageWrapper, escposImage);
                // Print store header
                escpos.writeLF(titleStyle, "Ardi-Mart")
                        .feed(1);
                escpos.writeLF(centerStyle, "Jl. Arjuna, No. 24")
                        .writeLF(centerStyle, "Tel: 081-936-070-879")
                        .feed(1);
                escpos.write(centerStyle, "=".repeat(32))
                        .feed(1);

                // Print invoice details
                escpos.writeLF(String.format("Invoice : %s", invoice))
                        .writeLF(String.format("Date   : %s", dateTime))
                        .writeLF(String.format("Cust ID: %s",
                                (customerId == 0 ? "-" : customerId.toString())))
                        .feed(1);

                escpos.write(centerStyle, "=".repeat(32))
                        .feed(1);

                // Fetch and print transaction details
                String fetchQuery = "SELECT p.name AS product, u.name AS unit, "
                        + "p.sell_price AS sell_price, qty, sub_total "
                        + "FROM transactions_detail td "
                        + "JOIN products p ON p.barcode = td.barcode "
                        + "JOIN units u ON u.id = p.unit_id "
                        + "WHERE td.invoice = ?";

                try (PreparedStatement ps = conn.prepareStatement(fetchQuery)) {
                    ps.setString(1, invoice);
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            String product = rs.getString("product");
                            if (product.length() > 32) {
                                product = product.substring(0, 29) + "..."; // Ensure the product name fits in 32 characters
                            }

                            // Print product name on the first line
                            escpos.writeLF(product);

                            // Print quantity, unit, sell price, and subtotal on the second line
                            escpos.writeLF(String.format("%-2.1f %-3s X %,8.2f %,12.2f",
                                    rs.getDouble("qty"),
                                    rs.getString("unit"),
                                    rs.getDouble("sell_price"),
                                    rs.getDouble("sub_total")));
                        }
                    }
                }

                // Print totals section
                escpos.feed(1)
                        .write(centerStyle, "=".repeat(32))
                        .feed(1);

                Style rightStyle = new Style()
                        .setJustification(EscPosConst.Justification.Right);

                escpos.writeLF(rightStyle, String.format("Gross Total  : %,12.2f", grossTotal))
                        .writeLF(rightStyle, String.format("Discount (%%): %,12.2f%%", discPercent))
                        .writeLF(rightStyle, String.format("Discount (Rp): %,12.2f", discIDR))
                        .writeLF(rightStyle, String.format("Net Total    : %,12.2f", total))
                        .writeLF(rightStyle, String.format("Payment      : %,12.2f", payment))
                        .writeLF(rightStyle, String.format("Change       : %,12.2f", change));

                // Print footer
                escpos.feed(1)
                        .write(centerStyle, "=".repeat(32))
                        .feed(1)
                        .writeLF(footerStyle, "Thank You for Your Visit!")
                        .writeLF(footerStyle, "Please Come Again!")
                        .feed(4)
                        .cut(EscPos.CutMode.FULL);
            }
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error generating receipt: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fetchTempTransactions() {
        String invoice = txtInvoice.getText(); // Get the invoice number
        DefaultTableModel model = (DefaultTableModel) tblTempTransactions.getModel(); // Get the table model
        model.setRowCount(0); // Clear existing data in the table

        PreparedStatement pst = null; // Declare the PreparedStatement variable

        try {
            // Prepare the SQL query
            String query = "SELECT temp_transactions.id, temp_transactions.barcode, products.name AS product, temp_transactions.qty AS qty, temp_transactions.sell_price AS sell_price, temp_transactions.subtotal AS subtotal "
                    + "FROM temp_transactions "
                    + "JOIN products ON products.barcode = temp_transactions.barcode "
                    + "WHERE invoice = ?";
            pst = conn.prepareStatement(query); // Initialize the PreparedStatement
            pst.setString(1, invoice); // Set the invoice parameter in the query
            // Iterate through the result set and populate the table
            try ( // Execute the query
                    ResultSet rs = pst.executeQuery()) {
                // Iterate through the result set and populate the table
                int no = 1;
                while (rs.next()) {
                    String id = rs.getString("id");
                    String barcode = rs.getString("barcode");
                    String product = rs.getString("product");
                    Double qty = rs.getDouble("qty");
                    Double price = rs.getDouble("sell_price");
                    Double subtotal = rs.getDouble("subtotal");
                    CurrencyFilter currencyFilter = new CurrencyFilter();
                    String formattedPrice = currencyFilter.currencyFormat.format(price);
                    String formattedSubTotal = currencyFilter.currencyFormat.format(subtotal);

                    // Add the data to the table model
                    model.addRow(new Object[]{no++, barcode, product, qty, formattedPrice, formattedSubTotal, "Delete", id});
                }
                // Close the result set
            }

            // Add a custom renderer and editor for the last column (Delete button)
            tblTempTransactions.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
            tblTempTransactions.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Make sure to close the PreparedStatement in the finally block
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    // Custom renderer for the JButton
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Delete" : value.toString());
            setBackground(Color.RED);
            setForeground(Color.WHITE);
            return this;
        }
    }

// Custom editor for the JButton
    class ButtonEditor extends DefaultCellEditor {

        private final JButton button;
        private String label;
        private boolean isPushed;
        private int currentRow; // Keep track of the current row being edited

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(Color.RED);
            button.setForeground(Color.WHITE);

            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped(); // Stop editing to commit the action
                performDeleteAction(); // Call the delete action
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Delete" : value.toString();
            button.setText(label);
            isPushed = true;
            currentRow = row; // Store the current row being edited
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        private void performDeleteAction() {
            if (currentRow >= 0) {
                String id = tblTempTransactions.getValueAt(currentRow, 7).toString(); // Get the barcode value from the second column
                deleteItem(id); // Call the delete method
            } else {
                JOptionPane.showMessageDialog(null, "No row selected to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

// Method to delete a temporary transaction
    private void deleteItem(String id) {
        try {
            String query = "DELETE FROM temp_transactions WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, id);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Product deleted successfully.");
                    fetchTempTransactions();
                    sumTempTransactions(); // Refresh the table
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sumTempTransactions() {
        try {
            String invoice = txtInvoice.getText();
            String query = "SELECT SUM(subtotal) AS sub_total FROM temp_transactions WHERE invoice = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, invoice);
                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next()) {
                        double subTotal = resultSet.getDouble("sub_total");

                        AbstractDocument doc = (AbstractDocument) txtTotal.getDocument();
                        DocumentFilter originalFilter = doc.getDocumentFilter();
                        doc.setDocumentFilter(null);  // Remove the filter temporarily

                        CurrencyFilter currencyFilter = new CurrencyFilter();
                        String formattedSubTotal = currencyFilter.currencyFormat.format(subTotal);

                        txtTotal.setText(formattedSubTotal);

                        doc.setDocumentFilter(originalFilter); // Set the formatted value to txtTotal
                    } else {
                        txtTotal.setText("Rp 0");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error calculating total: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTempTransactions(String invoice) {
        int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to cancel this transaction?",
                "Confirm Cancel",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmation == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM temp_transactions WHERE invoice = ?";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, invoice);

                    int rowsDeleted = pst.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Transaction canceled successfully.");
                        fetchTempTransactions();
                        sumTempTransactions(); // Refresh the table
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error canceling transaction: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void showPaymentModal(String invoice) {
        paymentDialog = new JDialog(this, "Add New User", true);
        paymentDialog.setSize(320, 360);
        paymentDialog.setLayout(new BorderLayout());

        String totalText = txtTotal.getText();
// Remove the "Rp." prefix if it exists
        totalText = totalText.replace("Rp ", "").replace(".", "").trim();
        originalTotal = Double.parseDouble(totalText); // Set originalTotal

        // Panel for input
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Small gaps around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblDiscPercent = new JLabel("Disc(%)");
        txtDiscPercent = new JTextField(10);
        ((AbstractDocument) txtDiscPercent.getDocument()).setDocumentFilter(new PercentageFilter());
        JLabel lblDiscIDR = new JLabel("Disc(IDR)");
        txtDiscIDR = new JTextField(10);
        ((AbstractDocument) txtDiscIDR.getDocument()).setDocumentFilter(new CurrencyFilter());

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblDiscPercent, gbc);

        gbc.gridx = 1;
        formPanel.add(lblDiscIDR, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(txtDiscPercent, gbc);

        gbc.gridx = 1;
        formPanel.add(txtDiscIDR, gbc);

        JLabel lblTotalPayment = new JLabel("Total Payment");
        totalAmount = new JTextField();  // Initialize the text field if not initialized yet
        ((AbstractDocument) totalAmount.getDocument()).setDocumentFilter(new CurrencyFilter());

        CurrencyFilter currencyFilter = new CurrencyFilter();
        String formattedTotal = currencyFilter.currencyFormat.format(originalTotal);
        totalAmount.setText(formattedTotal);
        totalAmount.setFont(new Font("Arial", Font.BOLD, 20));
        totalAmount.setForeground(Color.BLUE);
        totalAmount.setOpaque(true);
        totalAmount.setBackground(Color.LIGHT_GRAY);
        totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        totalAmount.setEditable(false);
        totalAmount.setFocusable(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(lblTotalPayment, gbc);

        gbc.gridy = 3;
        formPanel.add(totalAmount, gbc);

        // Payment
        JLabel lblPayment = new JLabel("Payment");
        txtPayment = new JTextField();
        txtPayment.setFont(new Font("Arial", Font.BOLD, 20));
        txtPayment.setForeground(Color.RED);
        txtPayment.setHorizontalAlignment(SwingConstants.RIGHT);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(lblPayment, gbc);

        gbc.gridy = 5;
        formPanel.add(txtPayment, gbc);

        JLabel lblChange = new JLabel("Change");
        changeAmount = new JTextField();
        changeAmount.setFont(new Font("Arial", Font.BOLD, 20));
        changeAmount.setForeground(Color.BLACK);
        changeAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        changeAmount.setOpaque(true);
        changeAmount.setBackground(Color.LIGHT_GRAY);

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        formPanel.add(lblChange, gbc);

        gbc.gridy = 7;
        formPanel.add(changeAmount, gbc);

        inputPanel.add(formPanel); // Add the form panel to the input panel

        ((AbstractDocument) txtPayment.getDocument()).setDocumentFilter(new CurrencyFilter());

        // Key listeners for discount fields
        txtDiscPercent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits and backspace
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore any non-numeric input
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateFinalTotal(); // Recalculate the final total whenever the discount percent changes
            }
        });

        txtDiscIDR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits and backspace
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore any non-numeric input
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateFinalTotal(); // Recalculate the final total whenever the IDR discount changes
            }
        });

        txtPayment.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits and backspace
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore any non-numeric input
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String payment = txtPayment.getText();
                    if (payment.isEmpty()) {
                        // If the payment field is empty, reset to the original total
                        changeAmount.setText(""); // Clear the change field
                        return; // Avoid further calculation
                    }

                    String cleanedPayment = payment.replace("Rp ", "").replace(".", "").trim();
                    // Subtract the final total (after discount) from the payment to get the change
                    // Get the text from totalAmount field
                    String totalText = totalAmount.getText();

                    String cleanedTotalText = totalText.replace("Rp ", "").replace(".", "").trim();

                    double finalTotalValue = Double.parseDouble(cleanedTotalText); // Get the final total from the totalAmount field
                    double finalPayment = Double.parseDouble(cleanedPayment);

                    // If payment is equal to the total, set change to zero
                    double change = finalPayment - finalTotalValue;
                    if (change == 0) {
                        changeAmount.setText("Rp 0");
                    } else {
                        CurrencyFilter currencyFilter = new CurrencyFilter();
                        String formattedTotal = currencyFilter.currencyFormat.format(change);

                        changeAmount.setText(formattedTotal);
                    }

                    changeAmount.setEditable(false);
                    changeAmount.setFocusable(false);
                } catch (NumberFormatException ex) {
                    // Handle case when input is empty or invalid
                    changeAmount.setText("");
                    changeAmount.setEditable(false);
                    changeAmount.setFocusable(false);
                }
            }
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        btnSave.setBackground(Color.GREEN);
        btnSave.setForeground(Color.WHITE);

        // Set the "Cancel" button to red with white text
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);

        btnSave.addActionListener(e -> {
            String payment = txtPayment.getText();
            if (payment == null || payment.trim().isEmpty()) {
                // If payment is empty or null, show an error
                JOptionPane.showMessageDialog(
                        this, // The parent component (usually the frame)
                        "Please input payment amount", // The message
                        "Error", // Title of the dialog
                        JOptionPane.ERROR_MESSAGE // Error icon
                );
                return; // Exit the method to prevent further processing
            }

            String cleanedPayment = payment.replace("Rp ", "").replace(".", "").trim();
            double finalPayment = Double.parseDouble(cleanedPayment);

            String totalValue = totalAmount.getText();
            String cleanedTotalText = totalValue.replace("Rp ", "").replace(".", "").trim();
            double finalTotalValue = Double.parseDouble(cleanedTotalText);

            String totalChange = changeAmount.getText();
            String cleanedTotalChange = totalChange.replace("Rp ", "").replace(".", "").trim();
            double finalTotalChange = Double.parseDouble(cleanedTotalChange);

            String discPercent = txtDiscPercent.getText().trim();
            double finalDiscPercent = 0.0; // Default value

            if (!discPercent.isEmpty()) {
                String cleanedDiscPercent = discPercent.replace("%", "").trim();
                finalDiscPercent = Double.parseDouble(cleanedDiscPercent);
            }

            String discIDR = txtDiscIDR.getText().trim();
            double finalDiscIDR = 0.0; // Default value

            if (!discIDR.isEmpty()) {
                String cleanedDiscIDR = discIDR.replace("Rp ", "").replace(".", "").trim();
                finalDiscIDR = Double.parseDouble(cleanedDiscIDR);
            }

            if (finalPayment >= finalTotalValue) {
                int confirmation = JOptionPane.showConfirmDialog(
                        this,
                        "Print Invoice?",
                        "Confirm Cancel",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (confirmation == JOptionPane.YES_OPTION) {
                    try {
                        saveData(invoice, originalTotal, finalTotalValue, finalPayment, finalTotalChange, finalDiscPercent, finalDiscIDR);
                    } catch (IOException ex) {
                        Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                // If payment is less than the total, show an error
                JOptionPane.showMessageDialog(
                        this, // The parent component (usually the frame)
                        "Insufficient payment amount.", // The message
                        "Error", // Title of the dialog
                        JOptionPane.ERROR_MESSAGE // Error icon
                );
            }
        });

        paymentDialog.add(inputPanel, BorderLayout.CENTER);
        paymentDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Handle Cancel button
        btnCancel.addActionListener(e -> paymentDialog.dispose());
        paymentDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                txtPayment.requestFocus();
            }
        });
        paymentDialog.setLocationRelativeTo(this); // Center dialog
        paymentDialog.setVisible(true);
    }

    private void updateFinalTotal() {
        try {
            double finalTotal = originalTotal; // Start with the original total

            // Discount Percent
            String discPercent = txtDiscPercent.getText().replace("%", "").trim();
            if (!discPercent.isEmpty()) {
                int discPercentValue = Integer.parseInt(discPercent);

                // Ensure the value is between 0 and 100
                if (discPercentValue < 0) {
                    txtDiscPercent.setText("0");
                    discPercentValue = 0;
                } else if (discPercentValue > 100) {
                    txtDiscPercent.setText("100");
                    discPercentValue = 100;
                }

                // Convert to decimal (e.g., 50 -> 0.5)
                double discPercentDecimal = discPercentValue / 100.0;
                // Apply the percentage discount
                finalTotal *= (1 - discPercentDecimal);
            }

            // IDR Discount
            String discIDR = txtDiscIDR.getText().replace("Rp ", "").replace(".", "").trim();
            if (!discIDR.isEmpty()) {
                double discIDRValue = Double.parseDouble(discIDR);
                // Apply the IDR discount
                finalTotal -= discIDRValue;
            }

            // Update the total amount display
            ((AbstractDocument) totalAmount.getDocument()).setDocumentFilter(new CurrencyFilter());

            CurrencyFilter currencyFilter = new CurrencyFilter();
            String formattedTotal = currencyFilter.currencyFormat.format(finalTotal);

            totalAmount.setText(formattedTotal);
            totalAmount.setEditable(false);
            totalAmount.setFocusable(false);

        } catch (NumberFormatException ex) {
            // Handle case when input is empty or invalid (e.g., reset)
            txtDiscPercent.setText("0");
            txtDiscIDR.setText("0");
            totalAmount = new JTextField();  // Initialize the text field if not initialized yet
            ((AbstractDocument) totalAmount.getDocument()).setDocumentFilter(new CurrencyFilter());

            CurrencyFilter currencyFilter = new CurrencyFilter();
            String formattedTotal = currencyFilter.currencyFormat.format(originalTotal);

            totalAmount.setText(formattedTotal);
            totalAmount.setEditable(false);
            totalAmount.setFocusable(false);
            // Reset to original total
        }
    }

    static class CurrencyFilter extends DocumentFilter {

        private final DecimalFormat currencyFormat;

        public CurrencyFilter() {
            // Create a DecimalFormat for IDR
            currencyFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            currencyFormat.setMaximumFractionDigits(0); // No decimal places for IDR
            currencyFormat.setGroupingUsed(true); // Use grouping separators
            currencyFormat.setPositivePrefix("Rp ");
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) {
                return;
            }
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
            updateText(fb, newText);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset + length);
            updateText(fb, newText);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + currentText.substring(offset + length);
            updateText(fb, newText);
        }

        private void updateText(DocumentFilter.FilterBypass fb, String text) throws BadLocationException {
            // Check for the negative sign and retain it
            boolean isNegative = text.startsWith("-");

            // Remove non-digit characters except for the minus sign
            String numericText = text.replaceAll("[^\\d-]", "");
            if (numericText.isEmpty()) {
                numericText = "0";
            }

            // If the number is negative, parse it as a negative value
            long parsedValue = Long.parseLong(numericText.replace("-", ""));
            String formattedText = currencyFormat.format(parsedValue);

            // If it's negative, add the negative sign back in the formatted text
            if (isNegative) {
                formattedText = "-" + formattedText;
            }

            fb.replace(0, fb.getDocument().getLength(), formattedText, null);
        }
    }

    static class PercentageFilter extends DocumentFilter {

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) {
                return;
            }
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
            updateText(fb, newText);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset + length);
            updateText(fb, newText);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + currentText.substring(offset + length);
            updateText(fb, newText);
        }

        private void updateText(DocumentFilter.FilterBypass fb, String text) throws BadLocationException {
            // Remove non-digit characters (except for the decimal point)
            String numericText = text.replaceAll("[^\\d.]", "");

            // Avoid the decimal point being the first character
            if (numericText.isEmpty()) {
                numericText = "0";
            }

            // Limit the number of decimals to two (optional)
            if (numericText.contains(".")) {
                int decimalIndex = numericText.indexOf(".");
                String integerPart = numericText.substring(0, decimalIndex);
                String decimalPart = numericText.substring(decimalIndex + 1);
                if (decimalPart.length() > 2) {
                    decimalPart = decimalPart.substring(0, 2);  // Limit to two decimal places
                }
                numericText = integerPart + "." + decimalPart;
            }

            // Format the numericText and add the percentage sign
            String formattedText = numericText + "%";

            // Replace the text with the formatted percentage
            fb.replace(0, fb.getDocument().getLength(), formattedText, null);
        }
    }

    private void customizeTable() {
        // Set font for the table's cells
        Font tableFont = new Font("Arial", Font.PLAIN, 14);  // Change the font size as needed
        tblTempTransactions.setFont(tableFont);  // Apply to the table cells

        // Set font for the table's header
        JTableHeader tableHeader = tblTempTransactions.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 16));  // Set a bigger font for the header

        // Adjust the row height to fit the larger font size
        tblTempTransactions.setRowHeight(30);  // Set a larger row height if needed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancelTransactions;
    private javax.swing.JLabel btnCategories;
    private javax.swing.JButton btnConfirmTransactions;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLevels;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel btnProducts;
    private javax.swing.JLabel btnTransactions;
    private javax.swing.JLabel btnUnits;
    private javax.swing.JLabel btnUsers;
    private javax.swing.JLabel iconCategories;
    private javax.swing.JLabel iconHome;
    private javax.swing.JLabel iconLevels;
    private javax.swing.JLabel iconProducts;
    private javax.swing.JLabel iconTransactions;
    private javax.swing.JLabel iconUnits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelBarcode;
    private javax.swing.JLabel labelCategories;
    private javax.swing.JLabel labelCustomer;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelInvoice;
    private javax.swing.JLabel labelProduct;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tblTempTransactions;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtQty;
    private javax.swing.JLabel txtSession;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
