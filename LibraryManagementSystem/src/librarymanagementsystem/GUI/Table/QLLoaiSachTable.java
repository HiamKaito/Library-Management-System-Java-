package librarymanagementsystem.GUI.Table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import librarymanagementsystem.BUS.QLLoaiSachBUS;
import librarymanagementsystem.DTO.QLLoaiSachDTO;

public class QLLoaiSachTable{
    
    
    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLLoaiSachDTO> createObjectDataModel(){
        return new ObjectTableModel<QLLoaiSachDTO>() {
            @Override
            public Object getValueAt(QLLoaiSachDTO loaiSach, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return loaiSach.getMaSach();
                    case 1:
                        return loaiSach.getTenSach();
                    case 2:
                        return loaiSach.getTenTacGia();
                    case 3:
                        return loaiSach.getTenNXB();
                    case 4:
                        return loaiSach.getTheLoai();
                    case 5:
                        return loaiSach.getNgonNgu();
                    case 6:
                        return loaiSach.getTomTatNoiDung();
                    case 7:
                        return loaiSach.getNamXB();
                    case 8:
                        return loaiSach.getGiaTien();
                    case 9:
                        return loaiSach.getSoTrang();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 10;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Mã Sách";
                    case 1:
                        return "Tên Sách";
                    case 2:
                        return "Tên Tác Giả";
                    case 3:
                        return "Tên NXB";
                    case 4:
                        return "Thể Loại";
                    case 5:
                        return "Ngôn Ngữ";
                    case 6:
                        return "Tóm Tắt Nội Dung";
                    case 7:
                        return "Năm Xuất Bản";
                    case 8:
                        return "Giá Tiền";
                    case 9:
                        return "Số Trang";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLLoaiSachDTO> createDataProvider(
            ObjectTableModel<QLLoaiSachDTO> objectDataModel) {
        final List<QLLoaiSachDTO> list = new QLLoaiSachBUS().getArrSach();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    public static void main(String[] args) {
        JFrame frame = createFrame();
        ObjectTableModel<QLLoaiSachDTO> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        //** Adjust **//
        table.setRowHeight(35);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        /*table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        Align
        */
        table.setFont(new Font("verdana", Font.PLAIN, 13));
        
        table.getTableHeader().setBackground(new Color(91, 243, 207));
        table.getTableHeader().setPreferredSize(new Dimension(0,35)); // HEader Height
        table.getTableHeader().setFont(new Font("verdana", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.WHITE);
        //table.getTableHeader().;
        //** End Adjust **//
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLLoaiSachDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLLoaiSachDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        /**/
        JPanel p = paginatedDecorator.getContentPanel();
        //frame.add(paginatedDecorator.getContentPanel());
        p.setSize(700, 500);
        p.setBackground(new java.awt.Color(255, 255, 255));
        frame.add(p);
        frame.setBackground(new java.awt.Color(255, 255, 255));
         
        /**/
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}