/**
 *Tile: LogicControl
 *Description: 关于学生信息的操作
 * @author Sheffy
 * @date 2017年4月6日 {time}
 *Problems:
 */
package management_of_school_roll;

import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;


/**
 *Class Name: logic_control
 *Description: 增删改查、打印学生信息、打印学生列表、保存学生信息、读取学生信息
 * @author Sheffy
 * @date 2017年4月6日 {time}
 */
class LogicControl {
	
	private LinkedList<Student> llist;
	
	//构造函数
	//当文件/数据库非空时，读出
	public LogicControl(LinkedList<Student> llist){
		this.llist=llist;
	}
	
	/**
	 *Method Name：add
	 *Description：添加学生
	 *Call：
	 *Remove：
	 *Update：
	 * @param stu
	 */
	public void add(Student stu){
		llist.add(stu);																																	
	}
	
	/**
	 *Method Name：delete
	 *Description：删除学生
	 *Call：
	 *Remove：
	 *Update：
	 * @param stu
	 */
	public void delete(String id){
		//查找结点
		
		
		Student stu = null;
		//若输入为空，则需重新输入
		if(stu==null){
			System.out.println("输入不能为空！");
		}
		
		//删除学生
		
			
	}
	
	/**
	 *Method Name：alter
	 *Description：修改学生信息
	 *Call：
	 *Remove：
	 *Update：
	 * @param info
	 */
	public void alter(String info){
		
	}
	
	/**
	 *Method Name：query
	 *Description：查询学生信息
	 *Call：
	 *Remove：
	 *Update：
	 * @param id
	 * @return
	 */
	public Student query(String id){
		Student stu = null;
		
		return stu;
	}
	
	/**
	 *Method Name：printList
	 *Description：打印学生列表
	 *Call：Student.item
	 *Remove：
	 *Update：
	 */
	public void printList(LinkedList<Student> llist){
		for(Student stu:llist){
			System.out.println(stu.item());
		}
	}
	
}

