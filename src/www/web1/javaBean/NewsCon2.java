package www.web1.javaBean;

import java.util.List;
import java.util.Stack;

import org.springframework.beans.NullValueInNestedPathException;

public class NewsCon2 {
	//此类用于给NewsCon2增加判别发送对象的属性
	Stack<NewsCon> a;
	Stack<NewsCon> b;
	
	NewsCon top;
	int size;
	int type = 0;
	
	public NewsCon2(List<NewsCon> a, List<NewsCon> b) throws Exception {
		super();
		this.a = new Stack<NewsCon>();
		for(NewsCon i:a){
			this.a.push(i);
		}
		this.b = new Stack<NewsCon>();
		for(NewsCon i:b){
			this.b.push(i);
		}
		size = a.size()+b.size();
		System.out.println("a size"+String.valueOf(a.size()));
		System.out.println("b size"+String.valueOf(b.size()));
		this.pop();
	}
	
	public void pop() throws Exception{
		if(size >= 0){
			if(size == 0){
				top = null;
				return;
			}
			if(a.empty()){
				type = 1;
				size--;
				top = b.pop();
				return;
			}
			if(b.empty()){
				type = 0;
				size--;
				top = a.pop();
				return;
			}
			if(a.peek().getDate().getTime() < b.peek().getDate().getTime()){
				type = 0;
				size--;
				top = a.pop();
				return;
			}else{
				type = 1;
				size--;
				top = b.pop();
				return;
			}
		}else{
			throw new Exception("NewsCon2的值已空");
		}
	}
	
	public String getTopContent(){
		return top.getContent();
	}
	
	public String getTopDateString(){
		return top.getDateString();
	}
	
	public int getSize(){
		return size;
	}
	
	public int getType(){
		return type;
	}
}
