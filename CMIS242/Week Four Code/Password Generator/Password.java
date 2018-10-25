
public class Password{

	private String password="";
	private String choices = "1234567890!@#$%^&*abcdefghijklmn"+
							"opqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Password(int length){
	
		for(int i=0;i<length;i++){
			password = password + getOne();
		}
	}
	
	private String getOne(){
		int num = (int)(Math.random()*choices.length());
		return choices.substring(num,num+1);
		
	}

	public String getPassword(){
		return password;
	}
	public String toString(){
		return password;
	}
}
