<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.example.dao.PlayerDao, com.example.vo.PlayerVo,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
  <title>My Player</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<div class="container">
  <%--                 header                    --%>
  <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
      My Player
    </a>
    <ul class="nav nav-pills">
      <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">선수 목록</a></li>
      <li class="nav-item"><a href="/addCamp" class="nav-link">선수 추가</a></li>
    </ul>
  </header>
  <%--                 body                   --%>
  <div class="row row-cols-lg-3 row-cols-md-2">
    <c:forEach items="${list}" var="p">
      <%--                 선수 정보 카드                   --%>
      <div class="card player-card ${p.getGrade()}">
        <div style="display: flex; justify-content: space-between; width: 100% ">
          <h3> ${p.getAverage()} </h3>
         <h3> ${p.getGrade()}</h3>
        </div>
        <img src='${p.getImage()}' class="card-img-top d-block mx-auto player-image">

        <div class="card-body">
          <h5 class="card-title">${p.getName()}</h5>
          <p class="card-text">포지션: ${p.getFormation()}</p>
          <p class="card-text">나이: ${p.getOld()}</p>
          <p class="card-text">체격: ${p.getPhysical()}</p>
          <button class="w-btn w-btn-gray" type="button">세부 정보 확인</button>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>

