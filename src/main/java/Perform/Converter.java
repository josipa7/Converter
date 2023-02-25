package Perform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Servlet implementation class Converter
 */
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	   public String intToRoman(int broj) {
			 String niz="";
			
				
			    if(broj>=1000) {
					int c=broj/100;
					for(int i=0;i<c;++i) {
						niz=niz+"M";
					}
					broj=broj-(c*1000);
				}
			    
			    if(broj>=400 && broj<500) {
					
			 				niz=niz+"CD";		
			 				broj=broj%10;
			 		}	 		
			    
			    if(broj>=500) {
					
					
						niz=niz+"D";
					
					    broj=broj-500;
					    
				}	  
				
			    if(broj>=100) {
			    	    int b=broj/100;
					
						for(int i=0;i<b;++i) {
								niz=niz+"C";
						
							}
						
						broj=broj-(100*b);
			
			    }
			    
			    
			    if(broj>=90 && broj<100) {
					
	 				niz=niz+"XC";
	 			
	 				broj=broj-90;
	 		}
			    
			    
			    if(broj>=50 && broj<90) {
					
		 			niz=niz+"L";
		 		
		 			broj=broj-50;
		 		}
			    
			    if(broj>=40 && broj<50) {
					
		 				niz=niz+"XL";
		 			
		 				broj=broj-40;
		 		}
			    
			    if(broj>=10) {
			    	
					int a=broj/10;
		 			for(int i=0;i<a;++i) {
		 				niz=niz+"X";
		 			}
		 			broj=broj-(a*10);
		 		}
			    
			    if(broj==9) {
			    	niz=niz+"IX";
			    	broj=0;
			    	
			    }
			    
			    if(broj>=5) {
					
		 				niz=niz+"V";
		 			
		 				broj=broj-5;
		 		}
			    
			    if(broj==4) {
			    	niz=niz+"IV";
			    	broj=0;
			    }
			    
			    if(broj>=1) {
					
		 			for(int i=0;i<broj;++i) {
		 				niz=niz+"I";
		 			}
		 			broj=0;
		 		}	
				
				return niz;
				
			}
	

	
	
	 public int romanToInt(String s) {
	       int finalni=0;
	       
	        Map<Integer,String> m=new HashMap<Integer,String>();
	        m.put(1,"I");
	        m.put(5,"V");
	        m.put(10,"X");
	        m.put(50,"L");
	        m.put(100,"C");
	        m.put(500,"D");
	        m.put(1000,"M");
	        
	        

	        for(int i =0;i<s.length();++i){
	            for (Map.Entry<Integer, String> entry : m.entrySet()) {

	                 if(entry.getValue().equals(s.substring(i,i+1))&&("V".equals(s.substring(i,i+1)))){
	                        finalni=finalni+entry.getKey();
	                        
	                        if(i>0 && "I".equals(s.substring(i-1,i)))
	                            finalni=finalni-2;
	                        
	    
	}
	                 else if(entry.getValue().equals(s.substring(i,i+1))&&("X".equals(s.substring(i,i+1)))){
	                        finalni=finalni+entry.getKey();
	                        
	                        if(i>0 && "I".equals(s.substring(i-1,i)))
	                            finalni=finalni-2;
	                        
	    
	}
	                  else if(entry.getValue().equals(s.substring(i,i+1))&&("L".equals(s.substring(i,i+1)))){
	                        finalni=finalni+entry.getKey();
	                  
	                        if(i>0 && "X".equals(s.substring(i-1,i)))
	                            finalni=finalni-20;
	                    
	                  }

	                   else if(entry.getValue().equals(s.substring(i,i+1))&&("C".equals(s.substring(i,i+1)))){
	                        finalni=finalni+entry.getKey();
	                  
	                        if(i>0 && "X".equals(s.substring(i-1,i)))
	                                finalni=finalni-20;
	                  }
	                   else if(entry.getValue().equals(s.substring(i,i+1))&&("D".equals(s.substring(i,i+1)))){

	                        finalni=finalni+entry.getKey();
	                        if(i>0 && "C".equals(s.substring(i-1,i)))
	                                finalni=finalni-200;

	                  
	                  }
	                    else if(entry.getValue().equals(s.substring(i,i+1))&&("M".equals(s.substring(i,i+1)))){

	                             finalni=finalni+entry.getKey();
	                             if(i>0 && "C".equals(s.substring(i-1,i)))
	                                    finalni=finalni-200;

	                  
	                  }
	                    else if(entry.getValue().equals(s.substring(i,i+1))){

	                                finalni=finalni+entry.getKey();
	                        
	                    }
	                 
	}

	            
	        }
	       
	        return finalni;
	    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=null;
	
		try {
	
			Converter ca=new Converter();
		
			
			out=response.getWriter();
			
			out.println("<center>");
			out.println("<h1>Converter</h1>");
			out.println("<h2>Result</h2>");
			out.println("<div id=styledimg>");
			out.println("</div>");
			
			
			ArrayList lstletter= new ArrayList<String>(Arrays.asList("M","D","C","L","X","V","I"));	
			int num=0;
			for(int j=0;j<request.getParameter("t1").length();++j) {
				
				
				
				
				if(lstletter.contains(request.getParameter("t1").substring(j,j+1)))
						num=num+1;
				
			}
		
				
						
			
			 
		   

		     if(request.getParameter("t1").matches(".*[0-9].*")) {
				 int b=Integer.parseInt(request.getParameter("t1"));
				
				 out.println("<h2>Roman number is: </h2>");
				 
				 out.println("<button style='background-color:white;width:400px;'>");
				
				 out.println("<br><br>");
				 out.println(b+" = <h2>"+intToRoman(b)+"</h2>");
				 out.println("</button>");
			 }
			
		     
		     
		   
		    	
		     else if((String.class.isInstance(request.getParameter("t1")) && request.getParameter("t1")!="") && num==request.getParameter("t1").length()) {
		    	 
		    	
		    	 
		    	    String a=request.getParameter("t1");
		    	

		    	    out.println("<h2>Number is: </h2>");
		    	    out.println(a+" = ");
		    	    out.println("<br><br>");
		    	    out.println("<button style='background-color:white;width:400px;'>");
		 			out.println("<h2>"+romanToInt(a)+"</h2>");
		 			out.println("</button>");
		 			
		     
		     } 
		     else {
		    	 
		    	 out.println("Sorry, you entered wrong character. Try again!");
		     }
			 
			
			//String op=request.getParameter("btn");
			
			
		    
			
			
			
		}catch(Exception e) {
			out.println("Error: "+e.getMessage());
			
		}
		finally {
			
			String cssTag="<link rel='stylesheet' type='text/css' href='css/styles.css'>";
			out.println("<head><title>Title Name</title>"+cssTag+"</head>");
			
			out.println("<br>");
			out.println("<br>");
			
			
			out.println("</button>");
			
			out.println("<button id=but1>");
			out.println("<a href=index.html>BACK</a>");
			out.println("</button>");
			out.println("</center>");
		
			
		}
	}
	
	
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
