/**
 *Tile: DuoTai
 *Description: java����֮��̬��ϰ
 * @author Sheffy
 * @date 2017��3��13�� {time}
 *Problems:
 */
import java.awt.Label;
import java.util.*;

/**
 *Class Name: Animal
 *Description:����---������
 * @author Sheffy
 * @date 2017��3��13�� {time}
 *Problems:
 */
abstract class Animal{
	private String nameString;
	
	public Animal(String nameString){
		this.nameString=nameString;
	}

	public abstract void shout();
	
}

/**
 *Class Name: Cat
 *Description: �����������--è��
 * @author Sheffy
 * @date 2017��3��13�� {time}
 *Problems:
 */
class Cat extends Animal{
	private String colorString;
	public Cat(String nameString,String colorString) {
		super(nameString);
		// TODO Auto-generated constructor stub
		this.colorString=colorString;
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("miao~~miao~~~");
	}
	
}

/**
 *Class Name: Dog
 *Description: �����������--����
 * @author Sheffy
 * @date 2017��3��13�� {time}
 *Problems:
 */
class Dog extends Animal{
	private String colorString;
	public Dog(String nameString,String colorString) {
		super(nameString);
		// TODO Auto-generated constructor stub
		this.colorString=colorString;
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("wang~~wang~~~~");
	}
}

/**
 *Class Name: Me
 *Description:���࣬���ö����� 
 * @author Sheffy
 * @date 2017��3��13�� {time}
 *Problems:
 */
class Me{
	private String nameString;
	private Animal pet;
	public Me(String nameString,Animal animal){
		this.nameString=nameString;
		this.pet=animal;
	}
	
	public void mypetShout(){
		pet.shout();
	}
}

/**
	 *Class Name: DuoTai
	 *Description: 
	 * @author Sheffy
	 * @date 2017��3��13�� {time}
	 */
public class DuoTai {
	public static void main(String arg[]){
		Cat cat =new Cat("zhuzhu", "white");
		Dog dog=new Dog("NIAONIAO", "YELLO");
		
	    Me me1=new Me("Sheffy",cat);
	    Me me2=new Me("sheffy", dog);
	    
	    me1.mypetShout();
	    me2.mypetShout();
	}
}

