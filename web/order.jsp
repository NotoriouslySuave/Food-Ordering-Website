<%-- 
    Document   : order
    Created on : 17 Apr, 2016, 7:24:51 AM
    Author     : Sairam Pillai
--%>

<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="beans.foods"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.hibernate.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order foods</title>
        <link href='https://fonts.googleapis.com/css?family=Raleway:700italic' rel='stylesheet' type='text/css'>
		<style>
		@font-face { font-family: Ailerons; src: url('Ailerons-Typeface.otf'); }
		html { 
			
			background: url(delivery.jpg) no-repeat center center fixed; 
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
			
		}
		body{
			background: rgba(0,0,0,0.4);
			align:center;
		}
		.title{
			text-align:center;
			color: white;
			font-size:6em;
			font-family: Ailerons;
		}
		.features{
			margin-top: 40px;
			margin-left: 0px auto;
			margin-right:0px auto;
		}
		.feature{
			text-align:center;
			color:white;
			border: 2px solid white;
			border-radius:30px;
			padding:10px;
			display:inline-block;
			width:31%;
			nargin:0px auto;
			font-family: 'Raleway', sans-serif;
			font-size:1.5em
		}
		.join{
			font-family: 'Raleway', sans-serif;
			font-size:3.7em;
			color:white;
			text-align:center;	
			margin-top:10px;
			
		}
		.form{
			font-size:1.4em;
			color:white;
			text-align:center;	
			margin-top:10px;
			font-family: 'Raleway', sans-serif;
			line-height:2px;
			padding:10px;
			margin: 0;
  -webkit-box-sizing: border-box; 
     -moz-box-sizing: border-box; 
          box-sizing: border-box;
			
		}
		input {
			font-family: 'Raleway', sans-serif;
			border: 1px solid #999;
			border-radius:30px;
			font-size:1.2em;
			-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
			-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
			box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
		}
                h1{
                    font-size:2em;
                    font-family: 'Raleway', sans-serif;
                    color:white;
                    text-align:center;
                    margin-top: auto;
                    margin-bottom: auto;
                }
                p{
                    font-size:1em;
                    font-family: 'Raleway', sans-serif;
                    color:white;
                    text-align:center;
                    padding:20px;
                    
                }
                .items{
                    margin:0 auto;
                    max-width:80%;
                    font-family: 'Raleway', sans-serif;
                    padding: 20px;
                    
                }
                .item{
                    border:2px red double;
                    border-radius:30px;
                    color:white;
                    padding:20px;
                    display: inline-block;
                    min-width: 16%;
                    background-color: rgba(195,194,193,0.7);
                }
                .item.name{
                    
                    font-size:1.5em;
                }
                .item.hotel{
                    
                }
                .item.type{
                    
                    
                }
                .item.price{
                    
                    font-size:1em;
                }
                input[type="checkbox"]{
                    background-color: rgba(0,0,0,0);
                    border-radius:2px;
                    border:1px solid red;
                }
                a{
                    text-decoration: none;
                }
                div.feature:hover{
                    background-color: green;
                    alpha:0.6;    
                }
		</style>
    </head>
    <body>
        <div class="title">QuickFood</div>
        <h1>Hello, <%= request.getSession().getAttribute("username")%>! Our collection:</h1>
        <a href="dashboard.jsp"><div class="feature">Go to Dashboard</div></a>
        <a href="pending.jsp"><div class="feature">Pending Order</div></a>
        <a href="pending.jsp"><div class="feature">Remove Items</div></a>
        <div class="items">
            <form action="orderlist" method="get">
            <%
              ArrayList list=((ArrayList)session.getAttribute("list"));//list of foods from session and servlet listfoods.java
              if(list!=null && list.size()>0){
                  for(int i=0;i<list.size();i++){
                      foods foodObj = (foods)list.get(i);//reading individual foods object from list
            
            %>
            
            <div class="item">
                <div class="name"><img src="Waiter-52.png" style="width:20px;height:20px;"></img><%= foodObj.getName()%></div>
                <div class="hotel"><img src="5 Star Hotel-52.png" style=width:20px;height:20px;"></img><%= foodObj.getHotel()%></div>
                <div class="type"><img src="Restaurant Filled-50.png" style=width:20px;height:20px;"><%= foodObj.getType()%></div>
                <div class="price"><img src="Rupee-64.png" style=width:20px;height:20px;"><%= foodObj.getPrice()%></div>
                <div class="price"><input type="checkbox" name="selectedfoods"value="<%= foodObj.getId()%>"><label>Get <%= foodObj.getName()%> now!</label></div>
            </div>
            <%
                  }
              }
             %> 
             <span class="mid"><input type="submit" value="Checkout" style="width:10%;margin:0 auto;align:center; cursor: pointer;"></span>
            </form>
        </div>     
           
        
    </body>
</html>
