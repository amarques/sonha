<%@page import="br.com.fiap.sonha.beans.UsuarioBEANS"%>
<%@page import="br.com.fiap.sonha.bo.UsuarioBO"%>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en" itemscope itemtype="http://schema.org/Product"> <!--<![endif]-->
<head>

  <!-- Meta tags & title /-->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sonha - Participe hoje do Sonha</title>
  <meta name="description" content="." />
  <meta name="keywords" content="" />
  <meta name="author" content="humans.txt">

  <!-- Favicon /-->
  <link rel="shortcut icon" href="favicon.png" type="image/x-icon" /> <!-- Favicon /-->

  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

  <!-- Stylesheets /-->
  <link rel="stylesheet" href="css/sonha.css">   <!-- Sonha Framework /-->
  <link rel="stylesheet" href="css/style.css">   <!-- Main stylesheet /-->
  <link rel="stylesheet" href="css/component.css"> <!-- Flexslider - Thumbs Icon /-->
  <link rel="stylesheet" href="css/cadastro.css">
  
  
  <script src="js/modernizr-2.6.2.min.js"></script>  <!-- Modernizr /-->
  <script src="js/validation.js"></script>  <!-- Modernizr /-->
  
  
</head>

<body>
	<div id="fb-root"></div>

<!-- NAVIGATION ############################################### -->


		<!-- Mobile Menu --> 

		<div class="mobile-menu">
			<section id="collapse">
				<div class="row">
					<div class="mobile-menu-inner">
						<ul class="nav-mobile">

						
						<%
						UsuarioBEANS oUsuario = (UsuarioBEANS)session.getAttribute("userData");
						if (oUsuario == null) {
							%>
						<li><a href="novousuario.jsp">Inscreva-se</a></li>
							<%
						} else {
							%>
						<% String sobrenome = "";
						if (oUsuario.getSobrenome() != null && !oUsuario.getSobrenome().equals("")) {
							sobrenome = " " + oUsuario.getSobrenome();
						} %>
						<li><a href="editarperfil.jsp"><%=oUsuario.getNome() + sobrenome %></a></li>
							<%
						}
						%>

						 <li><a href="#">Manifesto</a></li>
						 
						 <li><a href="#">Sobre</a></li>
						 
						</ul>
					</div>
				</div>
			</section>
			<a href="#" id="collapse-menu"><img src="img/menu.png" alt="MENU ICON"></a>
		</div>


		<!--  Menu --> 


		<div class="cbp-af-header">
		
			<nav class="row">
				 <div id="logo"><a href="index.jsp"><img alt="SONHA" src="img/logotop.png"></a></div>
				
				 <ul id="nav">

						
						<%
						if (oUsuario == null) {
							%>
						<li><a href="novousuario.jsp">Inscreva-se</a></li>
							<%
						} else {
							%>
						<% String sobrenome = "";
						if (oUsuario.getSobrenome() != null && !oUsuario.getSobrenome().equals("")) {
							sobrenome = oUsuario.getSobrenome();
						} %>	
						<li><a href="editarperfil.jsp"><%=oUsuario.getNome() + " " + sobrenome %></a></li>
							<%
						}
						%>

					 <li><a href="#">Manifesto</a></li>
					 
					 <li><a href="#cbp-so-scroller">Sobre</a></li>
				 </ul>
			 
			</nav>
		
		</div> 


<!-- END NAVIGATION ############################################### -->


<!-- HEADER ############################################### -->
<!-- BEGIN CONTAINER ############################################### -->
<div id="container" class="container">


<section id="header">

	<div class="row text-right social-stuff">

	</div>
	
	
    <div class="row">
    
      <div class="twelve columns centered">
      
      	<div class="cadBox">
        		<div class="logo">
                	<img src="img/home/logo.png" />
                </div>
        		<h2>Participe hoje do Sonha.</h2>
        		<form name="Login" id="Login" action="AdicionarUsuarioServlet" method="post" onSubmit="return valida(this);">
                    <div class="clear">
						<input type="text" placeholder="e-mail" name="email" tabindex="1" />
						<span id="email" class="erro">Campo obrigatório. Preencha o e-mail corretamente</span>
					</div>
                    <div class="clear">
						<div>
							<input type="text" placeholder="name" name="name" tabindex="2" />
							<span id="nome" class="erro">Campo obrigatório. Preencha o nome corretamente.</span>
						</div>
					</div>
					<div class="clear">
						<div>
							<input type="password" placeholder="senha" name="password" tabindex="3"/>
							<span id="senha" class="erro">Campo obrigatório. *Minimo de 4 caracteres</span>
						</div>
						<div>
							<input type="password" placeholder="confirmar senha" name="conf_senha" tabindex="4" />
							<span id="conf_senha" class="erro">Campo obrigatório</span>
							<span id="valida_senha" class="erro">A senha e a confirmação precisam ser iguais.</span>
						</div>
					</div>
					<input type="submit" class="cadBtn button2 fade3" value="confirmar" tabindex="5"/>
				</form>
			</div>
        
      </div>     
                
    </div>


</section>
<!-- FOOTER SECTION ############################################### -->


<section id="footer">

	<div class="row">

		<!-- Text from left -->
		
		<div class="seven columns pull_left">
		
			<p>© 2014<br>Made with <img src="img/withlove.png" alt="With Love"> in FIAP</p>

		</div>

		<!-- Footer Navigation -->

		<div class="five columns text-right social">
			
		
				 <ul id="navfirst">
				 
					 <li><a href="#">Manifesto</a></li>
					 
					 <li><a href="#">Privacidade</a></li>
					 
					 <li><a href="#">Suporte</a></li>
					 
				 </ul>
          	
		</div>

	</div>

</section>


<!-- END FOOTER SECTION ############################################### -->


</div> <!-- end of container -->


  <!-- Grab Google CDN's jQuery, fall back to local if offline -->
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="js/jquery-1.9.1.min.js"><\/script>')</script>
  <script src="js/main.js" type="text/javascript"></script> <!-- Main Javascript File -->
  <script src="js/plugins.js" type="text/javascript"></script> <!--Plugins File -->
  <script src="js/cbpScroller.js" type="text/javascript"></script> <!-- Scroll from left & right -->
  <script src="js/classie.js" type="text/javascript"></script> <!-- Scroll from left & right -->
  <script src="js/jquery.scrollto.js" type="text/javascript"></script> <!-- ScrollTo for Button -->
  <script src="js/jquery.parallax-1.1.3.js" type="text/javascript"></script> <!-- Parallax -->
  <script src="js/jquery.flexslider.js" type="text/javascript"></script> <!-- FlexSlider -->

  
  <!-- Change UA-XXXXX-X to be your site's ID -->
  <!--<script>
    window._gaq = [['_setAccount','UAXXXXXXXX1'],['_trackPageview'],['_trackPageLoadTime']];
    Modernizr.load({
      load: ('https:' == location.protocol ? '//ssl' : '//www') + '.google-analytics.com/ga.js'
    });
  </script>  -->

  </body>
  
</html>
