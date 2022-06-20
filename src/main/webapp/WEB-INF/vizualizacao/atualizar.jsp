<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar</title>
</head>
<body>

<form action="ServletTeste" method="POST">
<label for="nft">NFT: </label>
<input id="nft" name="nft" type="text" value="${lista.nft}"/>
<label for="nome">Nome: </label>
<input id="nome" name="nome" type="text" value="${lista.nome}"/>
<label for="preco">Preço: </label>
<input id="preco" name="preco" type="number" value="${lista.preco}"/>
<label for="descricao">Descrição: </label>
<input id="descricao" name="descricao" type="text" value="${lista.descricao}"/>
<input id="id" name="id" type="hidden" value="${lista.id}"/>
<button type="submit">Atualizar</button>
</form>
</body>
</html>