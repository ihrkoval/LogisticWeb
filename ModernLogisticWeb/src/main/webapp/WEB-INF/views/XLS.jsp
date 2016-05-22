<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   
    <sec:authorize access="isAnonymous()">
	<meta http-equiv="refresh" content="0; url=./login" />
	</sec:authorize>
    <sec:authorize access="isAuthenticated()">
    
    
<html>
<head>
    <title>XLS</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSS -->
    <link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-accordeon.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-accordeon.structure.css"/>
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/xml.js"></script>
    <script>
        $(function() {
            $( "#accordion" ).accordion();
        });
    </script>
</head>
<body>
    <div id="header">    
        <div class="infoBar">
            <div class="infoBarLeft">
                <div class="infoBarIcon" title="Put your Foto">
                	 <img src="resources/images/userFoto.png" width=90px height=90px;/>
                </div>
            </div>
            <div class="infoBarCenter">
                <h1>Modern Logistic S<img class="logoIcon" src="resources/images/citizen_globe.gif" width=25px  height=25px/>ftware</h1>
            </div>
            <div class="infoBarRight">
            	<img src="resources/images/excel-256.png" width=100px height=100px;/>
             </div>
        </div>
    </div>
    <div id="content">
        <div class="leftBar">
            <div class="back" title="Tools"><a href="Tools"><img src="resources/images/left_arrow.png" width=30px height=30px;/></a></div>
            <div class="info" title="Info"><a href="Tools"><img src="resources/images/info.png" width=30px height=30px;/></a></div>
        </div>
        <div id="accordion">
              <h3>Отчет-реестр по Вересу(ФОРА)</h3>
              <div>
                  <div class="leftSide">
                       <form id="form" action="excel" method="get">
                            <label for="startDate">Начало периода:</label>
                                <input id="startDate" type="date" name="startDate" placeholder="date" required="required"/>
                            <label for="endDate">Конец периода:</label>
                                <input id="endDate" type="date" name="endDate" placeholder="date" required="required"/>
                       </form>
                       <button type="submit" form="form">Сгенерировать документ</button>
                  </div>
              </div>
              <h3>Отчет-сверка по выгрузке(ящ)</h3>
              <div>
                Section 2
              </div>
              <h3>Section 3</h3>
              <div>
                Section 3
              </div>
              <h3>Section 4</h3>
              <div>
                Section 4
              </div>
        </div>
    </div>
    <div id="footer">
        <h1>XLS Converting</h1>
    </div>
</body>
</html>
</sec:authorize>