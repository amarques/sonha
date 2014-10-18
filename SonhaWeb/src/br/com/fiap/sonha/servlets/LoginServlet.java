package br.com.fiap.sonha.servlets;

import java.io.IOException;
import java.util.List;

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
import br.com.fiap.sonha.bo.UsuarioBO;

/**
 * Servlet implementation class LoginServlet OK
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UsuarioBO usuarioBO = new UsuarioBO();
			
			UsuarioBEANS usuario = new UsuarioBEANS();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			int cdUsuario = usuarioBO.efetuarLogin(email, password);
			
			if (cdUsuario == 0) {
				usuarioBO.fecharConexao();
				request.setAttribute("loginInvalido", "Login ou Senha Incorretos");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}
			else {
				usuario = usuarioBO.selecionarUsuario(cdUsuario);
				usuario.setCdUsuario(cdUsuario);
				HttpSession session = request.getSession();
				if (session.getAttribute("userData") == null) {
					session.setAttribute("userData", usuario);
				}
				
				request.getRequestDispatcher("feedsonhos.jsp").forward(request,
						response);
				usuarioBO.fecharConexao();
				
				CategoriaSonhoBO categoriaSonhoBO = new CategoriaSonhoBO();
				SonhoBO sonhoBO = new SonhoBO();
				
				List<CategoriaSonhoBEANS> listaCategorias = categoriaSonhoBO.listarCategorias();
				categoriaSonhoBO.fecharConexao();
				
				List<SonhoBEANS> listaSonhos = sonhoBO.listarSonhos();
				sonhoBO.fecharConexao();
				
				request.setAttribute("listaCategorias", listaCategorias);
				request.setAttribute("listaSonhos", listaSonhos);
				
				request.getRequestDispatcher("feedsonhos.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
