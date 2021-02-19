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
	    <h1 class="h3 mb-2 text-gray-800"><b>Dossier Médical : KA01131992</b></h1>
	    <br>
	    <div class="row">
	        <div class="col-lg-6">
	            <!-- Default Card Example -->
	            <div class="card shadow mb-4">
	                <div class="card-header py-3">
	                    <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-id-card" aria-hidden="true"></i> &nbsp;Informations Personnelles</h6>
	                </div>
	                <div class="card-body">
                        <table class="table table-bordered table-striped" style="color: black;font-weight: bold;">
                            <tbody>
	                           	 <tr>
	                                 <td>CIN : </td>
	                                 <td>U667767</td>
	                            </tr>
                                <tr>
                                    <td>Nom : </td>
                                    <td>Kamali</td>
                                </tr>
                                <tr>
                                    <td>Prénom : </td>
                                    <td>Abderahmane</td>
                                </tr>
                                <tr>
                                    <td>Date de naissance : </td>
                                    <td>19/06/1993</td>
                                </tr>
                                <tr>
                                    <td>Télephone : </td>
                                    <td>0677777777</td>
                                </tr>
                                <tr>
                                    <td>Email : </td>
                                    <td>abdel1342@gmail.com</td>
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
	                            <tr>
	                                <td>Total des rendez-vous : </td>
	                                <td>6</td>
	                            </tr>
	                            <tr>
	                                <td>Total des consultations :</td>
	                                <td>3</td>
	                            </tr>
	                            <tr>
	                                <td>Total des ordonnances</td>
	                                <td>3</td>
	                            </tr>
	                            <tr>
	                                <td>Total des médicaments :</td>
	                                <td>13</td>
	                            </tr>
	                            <tr>
	                                <td>Total des frais payés :</td>
	                                <td>2000 dhs</td>
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
			        <!-- <a href="#" class="btn btn-success btn-icon-split" style="margin-left: 15px;width: 23%;">
			            <span class="icon text-white-50">
			                <i class="fa fa-plus" aria-hidden="true"></i>
			            </span>
			            <span class="text">Ajouter une consultation</span>
			        </a>-->
			    <div class="card-body">
			        <div class="table-responsive">
			            <table class="table table-bordered" style="color: black;" id="dataTable" width="100%" cellspacing="0">
			                <thead class="bg-primary">
			                    <tr>
			                        <th>Name</th>
			                        <th>Position</th>
			                        <th>Office</th>
			                        <th>Age</th>
			                        <th>Start date</th>
			                        <th>Salary</th>
			                    </tr>
			                </thead>
			                
			                <tbody>
			                    <tr>
			                        <td>Tiger Nixon</td>
			                        <td>System Architect</td>
			                        <td>Edinburgh</td>
			                        <td>61</td>
			                        <td>2011/04/25</td>
			                        <td>$320,800</td>
			                    </tr>
			                    
			                 
			                   
			                    
			                </tbody>
			                <tfoot class="bg-primary">
			                    <tr>
			                        <th>Name</th>
			                        <th>Position</th>
			                        <th>Office</th>
			                        <th>Age</th>
			                        <th>Start date</th>
			                        <th>Salary</th>
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
	                <a href="#" class="btn btn-success btn-icon-split" style="margin-left: 15px;width: 23%;">
	                    <span class="icon text-white-50">
	                        <i class="fa fa-plus" aria-hidden="true"></i>
	                    </span>
	                    <span class="text">Ajouter une consultation</span>
	                </a>
	            <div class="card-body">
	                <div class="table-responsive">
	                    <table class="table table-bordered" style="color: black;" id="dataTable" width="100%" cellspacing="0">
	                        <thead class="bg-success">
	                            <tr>
	                                <th>Name</th>
	                                <th>Position</th>
	                                <th>Office</th>
	                                <th>Age</th>
	                                <th>Start date</th>
	                                <th>Salary</th>
	                            </tr>
	                        </thead>
	                        
	                        <tbody>
	                            <tr>
	                                <td>Tiger Nixon</td>
	                                <td>System Architect</td>
	                                <td>Edinburgh</td>
	                                <td>61</td>
	                                <td>2011/04/25</td>
	                                <td>$320,800</td>
	                            </tr>
	                            
	                      
	                        </tbody>
	                        <tfoot class="bg-success">
	                            <tr>
	                                <th>Name</th>
	                                <th>Position</th>
	                                <th>Office</th>
	                                <th>Age</th>
	                                <th>Start date</th>
	                                <th>Salary</th>
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

	<!-- script js -->
	<script src="js/main.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<!-- fin script js -->
</body>
</html>