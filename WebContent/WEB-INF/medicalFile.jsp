<%@page import="com.javaBeans.Consultation"%>
<%@page import="com.DAO.AppointmentDAO"%>
<%@page import="com.javaBeans.MedicalFile,java.util.ArrayList,com.javaBeans.Appointment,java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    <h1 class="h3 mb-2 text-gray-800"><b>Dossier Médical : ${ medicalFile.id}</b></h1>
	    <br>
	    <div class="row">
	        <div class="col-lg-6">
	            <!-- Default Card Example -->
	            <div class="card shadow mb-4">
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
	                                 <td>Genre : </td>
	                                 <td>${ medicalFile.patient.sex}</td>
	                            </tr>
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
	                </div>
	            </div>
	        </div>
	
	        <div class="col-lg-6">
	            <!-- Dropdown Card Example -->
	            <div class="card shadow mb-4">
	                <!-- Card Header - Dropdown -->
	                <div
	                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	                    <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-table" aria-hidden="true"></i>&nbsp;Statistiques</h6>
	
	                </div>
	                <!-- Card Body -->
	                <div class="card-body">
	                	<table class="table table-bordered table-striped" style="color: black;font-weight: bold;">
	                        <tbody>
	                        	<%
	                        		
	                        		HashMap<String,Double> statistiques = medicalFile.getStatistiques();
	                        	%>
	                            <tr>
	                                <td>Total des rendez-vous : </td>
	                                <td><%=statistiques.get("appointments")%></td>
	                            </tr>
	                            <tr>
	                                <td>Total des consultations :</td>
	                                <td><%=statistiques.get("consultations") %></td>
	                            </tr>
	                            <tr>
	                                <td>Total des ordonnances</td>
	                                <td><%=statistiques.get("prescriptions") %></td>
	                            </tr>
	                            
	                            <tr>
	                                <td>Total des frais payés :</td>
	                                <td><%=statistiques.get("totalPrice") %></td>
	                            </tr>
	                        </tbody>
                         </table>
	                </div>
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
			                        <th>Actions</th>
			                        
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
			                        <td>
			                        	<form action="/CabinetMedicale/MedicalFile" method="POST">
					                
							                <input type="hidden" name="id" value="<%=app.getId_appointment() %>" />
						                	<button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#ModalDelete">
						                		<i class="far fa-trash-alt"></i>
						                	</button>
						                	<div class="modal" id="ModalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-body">
                                                            <p>Confirmez la suppression de ce rendez-vous</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-outline-danger waves-effect" data-dismiss="modal">Annuler</button>
                                                            <button type="submit" class="btn btn-outline-primary waves-effect" name="delete" id="delete">Confirmer</button>
                                                    	</div>
                                                    </div>
                                                </div>
                                            </div>  	
					                	</form>
			                        
			                        
			                        </td>
			                        
			                    </tr>
			                
			                <%
			                	id++;
			                	}
			                %>
			                		
			                   
			                </tbody>
			                <tfoot class="bg-success">
			                    <tr>
			                       	<th>#</th>
			                        <th>Date de rendez-vous</th>
			                        <th>Date de prise de rendez-vous</th>
			                        <th>Type de maladie</th>
			                        <th>Description</th>
			                        <th>Actions</th>
			                       
			                    </tr>
			                </tfoot>
			            </table>
			        </div>
			    </div>
			</div>
	
	        <!-- liste des consultation -->
	        <div class="card shadow mb-4" style="width: 100%;">
	            <div class="card-header py-3">
	                <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp;Listes des consultations</h6>
	            </div>
	            <div class="my-2"></div>
	                <a href="#" class="btn btn-success btn-icon-split" data-toggle="modal" data-target="exampleModal" style="margin-left: 15px;width: 23%;">
	                    <span class="icon text-white-50">
	                        <i class="fa fa-plus" aria-hidden="true"></i>
	                    </span>
	                    <span class="text" >Ajouter une consultation</span>
	                </a>
	               
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
			                        <td><%=cons.getPrescription() %></td>
			                    </tr>
			                 <%
			                	id1++;
			                	}
			                %>
	                            
	                      
	                        </tbody>
	                        <tfoot class="bg-success">
	                            <tr>
	                                <th>#</th>
	                                <th>Date de consultation</th>
	                                <th>Motif</th>
	                                <th>Prix</th>
	                                <th>Ordonnance</th>
	                            </tr>
	                        </tfoot>
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

	
	<script src="js/main.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	<!-- fin script js -->
</body>
</html>