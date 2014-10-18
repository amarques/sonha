package br.com.fiap.sonha.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.sonha.beans.CategoriaSonhoBEANS;
import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.CategoriaSonhoBO;
import br.com.fiap.sonha.bo.SonhoBO;

/**
 * Servlet implementation class AdicionarSonhoServlet
 */
@WebServlet("/AdicionarSonhoServlet")
public class AdicionarSonhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarSonhoServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
			SonhoBO sonhoBO = new SonhoBO();
			CategoriaSonhoBO categoriaSonhoBO = new CategoriaSonhoBO();
			SonhoBEANS sonho = new SonhoBEANS();
			CategoriaSonhoBEANS categoria = new CategoriaSonhoBEANS();
			String tituloSonho = request.getParameter("dreamtitle");
			String descricaoSonho = request.getParameter("dreamdetail");
			int cdCategoria = Integer.parseInt(request.getParameter("dreamcategory"));
			
			HttpSession session = request.getSession();
			UsuarioBEANS usuario = (UsuarioBEANS) session.getAttribute("userData");
			
			sonho.setTituloSonho(tituloSonho);
			sonho.setDescricaoSonho(descricaoSonho);
			sonho.setCdCategoria(cdCategoria);
			sonho.setSonhoRealizado(false);
			sonho.setCdUsuario(usuario.getCdUsuario());
			
			int cdSonho = sonhoBO.adicionarSonho(sonho);
			
			sonho = sonhoBO.obterSonho(cdSonho);
			sonhoBO.fecharConexao();
			
			categoria = categoriaSonhoBO.obterCategoria(cdCategoria);
			categoriaSonhoBO.fecharConexao();
			request.setAttribute("tituloSonho", sonho.getTituloSonho());
			request.setAttribute("descricaoSonho", sonho.getDescricaoSonho());
			request.setAttribute("categoria", categoria.getNomeCategoria());
			request.setAttribute("codigoSonho", sonho.getCdSonho());
			request.setAttribute("dataCriacao", sonho.getDtCriacao());
			if (sonho.isSonhoRealizado()) {
				request.setAttribute("sonhoRealizado", "Sonho Realizado");
			}
			else {
				request.setAttribute("sonhoRealizado", "Sonho a Realizar");
			}
			request.getRequestDispatcher("sonho.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request,
					response);
		} 
    }

}
