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
     <link href="css/sb-admin-2.min.css" rel="stylesheet">
     
     <!-- ===== CSS font ===== -->
     <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
     <!--lien dataTable.css-->
     <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

     <title>Liste patients</title>
    </head>

    <%@ page import = "com.javaBeans.Patient" %>
	<%@ page import = "java.util.ArrayList" %>
	<%@ page import = "java.util.Date" %>
	
	<body id="body-pd">
	
	<%@ include file="side-bar_doctor.jsp" %>
	
	<!-- Begin Page Content -->
		<div class="container-fluid" style="padding-top:5rem;">
	<%
		ArrayList<Patient> patients = (ArrayList<Patient>) request.getAttribute("patients");

		if(request.getAttribute("action")!=null)
		{ 
			if(request.getAttribute("action").equals("edit"))
			{
				request.getAttribute("nom");
				request.getAttribute("prenom");
	%>
				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				  	<strong>Patient ! <%= request.getAttribute("prenom") + " " + request.getAttribute("nom") %></strong> est modifier.   	
			    </div>
    <%
			}
			if(request.getAttribute("action").equals("supprimer"))
			{
	%>
				<div class="alert alert-danger" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				  	<strong>Patient ! numéro <%= request.getAttribute("id_p") %></strong> est supprimer.   	
			    </div>
    <%
			}
		}
	%>
			
            <!-- Page Heading -->
            <p class="mb-4">
            	Voici Tout les patients  
            </p>
	
	        <!-- DataTales Example -->
	        <div class="card shadow mb-4">
	            <div class="card-header py-3">
	                <h6 class="m-0 font-weight-bold text-primary">les Pations</h6>
	            </div>
	            <div class="card-body">
	                <div class="table-responsive">
	                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                        <thead>
	                            <tr>
	                                <th>Nom</th>
	                                <th>Prenom</th>
	                                <th>Email</th>
	                                <th>Numéro</th>
	                                <th>Date naissance</th>
	                                <th>Sex</th>
	                                <th>Actions</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                        	<%
									for(Patient patient: patients)
								    {
								%>
	 
	                            <tr>
	                                <td><%= patient.getFirstName() %></td>
	                                <td><%= patient.getLastName() %></td>
	                                <td><%= patient.getEmail() %></td>
	                                <td><%= patient.getPhone() %></td>
	                                <td><%= patient.getBirthDate() %></td>
	                                <td><%= patient.getSex() %></td>
	                                <td>
						                
						                <form action="/CabinetMedicale/Patients" method="POST">
						                
							                <a type="button" href="/CabinetMedicale/EditPatient?id=<%= patient.getId_user() %>" class="btn btn-success"> 
							                    <i class="fas fa-user-edit"></i>
							                </a>					                
						                
						                	<input type="hidden" name="id" value="<%= patient.getId_user() %>" />	
						                	<button class="btn btn-danger" type="submit"><i class="fas fa-user-times"></i></button>	
						                	
						                	<a type="button" href="MedicalFile?id=<%= patient.getId_user() %>" class="btn btn-info"> 
							                    <i class="fas fa-folder"></i>
							                </a>			                	
						                </form>
						                
									</td>
	                                
	                            </tr>
								<%
								    }
								%>                            
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div>
	
	    </div>
	    <!-- End of Main Content -->
			
        <!-- footer -->
		<%@ include file="footer.jsp" %>
		<!-- fin footer -->
		
		<!--===== MAIN JS =====-->
        <script src="js/main.js"></script>
	
		<!-- Custom scripts for all pages-->
	    <script src="js/sb-admin-2.min.js"></script>
	
		<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
		<!--script dataTable-->
	    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	    
	    <script>
            
	       	$(document).ready(function() {
	            var table = $('#dataTable').DataTable();
	   		 } );
    	</script>

    </body>
</html>
