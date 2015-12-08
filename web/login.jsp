<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 11/30/2015
  Time: 2:06 PM
  Bootstrap html and css snippet from https://gist.github.com/bMinaise/7329874 - edited to remove the "need help?" link,
  "remember me" checkbox, and to link to my own registration page. Changed "Email" to "Username", and edited attributes
  to allow JAAS integration. Replaced the profile image, added a border, and made it a larger square instead of round.
  Altered css to base button-input spacing on the button, not the password field, to avoid weird spacing on the sign up
  page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/imports/head.jsp" />
    <title>Log In</title>
    <link rel="stylesheet" type="text/css" href="/imports/login.css" />
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign In</h1>
            <div class="account-wall">
                <img class="profile-img" src="/imports/images/catLineartMakoZune.PNG"
                     alt="Generously created and licensed for reuse by Mako-Zune on DeviantArt">
                <form class="form-signin">
                    <input type="text" class="form-control" placeholder="Username" required autofocus>
                    <input type="password" class="form-control" placeholder="Password" required>
                    <button class="btn btn-lg btn-block" type="submit">
                        Sign in</button>
                </form>
            </div>
            <a href="/new-user.jsp" class="text-center new-account">New around here? Create an account!</a>
        </div>
    </div>
</div>
</body>
</html>
