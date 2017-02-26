<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Flat HTML5/CSS3 Login Form</title>
      <link rel="stylesheet" href="<c:url value="/resources/css/login_style.css" />">
</head>

<body>
  <div class="login-page">
  <div class="form">
  	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<c:if test="${not empty wlkmsg}">
		<div class="wlkmsg">${wlkmsg}</div>
	</c:if>
    <form class="register-form">
      <input type="text" placeholder="name"/>
      <input type="password" placeholder="password"/>
      <input type="text" placeholder="email address"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form id="loginform" class="login-form" action="<c:url value='j_spring_security_check' />" method='POST'>
      <input type="text" name="user" placeholder="username"/>
      <input type="password" name="pwd" placeholder="password"/>
      <button id="loginButton">login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
      <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="<c:url value="/resources/js/login_script.js" />"></script>

</body>
</html>
