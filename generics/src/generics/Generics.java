/**
 *Tile: Generics
 *Description: java基础之泛型，Java 泛型（generics）是 JDK 5 中引入的一个新特性, 
 *             泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 *             泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *             定义泛型方法的规则：
 *              所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
 *              每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
 *              类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
 *              泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
 * @author Sheffy
 * @date 2017年3月16日 {time}
 *Problems:
 */

package generics;


/**
 *Class Name: Generics
 *Description: 
 * @author Sheffy
 * @date 2017年3月16日 {time}
 */
public class Generics {
	
}

import java.io.*;
import java.util.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    int a=cin.nextInt(),b=cin.nextInt();
                    System.out.println(a+b);
            }
}