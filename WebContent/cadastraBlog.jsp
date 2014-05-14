<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro de Blog - JBlog</title>
</head>
<body>
		<form action="servletBlog" method="get">
			ID de Blog: <input type="text" name="id" /><br />
			Titulo Blog: <input type="text" name="titulo"/><br />
			Descrição Blog: <input type="text" name="descricao"/><br />
			Meta: <input type="text" name="meta" /><br />
			<input type="submit" value="Inserir" name="cmd"/>
			<input type="submit" value="Alterar" name="cmd"/>
			<input type="submit" value="Deletar" name="cmd"/>
			<input type="submit" value="Consultar" name="cmd"/>
		</form>
</body>
</html>