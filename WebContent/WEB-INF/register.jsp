<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="UTF-8">
        <title>Creation de compte</title>
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
                    <div class="pb-5"> <img src="images/login.jpg" alt="" style="border-radius: 10% ;width: 500px;"> </div>
                </div>
                <div class="col-lg-4 offset-lg-2 col-md-6 offset-md-3">
                    <div class="pt-4">
                        <h6><span class="fa fa-superpowers text-primary px-md-2" style="font-size: 38px;font-family:'Lucida Sans';margin-left: 60px;">BIENVENUE</span></h6>
                    </div>
                    <div class="mt-3 mt-md-5">
                        <h5>Créer votre compte</h5>
                        <form class="pt-4" method="POST" action="Register">
                        	<style>
                                .nom{
                                    display: flex;
                                    
                                    
                                }
                                .nom label{
                                	font-weight: bold;
                                }
                               

                            </style>
                            <div class="divsexe">
		                        <label for="nom" style="padding-right:30px;font-weight: bold;">Genre</label>
		                        <input class="sexe" type="radio" name="genre" id="genre-m" value="Homme">
		                        <label class="label" for="genre-m" style="padding-right:30px;">Homme</label>
		                        <input class="sexe" type="radio" name="genre" id="genre-f" value="Femme" >
		                        <label class="label" for="genre-f">Femme</label>
                    		</div>
                            <div class="nom">
                                <div class="d-flex flex-column pb-3" > <label for="lastName">Nom</label> <input type="text" name="lastName" id="" class="border-bottom border-primary" placeholder="Saisir votre nom ici" required="required"> </div>
                                 <div class="d-flex flex-column pb-3" style="padding-left: 20px;"> <label for="firstName">Prénom</label> <input type="text" name="fristName" id="" class="border-bottom border-primary" placeholder="Saisir votre prénom ici" required="required"> </div>

                            </div>
                            <div class="nom">
                               	
                                <div class="d-flex flex-column pb-3" > <label for="firstName">Cin</label> <input type="text" name="cin" id="" class="border-bottom border-primary" placeholder="Saisir votre cin ici" required="required"> </div>
                                <div class="d-flex flex-column pb-3" style="padding-left: 20px;"> <label for="phone">Téléphone</label> <input type="text" name="phone" id="" class="border-bottom border-primary" placeholder="Saisir votre télephone ici" required="required"> </div>

                            </div>
                            <div class="nom">
                               	
                                <div class="d-flex flex-column pb-3" > <label for="birthday">Date de naissance</label> <input type="date" name="birthday" id="birthday" class="border-bottom border-primary"  required="required"> </div>
								<div class="d-flex flex-column pb-3" style="padding-left: 50px;"> <label for="email">Adresse Email</label> <input type="email" name="email" id="emailId" class="border-bottom border-primary" placeholder="Saisir votre email ici" required="required"> </div>
                            </div>
                            
                             <div class="nom">
                               	
                                <div class="d-flex flex-column pb-3"> <label for="password">Mot de passe</label> <input type="password" name="password" id="pwd" class="border-bottom border-primary" placeholder="Saisir votre mdp ici" required="required" onpaste="return false;"> </div>
								<div class="d-flex flex-column pb-3"style="padding-left: 20px;"> <label for="password">Confirmation</label> <input type="password" name="password" id="pwd" class="border-bottom border-primary" placeholder="Saisir votre mdp ici" required="required" onpaste="return false;"> </div>
								
                            </div>
                            <!--  <div class="d-flex flex-column pb-3"> <label for="lastName">Nom</label> <input type="text" name="lastName" id="" class="border-bottom border-primary" placeholder="Saisir votre nom ici" required="required"> </div>
                            <div class="d-flex flex-column pb-3"> <label for="firstName">Prénom</label> <input type="text" name="fristName" id="" class="border-bottom border-primary" placeholder="Saisir votre prénom ici" required="required"> </div>
                            
                            <div class="d-flex flex-column pb-3"> <label for="phone">Téléphone</label> <input type="text" name="phone" id="" class="border-bottom border-primary" placeholder="Saisir votre télephone ici" required="required"> </div>
                           	<div class="d-flex flex-column pb-3"> <label for="email">Adresse Email</label> <input type="email" name="email" id="emailId" class="border-bottom border-primary" placeholder="Saisir votre email ici" required="required"> </div>
                            <div class="d-flex flex-column pb-3"> <label for="password">Mot de passe</label> <input type="password" name="password" id="pwd" class="border-bottom border-primary" placeholder="Saisir votre mot de passe ici" required="required"> </div>
                            <br/>
                            -->
                            
                           <br>
                            <input type="submit" value="S'inscrire" class="btn btn-primary btn-block mb-3"> 
                           
                            <div class="register mt-5">
                                <p class=""> ${message}</p>
                            </div>
                            <!-- <button class="btn btn-block bg-white border border-primary rounded "><span class="fa fa-facebook-official text-primary px-2"></span>Log In with Facebook</button>-->
                            <div class="register mt-5">
                                <p>Vous avez déja un compte? <a href="Login">Se connecter</a></p>
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


    