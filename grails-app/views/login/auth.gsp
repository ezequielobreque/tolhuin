<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<g:set var="entityName" value="${message(code: 'ambito.label', default: 'Ambito')}" />
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<style>
	.container{
		height: 100%;
		align-content: center;
	}

	.card{
		height: 370px;
		margin-top: auto;
		margin-bottom: auto;
		width: 400px;
		background-color: rgba(0,0,0,0.5) !important;
	}

	.social_icon span{
		font-size: 60px;
		margin-left: 10px;
		color: #FFC312;
	}

	.social_icon span:hover{
		color: white;
		cursor: pointer;
	}

	.card-header h3{
		color: white;
	}

	.social_icon{
		position: absolute;
		right: 20px;
		top: -45px;
	}

	.input-group-prepend span{
		width: 50px;
		background-color: #FFC312;
		color: black;
		border:0 !important;
	}

	input:focus{
		outline: 0 0 0 0  !important;
		box-shadow: 0 0 0 0 !important;

	}

	.remember{
		color: white;
	}

	.remember input
	{
		width: 20px;
		height: 20px;
		margin-left: 15px;
		margin-right: 5px;
	}

	.login_btn{
		color: black;
		background-color: #FFC312;
		width: 100px;
	}

	.login_btn:hover{
		color: black;
		background-color: white;
	}

	.links{
		color: white;
	}

	.links a{
		margin-left: 4px;
	}
	</style>

</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Iniciar sesión</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
			</div>
			<div class="card-body">
				<g:if test="${params.login_error=="1"}">
					<a style="color: red">Error al autentificar intenta denuevo</a>
				</g:if>
				<form action="/login/authenticate" method="POST" id="loginForm" autocomplete="off">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" name="username" id="username" placeholder="username">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>

						<input type="password" class="form-control" name="password" id="password" placeholder="password">
					</div>
					<div class="row align-items-center remember"  id="remember_me_holder">
						<input  type="checkbox" name="remember-me" id="remember_me">recuerdame

					</div>


					<div class="form-group">
						<input type="submit"  id="submit"  value="Identifícate" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					<a> En caso de perder la contraseña contacte al administradorr</a>
				</div>
%{--				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>--}%
			</div>
		</div>
	</div>
</div>
%{--<div id="login">
	<div class="inner">
		<div class="fheader">Por favor identifícate</div>



		<form action="/login/authenticate" method="POST" id="loginForm" class="cssform" autocomplete="off">
			<p>
				<label for="username">Nombre de usuario:</label>
				<input type="text" class="text_" name="username" id="username">
			</p>

			<p>
				<label for="password">Contraseña:</label>
				<input type="password" class="text_" name="password" id="password">
			</p>

			<p id="remember_me_holder">
				<input type="checkbox" class="chk" name="remember-me" id="remember_me">
				<label for="remember_me">Recuérdame</label>
			</p>

			<p>
				<input type="submit" id="submit" value="Identifícate">
			</p>
		</form>
	</div>
</div>--}%

</body>
</html>
