<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro de usu�rio - JBlog</title>
</head>
<body>
	<div>
		<h2>Cadastro de usu�rio:</h2>
		<form action="servletUsuario" method="post">
			ID de usu�rio: <input type="text" name="id" /><br />
			Nome de usu�rio: <input type="text" name="nome"/><br />
			Login de usu�rio: <input type="text" name="login"/><br />
			Senha de usu�rio: <input type="password" name="senha" /><br />
			Bio: <input type="text" name="bio"/><br />
			<input type="submit" value="Inserir" name="cmd"/>
			<input type="submit" value="Alterar" name="cmd"/>
			<input type="submit" value="Deletar" name="cmd"/>
			<input type="submit" value="Consultar" name="cmd"/>
		</form>
	</div>
	
</body>
</html>