<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	    <title>Prendre un rendez-vous</title>
	</head>
	
    <body id="body-pd">
    	<%@ include file="side-bar.jsp" %>
    	
    	<div class="container-fluid" style="padding-top:5rem;">
	    	<%	
		    	String action = null ;
				String desc = null ;
				String type = null ;
	    		
				if(request.getAttribute("action")!=null)
				{ 
					action = (String) request.getAttribute("action");
					desc = (String) request.getAttribute("desc");
					type = (String) request.getAttribute("type");
			%>
					<div class="alert alert-danger" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span></button>
					  	<strong>Date !</strong> est occupé choisi une autre date.   	
				    </div>
		    <%
				}
			%>	
	        	
	        <!-- Page Heading -->
	        <div class="d-sm-flex align-items-center justify-content-between mb-4">
	            <h1 class="h3 mb-0 text-gray-800">Rendez-vous </h1>
	        </div>
	        
	        <!-- Content Row -->
	        <div class="row">
	
	            <!-- Area Chart -->
	            <div class="col-xl-12 col-lg-10">
	                <div class="card shadow mb-4">
	                   	                                     
	                    <!-- Card Header - Dropdown -->
	                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	                        <h6 class="m-0 font-weight-bold text-primary">Rendez-vous</h6>
	                    </div>
	                    
	                    <!-- Card Body -->
	                    <div class="card-body">
		                    <form action="Appointments" method="POST">
		                    
		                    	<div class="form-row d-flex flex-column pb-3">
		                               <label for="treatment">Type de traitement :</label>
		                               <div class="form-select">
		                                   <select name="treatment" class="form-control" id="treatmentId">
		                                       <option value=<%= action == "refuse" ? type : ""%>><%= action == "refuse" ? type : ""%></option>
		                                       <option value="maladie des enfants">maladie des enfants</option>
		                                       <option value="vaccination">vaccination</option>
		                                       <option value="test">test</option>
		                                       <option value="maladie des adults">maladie des adults</option>
		                                       <option value="enciente">enciente</option>
		                                   </select>
		                               </div>
		                           </div>                         	                   
								
								<div class="form-floating">
									<label class="form-label">Description</label>
								 	<textarea class="form-control" name="description" id="descriptionId" style="height: 100px"><%= action == "refuse" ? desc : ""%></textarea>
								</div>
								
								<div class="mb-3">								  
								  	<label class="form-label">Date </label>
								    <input type="datetime-local"  class="form-control" name="datetime" id="datetimeId" required>
								</div>
		
								
							  	<button type="submit" class="btn btn-primary" name="submit" id="submitId">Reserver</button>
						
							</form>  
	                    </div>
	                    
	                </div>
	            </div>
	
	        </div>
		        
		</div>
			
		<script>
		    if ( window.history.replaceState ) {
		        window.history.replaceState( null, null, window.location.href );
		    }
		</script>
		<!--===== MAIN JS =====-->
		<script src="js/main.js"></script>
	</body>

</html>