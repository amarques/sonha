<%@page import="br.com.fiap.sonha.beans.UsuarioBEANS"%>
<%@page import="br.com.fiap.sonha.bo.UsuarioBO"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="pt-br"> <!--<![endif]-->
<head>

  <!-- Meta tags & title /-->
  <!-- Eclipse git test - last configuration /-->
  
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sonha - Onde seus sonhos podem colaborativamente se tornar realidade</title>
  <meta name="description" content="." />
  <meta name="keywords" content="" />
  <meta name="author" content="humans.txt">

  <!-- Favicon /-->
  <link rel="shortcut icon" href="favicon.png" type="image/x-icon" /> <!-- Favicon /-->

  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

  <!-- Stylesheets /-->
  <link rel="stylesheet" href="css/sonha.css">   <!-- Sonha Framework /-->
  <link rel="stylesheet" href="css/stylehome.css">   <!-- Main stylesheet used by Home /-->
  <link rel="stylesheet" href="css/component.css"> <!-- Flexslider - Thumbs Icon /-->
  
  
  <script src="js/modernizr-2.6.2.min.js"></script>  <!-- Modernizr /-->
  
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
						<li><a href="novousuario.jsp">Inscreva</a></li>
							<%
						} else {
							%>
						<li><a href="editarperfil.jsp"><%=oUsuario.getNome() %></a></li>
							<%
						}
						%>
					 
					 <li><a href="sobre.html">Manifesto</a></li>
					 
					 <li><a href="sobre.html">Sobre</a></li>
				 </ul>
			 
			</nav>
		
		</div> 


<!-- END NAVIGATION ############################################### -->


<!-- HEADER ############################################### -->


<section id="header">

	<div class="row text-right social-stuff">
		<!-- Elementos sociais -->
	</div>
	
	
    <div class="row">
    
      <div class="twelve columns centered">
      
      	<!-- Logo --> 
      
      	<div class="fade1 logo"><a href="index.jsp"><img src="img/logo.png" alt="Logo"></a></div>
      	
      	<!-- Title --> 
        <h2 class="fade2">Onde seus sonhos podem colaborativamente
	        			<br>se tornar realidade.</h2>  
        
        <!-- Button--> 
        				<%
						if (oUsuario == null) {
							%>
						<a class="button1 fade3" href="login.jsp">Entrar</a>
							<%
						} else {
							%>
						<a class="button1 fade3" href="feedsonhos.jsp">Entrar</a>
							<%
						}
						%>
        
        
        <a class="button2 fade3" style="margin-left:10px;" href="novousuario.jsp">Inscreva-se no Sonha</a>
        
      </div>     
                
    </div>


</section>


<!-- END HEADER ############################################### -->

<!-- BEGIN CONTAINER ############################################### -->
<div id="container" class="container">

<div id="cbp-so-scroller" class="cbp-so-scroller"> <!-- HERE IS THE DIV FOR SCROLLING EFFECT -->


<!-- SECTION THUMBS ############################################### -->


<section class="cbp-so-section thumbs">

	<div class="row">

		<div class="twelve columns centered">
		
			<h3>Em apenas 3 passos</h3>
			
			<p class="lead">Nós armazenamos com carinho os seus <b>sonhos</b>, você divulga e a comunidade, guardiões e parceiros <b>colaboram</b> para que você <b>realize</b> os seus sonhos.</p>
		

			<div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9b">
			         
                <ul class="three_up tiles centered hi-icon-effect-9 hi-icon-effect-9b">
                    
                    <li>
                    <a href="#set-9" class="hi-icon hi-icon-images">Images</a>
                    <div class="clear"></div>
                    <h4>Crie seu sonho</h4>
                    <p>Cadastre o seu sonho na comunidade</p>
                    </li>
                    
                    <li>
                    <a href="#set-9" class="hi-icon hi-icon-pencil">Edit</a>
                    <div class="clear"></div>
                    <h4>Refinar e atualizar</h4>
                    <p>Mantenha os seus progressos sempre atualizados interagindo com as pessoas</p>
                    </li>
                    
                    <li>
                    <a href="#set-9" class="hi-icon hi-icon-mail">Mail</a>
                    <div class="clear"></div>
                    <h4>COMPARTILHE</h4>
                    <p>Quanto mais pessoas alcançadas, mais chances você tem de realizar os sonhos</p>
                    </li>
                
                </ul>
            
  			</div>          

		</div>

	</div>		
		
</section>

<!-- END SECTION THUMBS ############################################### -->


<!-- FIRST SECTION ############################################### -->


<section class="cbp-so-section work1">

	<div class="row">
		
		<div class="six columns cbp-so-side cbp-so-side-left">
		
			<!-- Title --> 
		
			<h3>Estamos construindo uma aplicação mobile</h3>
						
			<!-- Content --> 
			
			<p>Estamos preparando uma surpresa para você, em breve o <strong>Sonha</strong> terá uma aplicação totalmente alinhada a realização de sonhos, compra de produtos relacionados, dicas de viagens e muito mais! Fique por dentro das novidades.</p>
			
			
			<div class="download-button" style="padding-top:30px;">
			
				<img src="img/appstore.png" alt="EXEMPLE">
			
				<img src="img/gplay.png" alt="EXEMPLE">
			
			</div>
		
		</div>
	
		<!-- Image from right --> 
	
		<div class="six columns cbp-so-side-img cbp-so-side-right" style="margin-bottom:-60px;" >
		
			<img src="img/mobapp.jpg" alt="EXEMPLE">
		
		</div>

	</div>

</section>

<!-- END FIRST SECTION ############################################### -->

</div> <!-- end of div scrolling effect -->



<!-- TESTIMONIALES SECTION ############################################### -->


<section id="testimonial">

	<div class="row">
	
		<div class="twelve columns centered">

					<h3>Nosso time</h3>
					
					<p class="lead">Nós amamos feedbacks! Caso tenha qualquer dúvida ou problema. Fale conosco!</p>
					
					<div class="testblock">
					
						<div class="testimg">
						
							<div class="flexslider" id="slider1">
							
								<ul class="slides">
									
									<li><img src="img/team/r-and.png" alt="Anderson Marques">   <!-- set client 1 photo here !--></li>

									<li><img src="img/team/r-mima.png" alt="Mima Verde">   <!-- set client 1 photo here !--></li>

									<li><img src="img/team/r-rod.png" alt="Rodrigo Rocha">   <!-- set client 1 photo here !--></li>

									<li><img src="img/team/r-van.png" alt="Vanessa Vidal">   <!-- set client 1 photo here !--></li>

									<li><img src="img/team/r-davi.png" alt="Davi Couto">   <!-- set client 1 photo here !--></li>
									
										<!--to add more client, copy the above li element and change the image-->
								</ul>
								
							</div>
						
						</div>
						
						<div class="testtext">

							<div class="flexslider" id="slider2">
							
								<ul class="slides">
								
									<li>
										<h4 class="testtitle">Anderson Marques</h4>  
										<div class="testsub">Líer de Projetos</div> 
										<div class="testtextblock">							
											<p>Sonhador, apaixonado por tecnologia e barrigudo</p>
										</div>
									</li>
									
									<li>
										<h4 class="testtitle">Mima Verde</h4>  	
										<div class="testsub">Front End</div> 
										<div class="testtextblock">					
											<p>Sonhadora e mestre do HTML5+CSS3+Outros paranauês</p>
										</div>
									</li>
									
									<li>
										<h4 class="testtitle">Rodrigo Rocha</h4> 
										<div class="testsub">Back End</div> 
										<div class="testtextblock">					
											<p>Sonhador, mestre Cobol, boné sagrado e conhecedor dos segredos do Java</p>
										</div>
									</li>

									<li>
										<h4 class="testtitle">Vanessa Vidal</h4>
										<div class="testsub">Analisa de Suporte</div>
										<div class="testtextblock">	
											<p>Sonhadora habilidosa nos mistérios do Front End e amante frenética de Rammstein, series e filmes (nesta ordem)</p>
										</div>
									</li>

									<li>
										<h4 class="testtitle">Davi Couto</h4>  	
										<div class="testsub">Consutor EAD</div>
										<div class="testtextblock">
											<p>Sonhador, o Lion do EAD e especialista de negócios</p>
										</div>
									</li>
									
										<!--to add more testimonial, copy line the li element -->
								</ul>
								
							</div>				
						
						</div>
						
					</div>	
					
			</div> <!-- Columns end -->
	
	</div> <!-- Row end -->

</section>

<!-- END TESTIMONIALES SECTION ############################################### -->


<!-- LITTLE TEXT JOIN US SECTION ############################################### -->

<section id="joinus">

	<div class="row">
	
		<div class="eight columns centered">
		
			<h2>Onde seus sonhos podem colaborativamente se tornar realidade!</h2>
			
		</div>
		
	</div>

</section>

<!-- END LITTLE TEXT JOIN US SECTION ############################################### -->

<div id="footerSpacer"></div> <!-- USED FOR THE FIXED EFFECT : DON'T REMOVE -->


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
