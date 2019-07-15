<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <title>login de usuario</title>
    </head>
    <body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"></h3>
                </div>
                <div class="panel-body">
                    <g:form name="login" action="logear">
                        <fieldset>
                            <g:if test="${flash.errorUsuario}">
                            <div class="form-group has-error">
                                <input class="form-control" placeholder="usuario" name="usuario" type="text" autofocus>
                            </div>
                        </g:if>
                        <g:else>
                            <div class="form-group has-success">
                                <input class="form-control" placeholder="usuario" name="usuario" type="text" autofocus>
                            </div>
                        </g:else>
                            <div class="form-group has-success">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" class="btn btn-success btn-block">Login</button>
                            <p></p>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>

    </body>
</html>
