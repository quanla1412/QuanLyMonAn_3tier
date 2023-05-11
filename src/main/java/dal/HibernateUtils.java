package dal;

import dal.entity.Ban;
import dal.entity.ChucVu;
import dal.entity.DonGoi;
import dal.entity.KhachHang;
import dal.entity.LoaiBan;
import dal.entity.LoaiKhachHang;
import dal.entity.LoaiMonAn;
import dal.entity.MonAn;
import dal.entity.NhanVien;
import dal.entity.TinhTrangBan;
import dal.entity.TinhTrangMonAn;
import dal.entity.TinhTrangNhanVien;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author LeAnhQuan
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        
        Properties prop = new Properties();
        
        prop.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        prop.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        prop.put(Environment.URL, "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyNhaHang;encrypt=true;trustServerCertificate=true");
        prop.put(Environment.USER, "sa");
        prop.put(Environment.PASS, "sa");
        prop.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(prop);
        
        
       
        conf.addAnnotatedClass(LoaiBan.class);
        conf.addAnnotatedClass(TinhTrangBan.class);
        conf.addAnnotatedClass(Ban.class);
        conf.addAnnotatedClass(LoaiMonAn.class);        
        conf.addAnnotatedClass(TinhTrangMonAn.class);
        conf.addAnnotatedClass(MonAn.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(TinhTrangNhanVien.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(LoaiKhachHang.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(DonGoi.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(registry);
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    
}
