package Perform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Numbers extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	

	   public String decimalToBinary(int broj) {
		   int num=0;
		   String finalni="";
		   
		   int i=(int)Math.floor(Math.sqrt(broj));
		   
		   
		   while(i>=0) {
		   	num=(int) Math.pow(2,i);
		   	if((broj-num<Math.abs(broj-Math.pow(2,i-1))) && broj>=num) {
		   		
		   		finalni=finalni+"1";
		   		broj=broj-num;
		   		
		   		
		   	}
		   	else
		   		
		   		finalni=finalni+"0";

		   	i=i-1;
		   	
		   } 
		   int k1=0;
		   for(int k=0;k<finalni.length();++k) {
			   if(finalni.substring(k,k+1).equals("1")) {
				   
				   break;
			   }
			   else
				   k1=k1+1;
		   }
		  
		   String finalni2="";
		   
		   for(int z=k1;z<finalni.length();++z) {
			   finalni2=finalni2+finalni.substring(z,z+1);
		   }
		   finalni="";
		   finalni=finalni2;
		  
		   return finalni;
		  
				
		}
	   
	   public int binaryToDecimal(String binBroj) {
		   int znam=binBroj.length()-1;
		   int decimalni=0;
		   for(int i=0;i<binBroj.length();++i) {
			   
			   if(binBroj.substring(i, i+1).equals("1")) {
				   
				   decimalni=(int) (decimalni+Math.pow(2,znam));
			   }
			   znam=znam-1;
			   
		   }
		   
		   
		   return decimalni;
	   }
	  
	   
	   


		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out=null;
			
			
			
			
			
			try {
				

				Numbers nu=new Numbers();
				
		
			   
				out=response.getWriter();
				
				
				
				out.println("<center>");
				out.println("<h1>Converter</h1>");
				out.println("<h2>Result</h2>");
				out.println("<div id=styledimg>");
				out.println("</div>");
				
				if(request.getParameter("btn").equals("s")) {
					
					if(request.getParameter("t2").matches("[0-9]+")) {
					
						int a=Integer.parseInt(request.getParameter("t2"));
						

						 out.println("<h2>Decimal number is: </h2>");
						 
						 out.println("<button style='background-color:white;width:400px;'>");
						
						 out.println("<br><br>");
				
						out.println(a+" = <h2>"+nu.decimalToBinary(a)+"</h2>");
						
						out.println("</button>");
						
					}
					else {
						
						out.println("Sorry, you entered wrong character. Try again!");
					}
				}
				else {
					
					
					if(request.getParameter("t2").matches("[0-1]+")) {
						
						String c=(request.getParameter("t2"));
						
						
						 out.println("<h2>Decimal number is: </h2>");
						 
						 out.println("<button style='background-color:white;width:400px;'>");
						
						 out.println("<br><br>");
						
						
						out.println(c+" = <h2>"+nu.binaryToDecimal(c)+"</h2>");
						
						out.println("</button>");
						
					
					}
					else {
						
						out.println("Sorry, you entered wrong character. Try again!");
					}
						
				
				}
				
			
		
				
				
			}catch(Exception e) {
				out.println("Error: "+e.getMessage());
				
			}
			finally {
				
				
				String cssTag="<link rel='stylesheet' type='text/css' href='css/styles.css'>";
				out.println("<head><title>Title Name</title>"+cssTag+"</head>");
				out.println("<br><br>");
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

	
	


