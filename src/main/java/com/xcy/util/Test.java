package com.xcy.util;

public class Test {
	static class Point {
		
		int x , y , radius;
		  
		public Point(int x, int y){ 
			  this.x=x;
			  this.y=y;  
			  System.out.println("父类构造函数被调用！");
		}
		
		static class Circle extends Point{
		   Circle(int r, int x, int y){
			  super(x, y); 	  
			  radius=r;
			  System.out.println("子类构造函数被调用！");   
		   }
		   
		   public static void main(String[] args) {
				Circle c1=new Circle(1,1,1);
				System.out.println(c1);
			}
		}
		
		
	}
	
}

