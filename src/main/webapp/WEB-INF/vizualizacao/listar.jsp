<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem</title>
</head>
<body>
<h1>Listagem</h1>
<table>
<thead>
<tr>
<th>Id</th>
<th>Nome</th>
<th>Preço</th>
<th>NFT</th>
<th>Descrição</th>
<tr>
</thead>
<c:forEach var = "lista" items = "${lista}">
<!-- nomeArray.get(index).getVariavel() || notas.get(i).getNome -->
<tr>
<td>${lista.id}</td>
<td>${lista.nome}</td>
<td>${lista.preco} </td>
<td><h1>&#${lista.nft};</h1></td>
<!-- h1 &# nomeArray.nomeVariavel ; h1-->
<td>${lista.descricao}</td>
<td>
<a href="ServletTeste?acao=atualizar&id=${lista.id}">editar</a> | 
<a href="ServletTeste?acao=excluir&id=${lista.id}">excluir</a> 
</td> <!-- 
Faz um link que referencia o DOGET e pega a variavel ação e iguala a editar 
e retorna o id / ''-->
 </tr>
 </c:forEach>
</table>
</body>
</html>

