package main.services;

import java.util.ArrayList;


public class CalculatorService {

	String result="";
	ArrayList<Integer> whiteSpaceIndex=null;
	public ArrayList<Character>chars= null;
	
	public CalculatorService(String text){
		this.setWhiteSpacesAndChars(text);
	}
	
	public void setWhiteSpacesAndChars(String text)
	{
		char[] charArr=text.toCharArray();
		whiteSpaceIndex=new ArrayList<Integer>();
		chars=new ArrayList<Character>();
		for(int i=0;i<charArr.length;i++)
		{
			if(charArr[i]==' ')
			{
				whiteSpaceIndex.add(i);
			}else {
				chars.add(charArr[i]);
			}
		}	
	}
	public String getResult(ArrayList<Character> chars,int start)
	{
        if(start==chars.size())
		{
        	result=result+formattResult(chars)+",";

		}else {
			for(int i=start;i<chars.size();i++)
			{

					    char temp=chars.get(start);
						chars.set(start, chars.get(i));
						chars.set(i, temp);
						getResult(chars,start+1);
						temp=chars.get(start);
						chars.set(start, chars.get(i));
						chars.set(i, temp);
		
			}
		}
		return result;
	}
	
	public String formattResult(ArrayList<Character> result) {
	
		ArrayList<Character> res=(ArrayList<Character>) result.clone();
		if(whiteSpaceIndex.size()!=0)
		{
			for(Integer i=0;i<whiteSpaceIndex.size();i++)
			{	
				res.add(whiteSpaceIndex.get(i),' ');		
			}
			
		}
		String resString = "";

		for (int i=0;i<res.size();i++)
		{
			resString +=res.get(i) ;
		}
				
		return resString;
	}
	
}
