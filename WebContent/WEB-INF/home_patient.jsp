<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "com.javaBeans.User" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- ===== BOX ICONS ===== -->
        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="css/styles.css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link href="css/Accueil.css" rel="stylesheet">
        <title>Patient</title>
    </head>
    
    <%
		User user = (User) session.getAttribute("user");
	%>
	
    <body id="body-pd">
    	<%@ include file="side-bar.jsp" %>
    	
    	<div class="container-fluid" style="padding-top:5rem;">
	    	<%		
				if(request.getAttribute("action")!=null)
				{ 
			%>
					<div class="alert alert-success" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span></button>
					  	<strong>Rendez-Vous !</strong> est effectué.   	
				    </div>
		    <%
				}
			%>
		
            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800"><b>Bonjour <%= user.getFirstName() + " " + user.getLastName() %></b></h1>
	            
            <div class="row">
	        
				<div class="col-4">
					<a href="/CabinetMedicale/Info_patient">
						<div class="box">  
							<div class="imgBx">
							    <img src="images/information.jpg" width="250px" height="300"> 
							</div>
							<p class="text">Mes information</p>
							<div class="details"><h2>Information</h2></div>
						</div>
					</a>
				</div>
			        
				<div class="col-4">
					<a href="/CabinetMedicale/Appointments">
						<div class="box">  
							<div class="imgBx">
							    <img src="images/rendezVous.jpg" width="250px" height="300"> 
							</div>
							<p class="text">Prendre rendez vous</p>
							<div class="details"><h2>Rendez Vous</h2></div>
						</div>
					</a>
				</div>

				<div class="col-4">
					<a href="/CabinetMedicale/Logout">
						<div class="box">  
							<div class="imgBx">
							    <img src="images/deconnexion.jpg" width="250px" height="300"> 
							</div>
							<p class="text">Se déconnecter</p>
							<div class="details"><h2>Déconnecter</h2></div>
						</div>
					</a>
				</div>
				
            </div>
		</div>
    	
    	<!-- script -->
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!--===== MAIN JS =====-->
        <script src="js/main.js"></script>
        <!-- script -->
    </body>
</html>
