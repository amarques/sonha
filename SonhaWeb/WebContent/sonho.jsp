<%@page import="br.com.fiap.sonha.beans.UsuarioBEANS"%>
<%@page import="br.com.fiap.sonha.beans.SonhoBEANS"%>
<%@page import="br.com.fiap.sonha.bo.UsuarioBO"%>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="pt-br"> <!--<![endif]-->
<head>

  <!-- Meta tags & title /-->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sonha - Sonho</title>
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
  <link rel="stylesheet" href="css/sonho.css">
  <link rel="stylesheet" href="css/responsivo.css">
  
  
  <script src="js/modernizr-2.6.2.min.js"></script>  <!-- Modernizr /-->
  <script src="js/validation.js"></script>  
  <script src="js/jquery-1.9.1.min.js"></script>  
  <script>
	  $(document).ready(function(){
			$('.like').click(function(){
				$(this).children('.likeIcon').toggleClass('actived');
				return false;
			});
		});
  </script>  
  
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
							sobrenome = oUsuario.getSobrenome();
						} %>	
						<li><a href="editarperfil.jsp"><%=oUsuario.getNome() + sobrenome %></a></li>
							<%
						}
						%>

						 <li><a href="sobre.html">Manifesto</a></li>
						 
						 <li><a href="sobre.html">Sobre</a></li>
						 
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
							sobrenome = " " + oUsuario.getSobrenome();
						} %>	
						<li><a href="editarperfil.jsp"><%=oUsuario.getNome() + sobrenome %></a></li>
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

		<!--  Facebook Share Button--> 
	<div class="fb-like" data-href="https://www.facebook.com/sonhaoficial" data-layout="button_count" data-action="like" data-show-faces="false" data-share="false"></div>
	
		<!-- PUT HERE YOUR GENERATE CODE OF FACEBOOK BUTTON : developers.facebook.com/docs/reference/plugins/like/ -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=263256367218315&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

		<!-- Twitter Share Button --> 
		
<a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>

	</div>
	
	
    <div class="row">
    
      <div class="twelve columns centered">
      
      	<div class="cadSonho">
				<form action="">
					<div class="cadBox cadBoxL fLeft infoSonho">
						<h4><%= request.getAttribute("tituloSonho") %></h4>
						<p><%= request.getAttribute("descricaoSonho") %></p>
						<p>Data de Cria��o: <%= request.getAttribute("dataCriacao") %></p>
						<p><%= request.getAttribute("sonhoRealizado") %></p>
						<h5>Categoria</h5>
						<p class="tags"><%= request.getAttribute("categoria") %></p>
					</div>
					<div class="cadBox cadBoxR fRight">
						<img src="img/no-image.jpg"/>
						<div class="like">
							<span class="likeIcon"></span>
							<p><span>82</span> pessoas curtiram</p>
						</div>
					</div>
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
		
			<p>� 2014<br>Made with <img src="img/withlove.png" alt="With Love"> in FIAP</p>

		</div>

		<!-- Footer Navigation -->

		<div class="five columns text-right social">
			
		
				 <ul id="navfirst">
				 
					 <li><a href="sobre.html">Manifesto</a></li>
					 
					 <li><a href="sobre.html">Privacidade</a></li>
					 
					 <li><a href="sobre.html">Suporte</a></li>
					 
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
