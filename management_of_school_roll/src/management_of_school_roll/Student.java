/**
 *Tile: Student
 *Description: ѧ����Ϣ
 * @author Sheffy
 * @date 2017��4��6�� {time}
 *Problems:
 */
package management_of_school_roll;

/**
 *Class Name: Student
 *Description:ѧ����Ϣ������ִ����ɾ�Ĳ�ʹ�ӡ�б� 
 * @author Sheffy
 * @date 2017��3��31�� {time}
 *Problems:
 */
class Student{
	//ѧ��
	private String stuID;
	//����
	private String name;
	//�Ա�
	private String sex;
	//����
	private int age;
	
	//���캯��
	public Student(String stuID,String name,String sex,int age){
		this.stuID=stuID;
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	
	
	public String getStuID() {
		return stuID;
	}
	
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String item(){
		String sitem=getStuID()+"\t"+getName()+"\t"+getSex()+"\t"+getAge();
		return sitem;
	}
	
	
}