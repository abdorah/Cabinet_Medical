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
    <title>Rendez-vous</title>
</head>

<body id="body-pd">
<!--===== SIDE BAR =====-->
<%@ include file="side-bar.jsp" %>

<div class="container-fluid" style="padding-top:5rem;">
    <div class="row">

        <div class="col-xl-8 col-lg-7">

            <!-- Area Chart -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h1 class="h3 mb-2 text-gray-800"><b>Rendez-vous</b></h1>
                </div>
                <div style="flex:1 1 auto;min-height:1px;padding:1.25rem;height: min-content">
                    <div style="  position: relative;height: 25rem;width: 100%;padding:1.25rem">
                        <form id="formId" method="POST" action="Appointments" class="col-form-label">
                            <div class="form-row d-flex flex-column pb-3">
                                <label for="treatment">Type de traitement :</label>
                                <div class="form-select">
                                    <select name="treatment" id="treatmentId">
                                        <option value=""></option>
                                        <option value="maladie des enfants">maladie des enfants</option>
                                        <option value="vaccination">vaccination</option>
                                        <option value="test">test</option>
                                        <option value="maladie des adults">maladie des adults</option>
                                        <option value="enciente">enciente</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group d-flex flex-column pb-3">
                                <label for="description">Description :</label>
                                <input type="text" name="description" id="descriptionId">
                            </div>
                            <div class="form-group d-flex flex-column pb-3">
                                <label for="datetime">Date :</label>
                                <input type="datetime-local" name="datetime" id="datetimeId">
                            </div>
                            <div style="float: left">
                                <input type="submit" value="Reserver" class="submit" name="submit"
                                       id="submitId" />
                            </div>
                        </form>
                    </div>
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