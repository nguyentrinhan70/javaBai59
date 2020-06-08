package nguyentrinhan70.example.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import nguyentrinhan70.example.com.connect.NhaXuatBanService;
import nguyentrinhan70.example.com.model.NhaXuatBan;

public class QuanLySachUI extends JFrame {
	
	JTextField txtTenNxb, txtMaNxb, txtDiaChi, txtDienThoai;
	JButton btnVeTruoc, btnVeSau;
	JLabel lblStep;
	
	JButton btnThem, btnLuu, btnSua, btnXoa;
	
	DefaultTableModel dtmNxb;
	JTable tblNxb;
	
	JButton btnTimKiem;
	
	ArrayList<NhaXuatBan> dsNxb = null;
	public QuanLySachUI(String title){
		super(title);
		addControls();
		addEvents();
		hienThiToanBoDanhSachNhaXuatBan();
	}

	private void hienThiToanBoDanhSachNhaXuatBan() {
		// TODO Auto-generated method stub
		NhaXuatBanService nxBanService = new NhaXuatBanService();
		dsNxb = nxBanService.layToanBoNhaXuatBan();
		
		dtmNxb.setRowCount(0);
		for(NhaXuatBan nxb:dsNxb){
			Vector<Object> vec = new Vector<>();
			vec.add(nxb.getMaNxb());
			vec.add(nxb.getTenNxb());
			vec.add(nxb.getDiaChi());
			vec.add(nxb.getSoPhone());
			dtmNxb.addRow(vec);
		}
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimKiemUI ui = new TimKiemUI("Màn hình tìm kiếm");
				ui.showWindow();
			}
		});
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		
		con.add(pnNorth, BorderLayout.NORTH);
		con.add(pnCenter, BorderLayout.CENTER);
		con.add(pnSouth, BorderLayout.SOUTH);
		
		pnNorth.setLayout(new BorderLayout());
		JPanel pnChiTiet = new JPanel();
		JPanel pnThucHien = new JPanel();
		pnNorth.add(pnChiTiet, BorderLayout.CENTER  	);
		pnNorth.add(pnThucHien, BorderLayout.EAST);
		
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		JPanel pnNxb = new JPanel();
		JLabel lblNxb = new JLabel("Thông tin nhà xuất bản");
		lblNxb.setForeground(Color.blue);
		lblNxb.setFont(new Font("arial", Font.BOLD, 30));
		pnNxb.add(lblNxb);
		pnChiTiet.add(pnNxb);
		
		JPanel pnMaNxb = new JPanel();
		pnMaNxb.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaNxb = new JLabel("Mã nhà xuất bản:");
		txtMaNxb = new JTextField(20);
		pnMaNxb.add(lblMaNxb);
		pnMaNxb.add(txtMaNxb);
		pnChiTiet.add(pnMaNxb);
		
		JPanel pnTenNxb = new JPanel();
		pnTenNxb.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenNxb = new JLabel("Tên nhà xuất bản:");
		txtTenNxb = new JTextField(20);
		pnTenNxb.add(lblTenNxb);
		pnTenNxb.add(txtTenNxb);
		pnChiTiet.add(pnTenNxb);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiaChi = new JLabel("Địa chỉ nhà xuất bản:");
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi .add(txtDiaChi);
		pnChiTiet.add(pnDiaChi);
		
		JPanel pnDienThoai = new JPanel();
		pnDienThoai.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDienThoai = new JLabel("Số điện thoại:");
		txtDienThoai = new JTextField(20);
		pnDienThoai.add(lblDienThoai);
		pnDienThoai.add(txtDienThoai);
		pnChiTiet.add(pnDienThoai);
		
		lblMaNxb.setPreferredSize(lblDiaChi.getPreferredSize());
		lblTenNxb.setPreferredSize(lblDiaChi.getPreferredSize());
		lblDienThoai.setPreferredSize(lblDiaChi.getPreferredSize());
		
		JPanel pnButtonChiTiet = new JPanel();
		btnVeTruoc = new JButton("Về trước");
		lblStep = new JLabel("1/10");
		btnVeSau = new JButton("Về sau");
		pnButtonChiTiet.add(btnVeTruoc);
		pnButtonChiTiet.add(lblStep);
		pnButtonChiTiet.add(btnVeSau);
		pnChiTiet.add(pnButtonChiTiet);
		
		pnThucHien.setLayout(new BoxLayout(pnThucHien, BoxLayout.Y_AXIS));
		btnThem = new JButton("Thêm");
		btnLuu = new JButton("Lưu");
		btnSua = new JButton("Sua");
		btnXoa = new JButton("Xóa");
		pnThucHien.add(btnThem);
		pnThucHien.add(btnLuu);
		pnThucHien.add(btnSua);
		pnThucHien.add(btnXoa);
		
		pnCenter.setLayout(new BorderLayout());
		dtmNxb = new DefaultTableModel();
		dtmNxb.addColumn("Mã nhà xuất bản");
		dtmNxb.addColumn("Tên nhà xuất bản");
		dtmNxb.addColumn("Địa chỉ");
		dtmNxb.addColumn("Số điện thoại");
		tblNxb= new JTable(dtmNxb);
		JScrollPane sc = new JScrollPane(tblNxb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(sc, BorderLayout.CENTER);
		
		JPanel pnButtonOfSouth = new JPanel();
		btnTimKiem = new JButton("Tìm kiếm");
		pnButtonOfSouth.add(btnTimKiem);
		pnSouth.add(pnButtonOfSouth);
		
		TitledBorder borderThongTinChiTiet = new TitledBorder(BorderFactory.createLineBorder(Color.RED),
				"Thông tin chi tiết");
		pnChiTiet.setBorder(borderThongTinChiTiet);
		
		TitledBorder borderThucHien = new TitledBorder(BorderFactory.createLineBorder(Color.GREEN),
				"Thực hiên");
		pnThucHien.setBorder(borderThucHien);
		
		
		btnThem.setIcon(new ImageIcon("images/them.png"));
		btnLuu.setIcon(new ImageIcon("images/luu.png"));
		btnSua.setIcon(new ImageIcon("images/sua.png"));
		
		btnXoa.setIcon(new ImageIcon("images/xoa.png"));
		
		btnVeSau.setIcon(new ImageIcon("images/next.png"));
		btnVeTruoc.setIcon(new ImageIcon("images/previous.png"));
		
		TitledBorder borderDanhSachNxb = new TitledBorder(
				BorderFactory.createLineBorder(Color.CYAN),
				"Danh sách nhà xuất bản");
		pnCenter.setBorder(borderDanhSachNxb);
		
		btnTimKiem.setIcon(new ImageIcon("images/search.png"));
	
	}
	public void showWindow(){
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
