<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="UTF-8">
        <title>Page de connexion</title>
        <link rel="stylesheet" href="css/login.css">
        <!--Jquery-->
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <!--Bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        
        <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
        
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
       
    </head>
    <body id="body">
        <div class="container bg-white pb-5">
            <div class="row d-flex justify-content-start align-items-center mt-sm-5">
                <div class="col-lg-5 col-10">
                    <div id="circle"></div>
                    <div class="pb-5"> <img src="images/login.jpg" alt="" style="border-radius: 10% ;width: 600px;"> </div>
                </div>
                <div class="col-lg-4 offset-lg-2 col-md-6 offset-md-3">
                    <div class="pt-4">
                        <h6><span class="fa fa-superpowers text-primary px-md-2" style="font-size: 38px;font-family:'Lucida Sans';margin-left: 60px;">BIENVENUE</span></h6>
                    </div>
                    <div class="mt-3 mt-md-5">
                        <h5>Connectez-vous à votre compte</h5>
                        <form class="pt-4" method="POST" action="Login">
                        	<style>
                        		label{
                        			font-weight: bold;
                        		}
                        	
                        	</style>
                            <div class="d-flex flex-column pb-3"> <label for="email">Adresse Email</label> <input type="email" name="email" id="emailId" class="border-bottom border-primary" placeholder="Saisir votre email ici" required="required"> </div>
                            <div class="d-flex flex-column pb-3"> <label for="password">Mot de passe</label> <input type="password" name="password" id="pwd" class="border-bottom border-primary" onpaste="return false;" placeholder="Saisir votre mot de passe ici" required="required"> </div>
                            <div class="d-flex jusity-content-end pb-4">
                                <div class="ml-auto"> <a href="#" class="text-danger text-decoration-none">Mot de passe oublié?</a> </div>
                            </div> 
                            <input type="submit" value="Se connecter" class="btn btn-primary btn-block mb-3"> 
                           
                            <div class="text-danger text-center">
                                <p> ${message}</p>
                            </div>
                            <!-- <button class="btn btn-block bg-white border border-primary rounded "><span class="fa fa-facebook-official text-primary px-2"></span>Log In with Facebook</button>-->
                            <div class="register mt-5">
                                <p>Vous n'avez pas de compte? <a href="Register">Créer un compte</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js' integrity=""></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js' integrity=""></script>

        
        
    </body>
</html>


    