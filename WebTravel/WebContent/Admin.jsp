<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>旅遊微革命-後台管理</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">

</head>
<body>
	<!-- header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://www.google.com.tw">後台管理</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">管理員<span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">個人檔案</a></li>
                    </ul>
                </li>
                <li><a href="http://www.google.com.tw">登出</a></li>
            </ul>
        </div>
    </div>
    <!-- /container -->
</div>




<!-- /Header -->
<!-- Main -->
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
             <ul class="nav nav-stacked">
               
                <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu1"><h4>管理景點區</h4></a>   <!-- <i class="glyphicon glyphicon-chevron-down"></i>-->
                    <ul class="nav nav-stacked collapse" id="menu1">
                        <!--<li class="active"> <a href="#"></a></li>-->                                                          <!--<i class="glyphicon glyphicon-home"></i> -->
                        <li><a href="#" name="action" ="insert">新增景點<span class="badge badge-info"></span></a></li>                           <!--<i class="glyphicon glyphicon-envelope"></i> -->
                        <li><a href="#" name="action" value="update">修改景點</a></li>                                                                   <!--<i class="glyphicon glyphicon-home"></i>--> 
                        <li><a href="#" name="action">刪除景點</a></li>                                                                  <!--<i class="glyphicon glyphicon-comment"></i> -->
                        <li><a href="#" name="action">審核檢舉</a></li>                                                                <!--<i class="glyphicon glyphicon-user"></i>--> 
                        <!--<li><a href="#">Transactions</a></li>-->                                                              <!--<i class="glyphicon glyphicon-flag"></i> -->
                        <!--<li><a href="#">Rules</a></li>-->                                                             <!--<i class="glyphicon glyphicon-exclamation-sign"></i>-->    
                        <!--<li><a href="#">Logout</a></li>-->                                                                    <!--<i class="glyphicon glyphicon-off"></i>--> 
                    </ul>
                </li>
               
                
                <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2"><h4>管理美食區</h4></a>       <!--<i class="glyphicon glyphicon-chevron-right"></i>-->

                    <ul class="nav nav-stacked collapse" id="menu2">
                        <li><a href="#">新增餐廳</a></li>
                        <li><a href="#">修改餐廳</a></li>
                        <li><a href="#">刪除餐廳</a></li>
                        <li><a href="#">審核檢舉</a></li>
                        <!--<li><a href="#">Alerts</a></li>-->
                    </ul>
                </li>
                
                <li class="nav-header">
                    <a href="#" data-toggle="collapse" data-target="#menu3"><h4>管理會員區</h4></a>                            <!--<i class="glyphicon glyphicon-chevron-right"></i>-->
                    <ul class="nav nav-stacked collapse" id="menu3">
                        <li><a href="#">修改會員重要資料</a></li>                                                                 <!--<i class="glyphicon glyphicon-circle"></i>-->
                        <li><a href="#">修改會員權限</a></li>                                                                  <!--<i class="glyphicon glyphicon-circle"></i> -->
                    </ul>
                </li>

                <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu4"><h4>管理心得區</h4></a>   
                    <ul class="nav nav-stacked collapse" id="menu4">
                        <li><a href="#"><span class="badge badge-info"></span></a></li>                         
                        <li><a href="#"></a></li>                                                                  
                        <li><a href="#"></a></li>                                                                  
                        <li><a href="#"></a></li>    
                    </ul>
                </li>

                 <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu5"><h4>管理遊戲區</h4></a>   
                    <ul class="nav nav-stacked collapse" id="menu5">
                        <li><a href="#"><span class="badge badge-info"></span></a></li>                         
                        <li><a href="#">新增題目</a></li>                                                                  
                        <li><a href="#">修改題目</a></li>                                                                  
                        <li><a href="#">刪除題目</a></li>    
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
        
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>

</body>
</html>