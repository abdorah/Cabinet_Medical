<%@page import="com.javaBeans.Consultation"%>
<%@page import="com.DAO.AppointmentDAO"%>
<%@page import="com.javaBeans.MedicalFile,java.util.ArrayList,com.javaBeans.Appointment,java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "com.javaBeans.User" %>

<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!-- ===== BOX ICONS ===== -->
     <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
     <!-- ===== CSS ===== -->
     <link rel="stylesheet" href="css/styles.css">
     <!-- ===== CSS font ===== -->
     <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
     <!--lien dataTable.css-->
     <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
     <!-- Custom styles for this template-->
     <link href="css/sb-admin-2.min.css" rel="stylesheet">

	<title>Dossier médicale du patient</title>
</head>
<body>
	
	<!-- Side bar -->
	<%@ include file="side-bar.jsp" %>
	<!-- fin Side bar -->

	<!-- debut cards -->
	<div class="container-fluid" style="margin-top: 100px;">
	
		<%

		if(request.getAttribute("action")!=null)
		{ 

		%>
				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				  	<strong>Informations !</strong> modifier.   	
			    </div>
    	<%
			}
		%>
	    
	    <h1 class="h3 mb-2 text-gray-800"><b>Dossier Médical : ${ medicalFile.id}</b></h1>
	    <br>
	    <div class="row">

            <!-- Default Card Example -->
            <div class="card shadow mb-4" style="width: 100%;">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-id-card" aria-hidden="true"></i> &nbsp;Informations Personnelles</h6>
                </div>
                <%
                  		MedicalFile medicalFile = (MedicalFile) request.getAttribute("medicalFile");
                %>
                <div class="card-body">
                       <table class="table table-bordered table-striped" style="color: black;font-weight: bold;">
                           <tbody>
                           	 <tr>
                                 <td>CIN : </td>
                                 <td>${ medicalFile.patient.cin}</td>
                            </tr>
                               <tr>
                                   <td>Nom : </td>
                                   <td>${ medicalFile.patient.lastName}</td>
                               </tr>
                               <tr>
                                   <td>Prénom : </td>
                                   <td>${ medicalFile.patient.firstName}</td>
                               </tr>
                               <tr>
                                 <td>Genre : </td>
                                 <td>${ medicalFile.patient.sex}</td>
                            </tr>
                               <tr>
                                   <td>Date de naissance : </td>
                                   <td>${ medicalFile.patient.birthDate}</td>
                               </tr>
                               <tr>
                                   <td>Télephone : </td>
                                   <td>${ medicalFile.patient.phone}</td>
                               </tr>
                               <tr>
                                   <td>Email : </td>
                                   <td>${ medicalFile.patient.email}</td>
                               </tr>
                           </tbody>
                       </table>
                       <a type="button" href="/CabinetMedicale/EditInfo" class="btn btn-success"> 
						 <i class="fas fa-user-edit"></i>
					</a>
                </div>
            </div>

	        <!-- liste des rendez-vous -->
			<div class="card shadow mb-4" style="width: 100%;">
			    <div class="card-header py-3">
			        <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp;Listes des rendez-vous</h6>
			    </div>
			    <div class="my-2"></div>			    
			    
			    <div class="card-body">
			        <div class="table-responsive">
			            <table  class="table table-bordered" style="color: black;" id="dataTable1" width="100%" cellspacing="0">
			                <thead class="bg-success">
			                    <tr>
			                        <th>#</th>
			                        <th>Date de rendez-vous</th>
			                        <th>Date de prise de rendez-vous</th>
			                        <th>Type de maladie</th>
			                        <th>Description</th>			                        
			                    </tr>
			                </thead>
			                <tbody>
			                <%
			                	int id=1;
			                	
			                	ArrayList<Appointment> appList = medicalFile.getAppointmentList();
			                	
			                	for (Appointment app : appList ){
			                %>
			                	<tr>
			                        <td><%=id %></td>
			                        <td><%=app.getDateofAppointment() %></td>
			                        <td><%=app.getDateofChecking() %></td>
			                        <td><%=app.getTypeofIllness() %></td>
			                        <td><%=app.getDescription() %></td>			         
			                    </tr>
			                
			                <%
			                	id++;
			                	}
			                %>
			                					                   
			                </tbody>
			            </table>
			        </div>
			    </div>
			</div>
	
	        <!-- liste des consultation -->
	        <div class="card shadow mb-4" style="width: 100%;">
	            <div class="card-header py-3">
	                <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp;Listes des consultations</h6>
	            </div>
	               
	            <div class="card-body">
	                <div class="table-responsive">
	                    <table class="table table-bordered" style="color: black;" id="dataTable2" width="100%" cellspacing="0">
	                        <thead class="bg-success">
	                            <tr>
	                                <th>#</th>
	                                <th>Date de consultation</th>
	                                <th>Motif de consultation</th>
	                                <th>Prix en DHS</th>
	                                <th>Ordonnance</th>
	                            </tr>
	                        </thead>
	                        
	                        <tbody>
	                       	<%
			                	int id1=1;
			                	
			                	ArrayList<Consultation> consList = medicalFile.getConsultationList();
			                	
			                	for (Consultation cons: consList ){
			                %>
			                	<tr>
			                        <td><%=id1 %></td>
			                        <td><%=cons.getConsulationDate() %></td>
			                        <td><%=cons.getMotif() %></td>
			                        <td><%=cons.getPrice() %></td>
			                        <td>
			                        	<!-- <input type="hidden" name="id" value="" /> -->
			                        	<% 
			                        		if(cons.getPrescription() == null){
			                        	%>
			                        	    Vide
			                        	<% 
			                        	
			                        		}else{
			                        	%>
			                        	
			                        	
				                        	<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#ModalShow">
						                		<i class="fas fa-edit"></i>
						                	</button>
						                	<div class="modal" id="ModalShow" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	                                            <div class="modal-dialog" role="document">
	                                                <div class="modal-content">
	                                                    <div class="modal-body">
	                                                        <table class="table table-bordered table-striped" style="color: black;font-weight: bold;">
										                        <tbody>
										                        	
										                            <tr>
										                                <td>Titre d'ordonnance : </td>
										                                <td><%=cons.getPrescription().getTitle()%></td>
										                            </tr>
										                            <tr>
										                                <td>Description :</td>
										                                <td><%=cons.getPrescription().getDescription() %></td>
										                            </tr>
										                            <tr>
										                                <td>Liste des médicaments :</td>
										                                <td><%=cons.getPrescription().getMedicationList() %></td>
										                            </tr>
										                            
										                           
										                        </tbody>
									                         </table>
	                                                    </div>
	                                                    <div class="modal-footer">
	                                                        <button type="button" class="btn btn-outline-danger waves-effect" data-dismiss="modal">Fermer</button>
	                                                       
	                                                	</div>
	                                                </div>
	                                            </div>
	                                        </div>  	
			                        </td>
			                        	<%	
			                        		} 
			                        	
			                        	%>
			                    </tr>
			                <%
			                	id1++;
			                	}
			                %>
	                                                  
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div>

	
	    </div>
	</div>
	<!-- fin cards -->
	
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
    
    <!-- script js -->
    
	<script>
            
       $(document).ready(function() {
            // $('#listStg').DataTable();
            var table1 = $('#dataTable1').DataTable();
            var table2 = $('#dataTable2').DataTable();
            var table_row1 = table1.rows( { selected: true } ).count();
            var table_row2 = table2.rows( { selected: true } ).count();
            if(table_row1<6){
                $('#dataTable1 tfoot').css("display","none");
                
            }
            if(table_row2<6){
                $('#dataTable2 tfoot').css("display","none");
                
            }

   		 } );
    </script>
    <script>
	    if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
	</script>
	<!-- fin script js -->
</body>
</html>