package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.Student;

public class Register {
	public static int register(Student student){
		// 初始化，读取配置文件hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		// 读取并解析映射文件student.hbm.xml
		SessionFactory sf = conf.buildSessionFactory();
		// 打开session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction ts = session.beginTransaction();
		Student stuCheck = (Student)session.get(Student.class, student.getAccount());
		int key = 0;
		if(stuCheck == null){
			if(student.getAccount() + "" != "" && student.getPassword() != null){
				session.save(student);
				ts.commit();
				session.close();
				key = 2;
			}else{
				session.close();
				key = 3;
			}
		}else{
			key = 1;
		}
		return key;
	}
}
