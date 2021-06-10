package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.Student;

public class Login {
	public static Boolean login(String account, String password){
		// 初始化，读取配置文件hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		// 读取并解析映射文件student.hbm.xml
		SessionFactory sf = conf.buildSessionFactory();
		// 打开session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction ts = null;
		if(account == "" || account.length() == 0 ){
			return false;
		}
		Student student = (Student)session.get(Student.class, Integer.parseInt(account));
		if(student != null && student.getPassword().equals(password)){
			session.close();
			return true;
		}else{
			session.close();
			return false;
		}
	}
}
