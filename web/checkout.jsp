<%-- 
    Document   : checkout
    Created on : 18 Apr, 2016, 4:52:15 PM
    Author     : Sairam Pillai
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
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
                    text-align:left;
                    padding:5px;
                    
                }
                a{
                    text-decoration: none;
                    color:white;
                }
                .items{
                    margin:0 auto;
                    max-width:80%;
                    font-family: 'Raleway', sans-serif;
                    padding: 20px;
                    
                }
                div.feature:hover{
                    background-color: green;
                    alpha:0.6;    
                }
                .bill{
                    width:30%;
                    margin:0 auto;
                }
		</style>
    </head>
    <body>
        <div class="title">QuickFood</div>
        <div class="features">
        <a href="dashboard.jsp"><div class="feature">Go to Dashboard</div></a>
        <a href="pending.jsp"><div class="feature">Remove Items</div></a>
        <a href="order.jsp"><div class="feature">Add Items</div></a>
        </div>
        <div class="bill">
        <%
              ArrayList pendinglist=((ArrayList)session.getAttribute("pendinglist"));//list of foods from session and servlet listfoods.java
              Integer total= 0;
              if(pendinglist!=null && pendinglist.size()>0){
                  for(int i=0;i<pendinglist.size();i++){
                      beans.Pending pendingObj = (beans.Pending)pendinglist.get(i);//reading individual foods object from list
                  
            %>
                <p><%= pendingObj.getName()%> from <%= pendingObj.getHotel()%> at Rs.<%= pendingObj.getPrice()%></p>
            <%
                    total+=pendingObj.getPrice();
                }
            %>
            <p>Total: Rs.<%=total%></p>
        <%
            }else{
            
        %>
            <p>No orders!</p>
        <%
            }
        %>
        </div>
    </body>
</html>
