<%@ page import="tolhuin.Rubro" %>
<!doctype html>
<html lang="es" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>


    <asset:stylesheet src="application.css"/>


	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>SB Admin 2 - Dashboard</title>

	<!-- Custom fonts for this template-->
%{--    <asset:stylesheet src="all.min.css"/>--}%
%{--	<asset:stylesheet src="all2.css"/>--}%
    <script src="https://kit.fontawesome.com/172f22dc35.js"></script>

	<asset:stylesheet src="all.min.css"/>

	<!-- Custom styles for this template-->
    <asset:stylesheet src="sb-admin-2.min.css"/>
	<asset:stylesheet src="my.css"/>
    <g:layoutHead/>
</head>
<body id="page-top">

%{--     <nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
      			</button>
      			<a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <asset:image src="120px-COA_Tolhuin.svg.png"/>
                    </i>tolhuin
                </a>
    		</div>
	    	<div class="collapse navbar-collapse" id="myNavbar">
	      		<ul class="nav navbar-nav">
	        		<li><a href="/emprendimiento/index">Emprendimientos</a></li>
	        		<li><a href="/usuario/index">Usuarios</a></li>
	        		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Tabuladores <span class="caret"></span></a>
	        			<ul class="dropdown-menu">
				          <li><a href="/ambito/index">Ambito</a></li>
				          <li><a href="/detalle/index">Detalle</a></li>
				          <li><a href="/sector/index">Sector</a></li>
				        </ul>
			      	</li>
	        		<li><a href="/grafico/index">Gráficos</a></li>
	      		</ul>
	      		<ul class="nav navbar-nav navbar-right">
	        		<li><a href="/login/index"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      		</ul>
	    	</div>
	  	</div>
   </nav>--}%



<!-- Page Wrapper -->
<div id="wrapper">

	<!-- Sidebar -->
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" style="margin-top:4.375rem">

		<!-- Sidebar - Brand -->
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
			<div class="sidebar-brand-icon">
				<i class="fa grails-icon"><asset:image src="120px-COA_Tolhuin.svg.png"/></i>
			</div>
			<div class="sidebar-brand-text mx-3">Municipalidad de Tolhuin</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item active">
			<a class="nav-link" href="/map/mapa">
				<i class="fas fa-map"></i>
				<span>Mapa de Emprendimientos</span></a>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">
			Interface
		</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
				<i class="fas fa-industry"></i>
				<span> Emprendimientos </span>
			</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Opciones:</h6>

					<a class="collapse-item" href="/emprendimiento/index">Lista de Emprendimientos</a>

						<a class="collapse-item" href="/main/Emprendimientos">Emprendimientos Populares</a>
					<sec:ifNotGranted roles='ROLE_ANONYMOUS'>
					<a class="collapse-item" href="/emprendimiento/create">Nuevo Emprendimiento</a>
						<a class="collapse-item" href="/usuario/misEmprendimientos">Mis Emprendimientos</a>
					</sec:ifNotGranted>
					<sec:ifAnyGranted roles='ROLE_MINISTERIO,ROLE_ADMIN,ROLE_ADMINISTRADOR'>
						<a class="collapse-item" href="/excelImporter/index">Importar excel</a>
						<a class="collapse-item" href="/emprendimiento/FiltrosEspeciales">Filtros Especiales</a>
					</sec:ifAnyGranted>
				</div>
			</div>
		</li>

		<!-- Nav Item - Utilities Collapse Menu -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
				<i class="fas fa-user"></i>
				<span>Usuarios</span>
			</a>
			<div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Custom Utilities:</h6>
					<sec:ifNotLoggedIn>
					<a class="collapse-item" href="/usuario/create">Registrarse</a>
						<g:link class="collapse-item" controller="login">Iniciar Sesion </g:link>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/utilities-animation.html">Recuperar contraseña</a>
					</sec:ifNotLoggedIn>
						<sec:ifLoggedIn>
%{--					<a class="collapse-item" href="/login/logout"></a>--}%
							<g:link class="collapse-item" controller="logout">Cerrar Sesion </g:link>
						</sec:ifLoggedIn>

				</div>
			</div>
		</li>

		<!-- Nav Item - Tables -->
		<li class="nav-item">
			<a class="nav-link" href="/grafico/index">
				<i class="fas fa-fw fa-chart-area"></i>
				<span>Graficos</span></a>
		</li>
	<li class="nav-item">
		<a class="nav-link" href="/usuario/ayuda">
			<i class="fas fa-question-circle"></i>
			<span>Ayuda</span></a>
	</li>

	`<sec:ifAnyGranted roles='ROLE_MINISTERIO,ROLE_ADMIN,ROLE_ADMINISTRADOR'>

		<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
			<i class="fas fa-plus"></i>
			<span> Extras </span>
		</a>
		<div id="collapseFour" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Opciones:</h6>
					<a class="collapse-item" href="/rubro/index">Rubros</a>
				<a class="collapse-item" href="/ambito/index">Ambitos</a>
					<a class="collapse-item" href="/sector/index">Sectores</a>
					<a class="collapse-item" href="/usuario/index">Usuarios</a>


			</div>
		</div>
	</li>
				</sec:ifAnyGranted>
		<!-- Divider -->
		<hr class="sidebar-divider">

		%{--<!-- Heading -->
		<div class="sidebar-heading">
			Addons
		</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
				<i class="fas fa-fw fa-folder"></i>
				<span>Pages</span>
			</a>
			<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Login Screens:</h6>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/login.html">Login</a>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/register.html">Register</a>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/forgot-password.html">Forgot Password</a>
					<div class="collapse-divider"></div>
					<h6 class="collapse-header">Other Pages:</h6>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/404.html">404 Page</a>
					<a class="collapse-item" href="/startbootstrap-sb-admin-2-gh-pages/blank.html">Blank Page</a>
				</div>
			</div>
		</li>

		<!-- Nav Item - Charts -->
		<li class="nav-item">
			<a class="nav-link" href="/startbootstrap-sb-admin-2-gh-pages/charts.html">
				<i class="fas fa-fw fa-chart-area"></i>
				<span>Charts</span></a>
		</li>



		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">--}%

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">


	   %{--<div class="content2">--}%
			%{--<div class="content3">--}%
			<!-- Topbar -->
			<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 fixed-top shadow">

				<!-- Sidebar Toggle (Topbar) -->
				<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
					<i class="fa fa-bars"></i>
				</button>

				<!-- Topbar Search -->

				<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" method="get" action="/emprendimiento/busqueda">
					<div class="input-group">
						<input type="text" class="form-control bg-light border-0 small" name="buscar" id="buscar" placeholder="Buscar Emprendimientos.." aria-label="Search" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit" name="actions" value="filtro">
								<i class="fas fa-search fa-sm"></i>
							</button>
                            <button class="btn btn-primary" type="submit" name="actions" value="mapa">
                                <i class="fas fa-map-marked-alt"></i>
                            </button>
						</div>

					</div>
	<select class="form-control form-control-sm" style="width: 80px" name="rubro">
		<option disabled selected value>Rubro..</option>
		<g:each in="${tolhuin.Rubro.list()}">
			<option value="${it.nombre}">${it.nombre}</option>
		</g:each>

	</select>
	<select class="form-control form-control-sm" name="ambito">
		<option disabled selected value>Ambito..</option>
		<option value="PRIVADO">Privado</option>
		<option value="ESTATAL">Estatal</option>

	</select>
	<select class="form-control form-control-sm" name="sector">
		<option disabled selected value>Sector..</option>
		<option value="PRIMARIO">Primario</option>
		<option value="SECUNDARIO">Secundario</option>
		<option value="TERCIARIO">Terciario</option>
	</select>
				</form>

				<!-- Topbar Navbar -->
				<ul class="navbar-nav ml-auto">

					<!-- Nav Item - Search Dropdown (Visible Only XS) -->
					<li class="nav-item dropdown no-arrow d-sm-none">
						<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-search fa-fw"></i>
						</a>
						<!-- Dropdown - Messages -->
						<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
							<!--<form class="form-inline mr-auto w-100 navbar-search">
								<div class="input-group">
									<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
									<div class="input-group-append">
										<button class="btn btn-primary" type="button">
											<i class="fas fa-search fa-sm"></i>
										</button>
									</div>
								</div>
							</form>-->
		<form method="get" action="/emprendimiento/busqueda">
			<div class="input-group">
				<input type="text" class="form-control bg-light border-0 small" name="buscar" id="buscar" placeholder="Buscar Emprendimientos.." aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit" name="actions" value="filtro">
						<i class="fas fa-search fa-sm"></i>
					</button>
					<button class="btn btn-primary" type="submit" name="actions" value="mapa">
						<i class="fas fa-map-marked-alt"></i>
					</button>
				</div>

			</div>
			<select class="form-control form-control-sm" name="rubro">
				<option disabled selected value>Rubro..</option>
				<g:each in="${tolhuin.Rubro.list()}">
					<option value="${it.nombre}">${it.nombre}</option>
				</g:each>

			</select>
			<select class="form-control form-control-sm" name="ambito">
				<option disabled selected value>Ambito..</option>
				<option value="PRIVADO">Privado</option>
				<option value="ESTATAL">Estatal</option>

			</select>
			<select class="form-control form-control-sm" name="sector">
				<option disabled selected value>Sector..</option>
				<option value="PRIMARIO">Primario</option>
				<option value="SECUNDARIO">Secundario</option>
				<option value="TERCIARIO">Terciario</option>
			</select>
		</form>
						</div>
					</li>




					<sec:ifAnyGranted roles="ROLE_ANONYMOUS">

								<a href="/usuario/create" class="mr-2 d-none d-lg-inline text-gray-600 small">Registrarse</a>


                                <a href="/login/auth" class="mr-2 d-none d-lg-inline text-gray-600 small">Iniciar sesion</a>


					</sec:ifAnyGranted>
	<sec:ifLoggedIn>

					<!-- Nav Item - User Information -->
					<li class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="mr-2 d-none d-lg-inline text-gray-600 small">${sec.username()}</span>
							<img class="img-profile rounded-circle" src="https://www.shareicon.net/data/64x64/2015/09/24/106687_user_512x512.png">
						</a>
						<!-- Dropdown - User Information -->
						<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
							<a class="dropdown-item" href="/usuario/misEmprendimientos">
								<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
								Mis emprendimientos
							</a>
							<div class="dropdown-divider"></div>

						<g:link class="dropdown-item" controller="logout">
							<i class="fas fa-sign-out-alt">cerrar sesion</i>
						</g:link>




						</div>
					</li>

				</ul>
	</sec:ifLoggedIn>

			</nav>
			<!-- End of Topbar -->
	<div class="content2" style="margin-top:4.375rem" >
			<g:layoutBody/>
       %{--</div>--}%
			%{--</div>--}%
			<!-- Main Content -->


	</div>
<!-- End of Main Content -->

<!-- Footer -->
<footer class="sticky-footer bg-white">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright &copy; Your Website 2019</span>
		</div>
	</div>
</footer>
<!-- End of Footer -->

</div>
<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
	<i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="/startbootstrap-sb-admin-2-gh-pages/login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->
<asset:javascript src="jquery.min.js"/>
<asset:javascript src="bootstrap.bundle.min.js"/>



<!-- Core plugin JavaScript-->
<asset:javascript src="jquery.easing.min.js"/>
<asset:javascript src="sb-admin-2.min.js"/>

<!-- Page level plugins -->
<asset:javascript src="Chart.min.js"/>


<!-- Page level custom scripts -->
<asset:javascript src="chart-area-demo.js"/>
<asset:javascript src="chart-pie-demo.js"/>

%{--<asset:javascript src="application.js"/>--}%

</body>
</html>
