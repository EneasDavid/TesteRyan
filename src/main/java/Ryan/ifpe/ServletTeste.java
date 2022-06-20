package Ryan.ifpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ryan.ipfe.cadastrar.Produto;


import java.util.ArrayList;


@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Produto> lista = new ArrayList<>();
    Produto p = null;
	
    public ServletTeste() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var acao = request.getParameter("acao");
		
		if(acao.equals("listar")) {
			request.setAttribute("lista", this.lista);
			request.getRequestDispatcher("WEB-INF/vizualizacao/listar.jsp").forward(request,response);
			return;
		}
		if(acao.equals("atualizar")){
			request.setAttribute("lista", getNft(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("WEB-INF/vizualizacao/atualizar.jsp").forward(request,response);
			return;
		}
		if(acao.equals("excluir")) {
			this.removerNFT(Integer.parseInt(request.getParameter("id")));//remove
			request.setAttribute("lista", this.lista);	//retorna valor em string para lista	
			request.getRequestDispatcher("WEB-INF/vizualizacao/listar.jsp").forward(request,response);//redireciona para 
			//pagina jsp
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		var nft = request.getParameter("nft");
		var nome = request.getParameter("nome");
		var preco = Double.parseDouble(request.getParameter("preco"));
		var descricao = request.getParameter("descricao");
		
		if(request.getParameter("id") == null) {
		p = new Produto(nft, getId(), nome, preco,descricao);
		this.lista.add(p);
		response.sendRedirect("http://localhost:8080/TesteRyan/ServletTeste?acao=listar");
		} else {
			var pegaId = Integer.parseInt(request.getParameter("id"));
			p = new Produto(nft, pegaId, nome, preco,descricao);
			this.atualizarNFT(p);
			response.sendRedirect("http://localhost:8080/TesteRyan/ServletTeste?acao=listar");
		}
		System.out.println(p.toString());
	}
	
	private int getId() {
		return this.lista.size()+1;
	}
	//busca do array
	private Produto getNft(int id) {
		//percorre o array todo
		for(Produto nft:lista) {
			//verifica se o codigo posto é correspondente ao do nft desejado ou se existe
			if(nft.getId()==id) {
				return nft;
			}
		}
		return null;
	}
	
	//Metodo Remover
	private void removerNFT(int id) {
		//Procura o NFT pelo seu respectivo codigo
		this.lista.remove(getNft(id));
	}
	
//atualização
	private void atualizarNFT(Produto produto) {
		var posicao = this.lista.indexOf(getNft(produto.getId()));
		this.lista.set(posicao,produto);
	}
}


