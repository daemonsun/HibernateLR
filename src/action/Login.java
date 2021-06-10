package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.Student;

public class Login {
	public static Boolean login(String account, String password){
		// ��ʼ������ȡ�����ļ�hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		// ��ȡ������ӳ���ļ�student.hbm.xml
		SessionFactory sf = conf.buildSessionFactory();
		// ��session
		Session session = sf.openSession();
		// ��ʼһ������
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
