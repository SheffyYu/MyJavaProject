/**
 *Tile: Student
 *Description: 学生信息
 * @author Sheffy
 * @date 2017年4月6日 {time}
 *Problems:
 */
package management_of_school_roll;

/**
 *Class Name: Student
 *Description:学生信息操作，执行增删改查和打印列表 
 * @author Sheffy
 * @date 2017年3月31日 {time}
 *Problems:
 */
class Student{
	//学号
	private String stuID;
	//姓名
	private String name;
	//性别
	private String sex;
	//年龄
	private int age;
	
	//构造函数
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