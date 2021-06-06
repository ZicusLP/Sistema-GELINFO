<%@ page isErrorPage="true"%>
<%@ page import = "java.util.Enumeration"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Erro de Login</title>

<style type="text/css">
	body { background-color: #fff;}
	#cabecalho{
			background-color: #fff;
			width: 800px;
			height: 80px;
			}
	#corpo{
			background-color: #fff;
			width: 800px;
			height: 650px;
			}
	#rodape{
			background-color: #fff;
			width: 800px;
			height: 100px;
			}
</style>

</head>
<body>
<div align="center">
<div id="cabecalho">

</div>
<div id="corpo">
<img src="imagens/erro.png"  />
<hr />
Error : <%=exception.getMessage() %> <br />
Exceção ocorrida: <%= exception.getClass() %> <br />
<hr />
<a href="includes/login.jsp">Tente novamente!</a>
</div>
<div id="rodape">

</div>
</div>
</body>
</html>