package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhanVienBUS {
    private ArrayList<QLNhanVienDTO> arrNhanVien = new ArrayList<>();
    private QLNhanVienDAO nhanVienDAO = new QLNhanVienDAO();

    public QLNhanVienBUS() {
        arrNhanVien= nhanVienDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Quản Lý", "Password", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Chức Vụ"};
    }
    
    public QLNhanVienDTO getNhanVien(String maNhanVien){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.equals(maNhanVien)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLNhanVienDTO> getNhanVien_full(ArrayList <String> maNhanVien){
        Set<String> set = new HashSet<String>();
        ArrayList <QLNhanVienDTO> res = new ArrayList<>();
        for (String e : maNhanVien){
            set.add(e);
        }
        
        for (QLNhanVienDTO e : arrNhanVien){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLNhanVienDTO e : arrNhanVien){
            Pkey.add(e.getMaNhanVien());
        }
        return Pkey;
    }
    
    public ArrayList <QLNhanVienDTO> search (String column, String value){
        ArrayList <QLNhanVienDTO> result_search = new ArrayList <QLNhanVienDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Khách Hàng":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getMaNhanVien().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Password": 
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getPassword().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Họ Tên": 
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getHoTen().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Sinh":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getNgaySinh().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Địa Chỉ":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Điện Thoại":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Email":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Chức Vụ":
                for (QLNhanVienDTO e : arrNhanVien){
                    if (e.getChucVu().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLNhanVienDTO> search_all (String column, String value){
        ArrayList <QLNhanVienDTO> result_search = new ArrayList <QLNhanVienDTO> ();
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getMaNhanVien().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getPassword().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getHoTen().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgaySinh().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getChucVu().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLNhanVienDTO> filter (ArrayList <String> PKey){
        ArrayList <QLNhanVienDTO> res_filter = new ArrayList <QLNhanVienDTO>(); 
        for (QLNhanVienDTO e : arrNhanVien){
            if (PKey.contains(e.getMaNhanVien())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLNhanVienDTO> filter (ArrayList <String> PKey, ArrayList <QLNhanVienDTO> arr){
        ArrayList <QLNhanVienDTO> res_filter = new ArrayList <QLNhanVienDTO>(); 
        for (QLNhanVienDTO e : arr){
            if (PKey.contains(e.getMaNhanVien())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public String kiemTraTaiKhoan(String tk, String pass){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getMaNhanVien().equals(tk) && e.getPassword().equals(pass)){
                return e.getMaNhanVien();
            }
        }
        return "";
    }
    
    public String kiemTraTaiKhoan_RFID_code(String RFID_code){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getRFID_code().equals(RFID_code)){
                return e.getMaNhanVien();
            }
        }
        return "";
    }
    
    public Boolean add(QLNhanVienDTO nhanVien){
        Boolean check = nhanVienDAO.add(nhanVien);
        if (check){
            arrNhanVien.add(nhanVien);
        }
        return check;
    }
    
    public Boolean add(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.add(nhanVien);
    }
    
    public Boolean add(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt, String RFID_code){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt, RFID_code);
        return this.add(nhanVien);
    }
    
    public Boolean del(String maNhanVien){
        Boolean check = nhanVienDAO.del(maNhanVien);
        if (check){
            for (QLNhanVienDTO nhanVien : arrNhanVien){
                if (nhanVien.getMaNhanVien().equals(maNhanVien)){
                    arrNhanVien.remove(nhanVien);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLNhanVienDTO nhanVien){
        Boolean check = nhanVienDAO.mod(nhanVien);  
        if (check){
            for (QLNhanVienDTO s : arrNhanVien){
                if (s.getMaNhanVien().equals(nhanVien.getMaNhanVien())){
                    arrNhanVien.set(arrNhanVien.indexOf(s), nhanVien);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.mod(nhanVien);
    } 
    
    public Boolean mod_RFID_code(String maNhanVien, String RFID_code){
        Boolean check = nhanVienDAO.mod_RFID_code(maNhanVien, RFID_code);  
        if (check){
            for (QLNhanVienDTO s : arrNhanVien){
                if (s.getMaNhanVien().equals(maNhanVien)){
                    arrNhanVien.get(arrNhanVien.indexOf(s)).setRFID_code(RFID_code);
                    break;
                }
            }
        } 
        return check;
    }

    public ArrayList<QLNhanVienDTO> getArrNhanVien() {
        return arrNhanVien;
    }
    
    public int getSoLuongNhanVien(){
        return arrNhanVien.size();
    }
    
    
}
