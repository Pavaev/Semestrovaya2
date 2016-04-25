<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">

    <title>Доска позора|Пожаловаться на некачественные товары и слуги|Отзывы</title>

    <link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../assets/css/offcanvas.css" rel="stylesheet">
    <link href="../assets/css/registerfont.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Доска Позора </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/"/>">Главная</a></li>
                <li><a href="#about">О проекте</a></li>
                <li><a href="#contact">Контакты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Войти</b> <span class="caret"></span></a>
                    <ul id="login-dp" class="dropdown-menu">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    <b>Войти</b>

                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8"
                                          id="login-nav">
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputEmail2">Email </label>
                                            <input type="email" class="form-control" id="exampleInputEmail2"
                                                   placeholder="Email address" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputPassword2">Пароль</label>
                                            <input type="password" class="form-control" id="exampleInputPassword2"
                                                   placeholder="Password" required>

                                            <div class="help-block text-right"><a href="">Забыли пароль ?</a></div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block">Войти</button>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Оставаться в сети
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <div class="bottom text-center">
                                    Еще нет профиля ? <a href="${s:mvcUrl('UC#register').build()}"><b>Присоединиться</b></a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
                <li><a href="${s:mvcUrl('UC#register').build()}">Регистрация</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Найти...">
            </form>
        </div>
        <!-- /.nav-collapse -->
    </div>
    <!-- /.container -->
</div>
<!-- /.navbar -->

<div class="container">

    <h2 class="label-horizontal">Регистрация</h2>
    <c:if test="${not empty message}">
        <h1 class="alert alert-success">${message}</h1>
    </c:if>
    <form:form class="form-horizontal" method="POST" commandName="user">
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="lastName" path="lastName">Фамилия:</form:label>
            <div class="col-xs-9">
                <form:input type="text" class="form-control" id="lastName" placeholder="Введите фамилию"
                            path="lastName"/>
                <b id="warning">
                    <form:errors path="lastName"/>
                </b>
            </div>

        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="firstName" path="firstName">Имя:</form:label>
            <div class="col-xs-9">
                <form:input type="text" class="form-control" id="firstName" placeholder="Введите имя" path="firstName"/>
                <b id="warning">
                    <form:errors path="firstName"/>
                </b>
            </div>

        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="fatherName" path="midName">Отчество:</form:label>
            <div class="col-xs-9">
                <form:input type="text" class="form-control" id="fatherName" placeholder="Введите отчество"
                            path="midName"/>

            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" path="birth">Дата рождения:</form:label>
            <div class="col-xs-3">
                <form:select class="form-control" path="birth">
                    <option>Дата</option>
                </form:select>
            </div>
            <div class="col-xs-3">
                <form:select class="form-control" path="birth">
                    <option>Месяц</option>
                </form:select>
            </div>
            <div class="col-xs-3">
                <form:select class="form-control" path="birth">
                    <option>Год</option>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="inputEmail" path="email">Email:</form:label>
            <div class="col-xs-9">
                <form:input type="email" class="form-control" id="inputEmail" placeholder="Email" path="email"/>
                <b id="warning">
                    <form:errors path="email"/>
                </b>
            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="inputPassword" path="password">Пароль:</form:label>
            <div class="col-xs-9">
                <form:input type="password" class="form-control" id="inputPassword" placeholder="Введите пароль"
                            path="password"/>
                <b id="warning">
                    <form:errors path="password" font-color="red"/>
                </b>
            </div>
        </div>

        <div class="form-group">
            <form:label class="control-label col-xs-3" for="phoneNumber" path="phone">Телефон:</form:label>
            <div class="col-xs-9">
                <form:input type="tel" class="form-control" id="phoneNumber" placeholder="Введите номер телефона"
                            path="phone"/>
            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" name="town" for="postalAddress" path="town">Город:</form:label>
            <div class="col-xs-9">
                <form:select rows="3" name="town" class="form-control" id="postalAddress"
                             path="town">
                    <c:forEach var="town" items="${townList}">
                        <option value="${town.getId()}">${town.getName()}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <form:label class="control-label col-xs-3" for="sex" path="sex">Пол:</form:label>
            <div class="col-xs-2">
                <form:label class="radio-inline" path="sex">
                    <form:radiobutton name="genderRadios" value="male" id="sex" path="sex"/> Мужской
                </form:label>
            </div>
            <div class="col-xs-2">
                <label class="radio-inline">
                    <form:radiobutton name="genderRadios" value="female" id="sex" path="sex"/> Женский
                </label>
            </div>
            <form:errors path="sex"/>
        </div>
        <br>


        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" value="Регистрация">
                <input type="reset" class="btn btn-default" value="Очистить форму">
            </div>
        </div>
    </form:form>

    <hr>

    <footer>
        <p>&copy; Company 2016</p>
    </footer>

</div>
<!--/.container-->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/offcanvas.js"></script>
</body>
</html>