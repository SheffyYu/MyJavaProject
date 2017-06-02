/**
 *Tile: LogicControl
 *Description: ����ѧ����Ϣ�Ĳ���
 * @author Sheffy
 * @date 2017��4��6�� {time}
 *Problems:
 */
package management_of_school_roll;

import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;


/**
 *Class Name: logic_control
 *Description: ��ɾ�Ĳ顢��ӡѧ����Ϣ����ӡѧ���б�����ѧ����Ϣ����ȡѧ����Ϣ
 * @author Sheffy
 * @date 2017��4��6�� {time}
 */
class LogicControl {
	
	private LinkedList<Student> llist;
	
	//���캯��
	//���ļ�/���ݿ�ǿ�ʱ������
	public LogicControl(LinkedList<Student> llist){
		this.llist=llist;
	}
	
	/**
	 *Method Name��add
	 *Description�����ѧ��
	 *Call��
	 *Remove��
	 *Update��
	 * @param stu
	 */
	public void add(Student stu){
		llist.add(stu);																																	
	}
	
	/**
	 *Method Name��delete
	 *Description��ɾ��ѧ��
	 *Call��
	 *Remove��
	 *Update��
	 * @param stu
	 */
	public void delete(String id){
		//���ҽ��
		
		
		Student stu = null;
		//������Ϊ�գ�������������
		if(stu==null){
			System.out.println("���벻��Ϊ�գ�");
		}
		
		//ɾ��ѧ��
		
			
	}
	
	/**
	 *Method Name��alter
	 *Description���޸�ѧ����Ϣ
	 *Call��
	 *Remove��
	 *Update��
	 * @param info
	 */
	public void alter(String info){
		
	}
	
	/**
	 *Method Name��query
	 *Description����ѯѧ����Ϣ
	 *Call��
	 *Remove��
	 *Update��
	 * @param id
	 * @return
	 */
	public Student query(String id){
		Student stu = null;
		
		return stu;
	}
	
	/**
	 *Method Name��printList
	 *Description����ӡѧ���б�
	 *Call��Student.item
	 *Remove��
	 *Update��
	 */
	public void printList(LinkedList<Student> llist){
		for(Student stu:llist){
			System.out.println(stu.item());
		}
	}
	
}

