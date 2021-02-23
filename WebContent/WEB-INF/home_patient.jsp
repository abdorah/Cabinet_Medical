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
        <title>Patient</title>
    </head>
    
    <%
		User user = (User) session.getAttribute("user");
	%>
	
    <body id="body-pd">
    	<%@ include file="side-bar.jsp" %>
    	
    	<div class="container-fluid" style="padding-top:5rem;">
            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800"><b>Bonjour <%= user.getFirstName() + " " + user.getLastName() %></b></h1>
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
