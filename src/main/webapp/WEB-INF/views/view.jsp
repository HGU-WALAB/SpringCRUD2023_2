<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>My Player</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="../../css/main.css">
  <style>
    .table td {
      background-color: inherit;
      color: inherit;
      font-size: 16px;
      font-weight: bold;
    }
  </style>
</head>
<body style="background-color:#F7EFE5">
<%-- header --%>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="../list">My Player</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../list">선수 목록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../add">선수 추가</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<%-- body --%>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <table class="table table-bordered" style="border-radius:30px">
        <tbody class="${p.getGrade()}">
        <tr>
          <td style="width: 30%; font-size: 23px; font-weight: bold;">
            <div style="display:flex;justify-content: space-around">
              <span>${p.getGrade()}</span>
              <span>${p.getName()}</span>
              <span>${p.getAverage()}</span>
            </div>
            <img src="${pageContext.request.getContextPath()}/image/${p.getImage()}" class="card-img-top d-block mx-auto player-image" alt="Picture of ${p.getName()}">
          </td>
          <td style="font-size: 19px; font-weight: bold; padding: 20px;">
            <div style="margin-bottom: 15px">
              키: ${p.getHeight()}cm
            </div>
            <div style="margin-bottom: 15px">
              몸무게: ${p.getWeight()}kg
            </div>
            <div style="margin-bottom: 15px">
              포지션: ${p.getFormation()}
            </div>
            <div style="margin-bottom: 15px">
              생일: ${p.getBirthday()}
            </div>
            <div style="margin-bottom: 15px">
              나이: ${p.getAge()}세
            </div>
            <div style="margin-bottom: 15px">
              몸값: ${p.getPrice()}억
            </div>
            <div>
              체격: ${p.getPhysical()}
            </div>
          </td>
        </tr>
        <tr>
          <td colspan="2" style="text-align: center">능력치</td>
        </tr>
        <tr>
          <td>패스</td>
          <td>${p.getPass()}</td>
        </tr>
        <tr>
          <td>슛</td>
          <td>${p.getShoot()}</td>
        </tr>
        <tr>
          <td>수비력</td>
          <td>${p.getDefense()}</td>
        </tr>
        <tr>
          <td>속도</td>
          <td>${p.getSpeed()}</td>
        </tr>
        <tr>
          <td>축구 지능</td>
          <td>${p.getIntelligence()}</td>
        </tr>
        <tr>
          <td>골키퍼 능력</td>
          <td>${p.getGoalkeeping()}</td>
        </tr>
        </tbody>
      </table>
      <div style="text-align: right;">
        <button class="btn btn-outline-warning" onclick="location.href='../edit/${p.getId()}'" type="button">
          수정
        </button>
        <button class="btn btn-outline-danger" onclick="location.href='../delete/${p.getId()}'" type="button">
          삭제
        </button>
    </div>

    </div>
  </div>
</div>

</body>
</html>