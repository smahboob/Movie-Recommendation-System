<%@page import="com.org.Rating"%>
<%@page import="com.org.MovieDatabase"%>
<%@page import="com.org.RaterDatabase"%>
<%@page import="com.org.FirstRatings"%>
<%@page import="com.org.Filter"%>
<%@page import="com.org.GenreFilter"%>
<%@page import="com.org.AllFilters"%>
<%@page import="com.org.YearAfterFilter"%>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="App1.css" rel="stylesheet" type="text/css">
<title>Movie Recommendation System</title>
</head>
<body>

<h1 class = "headTitle">Rate the following movies</h1>
<%
MovieDatabase.initialize("ratedmoviesfull.csv");
AllFilters af = new AllFilters();
af.addFilter(new GenreFilter("Action"));
af.addFilter(new YearAfterFilter(2010));
ArrayList<String> arr = MovieDatabase.filterBy(af);
%>
<form action = "main1.jsp" method = "get">
<table style="width:100%">
   <tr>
    <th></th>
    <th>Year</th>
    <th>Movie Title</th> 
    <th>Rating</th>
  </tr>
  
  <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(1)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(1)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(1)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieOne" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(10)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(10)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(10)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieTwo" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(20)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(20)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(20)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieThree" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(30)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(30)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(30)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieFour" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(35)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(35)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(35)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieFive" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(40)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(40)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(40)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieSix" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(45)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(45)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(45)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieSeven" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(50)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(50)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(50)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieEight" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(60)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(60)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(60)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieNine" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
   
   <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(arr.get(23)));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><% out.println(MovieDatabase.getYear(arr.get(23)));    %></td>
  	<td><% out.println(MovieDatabase.getTitle(arr.get(23)));   %></td>
    <td><%for(int i = 0; i <= 10; i ++){%> <input type = "radio" name = "movieTen" value = <%out.println(i);%>> <%out.println(i);%> <%}%></td>
   </tr>
  
</table>
	
	<input class = "btn" type = "submit" value = "Submit">
	
	</form>
	
</body>
</html>




















