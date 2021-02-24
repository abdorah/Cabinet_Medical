<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.DAO.AppointmentDAO" %>
<% 
	AppointmentDAO app = new AppointmentDAO();
%>

<head>
	<style type="text/css">

		.notification-box {
		  position: fixed;
		  z-index: 99;
		  top: 20px;
		  right: 80px;
		  width: 50px;
		  height: 50px;
		  text-align: center;
		}
		.notification-bell {
		  animation: bell 1s 1s both infinite;
		}
		.notification-bell * {
		  display: block;
		  margin: 0 auto;
		  background-color: #A9A9A9;
		  box-shadow: 0px 0px 15px #A9A9A9;
		}
		.bell-top {
		  width: 6px;
		  height: 6px;
		  border-radius: 3px 3px 0 0;
		}
		.bell-middle {
		  width: 20px;
		  height: 20px;
		  margin-top: -1px;
		  border-radius: 12.5px 12.5px 0 0;
		}
		.bell-bottom {
		  position: relative;
		  z-index: 0;
		  width: 30px;
		  height: 2px;
		}
		.bell-bottom::before,
		.bell-bottom::after {
		  content: '';
		  position: absolute;
		  top: -4px;
		}
		.bell-bottom::before {
		  left: 1px;
		  border-bottom: 4px solid #fff;
		  border-right: 0 solid transparent;
		  border-left: 4px solid transparent;
		}
		.bell-bottom::after {
		  right: 1px;
		  border-bottom: 4px solid #fff;
		  border-right: 4px solid transparent;
		  border-left: 0 solid transparent;
		}
		.bell-rad {
		  width: 8px;
		  height: 4px;
		  margin-top: 2px;
		  border-radius: 0 0 4px 4px;
		  animation: rad 1s 2s both infinite;
		}
		.notification-count {
		  position: absolute;
		  z-index: 1;
		  top: -5px;
		  right: 2px;
		  width: 20px;
		  height: 20px;
		  line-height: 20px;
		  font-size: 16px;
		  border-radius: 50%;
		  background-color: #ff4927;
		  color: #fff;
		  animation: zoom 3s 3s both infinite;	 
		}
		<% if(app.notification() > 0) 
		{
		%>
			@keyframes bell {
			  0% { transform: rotate(0); }
			  10% { transform: rotate(30deg); }
			  20% { transform: rotate(0); }
			  80% { transform: rotate(0); }
			  90% { transform: rotate(-30deg); }
			  100% { transform: rotate(0); }
			}
	
			@keyframes zoom {
			  1% { opacity: 0; transform: scale(0); }
			  10% { opacity: 1; transform: scale(1); }
			  90% { opacity: 1; }
			  100% { opacity: 0; }
			}
		<%
		}
		%>

	</style>
</head>

<header class="header" id="header">
    <div class="header__toggle">
        <i class='bx bx-menu' id="header-toggle"></i>
    </div>
   
	<div class="notification-box">
	  <span class="notification-count"><%= app.notification() %></span>
	  <div class="notification-bell">
	    <span class="bell-top"></span>
	    <span class="bell-middle"></span>
	    <span class="bell-bottom"></span>
	    <span class="bell-rad"></span>
	  </div>
	</div>
	
    <div class="header__img">
        <img src="images/perfil.jpg" alt="">
    </div>
    
</header>

<div class="l-navbar" id="nav-bar">
    <nav class="nav">
        <div>
            <a href="#" class="nav__logo">
                <i class='bx bx-layer nav__logo-icon'></i>
                <span class="nav__logo-name">HEALTH CARE</span>
            </a>

            <div class="nav__list">
                <a href="/CabinetMedicale/Home" class="nav__link active">
                <i class='bx bx-grid-alt nav__icon' ></i>
                    <span class="nav__name">Dashboard</span>
                </a>

                <a href="/CabinetMedicale/Patients" class="nav__link">
                    <i class='bx bx-user nav__icon' ></i>
                    <span class="nav__name">Patients</span>
                </a>
                
                <a href="/CabinetMedicale/RendezVous?type=A" class="nav__link">
                    <i class='bx bx-message-square-detail nav__icon' ></i>
                    <span class="nav__name">Rendez-vous</span>
                </a>

                <a href="/CabinetMedicale/RendezVous?type=H" class="nav__link">
                    <i class='bx bx-data nav__icon' ></i>
                    <span class="nav__name">Historique</span>
                </a>

            </div>
        </div>

        <a href="/CabinetMedicale/Logout" class="nav__link">
            <i class='bx bx-log-out nav__icon' ></i>
            <span class="nav__name">Se déconnecter</span>
        </a>
    </nav>
</div>