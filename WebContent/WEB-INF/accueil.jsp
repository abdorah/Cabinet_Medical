<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Health care : Accueil</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/st.css">
  
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
  <!--banner-->
  <section id="banner" class="banner">
    <div class="bg-color">
      <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
          <div class="col-md-12">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
              <a class="navbar-brand" href="#"><img src="images/h.png" class="img-responsive" style="width: 100px; margin-top: -30px;"></a>
            </div>
            <div class="collapse navbar-collapse navbar-right" id="myNavbar">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#banner">Accueil</a></li>
                <li class=""><a href="#service">Services</a></li>
                <li class=""><a href="#doctor-team">A propos</a></li>
                
                <li class=""><a href="#contact">Contacts</a></li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
      <div class="container">
        <div class="row">
          <div class="banner-info">
            <!-- <div class="banner-logo text-center">
              <img src="img/logo.png" class="img-responsive">
            </div> -->
            <div class="banner-text text-center">
              <h1 class="white">Au service de votre santé</h1>
              <h3 style="color:antiquewhite"><b>
                Écouter</b>,<b>Préserver</b>,<b>Soigner</b></h3>
              <a href="/CabinetMedicale/Login" class="btn btn-appoint">Prendre un rendez-vous.</a>
            </div>
            <div class="overlay-detail text-center">
              <a href="#service"><i class="fa fa-angle-down"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--/ banner-->
  
  <!--service-->
  <section id="service" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-sm-4">
          <h2 class="ser-title">Nos services</h2>
          <hr class="botm-line">
          
        </div>
        <div class="col-md-4 col-sm-4">
          <div class="service-info">
            <div class="icon">
              <i class="fa fa-stethoscope"></i>
            </div>
            <div class="icon-info">
              <h4>Diagnostic médical</h4>
              
            </div>
          </div>
          <div class="service-info">
            <div class="icon">
              <i class="fa fa-ambulance"></i>
            </div>
            <div class="icon-info">
              <h4>Services d'urgence</h4>
              
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-4">
          <div class="service-info">
            <div class="icon">
              <i class="fa fa-user-md"></i>
            </div>
            <div class="icon-info">
              <h4>Conseil médical</h4>
              
            </div>
          </div>
          <div class="service-info">
            <div class="icon">
              <i class="fa fa-medkit"></i>
            </div>
            <div class="icon-info">
              <h4>Suivi médical</h4>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--/ service-->
  
  <!--cta-->
  <section id="cta-1" class="section-padding">
    <div class="container">
      <div class="col-md-4 col-sm-4">
        <h2 class="ser-title">Horaires du travail</h2>
        <hr class="botm-line">
        
      </div>
      <div class="row">
        <div class="schedule-tab">
          
         
          <div class="col-md-4  mt-boxy-3" style="width: 100%;">
            <div class="mt-boxy-color"></div>
            <div class="time-info">
              <h3>Horaires d'ouvertures</h3>
              <table style="margin: 8px 0px 0px;" border="1">
                <tbody>
                  <tr>
                    <td>Lundi - Vendredi</td>
                    <td>8.00 H - 17.00 H</td>
                  </tr>
                  <tr>
                    <td>Samedi</td>
                    <td>9.30 H - 17.30 H</td>
                  </tr>
                  <tr>
                    <td>Dimanche</td>
                    <td>9.30 H - 15.00 H</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
    
        </div>
      </div>
    </div>
  </section>
  <!--cta-->


  <!--doctor team-->
  <section id="doctor-team" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2 class="ser-title">L'équipe de notre cabinet</h2>
          <hr class="botm-line">
        </div>
        <div class="col-md-3 col-sm-3 col-xs-6">
          <div class="thumbnail">
            <img src="images/doctor4.jpg" alt="..." class="team-img">
            <div class="caption">
              <h3>Michel Donas</h3>
              <p><b>Médecin généraliste</b></p>
              <p>Tél: 078981314 <br>Email: Donas@hotmail.com</p>
              <ul class="list-inline">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-6">
          <div class="thumbnail">
            <img src="images/doctor1.jpg" alt="..." class="team-img">
            <div class="caption">
              <h3>June Wells</h3>
              <p><b>Assistant médical</b></p>
              <p>Tél: 0615142526 <br>Email: June@hotmail.com</p>
              <ul class="list-inline">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        
        <div class="col-md-3 col-sm-3 col-xs-6">
          <div class="thumbnail">
            <img src="images/doctor3.jpg" alt="..." class="team-img">
            <div class="caption">
              <h3>Amanda Denyl</h3>
              <p><b>Secrétaire </b></p>
              <p>Tél: 0615142526 <br>Email: Amanda@hotmail.com</p>
              <ul class="list-inline">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
       
        </div>
      </div>
  </section>
  <!--/ doctor team-->
  
  <!--/ testimonial-->
  
  <!--cta 2-->
  <section id="cta-2" class="section-padding">
    <div class="container">
      <div class=" row">
        <div class="col-md-2"></div>
        <div class="text-right-md col-md-4 col-sm-4">
          <h2 class="section-title white lg-line">«Quelques mots<br> sur notre cabinet»</h2>
        </div>
        <div class="col-md-4 col-sm-5">
          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a typek
          <p class="text-right text-primary"><i>Health care cabinet</i></p>
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>
  </section>
  <!--cta-->
  
  <!--contact-->
  <section id="contact" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2 class="ser-title">Contact</h2>
          <hr class="botm-line">
        </div>
        <div class="col-md-4 col-sm-4">
          <h3>Contact Info</h3>
          <div class="space"></div>
          <p><i class="fa fa-map-marker fa-fw pull-left fa-2x"></i>157 William St, New York, <br> 10038, États-Unis</p>
          <div class="space"></div>
          <p><i class="fa fa-envelope-o fa-fw pull-left fa-2x"></i>health.care@info.com</p>
          <div class="space"></div>
          <p><i class="fa fa-phone fa-fw pull-left fa-2x"></i>+219 1 51 74 43 25 6</p>
        </div>
        <div class="col-md-8 col-sm-8 marb20">
          <div class="contact-info">
            
              <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" allowfullscreen></iframe>
          </div>
            
          </div>
        </div>
      </div>
  </section>
  <!--/ contact-->
  
  <!--footer-->
  <footer id="footer">
    <div class="top-footer">
      <div class="container">
        <div class="row">
               
        </div>
      </div>
    </div>
    <div class="footer-line">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            © Copyright 2021. All Rights Reserved
            
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!--/ footer-->
	
	<script src="js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="js/custom.js"></script>
  

</body>

</html>
