<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="generator"
    content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ACDA team</title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="css/logo-nav.css" rel="stylesheet" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <!-- Navigation -->
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
      </button> 
      <a class="navbar-brand" href="#">
        <img src="css/pics/logo.png" alt="" />
      </a></div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li>
            <a href="services.jsp">Services</a>
          </li>
          <li>
            <a href="rules.jsp">Rules</a>
          </li>
          <li>
            <a href="contact.jsp">Contact</a>
          </li>
        </ul>
      </div>
      <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
  </nav>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h1>Input data</h1>
		</br>
        <form id="form">
          <table>
            <tr>
              <td>Service name:</td>
              <td>
                <input type="text" id="serviceName" />
              </td>
            </tr>
            <tr>
              <td>Port:</td>
              <td>
                <input type="text" id="port" />
              </td>
            </tr>
            <tr>
              <td>Type:</td>
              <td>
                <select id="type">
				  <option value="">---------Select--------</option>
                  <option value="HTTP">HTTP</option>
                  <option value="MySQL">MySQL</option>
                  <option value="AMQP">AMQP</option>
                  <option value="JMS">JMS</option>
                </select>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input type="button" id="add" value="Add" onclick="return validateForm();" />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div class="col-lg-12">
		</br>
        <h1>View data</h1>
        <table id="tableData" class="responstable">
          <tr>
            <th data-th="Driver details">
              <b>Service name</b>
            </th>
            <th data-th="Driver details">
              <b>Port</b>
            </th>
            <th data-th="Driver details">
              <b>Type</b>
            </th>
            <th data-th="Driver details">Action</th>
          </tr>
        </table>
      </div>
    </div>
  </div>
  <!-- /.container -->
  <!-- jQuery -->
  <script src="js/jquery.js"></script> 
  <script type="text/javascript" src="js/services.js"></script> 
  <script type="text/javascript">
    document.getElementById('serviceName').value ='';
    document.getElementById('port').value ='';
    document.getElementById('type').value ='';
</script> 
  <!-- Bootstrap Core JavaScript -->
   
  <script src="js/bootstrap.min.js"></script></body>
</html>
