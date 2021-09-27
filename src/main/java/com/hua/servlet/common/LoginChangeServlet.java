package com.hua.servlet.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;
/**
 * ��¼ת��
 * ��ȡ��¼�û�����Ϣ�����жϵ�¼�û�����ݣ������û�����ݽ�����ת������Ӧ���û�ҳ��
 * @author jxd
 *
 */
@WebServlet("/loginChangeServlet")
public class LoginChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�������username��password
		String username = request.getParameter("username");
		
		//�����ݿ��ȡ��¼�˺���Ϣ
		User user = get(username);
		
		//���鵽��user�Ž�session��
		if(user != null){
			String identity = user.getIdentity();
			request.getSession().setAttribute("user", user);
			
			//���ݵ�¼�˺ŵ���ݲ�ͬ�ض��򵽲�ͬ��ҳ��
			if(identity.equals("ѧ��")){	
				response.sendRedirect(request.getContextPath() + "/student/student.jsp");
			}
			if(identity.equals("��ʦ")){
				response.sendRedirect(request.getContextPath() + "/teacher/teacher.jsp");
			}
			if(identity.equals("����Ա")){
				response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic_dean.jsp");
			}
			if(identity.equals("����Ա")){
				response.sendRedirect(request.getContextPath() + "/administrator/administrator.jsp");
			}
		}
	}

	/**
	 * �����û��������ݿ��в�ѯ���û�����
	 * @param username �û���
	 * @return ������ҵ��û��ͷ����û����󣬷��򷵻�null
	 */
	private User get(String username) {
		//�������ݿ��ѯ
		User user = null;
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		user = userDAOImpl.get(username);
		//����user
		return user;
	}
}
