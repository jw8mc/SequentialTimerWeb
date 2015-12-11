<%@ page import="sequentialTimer.services.CatApiConsumer" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 12/7/2015
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>

<!-- Cat API service by Aden Forshaw - http://thecatapi.com/ -->

<h3 class="centered">TODAY'S KITTEN</h3>
<div class="centered">
    <!-- <a href="http://thecatapi.com"><img style="max-height: 500px; max-width: 100%;" src="http://thecatapi.com/api/images/get?format=src&type=jpg,png&size=sm"></a> -->
    <%
        CatApiConsumer consumer = new CatApiConsumer();
        String kittenImg = consumer.getReturnedKitten();
    %>

    <%= kittenImg %>
</div>

