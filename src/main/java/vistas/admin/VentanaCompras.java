package vistas.admin;

import controladores.BebidaControlador;
import controladores.CompraControlador;
import controladores.PedidoProveedorControlador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelos.Bebida;
import modelos.PedidoProveedor;
import modelos.Proveedor;

public class VentanaCompras extends javax.swing.JFrame {
    private Proveedor proveedor;
    private Map<Bebida, Integer> carrito = new LinkedHashMap<>();
    private BebidaControlador bebidaControlador = new BebidaControlador();
    private PedidoProveedorControlador pedidoProveedorControlador = new PedidoProveedorControlador();
    private CompraControlador compraControlador = new CompraControlador();

    public VentanaCompras(Proveedor proveedor) {
        this.proveedor = proveedor;
        initComponents();
        setLocationRelativeTo(null);
        personalizarTabla(tablaCarrito);
        personalizarTabla(tablaInventario);
        forzarColorEncabezado(tablaCarrito);
        forzarColorEncabezado(tablaInventario);
        cargarTablaInventario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        btnSeleccionarProducto = new javax.swing.JButton();
        btnRealizarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPRA DE PRODUCTOS");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 43, 91));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecciones los productos del pedido a proveedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 33, 33));
        jLabel2.setText("Productos del catálogo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 33, 33));
        jLabel3.setText("Carrito del pedido");

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tamaño (ml)", "Precio Unitario", "Categoría", "Stock Actual"
            }
        ));
        jScrollPane2.setViewportView(tablaCarrito);

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaInventario);

        btnQuitar.setBackground(new java.awt.Color(0, 80, 157));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnSeleccionarProducto.setBackground(new java.awt.Color(0, 80, 157));
        btnSeleccionarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSeleccionarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarProducto.setText("Seleccionar");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });

        btnRealizarPedido.setBackground(new java.awt.Color(0, 80, 157));
        btnRealizarPedido.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRealizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarPedido.setText("Realizar Pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(0, 80, 157));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuitar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarProducto)
                        .addGap(326, 326, 326)
                        .addComponent(btnRealizarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRealizarPedido)
                    .addComponent(btnSeleccionarProducto)
                    .addComponent(btnQuitar))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = tablaCarrito.getSelectedRow();
        if (fila >= 0) {
            String nombreSeleccionado = tablaCarrito.getValueAt(fila, 0).toString();

            Bebida bebidaAEliminar = null;
            for (Bebida b : carrito.keySet()) {
                if (b.getNombre().equals(nombreSeleccionado)) {
                    bebidaAEliminar = b;
                    break;
                }
            }

            if (bebidaAEliminar != null) {
                carrito.remove(bebidaAEliminar);
                cargarTablaCarrito();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un producto del carrito para eliminar.");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        int fila = tablaInventario.getSelectedRow();
        if (fila >= 0) {
            String nombreBebida = tablaInventario.getValueAt(fila, 0).toString();
            try {
                Bebida bebida = bebidaControlador.obtenerBebidaPorNombre(nombreBebida);
                String input = JOptionPane.showInputDialog(this, "¿Cantidad a agregar?");
                if (input == null) return;
                int cantidad = Integer.parseInt(input);

                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "Cantidad inválida.");
                    return;
                }

                int cantidadEnCarrito = carrito.getOrDefault(bebida, 0);
                int nuevaCantidadTotal = cantidadEnCarrito + cantidad;

                carrito.put(bebida, nuevaCantidadTotal);
                cargarTablaCarrito();
            } catch (SQLException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un producto de la tabla.");
        }
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoActionPerformed
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.");
            return;
        }

        try {
            Map.Entry<Bebida, Integer> primerItem = carrito.entrySet().iterator().next();
            Bebida bebidaPrincipal = primerItem.getKey();
            int cantidadPrincipal = primerItem.getValue();
            
            int idPedido = pedidoProveedorControlador.crearPedidoAutomatico(
                    bebidaPrincipal.getId(), cantidadPrincipal, proveedor.getRfc()
            );
            
            if (idPedido <= 0) {
                throw new SQLException("No se pudo crear el pedido a proveedor");
            }
            
            boolean exito = true;
            for (Map.Entry<Bebida, Integer> entry : carrito.entrySet()) {
                Bebida bebida = entry.getKey();
                int cantidad = entry.getValue();
                
                if (bebida.getId() == bebidaPrincipal.getId() && cantidad == cantidadPrincipal) {
                    continue;
                }
                exito &= pedidoProveedorControlador.agregarDetalleAPedido(idPedido, bebida.getId(), cantidad);
            }
            
            if (!exito) {
                throw new SQLException("Error al agregar detalles al pedido.");
            }
            JOptionPane.showMessageDialog(this, "Pedido registrado exitosamente.");
            carrito.clear();
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Error al procesar el pedido: " + e.getMessage(),
                "ERROR", JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnRealizarPedidoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new SeleccionProveedor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cargarTablaInventario() {
        try {
            List<Bebida> bebidas = bebidaControlador.obtenerTodasLasBebidas();
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            modelo.setColumnIdentifiers(new Object[]{"Nombre", "Tamaño (ml)", 
                "Precio Unitario", "Categoría", "Stock Actual"});
            for (Bebida b : bebidas) {
                modelo.addRow(new Object[]{
                    b.getNombre(),
                    b.getTamaño(),
                    b.getPrecio_unitario(),
                    b.getCategoria(),
                    b.getStock_actual()
                });
            }
            tablaInventario.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar las bebidas: " + e.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void cargarTablaCarrito() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Tamaño (ml)", 
                "Precio Unitario", "Cantidad", "Subtotal"});
        
        for (Map.Entry<Bebida, Integer> entry : carrito.entrySet()) {
            Bebida b = entry.getKey();
            int cantidad = entry.getValue();
            double subtotal = b.getPrecio_unitario() * cantidad;
            
            modelo.addRow(new Object[] {
                b.getNombre(),
                b.getTamaño(),
                b.getPrecio_unitario(),
                cantidad,
                subtotal
            });
        }
        tablaCarrito.setModel(modelo);
    }
    
    private void personalizarTabla(JTable tabla) {
        tabla.setRowHeight(28);
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));
        
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabla.setForeground(new Color(30, 30, 30));
        tabla.setBackground(new Color(240, 240, 240));
        
        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(0, 43, 91));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        
        tabla.setSelectionBackground(new Color(142, 197, 252));
        tabla.setSelectionForeground(Color.WHITE);
    }
    
    private void forzarColorEncabezado(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                lbl.setBackground(new Color(0, 43, 91));
                lbl.setForeground(Color.WHITE);
                lbl.setFont(new Font("Segoe UI", Font.BOLD, 15));
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setOpaque(true);
                return lbl;
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}
