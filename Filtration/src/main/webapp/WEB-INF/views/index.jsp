<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

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

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>

<body>
<%
        request.setCharacterEncoding("UTF-8");
        %>

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

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="jumbotron">
                <h1>Добро пожаловать на доску позора</h1>

                <p>Здесь вы можете поделиться своими замечаниями о некачественных товарах или услугах, а также
                    ознакомиться с отзывами других потребителей</p>
            </div>
            <a href="${s:mvcUrl('CC#complaint').build()}" role="button" class="btn btn-success btn-lg btn-block">Написать отзыв</a>


            <p>
            <h2>Последние отзывы: </h2>

            <div class="row">

                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" data-toggle="modal" href="<c:url value="/show"/>"
                                  role="button">Подробнее »</a></p></div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" href="<c:url value="/show"/>" role="button">Подробнее
                                »</a></p></div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" href="<c:url value="/show"/>" role="button">Подробнее
                                »</a></p></div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" href="<c:url value="/show"/>" role="button">Подробнее
                                »</a></p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" href="<c:url value="/show"/>" role="button">Подробнее
                                »</a></p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/300x200" alt="...">

                        <div class="caption">
                            <h3>Ярлык эскиза</h3>

                            <p>...</p>

                            <p><a class="btn btn-primary" href="<c:url value="/show"/>" role="button">Подробнее
                                »</a></p></div>
                    </div>
                </div>
            </div>
            <!--/row-->
        </div>
        <!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <div class="list-group">
                <a href="#" class="list-group-item active">Магазины</a>
                <a href="#" class="list-group-item">Кафе и рестораны</a>
                <a href="#" class="list-group-item">Строительные фирмы</a>
                <a href="#" class="list-group-item">Услуги</a>
                <a href="#" class="list-group-item">Прочее</a>
            </div>
        </div>
        <!--/span-->
    </div>
    <!--/row-->



    <hr>

    <footer>
        <p>&copy; Company 2016</p>
        <button type="submit" class="locale" id="RUS">RUS</button>
        <button type="submit" class="locale" id="ENG">ENG</button>
    </footer>

</div>
<!--/.container-->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/offcanvas.js"></script>
<script src="../assets/js/holder.js"></script>
</body>
</html>