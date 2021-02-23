<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaBeans.HomeData"%>
<%-- here we fetch data from the request parameter inorder to make it accessible for jsp --%>
<%
    HomeData homeData ;
    if (request.getAttribute("homeData")!=null) homeData =(HomeData) request.getAttribute("homeData");
    else homeData = new HomeData();
%>
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
        <title>Page d'accueil</title>


    </head>
    <body id="body-pd">
    	<%@ include file="side-bar.jsp" %>
    	
    	<div class="container-fluid" style="padding-top:5rem;">
            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800"><b>Tableau de bord</b></h1>
            <p class="mb-4">Statistique indiquant le Nombre des Patiens inscrits ,  Nombre des Rendez-vous pris,  Les rendez-vous prochaines ,Nombre des consultations faites
                ainsi que la fréquence annuelle de consultation du médecin.</p>
			<!-- Cards -->
            <div class="row">
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Nombre des Patiens inscrits</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%= homeData.getUsersNbr()%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                        Nombre des Rendez-vous pris</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%= homeData.getAppointmentNbr()%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                        Les rendez-vous prochaines </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%= homeData.getNxtAppointmentNbr()%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-comments fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Nombre des consultations faites
                                    </div>
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-auto">
                                            <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%= homeData.getDoneConsultations()%></div>
                                        </div>
                                        <div class="col">
                                            <div class="progress  progress-sm mr-2">
                                                <div class="progress-bar bg-info" role="progressbar"
                                                    style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                                    aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- fin Cards -->
            </div>
           
             
            <!-- Content Row -->
            <div class="row">

                <div class="col-xl-12 col-lg-12">

                    <!-- Area Chart -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Statistiques Annuels des consultations</h6>
                        </div>
                        <div class="card-body" style="min-height: 600px;">
                            <div class="chart-area">
                                <canvas id="canvas"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             <!-- fin Content Row -->
        </div>
        <!-- footer -->
		<%@ include file="footer.jsp" %>
		<!-- fin footer -->
    	
    	<!-- script -->
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!--===== MAIN JS =====-->
        <script src="js/main.js"></script>
        <script src="js/homeChart.js"></script>

        <!-- script -->
    </body>
</html>
