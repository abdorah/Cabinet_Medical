<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>Edit</title>
    </head>
    
	<%@ page import="java.io.*,java.util.*" %>
	<%@ page import="javax.servlet.*,java.text.*" %>

	<%
		int id = (int) request.getAttribute("id");
		String nom = (String) request.getAttribute("nom");
		String prenom = (String) request.getAttribute("prenom");
		String tel = (String) request.getAttribute("tel");
		String email = (String) request.getAttribute("email");
		String date_naiss = (String) request.getAttribute("date_naiss");
		String sex = (String) request.getAttribute("sex");
	%>
    
    <body id="body-pd">
    	<%@ include file="side-bar.jsp" %>
    	
    	<div class="container-fluid" style="padding-top:5rem;">
        	
	        <!-- Page Heading -->
	        <div class="d-sm-flex align-items-center justify-content-between mb-4">
	            <h1 class="h3 mb-0 text-gray-800">Edit</h1>
	        </div>
	        
	        <!-- Content Row -->
	        <div class="row">
	
	            <!-- Area Chart -->
	            <div class="col-xl-12 col-lg-10">
	                <div class="card shadow mb-4">
	                    
	                    <!-- Card Header - Dropdown -->
	                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	                        <h6 class="m-0 font-weight-bold text-primary">Patient</h6>
	                    </div>
	                    
	                    <!-- Card Body -->
	                    <div class="card-body">
	                    <form action="Info_patient" method="POST">
	                    	<input type="hidden" class="form-control" name="id" value="<%= id %>" required>
	                    	
	                    	<div class="mb-3">
		                        <div class="row">
								  <div class="col">
								  	<label class="form-label">Nom</label>
								    <input type="text" class="form-control" name="nom" value="<%= nom %>" required>
								  </div>
								  
								  <div class="col">
								  	<label class="form-label">Prénom</label>
								    <input type="text" class="form-control" name="prenom" value="<%= prenom %>" required>
								  </div>
								</div>
							</div>
							
	                        <div class="mb-3">
							  <label class="form-label">Email</label>
							  <input type="email" class="form-control" name="email" value="<%= email %>" required>
							</div>
							
							<div class="mb-3">
		                        <div class="row">
								  <div class="col">
								  	<label class="form-label">Télephone</label>
								    <input type="text" class="form-control" name="tel" value="<%= tel %>" required>
								  </div>
								  
								  <div class="col">
								  	<label class="form-label">Date naissance</label>
								    <input type="date" class="form-control" name="date_naiss" value="<%= date_naiss %>" max="<%= (new SimpleDateFormat("yyyy-MM-dd").format(new Date())) %>" required>
								  </div>
								</div>
							</div>
							
						  <fieldset class="row mb-3">
						    <legend class="col-form-label col-sm-2 pt-0">Sex :</legend>
						    <div class="col-sm-10">
						    
						      <div class="form-check">
						        <input class="form-check-input" type="radio" name="Sex" value="homme" <% if(sex.equals("homme")) { %> checked <% } %>>
						        Homme
						      </div>
						      
						      <div class="form-check">
						        <input class="form-check-input" type="radio" name="Sex" value="femme" <% if(sex.equals("femme")) { %> checked <% } %> >
						        Femme					        
						      </div>
	
						    </div>
						  </fieldset>
							
						  <button type="submit" class="btn btn-primary">Modifier</button>
						  <a href="/CabinetMedicale/Login" class="btn btn-danger ">Annuler</a>
						  
						</form>  
	                    </div>
	                    
	                </div>
	            </div>
	
	        </div>
	        
		</div>
			
        <!-- footer -->
		<%@ include file="footer.jsp" %>
		<!-- fin footer -->
    	
    	<!-- script -->
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!--===== MAIN JS =====-->
        <script src="js/main.js"></script>
        <!-- script -->
    </body>
</html>
