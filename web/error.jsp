<%-- 
    Document   : error
    Created on : 17 Apr, 2016, 6:47:55 AM
    Author     : Sairam Pillai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
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
                }
                p{
                    font-size:1em;
                    font-family: 'Raleway', sans-serif;
                    color:white;
                    text-align:center;
                    padding:20px;
                    
                }
                a{
                    text-decoration: none;
                }
		</style>
    </head>
    <body>
        <div stle="display:flex;justify-content:center;align-items:center;margin-top:45%;">
        <h1>Error logging in</h1>
        <p>I guess an incorrect username password combo could do that!</p>
        <a href="index.html"><h1>Log In Again</h1></a>
        </div>
    </body>
</html>
