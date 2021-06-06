<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Tela de Login</title>

<style type="text/css">
body { background-color: #f4f0ec;}
#Login{
			background-color: #cc8531;
			width: 1240px;
			height: 170px;
			font-family: Verdana,Arial,sans-serif;
			}
#cabecalho{
			background-color: #f4f0ec;
			width: 800px;
			height: 200px;
			}			
</style>

</head>
<body>


<div id="cabecalho">

</div>
<center>
<fieldset >
  <div id="Login">
  <form method="post" action="autenticador"> 
          <h3>Sistema GELINFO</h3> 
          <p> 
            <label for="login">Login:</label>
            <input id="login" name="login" required="required" type="text" placeholder="Digite seu Login"/>
          </p>
           
          <p> 
            <label for="senha">Senha:</label>
            <input id="senha" name="senha" required="required" type="password" placeholder="Digite sua Senha" /> 
          </p>
             
          <p> 
            <input type="submit" value="Logar" /> 
          </p>
           
         
        </form>
        </div>
</fieldset>
</center>
</body>
</html>