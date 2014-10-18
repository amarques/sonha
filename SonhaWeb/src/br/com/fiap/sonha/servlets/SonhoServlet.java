package br.com.fiap.sonha.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class SonhaServlet
 */
@WebServlet("/SonhaServlet")
public class SonhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SonhoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

/*	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			SonhoBO sonhoBO = new SonhoBO();
			SonhoBEANS sonho = new SonhoBEANS();
			UsuarioBEANS usuario = new UsuarioBEANS();
			
			String tituloSonho = request.getParameter("txtTituloSonho");
			String descricaoSonho = request.getParameter("txtDescricaoSonho");
			int cdCategoria = Integer.parseInt(request.getParameter("txtDescricaoSonho"));
			
			HttpSession session = request.getSession();

			if (session.getAttribute("usuario") == null) {
				session.setAttribute("usuario", usuario);
			}
			usuario = (UsuarioBEANS) session.getAttribute("usuario");
			
			sonho.setTituloSonho(tituloSonho);
			sonho.setDescricaoSonho(descricaoSonho);
			sonho.setCdCategoria(cdCategoria);
			sonho.setCdUsuario(usuario.getCdUsuario());
			sonho.setCdSonho(0);
			sonho.setSonhoRealizado(false);
			
			sonhoBO.adicionarSonho(sonho);
			
			request.getRequestDispatcher("sonho.jsp").forward(request,
					response);
		} catch (SQLException | RuntimeException e) {
			e.printStackTrace();
		}

	}*/

}
