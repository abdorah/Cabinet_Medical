<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- ===== BOX ICONS ===== -->
        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Rendez-vous</title>
    </head>

    <body id="body-pd">
        <!--===== SIDE BAR =====-->
        <%@ include file="side-bar.jsp" %>
            <div class="main">
                <div class="container">
                    <div class="appointment-content">
                        <div class="appointment-form">
                            <form method="POST" action="ServletAppointments" class="Checking-form" id="Checking-form">
                                <h2>Page de prise des rendez-vous</h2>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="state">Type de traitement :</label>
                                        <div class="form-select">
                                            <select name="state" id="state">
                                                <option value=""></option>
                                                <option value="1">maladie des enfants</option>
                                                <option value="2">vaccination</option>
                                                <option value="3">test</option>
                                                <option value="4">maladie des adults</option>
                                                <option value="5">enciente</option>
                                            </select>
                                            <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description :</label>
                                    <input type="text" name="description" id="description">
                                </div>
                                <div class="form-group">
                                    <label for="date">Date :</label>
                                    <input type="date" name="date" id="date">
                                </div>
                                <div class="form-group">
                                    <label for="time">Temps :</label>
                                    <input type="time" name="time" id="time">
                                </div>
                                <div class="form-submit">
                                    <input type="submit" value="Submit" class="submit" name="submit" id="submit" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--===== MAIN JS =====-->
            <script src="js/main.js"></script>
    </body>

    </html>