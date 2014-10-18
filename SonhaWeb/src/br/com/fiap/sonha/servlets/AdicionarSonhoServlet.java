package br.com.fiap.sonha.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.beans.UsuarioBEANS;
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
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
			SonhoBO sonhoBO = new SonhoBO();
			
			SonhoBEANS sonho = new SonhoBEANS();
			
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
			
			sonho.setCdSonho(cdSonho);
			
			request.setAttribute("tituloSonho", sonho.getTituloSonho());
			request.setAttribute("descricaoSonho", sonho.getDescricaoSonho());
			
			request.getRequestDispatcher("sonho.jsp").forward(request,
					response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

}
